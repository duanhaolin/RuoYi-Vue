-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户留言', '2000', '1', 'message', 'kcnq2/message/index', 1, 0, 'C', '0', '0', 'kcnq2:message:list', '#', 'admin', sysdate(), '', null, '用户留言菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户留言查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'kcnq2:message:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户留言新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'kcnq2:message:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户留言修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'kcnq2:message:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户留言删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'kcnq2:message:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户留言导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'kcnq2:message:export',       '#', 'admin', sysdate(), '', null, '');