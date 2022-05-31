package com.jlt.jlt_webstu.service;

import com.jlt.jlt_webstu.model.domain.Auction;
import com.jlt.jlt_webstu.model.domain.AuctionBag;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author jinlintao
* @description 针对表【auctionBag】的数据库操作Service
* @createDate 2022-05-27 09:18:35
*/
public interface AuctionbagService extends IService<AuctionBag> {

    List<AuctionBag> queryAuctionBag(String userID);

}
