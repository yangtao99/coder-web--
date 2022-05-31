package com.jlt.jlt_webstu.service;

import com.jlt.jlt_webstu.model.domain.Auction;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author jinlintao
* @description 针对表【auction】的数据库操作Service
* @createDate 2022-05-23 23:03:05
*/
public interface AuctionService extends IService<Auction> {


    Long addAuction(String auctionName,String auctionImageUrl, String auctionMesUrl,String auctionDescription,String auctionMoney,String auctionAddMoney);


    List<Auction> searchAuction(List<Auction> list, String value);

}
