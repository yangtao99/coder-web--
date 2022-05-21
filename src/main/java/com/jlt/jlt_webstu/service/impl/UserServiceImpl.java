package com.jlt.jlt_webstu.service.impl;
import java.util.Date;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jlt.jlt_webstu.model.domain.User;
import com.jlt.jlt_webstu.service.UserService;
import com.jlt.jlt_webstu.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.jlt.jlt_webstu.contant.UserConstant.USER_LOGIN_STATE;

/**
 * @author jinlintao
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 混淆密码，提高加密性能
     */
    private static final String SALT = "jlt";


    @Override
    public long userRegister(String userAccount, String userPassword, String checkPassword) {


        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword)) {
            return -1;
        }
        if (userAccount.length() < 4) {
            return -1;
        }
        if (userPassword.length() < 8 || checkPassword.length() < 8) {
            return -1;
        }


        String validPattern = "\\pP|\\pS|\\s+";
        Matcher matcher = Pattern.compile(validPattern).matcher(userAccount);
        if (matcher.find()) {
            return -1;
        }

        if (!userPassword.equals(checkPassword)) {
            return -1;
        }

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("userAccount", userAccount);
        long count = userMapper.selectCount(userQueryWrapper);
        if (count > 0) {
            return -1;
        }
        String handledPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes(StandardCharsets.UTF_8));

        User user = new User();
        user.setUserAccount(userAccount);
        user.setUserPassword(handledPassword);

        boolean saveResult = this.save(user);
        if (saveResult) {
            return user.getId();
        } else {
            return -1;
        }

    }

    @Override
    public User userLogin(String userAccount, String userPassword, HttpServletRequest request) {

        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            return null;
        }
        if (userAccount.length() < 4) {
            return null;
        }
        if (userPassword.length() < 8 ) {
            return null;
        }


        String validPattern = "\\pP|\\pS|\\s+";
        Matcher matcher = Pattern.compile(validPattern).matcher(userAccount);
        if (matcher.find()) {
            return null;
        }


        String handledPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes(StandardCharsets.UTF_8));
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("userAccount", userAccount);
        userQueryWrapper.eq("userPassword", handledPassword);
        User user = userMapper.selectOne(userQueryWrapper);
        if (user == null){
            log.info("user login failed, userAccount cannot match userPassword");
            return null;
        }

        User handledUser = getSafetyUser(user);

        request.getSession().setAttribute(USER_LOGIN_STATE,handledUser);
        request.getSession();
        return handledUser;
    }


    @Override
    public User getSafetyUser(User originUser){
        if (originUser == null){
            return null;
        }
        User handledUser = new User();
        handledUser.setId(originUser.getId());
        handledUser.setUsername(originUser.getUsername());
        handledUser.setUserAccount(originUser.getUserAccount());
        handledUser.setAvatarUrl(originUser.getAvatarUrl());
        handledUser.setGender(originUser.getGender());
        handledUser.setPhone(originUser.getPhone());
        handledUser.setEmail(originUser.getEmail());
        handledUser.setUserRole(originUser.getUserRole());
        handledUser.setUserStatus(originUser.getUserStatus());
        handledUser.setCreateTime(originUser.getCreateTime());
        return handledUser;
    }

    @Override
    public int userLogout(HttpServletRequest request) {
        request.getSession().removeAttribute(USER_LOGIN_STATE);
        return 1;
    }


}




