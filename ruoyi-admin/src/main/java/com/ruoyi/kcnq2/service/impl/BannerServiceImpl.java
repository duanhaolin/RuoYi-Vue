package com.ruoyi.kcnq2.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.kcnq2.mapper.BannerMapper;
import com.ruoyi.kcnq2.domain.Banner;
import com.ruoyi.kcnq2.service.IBannerService;

/**
 * Banner配置Service业务层处理
 *
 * @author liufeibo
 * @date 2024-11-16
 */
@Service
public class BannerServiceImpl implements IBannerService {
    @Autowired
    private BannerMapper bannerMapper;

    /**
     * 查询Banner配置
     *
     * @param id Banner配置主键
     * @return Banner配置
     */
    @Override
    public Banner selectBannerById(Long id) {
        return bannerMapper.selectBannerById(id);
    }

    /**
     * 查询Banner配置列表
     *
     * @param banner Banner配置
     * @return Banner配置
     */
    @Override
    public List<Banner> selectBannerList(Banner banner) {
        return bannerMapper.selectBannerList(banner);
    }

    /**
     * web端查询Banner配置列表
     *
     * @return Banner配置
     */
    @Override
    public List<Banner> selectBannerList2Web() {
        return bannerMapper.selectBannerList2Web();
    }

    /**
     * 新增Banner配置
     *
     * @param banner Banner配置
     * @return 结果
     */
    @Override
    public int insertBanner(Banner banner) {
        banner.setCreateTime(DateUtils.getNowDate());
        banner.setCreateBy(SecurityUtils.getUsername());
        banner.setUpdateBy(SecurityUtils.getUsername());
        return bannerMapper.insertBanner(banner);
    }

    /**
     * 修改Banner配置
     *
     * @param banner Banner配置
     * @return 结果
     */
    @Override
    public int updateBanner(Banner banner) {
        banner.setUpdateTime(DateUtils.getNowDate());
        banner.setUpdateBy(SecurityUtils.getUsername());
        return bannerMapper.updateBanner(banner);
    }

    /**
     * 批量删除Banner配置
     *
     * @param ids 需要删除的Banner配置主键
     * @return 结果
     */
    @Override
    public int deleteBannerByIds(Long[] ids) {
        return bannerMapper.updateBannerDeleteStatusByIds(ids, SecurityUtils.getUsername());
    }

    /**
     * 删除Banner配置信息
     *
     * @param id Banner配置主键
     * @return 结果
     */
    @Override
    public int deleteBannerById(Long id) {
        return bannerMapper.updateBannerDeleteStatusByIds(new Long[]{id}, SecurityUtils.getUsername());
    }
}
