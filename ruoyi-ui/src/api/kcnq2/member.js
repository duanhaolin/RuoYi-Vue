import request from '@/utils/request'

// 查询团队成员管理列表
export function listMember(query) {
  return request({
    url: '/kcnq2/member/list',
    method: 'get',
    params: query
  })
}

// 查询团队成员管理详细
export function getMember(id) {
  return request({
    url: '/kcnq2/member/' + id,
    method: 'get'
  })
}

// 新增团队成员管理
export function addMember(data) {
  return request({
    url: '/kcnq2/member',
    method: 'post',
    data: data
  })
}

// 修改团队成员管理
export function updateMember(data) {
  return request({
    url: '/kcnq2/member',
    method: 'put',
    data: data
  })
}

// 删除团队成员管理
export function delMember(id) {
  return request({
    url: '/kcnq2/member/' + id,
    method: 'delete'
  })
}
