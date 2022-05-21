package com.jlt.jlt_webstu.model.domain.request;

import lombok.Data;

import java.io.Serializable;


/**
 * 用户搜索请求体
 *
 * @author jlt
 */
@Data
public class UserSearchRequest implements Serializable {

    private static final long serialVersionUID = -4057549280227848858L;

    private String username;


}
