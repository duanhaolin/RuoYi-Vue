package com.ruoyi.kcnq2.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文章管理对象 kcnq2_article
 * 
 * @author liufeibo
 * @date 2024-11-17
 */
public class Article extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 主标题 */
    @Excel(name = "主标题")
    private String mainTitle;

    /** 副标题 */
    @Excel(name = "副标题")
    private String subTitle;

    /** 概要 */
    @Excel(name = "概要")
    private String summary;

    /** 文章大类 */
    @Excel(name = "文章大类")
    private Integer category;

    /** 文章小类 */
    @Excel(name = "文章小类")
    private Integer subCategory;

    /** 缩略图 */
    @Excel(name = "缩略图")
    private String thumbnail;

    /** 概要图 */
    @Excel(name = "概要图")
    private String summaryImage;

    /** 其他备用信息1 */
    private String extraInfo1;

    /** 其他备用信息2 */
    private String extraInfo2;

    /** 其他备用信息3 */
    private String extraInfo3;

    /** 其他备用信息4 */
    private String extraInfo4;

    /** 其他备用信息5 */
    private String extraInfo5;

    /** 文章详情 */
    private String contentId;

    /** SEO标题，用于设置页面的title标签 */
    private String seoTitle;

    /** SEO关键词，多个关键词用英文逗号分隔，用于meta keywords标签 */
    private String seoKeywords;

    /** SEO描述，用于meta description标签 */
    private String seoDescription;

    /** 规范链接(canonical URL)，用于处理重复内容 */
    private String canonicalUrl;

    /** Open Graph标题，用于社交媒体分享 */
    private String ogTitle;

    /** Open Graph描述，用于社交媒体分享 */
    private String ogDescription;

    /** Open Graph图片URL，用于社交媒体分享预览 */
    private String ogImage;

    /** 结构化数据(JSON-LD格式) */
    private String structuredData;

    /** 处理状态 */
    @Excel(name = "处理状态")
    private Long status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMainTitle(String mainTitle) 
    {
        this.mainTitle = mainTitle;
    }

    public String getMainTitle() 
    {
        return mainTitle;
    }
    public void setSubTitle(String subTitle) 
    {
        this.subTitle = subTitle;
    }

    public String getSubTitle() 
    {
        return subTitle;
    }
    public void setSummary(String summary) 
    {
        this.summary = summary;
    }

    public String getSummary() 
    {
        return summary;
    }
    public void setCategory(Integer category) 
    {
        this.category = category;
    }

    public Integer getCategory() 
    {
        return category;
    }
    public void setSubCategory(Integer subCategory) 
    {
        this.subCategory = subCategory;
    }

    public Integer getSubCategory() 
    {
        return subCategory;
    }
    public void setThumbnail(String thumbnail) 
    {
        this.thumbnail = thumbnail;
    }

    public String getThumbnail() 
    {
        return thumbnail;
    }
    public void setSummaryImage(String summaryImage) 
    {
        this.summaryImage = summaryImage;
    }

    public String getSummaryImage() 
    {
        return summaryImage;
    }
    public void setExtraInfo1(String extraInfo1) 
    {
        this.extraInfo1 = extraInfo1;
    }

    public String getExtraInfo1() 
    {
        return extraInfo1;
    }
    public void setExtraInfo2(String extraInfo2) 
    {
        this.extraInfo2 = extraInfo2;
    }

    public String getExtraInfo2() 
    {
        return extraInfo2;
    }
    public void setExtraInfo3(String extraInfo3) 
    {
        this.extraInfo3 = extraInfo3;
    }

    public String getExtraInfo3() 
    {
        return extraInfo3;
    }
    public void setExtraInfo4(String extraInfo4) 
    {
        this.extraInfo4 = extraInfo4;
    }

    public String getExtraInfo4() 
    {
        return extraInfo4;
    }
    public void setExtraInfo5(String extraInfo5) 
    {
        this.extraInfo5 = extraInfo5;
    }

    public String getExtraInfo5() 
    {
        return extraInfo5;
    }
    public void setContentId(String contentId) 
    {
        this.contentId = contentId;
    }

    public String getContentId() 
    {
        return contentId;
    }
    public void setSeoTitle(String seoTitle) 
    {
        this.seoTitle = seoTitle;
    }

    public String getSeoTitle() 
    {
        return seoTitle;
    }
    public void setSeoKeywords(String seoKeywords) 
    {
        this.seoKeywords = seoKeywords;
    }

    public String getSeoKeywords() 
    {
        return seoKeywords;
    }
    public void setSeoDescription(String seoDescription) 
    {
        this.seoDescription = seoDescription;
    }

    public String getSeoDescription() 
    {
        return seoDescription;
    }
    public void setCanonicalUrl(String canonicalUrl) 
    {
        this.canonicalUrl = canonicalUrl;
    }

    public String getCanonicalUrl() 
    {
        return canonicalUrl;
    }
    public void setOgTitle(String ogTitle) 
    {
        this.ogTitle = ogTitle;
    }

    public String getOgTitle() 
    {
        return ogTitle;
    }
    public void setOgDescription(String ogDescription) 
    {
        this.ogDescription = ogDescription;
    }

    public String getOgDescription() 
    {
        return ogDescription;
    }
    public void setOgImage(String ogImage) 
    {
        this.ogImage = ogImage;
    }

    public String getOgImage() 
    {
        return ogImage;
    }
    public void setStructuredData(String structuredData) 
    {
        this.structuredData = structuredData;
    }

    public String getStructuredData() 
    {
        return structuredData;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("mainTitle", getMainTitle())
            .append("subTitle", getSubTitle())
            .append("summary", getSummary())
            .append("category", getCategory())
            .append("subCategory", getSubCategory())
            .append("thumbnail", getThumbnail())
            .append("summaryImage", getSummaryImage())
            .append("extraInfo1", getExtraInfo1())
            .append("extraInfo2", getExtraInfo2())
            .append("extraInfo3", getExtraInfo3())
            .append("extraInfo4", getExtraInfo4())
            .append("extraInfo5", getExtraInfo5())
            .append("contentId", getContentId())
            .append("seoTitle", getSeoTitle())
            .append("seoKeywords", getSeoKeywords())
            .append("seoDescription", getSeoDescription())
            .append("canonicalUrl", getCanonicalUrl())
            .append("ogTitle", getOgTitle())
            .append("ogDescription", getOgDescription())
            .append("ogImage", getOgImage())
            .append("structuredData", getStructuredData())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
