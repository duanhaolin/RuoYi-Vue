<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="菜单名称" prop="menuName">
        <el-input
          v-model="queryParams.menuName"
          placeholder="请输入菜单名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否展示" prop="isShow">
        <el-select v-model="queryParams.isShow" placeholder="请选择是否展示" clearable>
          <el-option
            v-for="dict in dict.type.sys_show_hide"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable>
          <el-option
            v-for="dict in dict.type.is_delete"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="创建时间">
        <el-date-picker
          v-model="daterangeCreateTime"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['kcnq2:menuConfig:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="info"
          plain
          icon="el-icon-sort"
          size="mini"
          @click="toggleExpandAll"
        >展开/折叠</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table
      v-if="refreshTable"
      v-loading="loading"
      :data="menuConfigList"
      row-key="id"
      :default-expand-all="isExpandAll"
      :tree-props="{children: 'children', hasChildren: 'hasChildren'}"
    >
      <el-table-column label="菜单名称" align="center" prop="menuName"  width="260"/>
      <el-table-column label="菜单分类" align="center" prop="menuCategory" >
        <template slot-scope="scope">
          <dict-tag :options="dict.type.menu_type" :value="scope.row.menuCategory"/>
        </template>
      </el-table-column>
      <el-table-column label="菜单子分类" align="center" prop="menuSubtype" >
        <template slot-scope="scope">
          <dict-tag :options="dict.type.menu_sub_type" :value="scope.row.menuSubtype"/>
        </template>
      </el-table-column>
      <el-table-column label="父菜单" align="center" prop="parentId" />
      <el-table-column label="跳转链接" align="center" prop="jumpUrl" />
      <el-table-column label="展示顺序" align="center" prop="displayOrder" />
      <el-table-column label="是否展示" align="center" prop="isShow">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_show_hide" :value="scope.row.isShow"/>
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.is_delete" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['kcnq2:menuConfig:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-plus"
            @click="handleAdd(scope.row)"
            v-hasPermi="['kcnq2:menuConfig:add']"
          >新增</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['kcnq2:menuConfig:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 添加或修改菜单配置对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="1000px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="菜单分类" prop="menuCategory">
          <el-select v-model="form.menuCategory" placeholder="请选择菜单分类">
            <el-option
              v-for="dict in dict.type.menu_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="菜单子分类" prop="menuSubtype">
          <el-select v-model="form.menuSubtype" placeholder="请选择菜单子分类">
            <el-option
              v-for="dict in dict.type.menu_sub_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="父菜单" prop="parentId">
          <treeselect v-model="form.parentId" :options="menuConfigOptions" :normalizer="normalizer" placeholder="请选择父菜单" />
        </el-form-item>
        <el-form-item label="菜单名称" prop="menuName">
          <el-input v-model="form.menuName" placeholder="请输入菜单名称" />
        </el-form-item>
        <el-form-item label="跳转链接" prop="jumpUrl">
          <el-input v-model="form.jumpUrl" placeholder="请输入跳转链接" />
        </el-form-item>
        <el-form-item label="展示顺序" prop="displayOrder">
          <el-input v-model="form.displayOrder" placeholder="请输入展示顺序" />
        </el-form-item>
        <el-form-item label="是否展示" prop="isShow">
          <el-select v-model="form.isShow" placeholder="请选择是否展示">
            <el-option
              v-for="dict in dict.type.sys_show_hide"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.is_delete"
              :key="dict.value"
              :label="parseInt(dict.value)"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listMenuConfig, getMenuConfig, delMenuConfig, addMenuConfig, updateMenuConfig } from "@/api/kcnq2/menuConfig";
import Treeselect from "@riophae/vue-treeselect";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";

export default {
  name: "MenuConfig",
  dicts: ['is_delete', 'menu_type', 'menu_sub_type', 'sys_show_hide'],
  components: {
    Treeselect
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 显示搜索条件
      showSearch: true,
      // 菜单配置表格数据
      menuConfigList: [],
      // 菜单配置树选项
      menuConfigOptions: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 是否展开，默认全部展开
      isExpandAll: true,
      // 重新渲染表格状态
      refreshTable: true,
      // 备注时间范围
      daterangeCreateTime: [],
      // 查询参数
      queryParams: {
        menuName: null,
        isShow: null,
        status: null,
        createTime: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        menuCategory: [
          { required: true, message: "菜单分类不能为空", trigger: "change" }
        ],
        menuSubtype: [
          { required: true, message: "菜单子分类不能为空", trigger: "change" }
        ],
        menuName: [
          { required: true, message: "菜单名称不能为空", trigger: "blur" }
        ],
        isShow: [
          { required: true, message: "是否展示不能为空", trigger: "change" }
        ],
        status: [
          { required: true, message: "状态不能为空", trigger: "change" }
        ],
        createTime: [
          { required: true, message: "创建时间不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询菜单配置列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeCreateTime && '' != this.daterangeCreateTime) {
        this.queryParams.params["beginCreateTime"] = this.daterangeCreateTime[0];
        this.queryParams.params["endCreateTime"] = this.daterangeCreateTime[1];
      }
      listMenuConfig(this.queryParams).then(response => {
        this.menuConfigList = this.handleTree(response.data, "id", "parentId");
        this.loading = false;
      });
    },
    /** 转换菜单配置数据结构 */
    normalizer(node) {
      if (node.children && !node.children.length) {
        delete node.children;
      }
      return {
        id: node.id,
        label: node.menuName,
        children: node.children
      };
    },
    /** 查询菜单配置下拉树结构 */
    getTreeselect() {
      listMenuConfig().then(response => {
        this.menuConfigOptions = [];
        const data = { id: 0, menuName: '顶级节点', children: [] };
        data.children = this.handleTree(response.data, "id", "parentId");
        this.menuConfigOptions.push(data);
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        menuCategory: null,
        menuSubtype: null,
        parentId: null,
        menuName: null,
        jumpUrl: null,
        displayOrder: null,
        isShow: null,
        status: null,
        remark: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.daterangeCreateTime = [];
      this.resetForm("queryForm");
      this.handleQuery();
    },
    /** 新增按钮操作 */
    handleAdd(row) {
      this.reset();
      this.getTreeselect();
      if (row != null && row.id) {
        this.form.parentId = row.id;
      } else {
        this.form.parentId = 0;
      }
      this.open = true;
      this.title = "添加菜单配置";
    },
    /** 展开/折叠操作 */
    toggleExpandAll() {
      this.refreshTable = false;
      this.isExpandAll = !this.isExpandAll;
      this.$nextTick(() => {
        this.refreshTable = true;
      });
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.getTreeselect();
      if (row != null) {
        this.form.parentId = row.parentId;
      }
      getMenuConfig(row.id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改菜单配置";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateMenuConfig(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMenuConfig(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      this.$modal.confirm('是否确认删除菜单配置编号为"' + row.id + '"的数据项？').then(function() {
        return delMenuConfig(row.id);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    }
  }
};
</script>
