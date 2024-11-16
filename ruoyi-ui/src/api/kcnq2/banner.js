import request from '@/utils/request'

// 查询Banner配置列表
export function listBanner(query) {
  return request({
    url: '/kcnq2/banner/list',
    method: 'get',
    params: query
  })
}

// 查询Banner配置详细
export function getBanner(id) {
  return request({
    url: '/kcnq2/banner/' + id,
    method: 'get'
  })
}

// 新增Banner配置
export function addBanner(data) {
  return request({
    url: '/kcnq2/banner',
    method: 'post',
    data: data
  })
}

// 修改Banner配置
export function updateBanner(data) {
  return request({
    url: '/kcnq2/banner',
    method: 'put',
    data: data
  })
}

// 删除Banner配置
export function delBanner(id) {
  return request({
    url: '/kcnq2/banner/' + id,
    method: 'delete'
  })
}
