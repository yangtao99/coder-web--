package com.jlt.jlt_webstu.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName auction
 */
@TableName(value ="auction")
@Data
public class Auction implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private String auctionName;

    /**
     * 
     */
    private String auctionImageUrl;

    /**
     * 
     */
    private String auctionMesUrl;

    /**
     * 
     */
    private String auctionMoney;

    /**
     * 
     */
    private String auctionAddMoney;

    /**
     * 
     */
    private String auctionDescription;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}