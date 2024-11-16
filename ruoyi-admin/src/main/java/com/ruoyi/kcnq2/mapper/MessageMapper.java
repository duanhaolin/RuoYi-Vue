package com.ruoyi.kcnq2.mapper;

import java.util.List;
import com.ruoyi.kcnq2.domain.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户留言Mapper接口
 * 
 * @author liufeibo
 * @date 2024-11-16
 */
@Mapper
public interface MessageMapper 
{
    /**
     * 查询用户留言
     * 
     * @param id 用户留言主键
     * @return 用户留言
     */
    public Message selectMessageById(Long id);

    /**
     * 查询用户留言列表
     * 
     * @param message 用户留言
     * @return 用户留言集合
     */
    public List<Message> selectMessageList(Message message);

    /**
     * 新增用户留言
     * 
     * @param message 用户留言
     * @return 结果
     */
    public int insertMessage(Message message);

    /**
     * 修改用户留言
     * 
     * @param message 用户留言
     * @return 结果
     */
    public int updateMessage(Message message);

    /**
     * 删除用户留言
     * 
     * @param id 用户留言主键
     * @return 结果
     */
    public int deleteMessageById(Long id);

    /**
     * 批量删除用户留言
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMessageByIds(Long[] ids);

    int updateMessageDeleteStatusByIds(@Param("array") Long[] ids, @Param("username") String username);
}
