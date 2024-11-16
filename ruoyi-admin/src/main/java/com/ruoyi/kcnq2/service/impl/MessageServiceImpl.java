package com.ruoyi.kcnq2.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.kcnq2.mapper.MessageMapper;
import com.ruoyi.kcnq2.domain.Message;
import com.ruoyi.kcnq2.service.IMessageService;

/**
 * 用户留言Service业务层处理
 * 
 * @author liufeibo
 * @date 2024-11-16
 */
@Service
public class MessageServiceImpl implements IMessageService 
{
    @Autowired
    private MessageMapper messageMapper;

    /**
     * 查询用户留言
     * 
     * @param id 用户留言主键
     * @return 用户留言
     */
    @Override
    public Message selectMessageById(Long id)
    {
        return messageMapper.selectMessageById(id);
    }

    /**
     * 查询用户留言列表
     * 
     * @param message 用户留言
     * @return 用户留言
     */
    @Override
    public List<Message> selectMessageList(Message message)
    {
        return messageMapper.selectMessageList(message);
    }

    /**
     * 新增用户留言
     * 
     * @param message 用户留言
     * @return 结果
     */
    @Override
    public int insertMessage(Message message)
    {
        message.setCreateBy(SecurityUtils.getUsername());
        message.setUpdateBy(SecurityUtils.getUsername());
        return messageMapper.insertMessage(message);
    }

    /**
     * 修改用户留言
     * 
     * @param message 用户留言
     * @return 结果
     */
    @Override
    public int updateMessage(Message message)
    {
        message.setUpdateTime(DateUtils.getNowDate());
        message.setUpdateBy(SecurityUtils.getUsername());
        return messageMapper.updateMessage(message);
    }

    /**
     * 批量删除用户留言
     * 
     * @param ids 需要删除的用户留言主键
     * @return 结果
     */
    @Override
    public int deleteMessageByIds(Long[] ids)
    {
        //将状态修改成2
        String username = SecurityUtils.getUsername();
        return messageMapper.updateMessageDeleteStatusByIds(ids, username);
    }

    /**
     * 删除用户留言信息
     * 
     * @param id 用户留言主键
     * @return 结果
     */
    @Override
    public int deleteMessageById(Long id)
    {
        return messageMapper.updateMessageDeleteStatusByIds(new Long[]{id}, SecurityUtils.getUsername());
    }
}
