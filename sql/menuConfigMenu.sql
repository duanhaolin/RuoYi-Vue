-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('菜单配置', '2000', '1', 'menuConfig', 'kcnq2/menuConfig/index', 1, 0, 'C', '0', '0', 'kcnq2:menuConfig:list', '#', 'admin', sysdate(), '', null, '菜单配置菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('菜单配置查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'kcnq2:menuConfig:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('菜单配置新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'kcnq2:menuConfig:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('菜单配置修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'kcnq2:menuConfig:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('菜单配置删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'kcnq2:menuConfig:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('菜单配置导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'kcnq2:menuConfig:export',       '#', 'admin', sysdate(), '', null, '');