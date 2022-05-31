package com.jlt.jlt_webstu.model.domain.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class QueryAuctionBagRequest implements Serializable {

    private static final long serialVersionUID = -1383406787635293812L;

    private String userID;
}
