package com.jlt.jlt_webstu.service;

import com.jlt.jlt_webstu.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
* @author jinlintao
*/
public interface UserService extends IService<User> {

    /**
     *
     * @param userAccount 账号
     * @param userPassword 密码
     * @param checkPassword 第二次输入密码
     * @return userId
     */
    long userRegister(String userAccount,String userPassword,String checkPassword,String username);

    /**
     * @param userAccount 账号
     * @param userPassword 密码
     * @return 登陆者信息（脱敏）
     */
    User userLogin(String userAccount,String userPassword,HttpServletRequest request);

    User getSafetyUser(User originUser);

    int userLogout(HttpServletRequest request);
}
