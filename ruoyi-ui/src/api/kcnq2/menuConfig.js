import request from '@/utils/request'

// 查询菜单配置列表
export function listMenuConfig(query) {
  return request({
    url: '/kcnq2/menuConfig/list',
    method: 'get',
    params: query
  })
}

// 查询菜单配置详细
export function getMenuConfig(id) {
  return request({
    url: '/kcnq2/menuConfig/' + id,
    method: 'get'
  })
}

// 新增菜单配置
export function addMenuConfig(data) {
  return request({
    url: '/kcnq2/menuConfig',
    method: 'post',
    data: data
  })
}

// 修改菜单配置
export function updateMenuConfig(data) {
  return request({
    url: '/kcnq2/menuConfig',
    method: 'put',
    data: data
  })
}

// 删除菜单配置
export function delMenuConfig(id) {
  return request({
    url: '/kcnq2/menuConfig/' + id,
    method: 'delete'
  })
}
