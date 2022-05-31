package com.jlt.jlt_webstu.model.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     *
     */
    @TableLogic
    private Integer isDelete;
    /**
     *
     */
    private Date updateTime;
    /**
     *
     */
    private Date createTime;
    /**
     *
     */
    private Integer userStatus;

    /**
     *
     */
    private String email;

    /**
     *
     */
    private String phone;

    /**
     *
     */
    private String userPassword;

    /**
     *
     */
    private Integer gender;

    /**
     *
     */
    private String avatarUrl;

    /**
     *
     */
    private String userAccount;

    /**
     *
     */
    private String username;

    /**
     *
     */
    private Integer userRole;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", isDelete=" + isDelete +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                ", userStatus=" + userStatus +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", gender=" + gender +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", username='" + username + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}