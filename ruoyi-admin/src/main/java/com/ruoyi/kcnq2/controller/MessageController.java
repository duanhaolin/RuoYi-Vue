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
import com.ruoyi.kcnq2.domain.Message;
import com.ruoyi.kcnq2.service.IMessageService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户留言Controller
 * 
 * @author liufeibo
 * @date 2024-11-16
 */
@RestController
@RequestMapping("/kcnq2/message")
public class MessageController extends BaseController
{
    @Autowired
    private IMessageService messageService;

    /**
     * 查询用户留言列表
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:message:list')")
    @GetMapping("/list")
    public TableDataInfo list(Message message)
    {
        startPage();
        List<Message> list = messageService.selectMessageList(message);
        return getDataTable(list);
    }

    /**
     * 导出用户留言列表
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:message:export')")
    @Log(title = "用户留言", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Message message)
    {
        List<Message> list = messageService.selectMessageList(message);
        ExcelUtil<Message> util = new ExcelUtil<Message>(Message.class);
        util.exportExcel(response, list, "用户留言数据");
    }

    /**
     * 获取用户留言详细信息
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:message:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(messageService.selectMessageById(id));
    }

    /**
     * 管理端新增用户留言
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:message:add')")
    @Log(title = "用户留言", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Message message)
    {
        return toAjax(messageService.insertMessage(message));
    }

    /**
     * 用户新增用户留言
     */
    @Log(title = "用户留言", businessType = BusinessType.INSERT)
    @PostMapping("/userAdd")
    public AjaxResult userAdd(@RequestBody Message message)
    {
        return toAjax(messageService.insertMessage(message));
    }

    /**
     * 修改用户留言
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:message:edit')")
    @Log(title = "用户留言", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Message message)
    {
        return toAjax(messageService.updateMessage(message));
    }

    /**
     * 删除用户留言
     */
    @PreAuthorize("@ss.hasPermi('kcnq2:message:remove')")
    @Log(title = "用户留言", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(messageService.deleteMessageByIds(ids));
    }
}
