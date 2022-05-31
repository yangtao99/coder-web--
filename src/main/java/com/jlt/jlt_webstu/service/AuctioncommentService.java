package com.jlt.jlt_webstu.service;

import com.jlt.jlt_webstu.model.domain.Auctioncomment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author jinlintao
* @description 针对表【auctionComment】的数据库操作Service
* @createDate 2022-05-28 20:52:55
*/
public interface AuctioncommentService extends IService<Auctioncomment> {

    Long addAuctionComment(Auctioncomment auctioncomment);

}
