package com.lanxin.dao;

import java.util.Set;

/**
 * Created by Administrator on 2020/8/11 0011.
 */
public interface RoleDao {

    //通过用户名查询密码
    public String selectPassByUsername(String username);

    //通过用户名，查询权限
    public Set<String> selectPermsByUsername(String username);

    //通过用户名查询角色
    public Set<String> selectRolesByUsername(String username);
}
