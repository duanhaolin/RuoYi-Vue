package com.ruoyi.kcnq2.service.impl;

import java.util.Collections;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.kcnq2.mapper.TeamPurposeMapper;
import com.ruoyi.kcnq2.domain.TeamPurpose;
import com.ruoyi.kcnq2.service.ITeamPurposeService;

/**
 * 团队宗旨Service业务层处理
 * 
 * @author liufeibo
 * @date 2024-11-16
 */
@Service
public class TeamPurposeServiceImpl implements ITeamPurposeService 
{
    @Autowired
    private TeamPurposeMapper teamPurposeMapper;

    /**
     * 查询团队宗旨
     * 
     * @param id 团队宗旨主键
     * @return 团队宗旨
     */
    @Override
    public TeamPurpose selectTeamPurposeById(Long id)
    {
        return teamPurposeMapper.selectTeamPurposeById(id);
    }

    /**
     * 查询团队宗旨列表
     * 
     * @param teamPurpose 团队宗旨
     * @return 团队宗旨
     */
    @Override
    public List<TeamPurpose> selectTeamPurposeList(TeamPurpose teamPurpose)
    {
        return teamPurposeMapper.selectTeamPurposeList(teamPurpose);
    }

    /**
     * 新增团队宗旨
     * 
     * @param teamPurpose 团队宗旨
     * @return 结果
     */
    @Override
    public int insertTeamPurpose(TeamPurpose teamPurpose)
    {
        teamPurpose.setCreateTime(DateUtils.getNowDate());
        teamPurpose.setCreateBy(SecurityUtils.getUsername());
        teamPurpose.setUpdateBy(SecurityUtils.getUsername());
        return teamPurposeMapper.insertTeamPurpose(teamPurpose);
    }

    /**
     * 修改团队宗旨
     * 
     * @param teamPurpose 团队宗旨
     * @return 结果
     */
    @Override
    public int updateTeamPurpose(TeamPurpose teamPurpose)
    {
        teamPurpose.setUpdateTime(DateUtils.getNowDate());
        teamPurpose.setUpdateBy(SecurityUtils.getUsername());
        return teamPurposeMapper.updateTeamPurpose(teamPurpose);
    }

    /**
     * 批量删除团队宗旨
     * 
     * @param ids 需要删除的团队宗旨主键
     * @return 结果
     */
    @Override
    public int deleteTeamPurposeByIds(Long[] ids)
    {
        return teamPurposeMapper.updateTeamPurposeDeleteStatusByIds(ids, SecurityUtils.getUsername());
    }

    /**
     * 删除团队宗旨信息
     * 
     * @param id 团队宗旨主键
     * @return 结果
     */
    @Override
    public int deleteTeamPurposeById(Long id)
    {
        return teamPurposeMapper.updateTeamPurposeDeleteStatusByIds(new Long[] {id}, SecurityUtils.getUsername());
    }

    @Override
    public List<TeamPurpose> selectTeamPurposeList2Web() {
        return teamPurposeMapper.selectTeamPurposeList2Web();
    }
}
