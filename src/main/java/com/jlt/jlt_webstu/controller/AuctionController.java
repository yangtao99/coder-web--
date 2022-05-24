package com.jlt.jlt_webstu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jlt.jlt_webstu.mapper.AuctionMapper;
import com.jlt.jlt_webstu.model.domain.Auction;
import com.jlt.jlt_webstu.model.domain.request.AddAuctionRequest;
import com.jlt.jlt_webstu.service.AuctionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;


/**
 * @author jinlintao
 */
@RestController
@RequestMapping("/auction")
public class AuctionController {

    @Resource
    private AuctionService auctionService;

    @PostMapping("/addAuction")
    public Long addAuction(@RequestBody AddAuctionRequest addAuctionRequest) {
        if (addAuctionRequest == null) {
            return null;
        }
        String auctionName = addAuctionRequest.getAuctionName();
        String auctionImageUrl = addAuctionRequest.getAuctionImageUrl();
        String auctionMesUrl= addAuctionRequest.getAuctionMesUrl();
        String auctionDescription = addAuctionRequest.getAuctionDescription();
        String auctionMoney = addAuctionRequest.getAuctionMoney();
        String auctionAddMoney = addAuctionRequest.getAuctionAddMoney();
        if (StringUtils.isAnyBlank(auctionAddMoney,auctionName,auctionDescription,auctionMesUrl,auctionMoney,auctionImageUrl)){
            return null;
        }
        return auctionService.addAuction( auctionName,  auctionImageUrl,  auctionMesUrl,  auctionDescription,  auctionMoney,  auctionAddMoney);
    }


    @PostMapping("/searchAllAuction")
    public List<Auction> searchAllAuction(){

        QueryWrapper<Auction> auctionQueryWrapper = new QueryWrapper<>();

        auctionQueryWrapper.like("auctionName","");

        List<Auction> list = auctionService.list(auctionQueryWrapper);

        Collections.reverse(list);

        return list;
    }


}