package com.jlt.jlt_webstu.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 *
 * @author jlt
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = -2041596430014620382L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;
}
