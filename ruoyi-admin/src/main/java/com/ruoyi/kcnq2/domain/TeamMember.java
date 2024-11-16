package com.ruoyi.kcnq2.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 团队成员管理对象 kcnq2_team_member
 * 
 * @author liufeibo
 * @date 2024-11-16
 */
public class TeamMember extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 展示顺序 */
    @Excel(name = "展示顺序")
    private Integer displayOrder;

    /** 头像 */
    @Excel(name = "头像")
    private String avatar;

    /** 中文名 */
    @Excel(name = "中文名")
    private String chineseName;

    /** 英文名 */
    @Excel(name = "英文名")
    private String englishName;

    /** 职位信息 */
    @Excel(name = "职位信息")
    private String position;

    /** 详细简介 */
    private String description;

    /** 处理状态 */
    @Excel(name = "处理状态")
    private Integer status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDisplayOrder(Integer displayOrder) 
    {
        this.displayOrder = displayOrder;
    }

    public Integer getDisplayOrder() 
    {
        return displayOrder;
    }
    public void setAvatar(String avatar) 
    {
        this.avatar = avatar;
    }

    public String getAvatar() 
    {
        return avatar;
    }
    public void setChineseName(String chineseName) 
    {
        this.chineseName = chineseName;
    }

    public String getChineseName() 
    {
        return chineseName;
    }
    public void setEnglishName(String englishName) 
    {
        this.englishName = englishName;
    }

    public String getEnglishName() 
    {
        return englishName;
    }
    public void setPosition(String position) 
    {
        this.position = position;
    }

    public String getPosition() 
    {
        return position;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
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
            .append("displayOrder", getDisplayOrder())
            .append("avatar", getAvatar())
            .append("chineseName", getChineseName())
            .append("englishName", getEnglishName())
            .append("position", getPosition())
            .append("description", getDescription())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
