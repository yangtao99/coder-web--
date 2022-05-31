package com.jlt.jlt_webstu.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName auctionComment
 */
@TableName(value ="auctionComment")
@Data
public class Auctioncomment implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private String userAvatar;

    /**
     * 
     */
    private String content;

    /**
     * 
     */
    private String price;

    /**
     * 
     */
    private String auctionID;

    public Auctioncomment(String username, String userAvatar, String content, String price, String auctionID) {
        this.id = id;
        this.username = username;
        this.userAvatar = userAvatar;
        this.content = content;
        this.price = price;
        this.auctionID = auctionID;
    }

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}