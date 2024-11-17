package com.ruoyi.kcnq2.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.kcnq2.domain.MenuConfig;
import com.ruoyi.kcnq2.service.IMenuConfigService;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 菜单配置Controller
 * 
 * @author liufeibo
 * @date 2024-11-17
 */
@RestController
@RequestMapping("/kcnq2/menuConfig")
public class MenuConfigController extends BaseController
{
    @Autowired
    private IMenuConfigService menuConfigService;

    /**
     * 查询菜单配置列表
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:menuConfig:list')")
    @GetMapping("/list")
    public AjaxResult list(MenuConfig menuConfig)
    {
        List<MenuConfig> list = menuConfigService.selectMenuConfigList(menuConfig);
        return success(list);
    }

    /**
     * 导出菜单配置列表
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:menuConfig:export')")
    @Log(title = "菜单配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MenuConfig menuConfig)
    {
        List<MenuConfig> list = menuConfigService.selectMenuConfigList(menuConfig);
        ExcelUtil<MenuConfig> util = new ExcelUtil<MenuConfig>(MenuConfig.class);
        util.exportExcel(response, list, "菜单配置数据");
    }

    /**
     * 获取菜单配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:menuConfig:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(menuConfigService.selectMenuConfigById(id));
    }

    /**
     * 新增菜单配置
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:menuConfig:add')")
    @Log(title = "菜单配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MenuConfig menuConfig)
    {
        return toAjax(menuConfigService.insertMenuConfig(menuConfig));
    }

    /**
     * 修改菜单配置
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:menuConfig:edit')")
    @Log(title = "菜单配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MenuConfig menuConfig)
    {
        return toAjax(menuConfigService.updateMenuConfig(menuConfig));
    }

    /**
     * 删除菜单配置
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:menuConfig:remove')")
    @Log(title = "菜单配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(menuConfigService.deleteMenuConfigByIds(ids));
    }
}
