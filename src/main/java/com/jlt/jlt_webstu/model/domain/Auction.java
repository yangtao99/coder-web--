package com.jlt.jlt_webstu.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "Auction{" +
                "id=" + id +
                ", auctionName='" + auctionName + '\'' +
                ", auctionImageUrl='" + auctionImageUrl + '\'' +
                ", auctionMesUrl='" + auctionMesUrl + '\'' +
                ", auctionMoney='" + auctionMoney + '\'' +
                ", auctionAddMoney='" + auctionAddMoney + '\'' +
                ", auctionDescription='" + auctionDescription + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auction auction = (Auction) o;
        return id.equals(auction.id) && auctionName.equals(auction.auctionName) && auctionImageUrl.equals(auction.auctionImageUrl) && auctionMesUrl.equals(auction.auctionMesUrl) && auctionMoney.equals(auction.auctionMoney) && auctionAddMoney.equals(auction.auctionAddMoney) && auctionDescription.equals(auction.auctionDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, auctionName, auctionImageUrl, auctionMesUrl, auctionMoney, auctionAddMoney, auctionDescription);
    }

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}