package com.Llj.blog.service;

import com.Llj.blog.dao.pojo.SysUser;
import com.Llj.blog.vo.UserVo;
import com.Llj.blog.vo.params.Result;

/**
 * @description：
 */
public interface SysUserService {

//  根据id查询UserVo
    UserVo findUserVoById(Long id);

//  根据id查询账户信息
    SysUser findUserById(Long id);

//    通过账户名和密码
    SysUser findUser(String account, String password);

//    通过token检验用户
    Result findUserByToken(String token);

//    通过账户查找用户信息
    SysUser findUserByAccount(String account);

//    添加用户信息
    void save(SysUser sysUser);
}
