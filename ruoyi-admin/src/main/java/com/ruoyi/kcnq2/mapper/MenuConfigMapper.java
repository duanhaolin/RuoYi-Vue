package com.ruoyi.kcnq2.mapper;

import java.util.List;
import com.ruoyi.kcnq2.domain.MenuConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 菜单配置Mapper接口
 * 
 * @author liufeibo
 * @date 2024-11-17
 */
@Mapper
public interface MenuConfigMapper 
{
    /**
     * 查询菜单配置
     * 
     * @param id 菜单配置主键
     * @return 菜单配置
     */
    public MenuConfig selectMenuConfigById(Long id);

    /**
     * 查询菜单配置列表
     * 
     * @param menuConfig 菜单配置
     * @return 菜单配置集合
     */
    public List<MenuConfig> selectMenuConfigList(MenuConfig menuConfig);

    /**
     * 新增菜单配置
     * 
     * @param menuConfig 菜单配置
     * @return 结果
     */
    public int insertMenuConfig(MenuConfig menuConfig);

    /**
     * 修改菜单配置
     * 
     * @param menuConfig 菜单配置
     * @return 结果
     */
    public int updateMenuConfig(MenuConfig menuConfig);

    /**
     * 删除菜单配置
     * 
     * @param id 菜单配置主键
     * @return 结果
     */
    public int deleteMenuConfigById(Long id);

    /**
     * 批量删除菜单配置
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMenuConfigByIds(Long[] ids);

    int updateMenuDeleteStatusByIds(@Param("array") Long[] ids, @Param("username") String username);

}
