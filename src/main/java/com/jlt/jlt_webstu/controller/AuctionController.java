package com.jlt.jlt_webstu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jlt.jlt_webstu.model.domain.Auction;
import com.jlt.jlt_webstu.model.domain.request.AddAuctionRequest;
import com.jlt.jlt_webstu.service.AuctionService;
import com.jlt.jlt_webstu.utils.HandleAuctionList;
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

    String searchValue = "";

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
        this.searchValue="";
        return auctionService.addAuction( auctionName,  auctionImageUrl,  auctionMesUrl,  auctionDescription,  auctionMoney,  auctionAddMoney);
    }


    @PostMapping("/searchAllAuction")
    public List<Auction> searchAllAuction(){

        QueryWrapper<Auction> auctionQueryWrapper = new QueryWrapper<>();

        auctionQueryWrapper.like("auctionName","");

        List<Auction> list = auctionService.list(auctionQueryWrapper);

        list = auctionService.searchAuction(list,searchValue);

        Collections.reverse(list);

        List handleList = HandleAuctionList.repeatListWayOne(list);

        return handleList;
    }

    @PostMapping("/searchAuction")
    public List<Auction> searchAuction(@RequestBody String value){

       // String value = searchAuctionRequest.getValue();
        this.searchValue = value;

        QueryWrapper<Auction> auctionQueryWrapper = new QueryWrapper<>();

        auctionQueryWrapper.like("auctionName","");

        List<Auction> list = auctionService.list(auctionQueryWrapper);

        list = auctionService.searchAuction(list,value);

        Collections.reverse(list);

        List handleList = HandleAuctionList.repeatListWayOne(list);

        return handleList;
    }

}