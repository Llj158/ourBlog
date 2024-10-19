package com.Llj.blog.service;

import com.Llj.blog.dao.pojo.SysUser;
import com.Llj.blog.vo.params.LoginParam;
import com.Llj.blog.vo.params.Result;

/**
 * @description：
 */
public interface LoginService {

    /**
     * 登录功能
     * @param loginParam
     * @return
     */
    Result login(LoginParam loginParam);

    /**
     * 查询token
     * @param token
     * @return
     */
    SysUser checkToken(String token);

    /**
     * 退出登录
     * @param token
     * @return
     */
    Result logout(String token);

    /**
     * 注册登录
     * @param loginParam
     * @return
     */
    Result register(LoginParam loginParam);
}
