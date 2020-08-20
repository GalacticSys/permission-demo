import HTTPUtil from './HTTPUtil'




/**
 * 登陆
 */
export const login = data => HTTPUtil.post('/api/authentication/form', data);


/**
 * 退出
 */
export const logout =() => HTTPUtil.post('/api/logout');


/**
 * 获取用户信息
 */
export const getUserList = (data) => HTTPUtil.post('/api/sysUser/queryAllBySysUser',data);


/**
 * 添加用户信息
 */
export const addUser = (data) => HTTPUtil.post('/api/sysUser/insert',data);


/**
 * 删除用户信息
 */
export const deleteUser = (data) => HTTPUtil.delete('/api/sysUser/deleteById',data);







/**
 * 获取所有角色信息
 */
export const getRoleList = (data) => HTTPUtil.post('/api/sysRole/queryAllBySysRole',data);


/**
 * 通过用户id查询角色
 */
export const queryAllByUserId = (data) => HTTPUtil.get('/api/sysRole/queryAllByUserId',data);


/**
 * 添加角色信息
 */
export const addRole = (data) => HTTPUtil.post('/api/sysRole/insert',data);


/**
 * 删除角色信息
 */
export const deleteRole = (data) => HTTPUtil.delete('/api/sysRole/deleteById',data);





/**
 * 获取权限信息
 */
export const getPermissionList = (data) => HTTPUtil.post('/api/sysPermission/queryAllByPermission',data);


/**
 * 通过角色id查询权限
 */
export const queryByRoleId = (data) => HTTPUtil.get('/api/sysPermission/queryByRoleId',data);


/**
 * 添加权限信息
 */
export const addPermission = (data) => HTTPUtil.post('/api/sysPermission/insert',data);


/**
 * 删除权限信息
 */
export const deletePermission = (data) => HTTPUtil.delete('/api/sysPermission/deleteById',data);





/**
 * 分配权限
 */
export const assignPermission = (data) => HTTPUtil.post('/api/sysRolePermissionRelation/insertAll',data);


/**
 * 分配角色
 */
export const assignRoles = (data) => HTTPUtil.post('/api/sysUserRoleRelation/insertAll',data);
