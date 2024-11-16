import request from '@/utils/request'

// 查询用户留言列表
export function listMessage(query) {
  return request({
    url: '/kcnq2/message/list',
    method: 'get',
    params: query
  })
}

// 查询用户留言详细
export function getMessage(id) {
  return request({
    url: '/kcnq2/message/' + id,
    method: 'get'
  })
}

// 新增用户留言
export function addMessage(data) {
  return request({
    url: '/kcnq2/message',
    method: 'post',
    data: data
  })
}

// 修改用户留言
export function updateMessage(data) {
  return request({
    url: '/kcnq2/message',
    method: 'put',
    data: data
  })
}

// 删除用户留言
export function delMessage(id) {
  return request({
    url: '/kcnq2/message/' + id,
    method: 'delete'
  })
}
