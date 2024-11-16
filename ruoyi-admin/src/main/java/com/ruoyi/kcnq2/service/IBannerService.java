package com.ruoyi.kcnq2.service;

import java.util.List;
import com.ruoyi.kcnq2.domain.Banner;

/**
 * Banner配置Service接口
 * 
 * @author liufeibo
 * @date 2024-11-16
 */
public interface IBannerService 
{
    /**
     * 查询Banner配置
     * 
     * @param id Banner配置主键
     * @return Banner配置
     */
    public Banner selectBannerById(Long id);

    /**
     * 查询Banner配置列表
     * 
     * @param banner Banner配置
     * @return Banner配置集合
     */
    public List<Banner> selectBannerList(Banner banner);

    /**
     * web端查询Banner配置列表
     *
     * @return Banner配置集合
     */
    public List<Banner> selectBannerList2Web();

    /**
     * 新增Banner配置
     * 
     * @param banner Banner配置
     * @return 结果
     */
    public int insertBanner(Banner banner);

    /**
     * 修改Banner配置
     * 
     * @param banner Banner配置
     * @return 结果
     */
    public int updateBanner(Banner banner);

    /**
     * 批量删除Banner配置
     * 
     * @param ids 需要删除的Banner配置主键集合
     * @return 结果
     */
    public int deleteBannerByIds(Long[] ids);

    /**
     * 删除Banner配置信息
     * 
     * @param id Banner配置主键
     * @return 结果
     */
    public int deleteBannerById(Long id);
}
