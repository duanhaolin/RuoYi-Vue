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
import com.ruoyi.kcnq2.domain.TeamPurpose;
import com.ruoyi.kcnq2.service.ITeamPurposeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 团队宗旨Controller
 * 
 * @author liufeibo
 * @date 2024-11-16
 */
@RestController
@RequestMapping("/kcnq2/purpose")
public class TeamPurposeController extends BaseController
{
    @Autowired
    private ITeamPurposeService teamPurposeService;

    /**
     * 查询团队宗旨列表
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:purpose:list')")
    @GetMapping("/list")
    public TableDataInfo list(TeamPurpose teamPurpose)
    {
        startPage();
        List<TeamPurpose> list = teamPurposeService.selectTeamPurposeList(teamPurpose);
        return getDataTable(list);
    }

    /**
     * 查询团队宗旨列表
     */
    @GetMapping("/list/2Web")
    public AjaxResult list2Web()
    {
        List<TeamPurpose> list = teamPurposeService.selectTeamPurposeList2Web();
        return success(list);
    }

    /**
     * 导出团队宗旨列表
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:purpose:export')")
    @Log(title = "团队宗旨", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TeamPurpose teamPurpose)
    {
        List<TeamPurpose> list = teamPurposeService.selectTeamPurposeList(teamPurpose);
        ExcelUtil<TeamPurpose> util = new ExcelUtil<TeamPurpose>(TeamPurpose.class);
        util.exportExcel(response, list, "团队宗旨数据");
    }

    /**
     * 获取团队宗旨详细信息
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:purpose:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(teamPurposeService.selectTeamPurposeById(id));
    }

    /**
     * 新增团队宗旨
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:purpose:add')")
    @Log(title = "团队宗旨", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeamPurpose teamPurpose)
    {
        return toAjax(teamPurposeService.insertTeamPurpose(teamPurpose));
    }

    /**
     * 修改团队宗旨
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:purpose:edit')")
    @Log(title = "团队宗旨", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeamPurpose teamPurpose)
    {
        return toAjax(teamPurposeService.updateTeamPurpose(teamPurpose));
    }

    /**
     * 删除团队宗旨
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:purpose:remove')")
    @Log(title = "团队宗旨", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teamPurposeService.deleteTeamPurposeByIds(ids));
    }
}
