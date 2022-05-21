package com.jlt.jlt_webstu.model.domain.request;

import lombok.Data;

import java.io.Serializable;


/**
 * 用户登陆请求体
 *
 * @author jlt
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = 1839527585346465789L;

    private String userAccount;

    private String userPassword;

}
