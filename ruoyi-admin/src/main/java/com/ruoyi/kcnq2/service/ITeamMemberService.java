package com.ruoyi.kcnq2.service;

import java.util.List;
import com.ruoyi.kcnq2.domain.TeamMember;

/**
 * 团队成员管理Service接口
 * 
 * @author liufeibo
 * @date 2024-11-16
 */
public interface ITeamMemberService 
{
    /**
     * 查询团队成员管理
     * 
     * @param id 团队成员管理主键
     * @return 团队成员管理
     */
    public TeamMember selectTeamMemberById(Long id);

    /**
     * 查询团队成员管理列表
     * 
     * @param teamMember 团队成员管理
     * @return 团队成员管理集合
     */
    public List<TeamMember> selectTeamMemberList(TeamMember teamMember);

    public List<TeamMember> selectTeamMemberList2Web();

    /**
     * 新增团队成员管理
     * 
     * @param teamMember 团队成员管理
     * @return 结果
     */
    public int insertTeamMember(TeamMember teamMember);

    /**
     * 修改团队成员管理
     * 
     * @param teamMember 团队成员管理
     * @return 结果
     */
    public int updateTeamMember(TeamMember teamMember);

    /**
     * 批量删除团队成员管理
     * 
     * @param ids 需要删除的团队成员管理主键集合
     * @return 结果
     */
    public int deleteTeamMemberByIds(Long[] ids);

    /**
     * 删除团队成员管理信息
     * 
     * @param id 团队成员管理主键
     * @return 结果
     */
    public int deleteTeamMemberById(Long id);
}
