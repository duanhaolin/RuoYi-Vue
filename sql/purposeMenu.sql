-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('团队宗旨', '2000', '1', 'purpose', 'kcnq2/purpose/index', 1, 0, 'C', '0', '0', 'kcnq2:purpose:list', '#', 'admin', sysdate(), '', null, '团队宗旨菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('团队宗旨查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'kcnq2:purpose:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('团队宗旨新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'kcnq2:purpose:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('团队宗旨修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'kcnq2:purpose:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('团队宗旨删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'kcnq2:purpose:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('团队宗旨导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'kcnq2:purpose:export',       '#', 'admin', sysdate(), '', null, '');