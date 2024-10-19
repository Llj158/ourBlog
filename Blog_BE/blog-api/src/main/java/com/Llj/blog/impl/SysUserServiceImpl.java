package com.Llj.blog.impl;

import com.Llj.blog.dao.mapper.SysUserMapper;
import com.Llj.blog.dao.pojo.SysUser;
import com.Llj.blog.service.LoginService;
import com.Llj.blog.service.SysUserService;
import com.Llj.blog.vo.ErrorCode;
import com.Llj.blog.vo.LoginUserVo;
import com.Llj.blog.vo.UserVo;
import com.Llj.blog.vo.params.Result;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @description：
 */
@Service
//@Transactional
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    LoginService loginService;

    @Override
    public UserVo findUserVoById(Long id) {
        SysUser sysUser = sysUserMapper.selectById(id);
        if(sysUser == null){
            sysUser = new SysUser();
            sysUser.setId(1L);
            sysUser.setAvatar("/static/img/user.png");
            sysUser.setNickname("tuwei");
        }
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(sysUser, userVo);
        userVo.setId(String.valueOf(sysUser.getId()));
        return userVo;
    }

    @Override
    public SysUser findUserById(Long userId) {
        SysUser sysUser = sysUserMapper.selectById(userId);
        if(sysUser == null){
            sysUser = new SysUser();
            sysUser.setNickname("tuwei");
        }
        return sysUser;
    }

    @Override
    public SysUser findUser(String account, String password) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getAccount,account);
        queryWrapper.eq(SysUser::getPassword,password);
        queryWrapper.select(SysUser::getAccount, SysUser::getId, SysUser::getAvatar, SysUser::getNickname);
        queryWrapper.last("limit 1");

        return sysUserMapper.selectOne(queryWrapper);
    }

    @Override
    public Result findUserByToken(String token) {
//        1.检验token是否合法
//            是否为空，解析是否成功，redis是否存在
//          2.token检验失败
//            3.token检验成功，返回用户信息


        SysUser sysUser = loginService.checkToken(token);
        if(sysUser == null){
            Result.fail(ErrorCode.TOKEN_ERROR.getCode(), ErrorCode.TOKEN_ERROR.getMsg());
        }
        LoginUserVo loginUserVo = new LoginUserVo();
        loginUserVo.setId(String.valueOf(sysUser.getId()));
        loginUserVo.setAccount(sysUser.getAccount());
        loginUserVo.setNickname(sysUser.getNickname());
        loginUserVo.setAvatar(sysUser.getAvatar());

        return Result.success(loginUserVo);
    }

    //通过账户查询已经存在的用户信息
    @Override
    public SysUser findUserByAccount(String account) {
        LambdaQueryWrapper<SysUser> qw = new LambdaQueryWrapper<>();
        qw.eq(SysUser::getAccount,account).last("limit 1");

        return this.sysUserMapper.selectOne(qw);
    }

    //注册功能-添加用户信息到数据库
    @Override
    public void save(SysUser sysUser) {
        sysUserMapper.insert(sysUser);
    }
}
