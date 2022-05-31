package com.jlt.jlt_webstu.model.domain.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class SearchAuctionRequest implements Serializable {

    private static final long serialVersionUID = -2476627749923140198L;

    private String value;
}
