package com.ruoyi.kcnq2.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.kcnq2.mapper.TeamMemberMapper;
import com.ruoyi.kcnq2.domain.TeamMember;
import com.ruoyi.kcnq2.service.ITeamMemberService;

/**
 * 团队成员管理Service业务层处理
 *
 * @author liufeibo
 * @date 2024-11-16
 */
@Service
public class TeamMemberServiceImpl implements ITeamMemberService
{
    @Autowired
    private TeamMemberMapper teamMemberMapper;

    /**
     * 查询团队成员管理
     *
     * @param id 团队成员管理主键
     * @return 团队成员管理
     */
    @Override
    public TeamMember selectTeamMemberById(Long id)
    {
        return teamMemberMapper.selectTeamMemberById(id);
    }

    /**
     * 管理端查询团队成员管理列表
     *
     * @param teamMember 团队成员管理
     * @return 团队成员管理
     */
    @Override
    public List<TeamMember> selectTeamMemberList(TeamMember teamMember)
    {
        return teamMemberMapper.selectTeamMemberList(teamMember);
    }

    /**
     * web端查询团队成员管理列表
     *
     * @return 团队成员管理
     */
    @Override
    public List<TeamMember> selectTeamMemberList2Web()
    {
        return teamMemberMapper.selectTeamMemberList2Web();
    }

    /**
     * 新增团队成员管理
     *
     * @param teamMember 团队成员管理
     * @return 结果
     */
    @Override
    public int insertTeamMember(TeamMember teamMember)
    {
        teamMember.setCreateTime(DateUtils.getNowDate());
        teamMember.setCreateBy(SecurityUtils.getUsername());
        teamMember.setUpdateBy(SecurityUtils.getUsername());
        return teamMemberMapper.insertTeamMember(teamMember);
    }

    /**
     * 修改团队成员管理
     *
     * @param teamMember 团队成员管理
     * @return 结果
     */
    @Override
    public int updateTeamMember(TeamMember teamMember)
    {
        teamMember.setUpdateTime(DateUtils.getNowDate());
        teamMember.setUpdateBy(SecurityUtils.getUsername());
        return teamMemberMapper.updateTeamMember(teamMember);
    }

    /**
     * 批量删除团队成员管理
     *
     * @param ids 需要删除的团队成员管理主键
     * @return 结果
     */
    @Override
    public int deleteTeamMemberByIds(Long[] ids)
    {
        return teamMemberMapper.updateTeamMemberDeleteStatusByIds(ids, SecurityUtils.getUsername());
    }

    /**
     * 删除团队成员管理信息
     *
     * @param id 团队成员管理主键
     * @return 结果
     */
    @Override
    public int deleteTeamMemberById(Long id)
    {
        return teamMemberMapper.updateTeamMemberDeleteStatusByIds(new Long[] { id }, SecurityUtils.getUsername());
    }
}
