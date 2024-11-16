package com.ruoyi.kcnq2.service;

import java.util.List;
import com.ruoyi.kcnq2.domain.TeamPurpose;

/**
 * 团队宗旨Service接口
 * 
 * @author liufeibo
 * @date 2024-11-16
 */
public interface ITeamPurposeService 
{
    /**
     * 查询团队宗旨
     * 
     * @param id 团队宗旨主键
     * @return 团队宗旨
     */
    public TeamPurpose selectTeamPurposeById(Long id);

    /**
     * 查询团队宗旨列表
     * 
     * @param teamPurpose 团队宗旨
     * @return 团队宗旨集合
     */
    public List<TeamPurpose> selectTeamPurposeList(TeamPurpose teamPurpose);

    /**
     * 新增团队宗旨
     * 
     * @param teamPurpose 团队宗旨
     * @return 结果
     */
    public int insertTeamPurpose(TeamPurpose teamPurpose);

    /**
     * 修改团队宗旨
     * 
     * @param teamPurpose 团队宗旨
     * @return 结果
     */
    public int updateTeamPurpose(TeamPurpose teamPurpose);

    /**
     * 批量删除团队宗旨
     * 
     * @param ids 需要删除的团队宗旨主键集合
     * @return 结果
     */
    public int deleteTeamPurposeByIds(Long[] ids);

    /**
     * 删除团队宗旨信息
     * 
     * @param id 团队宗旨主键
     * @return 结果
     */
    public int deleteTeamPurposeById(Long id);

    List<TeamPurpose> selectTeamPurposeList2Web();
}
