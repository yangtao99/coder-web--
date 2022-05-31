package com.jlt.jlt_webstu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jlt.jlt_webstu.mapper.AuctionBagMapper;
import com.jlt.jlt_webstu.model.domain.Auction;
import com.jlt.jlt_webstu.model.domain.AuctionBag;
import com.jlt.jlt_webstu.model.domain.request.AddAuctionBagRequest;
import com.jlt.jlt_webstu.model.domain.request.AddAuctionRequest;
import com.jlt.jlt_webstu.model.domain.request.QueryAuctionBagRequest;
import com.jlt.jlt_webstu.service.AuctionService;
import com.jlt.jlt_webstu.service.AuctionbagService;
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
@RequestMapping("/auctionBag")
public class AuctionBagController {

    @Resource
    private AuctionbagService auctionbagService;

    @PostMapping("/queryAuctionBag")
    public List<AuctionBag> queryAuctionBag(@RequestBody QueryAuctionBagRequest queryAuctionBagRequest){

        String userID = queryAuctionBagRequest.getUserID();

        List<AuctionBag> list = auctionbagService.queryAuctionBag(userID);

        Collections.reverse(list);

        return list;



    }

    @PostMapping("/addAuctionBag")
    public Long addAuctionBag(@RequestBody AddAuctionBagRequest addAuctionBagRequest){

        AuctionBag auctionBag = new AuctionBag();
        auctionBag.setUsername(addAuctionBagRequest.getUsername());
        auctionBag.setUserID(addAuctionBagRequest.getUserID());
        auctionBag.setAuctionName(addAuctionBagRequest.getAuctionName());
        auctionBag.setAuctionMesUrl(addAuctionBagRequest.getAuctionMesUrl());
        auctionBag.setAuctionImageUrl(addAuctionBagRequest.getAuctionImageUrl());
        auctionBag.setAuctionDescription(addAuctionBagRequest.getAuctionDescription());
        auctionBag.setAuctionID(addAuctionBagRequest.getAuctionID());

        QueryWrapper<AuctionBag> auctionBagQueryWrapper = new QueryWrapper<>();

        auctionBagQueryWrapper.eq("auctionID",auctionBag.getAuctionID())
                .eq("userID",auctionBag.getUserID());

        AuctionBag repeat = auctionbagService.getOne(auctionBagQueryWrapper);

        if (repeat!=null){
            return -1L;
        }

        auctionbagService.save(auctionBag);
        return auctionBag.getId();
    }

    @PostMapping("removeAuctionBag")
    public Long removeAuctionBag(@RequestBody String auctionID){

        QueryWrapper<AuctionBag> auctionBagQueryWrapper = new QueryWrapper<>();

        auctionBagQueryWrapper.eq("auctionID",auctionID);

        if(auctionbagService.remove(auctionBagQueryWrapper)){
            return 1L;
        }else {
            return -1L;
        }

    }


}