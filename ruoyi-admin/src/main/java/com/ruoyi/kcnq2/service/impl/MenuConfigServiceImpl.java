package com.ruoyi.kcnq2.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.kcnq2.mapper.MenuConfigMapper;
import com.ruoyi.kcnq2.domain.MenuConfig;
import com.ruoyi.kcnq2.service.IMenuConfigService;

/**
 * 菜单配置Service业务层处理
 * 
 * @author liufeibo
 * @date 2024-11-17
 */
@Service
public class MenuConfigServiceImpl implements IMenuConfigService 
{
    @Autowired
    private MenuConfigMapper menuConfigMapper;

    /**
     * 查询菜单配置
     * 
     * @param id 菜单配置主键
     * @return 菜单配置
     */
    @Override
    public MenuConfig selectMenuConfigById(Long id)
    {
        return menuConfigMapper.selectMenuConfigById(id);
    }

    /**
     * 查询菜单配置列表
     * 
     * @param menuConfig 菜单配置
     * @return 菜单配置
     */
    @Override
    public List<MenuConfig> selectMenuConfigList(MenuConfig menuConfig)
    {
        return menuConfigMapper.selectMenuConfigList(menuConfig);
    }

    /**
     * 新增菜单配置
     * 
     * @param menuConfig 菜单配置
     * @return 结果
     */
    @Override
    public int insertMenuConfig(MenuConfig menuConfig)
    {
        menuConfig.setCreateTime(DateUtils.getNowDate());
        menuConfig.setCreateBy(SecurityUtils.getUsername());
        menuConfig.setUpdateBy(SecurityUtils.getUsername());
        return menuConfigMapper.insertMenuConfig(menuConfig);
    }

    /**
     * 修改菜单配置
     * 
     * @param menuConfig 菜单配置
     * @return 结果
     */
    @Override
    public int updateMenuConfig(MenuConfig menuConfig)
    {
        menuConfig.setUpdateTime(DateUtils.getNowDate());
        menuConfig.setUpdateBy(SecurityUtils.getUsername());
        return menuConfigMapper.updateMenuConfig(menuConfig);
    }

    /**
     * 批量删除菜单配置
     * 
     * @param ids 需要删除的菜单配置主键
     * @return 结果
     */
    @Override
    public int deleteMenuConfigByIds(Long[] ids)
    {
        return menuConfigMapper.updateMenuDeleteStatusByIds(ids, SecurityUtils.getUsername());
    }

    /**
     * 删除菜单配置信息
     * 
     * @param id 菜单配置主键
     * @return 结果
     */
    @Override
    public int deleteMenuConfigById(Long id)
    {
        return menuConfigMapper.updateMenuDeleteStatusByIds(new Long[] { id }, SecurityUtils.getUsername());
    }
}
