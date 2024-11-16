import request from '@/utils/request'

// 查询团队宗旨列表
export function listPurpose(query) {
  return request({
    url: '/kcnq2/purpose/list',
    method: 'get',
    params: query
  })
}

// 查询团队宗旨详细
export function getPurpose(id) {
  return request({
    url: '/kcnq2/purpose/' + id,
    method: 'get'
  })
}

// 新增团队宗旨
export function addPurpose(data) {
  return request({
    url: '/kcnq2/purpose',
    method: 'post',
    data: data
  })
}

// 修改团队宗旨
export function updatePurpose(data) {
  return request({
    url: '/kcnq2/purpose',
    method: 'put',
    data: data
  })
}

// 删除团队宗旨
export function delPurpose(id) {
  return request({
    url: '/kcnq2/purpose/' + id,
    method: 'delete'
  })
}
