package com.ruoyi.kcnq2.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * Banner配置对象 kcnq2_banner
 * 
 * @author liufeibo
 * @date 2024-11-16
 */
public class Banner extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号ID */
    private Long id;

    /** banner名称 */
    @Excel(name = "banner名称")
    private String bannerName;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String imageUrl;

    /** 目标地址 */
    @Excel(name = "目标地址")
    private String jumpUrl;

    /** 排序order */
    private Integer displayOrder;

    /** 是否展示 */
    @Excel(name = "是否展示")
    private Integer isShow;

    /** 删除状态 */
    @Excel(name = "删除状态")
    private Integer status;

    /** 展示开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "展示开始时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /** 展示结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "展示结束时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBannerName(String bannerName) 
    {
        this.bannerName = bannerName;
    }

    public String getBannerName() 
    {
        return bannerName;
    }
    public void setImageUrl(String imageUrl) 
    {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() 
    {
        return imageUrl;
    }
    public void setJumpUrl(String jumpUrl) 
    {
        this.jumpUrl = jumpUrl;
    }

    public String getJumpUrl() 
    {
        return jumpUrl;
    }
    public void setDisplayOrder(Integer displayOrder) 
    {
        this.displayOrder = displayOrder;
    }

    public Integer getDisplayOrder() 
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
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("bannerName", getBannerName())
            .append("imageUrl", getImageUrl())
            .append("jumpUrl", getJumpUrl())
            .append("displayOrder", getDisplayOrder())
            .append("isShow", getIsShow())
            .append("status", getStatus())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
