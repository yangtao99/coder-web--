package com.jlt.jlt_webstu.model.domain.request;

import lombok.Data;

@Data
public class AddAuctionCommentRequest {
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
    private String auctionID;

    /**
     *
     */
    private String price;

    /**
     *
     */
    private String content;



}
