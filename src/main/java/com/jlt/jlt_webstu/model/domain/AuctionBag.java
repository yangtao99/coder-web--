package com.jlt.jlt_webstu.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName auctionBag
 */
@TableName(value ="auctionBag")
@Data
public class AuctionBag implements Serializable {
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
    private String userID;

    /**
     * 
     */
    private String auctionName;

    /**
     * 
     */
    private String auctionMesUrl;

    /**
     * 
     */
    private String auctionImageUrl;

    /**
     * 
     */
    private String auctionDescription;

    /**
     * 
     */
    private String auctionID;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AuctionBag other = (AuctionBag) that;
        return  (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getUserID() == null ? other.getUserID() == null : this.getUserID().equals(other.getUserID()))
            && (this.getAuctionName() == null ? other.getAuctionName() == null : this.getAuctionName().equals(other.getAuctionName()))
            && (this.getAuctionMesUrl() == null ? other.getAuctionMesUrl() == null : this.getAuctionMesUrl().equals(other.getAuctionMesUrl()))
            && (this.getAuctionImageUrl() == null ? other.getAuctionImageUrl() == null : this.getAuctionImageUrl().equals(other.getAuctionImageUrl()))
            && (this.getAuctionDescription() == null ? other.getAuctionDescription() == null : this.getAuctionDescription().equals(other.getAuctionDescription()))
            && (this.getAuctionID() == null ? other.getAuctionID() == null : this.getAuctionID().equals(other.getAuctionID()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getUserID() == null) ? 0 : getUserID().hashCode());
        result = prime * result + ((getAuctionName() == null) ? 0 : getAuctionName().hashCode());
        result = prime * result + ((getAuctionMesUrl() == null) ? 0 : getAuctionMesUrl().hashCode());
        result = prime * result + ((getAuctionImageUrl() == null) ? 0 : getAuctionImageUrl().hashCode());
        result = prime * result + ((getAuctionDescription() == null) ? 0 : getAuctionDescription().hashCode());
        result = prime * result + ((getAuctionID() == null) ? 0 : getAuctionID().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", username=").append(username);
        sb.append(", userID=").append(userID);
        sb.append(", auctionName=").append(auctionName);
        sb.append(", auctionMesUrl=").append(auctionMesUrl);
        sb.append(", auctionImageUrl=").append(auctionImageUrl);
        sb.append(", auctionDescription=").append(auctionDescription);
        sb.append(", auctionID=").append(auctionID);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}