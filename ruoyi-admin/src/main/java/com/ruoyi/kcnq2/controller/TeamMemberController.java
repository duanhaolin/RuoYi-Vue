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
import com.ruoyi.kcnq2.domain.TeamMember;
import com.ruoyi.kcnq2.service.ITeamMemberService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 团队成员管理Controller
 * 
 * @author liufeibo
 * @date 2024-11-16
 */
@RestController
@RequestMapping("/kcnq2/member")
public class TeamMemberController extends BaseController
{
    @Autowired
    private ITeamMemberService teamMemberService;

    /**
     * 查询团队成员管理列表
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:member:list')")
    @GetMapping("/list")
    public TableDataInfo list(TeamMember teamMember)
    {
        startPage();
        List<TeamMember> list = teamMemberService.selectTeamMemberList(teamMember);
        return getDataTable(list);
    }

    /**
     * 查询团队成员管理列表
     */
    @GetMapping("/list/2Web")
    public AjaxResult list2Web()
    {
        List<TeamMember> list = teamMemberService.selectTeamMemberList2Web();
        return success(list);
    }

    /**
     * 导出团队成员管理列表
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:member:export')")
    @Log(title = "团队成员管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TeamMember teamMember)
    {
        List<TeamMember> list = teamMemberService.selectTeamMemberList(teamMember);
        ExcelUtil<TeamMember> util = new ExcelUtil<TeamMember>(TeamMember.class);
        util.exportExcel(response, list, "团队成员管理数据");
    }

    /**
     * 获取团队成员管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:member:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(teamMemberService.selectTeamMemberById(id));
    }

    /**
     * 新增团队成员管理
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:member:add')")
    @Log(title = "团队成员管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeamMember teamMember)
    {
        return toAjax(teamMemberService.insertTeamMember(teamMember));
    }

    /**
     * 修改团队成员管理
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:member:edit')")
    @Log(title = "团队成员管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeamMember teamMember)
    {
        return toAjax(teamMemberService.updateTeamMember(teamMember));
    }

    /**
     * 删除团队成员管理
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:member:remove')")
    @Log(title = "团队成员管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teamMemberService.deleteTeamMemberByIds(ids));
    }
}
