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
import com.ruoyi.kcnq2.domain.Banner;
import com.ruoyi.kcnq2.service.IBannerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * Banner配置Controller
 *
 * @author liufeibo
 * @date 2024-11-16
 */
@RestController
@RequestMapping("/kcnq2/banner")
public class BannerController extends BaseController {
    @Autowired
    private IBannerService bannerService;

    /**
     * 管理端查询Banner配置列表
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:banner:list')")
    @GetMapping("/list")
    public TableDataInfo list(Banner banner) {
        startPage();
        List<Banner> list = bannerService.selectBannerList(banner);
        return getDataTable(list);
    }


    /**
     * 用户端查询Banner配置列表
     */
    @GetMapping("/list/2Web")
    public AjaxResult list2Web() {
        List<Banner> list = bannerService.selectBannerList2Web();
        return success(list);
    }

    /**
     * 导出Banner配置列表
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:banner:export')")
    @Log(title = "Banner配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Banner banner) {
        List<Banner> list = bannerService.selectBannerList(banner);
        ExcelUtil<Banner> util = new ExcelUtil<Banner>(Banner.class);
        util.exportExcel(response, list, "Banner配置数据");
    }

    /**
     * 获取Banner配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:banner:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(bannerService.selectBannerById(id));
    }

    /**
     * 新增Banner配置
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:banner:add')")
    @Log(title = "Banner配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Banner banner) {
        return toAjax(bannerService.insertBanner(banner));
    }

    /**
     * 修改Banner配置
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:banner:edit')")
    @Log(title = "Banner配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Banner banner) {
        return toAjax(bannerService.updateBanner(banner));
    }

    /**
     * 删除Banner配置
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:banner:remove')")
    @Log(title = "Banner配置", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(bannerService.deleteBannerByIds(ids));
    }
}
