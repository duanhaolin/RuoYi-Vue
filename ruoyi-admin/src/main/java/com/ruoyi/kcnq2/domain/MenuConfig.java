package com.ruoyi.kcnq2.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.TreeEntity;

/**
 * 菜单配置对象 kcnq2_menu_config
 * 
 * @author liufeibo
 * @date 2024-11-17
 */
public class MenuConfig extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 菜单分类 */
    @Excel(name = "菜单分类")
    private String menuCategory;

    /** 菜单子分类 */
    @Excel(name = "菜单子分类")
    private String menuSubtype;

    /** 菜单名称 */
    @Excel(name = "菜单名称")
    private String menuName;

    /** 跳转链接 */
    @Excel(name = "跳转链接")
    private String jumpUrl;

    /** 展示顺序 */
    @Excel(name = "展示顺序")
    private Long displayOrder;

    /** 是否展示 */
    @Excel(name = "是否展示")
    private Integer isShow;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMenuCategory(String menuCategory) 
    {
        this.menuCategory = menuCategory;
    }

    public String getMenuCategory() 
    {
        return menuCategory;
    }
    public void setMenuSubtype(String menuSubtype) 
    {
        this.menuSubtype = menuSubtype;
    }

    public String getMenuSubtype() 
    {
        return menuSubtype;
    }
    public void setMenuName(String menuName) 
    {
        this.menuName = menuName;
    }

    public String getMenuName() 
    {
        return menuName;
    }
    public void setJumpUrl(String jumpUrl) 
    {
        this.jumpUrl = jumpUrl;
    }

    public String getJumpUrl() 
    {
        return jumpUrl;
    }
    public void setDisplayOrder(Long displayOrder) 
    {
        this.displayOrder = displayOrder;
    }

    public Long getDisplayOrder() 
    {
        return displayOrder;
    }
    public void setIsShow(Integer isShow) 
    {
        this.isShow = isShow;
    }

    public Integer getIsShow() 
    {
        return isShow;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("menuCategory", getMenuCategory())
            .append("menuSubtype", getMenuSubtype())
            .append("parentId", getParentId())
            .append("menuName", getMenuName())
            .append("jumpUrl", getJumpUrl())
            .append("displayOrder", getDisplayOrder())
            .append("isShow", getIsShow())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
