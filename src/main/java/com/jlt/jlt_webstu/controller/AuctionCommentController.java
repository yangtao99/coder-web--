package com.jlt.jlt_webstu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jlt.jlt_webstu.model.domain.Auction;
import com.jlt.jlt_webstu.model.domain.AuctionBag;
import com.jlt.jlt_webstu.model.domain.Auctioncomment;
import com.jlt.jlt_webstu.model.domain.request.AddAuctionCommentRequest;
import com.jlt.jlt_webstu.model.domain.request.AddAuctionRequest;
import com.jlt.jlt_webstu.model.domain.request.QueryAuctionBagRequest;
import com.jlt.jlt_webstu.service.AuctionService;
import com.jlt.jlt_webstu.service.AuctioncommentService;
import com.jlt.jlt_webstu.utils.HandleAuctionList;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;


/**
 * @author jinlintao
 */
@RestController
@RequestMapping("/auctionComment")
public class AuctionCommentController {


    @Resource
    AuctioncommentService auctioncommentService;

    @PostMapping("/addAuctionComment")
    public Long searchAuction(@RequestBody AddAuctionCommentRequest request){

        String auctionID = request.getAuctionID();
        String content = request.getContent();
        String price = request.getPrice();
        String username = request.getUsername();
        String userAvatar = request.getUserAvatar();

        Auctioncomment auctioncomment = new Auctioncomment(username, userAvatar, content, price, auctionID);

        return auctioncommentService.addAuctionComment(auctioncomment);

    }


    @PostMapping("/queryAuctionComment")
    public List<Auctioncomment> queryAuctionCommentBag(@RequestBody String auctionID){

        QueryWrapper<Auctioncomment> auctioncommentQueryWrapper = new QueryWrapper<>();

        auctioncommentQueryWrapper.eq("auctionID",auctionID);

        List<Auctioncomment> list = auctioncommentService.list(auctioncommentQueryWrapper);

        return list;

    }


}