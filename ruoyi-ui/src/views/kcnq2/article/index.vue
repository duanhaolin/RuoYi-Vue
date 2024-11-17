<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="主标题" prop="mainTitle">
        <el-input
          v-model="queryParams.mainTitle"
          placeholder="请输入主标题"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="副标题" prop="subTitle">
        <el-input
          v-model="queryParams.subTitle"
          placeholder="请输入副标题"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="文章大类" prop="category">
        <el-select v-model="queryParams.category" placeholder="请选择文章大类" clearable>
          <el-option
            v-for="dict in dict.type.article_category_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="文章小类" prop="subCategory">
        <el-select v-model="queryParams.subCategory" placeholder="请选择文章小类" clearable>
          <el-option
            v-for="dict in dict.type.article_category_sub_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="处理状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择处理状态" clearable>
          <el-option
            v-for="dict in dict.type.article_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
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
          v-hasPermi="['kcnq2:article:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['kcnq2:article:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['kcnq2:article:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['kcnq2:article:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="articleList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="id"  width="55"/>
      <el-table-column label="主标题" align="center" prop="mainTitle" />
      <el-table-column label="副标题" align="center" prop="subTitle" />
      <el-table-column label="概要" align="center" prop="summary" />
      <el-table-column label="文章大类" align="center" prop="category">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.article_category_type" :value="scope.row.category"/>
        </template>
      </el-table-column>
      <el-table-column label="文章小类" align="center" prop="subCategory">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.article_category_sub_type" :value="scope.row.subCategory"/>
        </template>
      </el-table-column>
      <el-table-column label="缩略图" align="center" prop="thumbnail" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.thumbnail" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="概要图" align="center" prop="summaryImage" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.summaryImage" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="处理状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.article_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['kcnq2:article:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['kcnq2:article:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改文章管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="1600px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="文章大类" prop="category">
          <el-select v-model="form.category" placeholder="请选择文章大类">
            <el-option
              v-for="dict in dict.type.article_category_type"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="文章小类" prop="subCategory">
          <el-select v-model="form.subCategory" placeholder="请选择文章小类">
            <el-option
              v-for="dict in dict.type.article_category_sub_type"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="主标题" prop="mainTitle">
          <el-input v-model="form.mainTitle" placeholder="请输入主标题" />
        </el-form-item>
        <el-form-item label="副标题" prop="subTitle">
          <el-input v-model="form.subTitle" placeholder="请输入副标题" />
        </el-form-item>
        <el-form-item label="概要">
          <editor v-model="form.summary" :min-height="150"/>
        </el-form-item>
        <el-form-item label="文章详情">
          <editor v-model="form.contentId" :min-height="400"/>
        </el-form-item>
        <el-form-item label="缩略图" prop="thumbnail">
          <image-upload v-model="form.thumbnail"/>
        </el-form-item>
        <el-form-item label="概要图" prop="summaryImage">
          <image-upload v-model="form.summaryImage"/>
        </el-form-item>
        <el-form-item label="处理状态" prop="status">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.article_status"
              :key="dict.value"
              :label="parseInt(dict.value)"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <!--一下是SEO内容，请在该位置插入一条横线，分隔上面和下面部分-->
        <hr /><hr />
        <el-form-item label="SEO标题" prop="seoTitle">
          <el-input v-model="form.seoTitle" placeholder="请输入SEO标题，用于设置页面的title标签" />
        </el-form-item>
        <el-form-item label="SEO关键词" prop="seoKeywords">
          <el-input v-model="form.seoKeywords" type="textarea" placeholder="SEO关键词，多个关键词用英文逗号分隔，用于meta keywords标签" />
        </el-form-item>
        <el-form-item label="SEO描述" prop="seoDescription">
          <el-input v-model="form.seoDescription" type="textarea" placeholder="SEO描述，用于meta description标签" />
        </el-form-item>
        <el-form-item label="规范链接" prop="canonicalUrl">
          <el-input v-model="form.canonicalUrl" placeholder="请输入规范链接(canonical URL)，用于处理重复内容" />
        </el-form-item>
        <el-form-item label="Open Graph标题" prop="ogTitle">
          <el-input v-model="form.ogTitle" placeholder="请输入Open Graph标题，用于社交媒体分享" />
        </el-form-item>
        <el-form-item label="Open Graph描述" prop="ogDescription">
          <el-input v-model="form.ogDescription" type="textarea" placeholder="Open Graph描述，用于社交媒体分享" />
        </el-form-item>
        <el-form-item label="Open Graph图片URL，用于社交媒体分享预览" prop="ogImage">
          <image-upload v-model="form.ogImage"/>
        </el-form-item>
        <el-form-item label="结构化数据" prop="structuredData">
          <el-input v-model="form.structuredData" type="textarea" placeholder="结构化数据(JSON-LD格式)" />
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
import { listArticle, getArticle, delArticle, addArticle, updateArticle } from "@/api/kcnq2/article";

export default {
  name: "Article",
  dicts: ['article_status', 'article_category_sub_type', 'article_category_type'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 文章管理表格数据
      articleList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 备注时间范围
      daterangeCreateTime: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        mainTitle: null,
        subTitle: null,
        summary: null,
        category: null,
        subCategory: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        mainTitle: [
          { required: true, message: "主标题不能为空", trigger: "blur" }
        ],
        subTitle: [
          { required: true, message: "副标题不能为空", trigger: "blur" }
        ],
        summary: [
          { required: true, message: "概要不能为空", trigger: "blur" }
        ],
        category: [
          { required: true, message: "文章大类不能为空", trigger: "change" }
        ],
        subCategory: [
          { required: true, message: "文章小类不能为空", trigger: "change" }
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
    /** 查询文章管理列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeCreateTime && '' != this.daterangeCreateTime) {
        this.queryParams.params["beginCreateTime"] = this.daterangeCreateTime[0];
        this.queryParams.params["endCreateTime"] = this.daterangeCreateTime[1];
      }
      listArticle(this.queryParams).then(response => {
        this.articleList = response.rows;
        this.total = response.total;
        this.loading = false;
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
        mainTitle: null,
        subTitle: null,
        summary: null,
        category: null,
        subCategory: null,
        thumbnail: null,
        summaryImage: null,
        extraInfo1: null,
        extraInfo2: null,
        extraInfo3: null,
        extraInfo4: null,
        extraInfo5: null,
        contentId: null,
        seoTitle: null,
        seoKeywords: null,
        seoDescription: null,
        canonicalUrl: null,
        ogTitle: null,
        ogDescription: null,
        ogImage: null,
        structuredData: null,
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
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.daterangeCreateTime = [];
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加文章管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getArticle(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改文章管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateArticle(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addArticle(this.form).then(response => {
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
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除文章管理编号为"' + ids + '"的数据项？').then(function() {
        return delArticle(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('kcnq2/article/export', {
        ...this.queryParams
      }, `article_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
