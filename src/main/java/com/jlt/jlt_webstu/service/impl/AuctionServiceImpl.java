package com.jlt.jlt_webstu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jlt.jlt_webstu.model.domain.Auction;
import com.jlt.jlt_webstu.service.AuctionService;
import com.jlt.jlt_webstu.mapper.AuctionMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author jinlintao
* @description 针对表【auction】的数据库操作Service实现
* @createDate 2022-05-23 23:03:05
*/
@Service
public class AuctionServiceImpl extends ServiceImpl<AuctionMapper, Auction>
    implements AuctionService{

    @Resource
    private AuctionMapper auctionMapper;

    @Override
    public Long addAuction(String auctionName, String auctionImageUrl, String auctionMesUrl, String auctionDescription, String auctionMoney, String auctionAddMoney) {

        if (StringUtils.isAnyBlank(auctionAddMoney,auctionName,auctionDescription,auctionMesUrl,auctionMoney,auctionImageUrl)){
            return -1L;
        }
        Auction auction = new Auction();
        auction.setAuctionName(auctionName);
        auction.setAuctionImageUrl(auctionImageUrl);
        auction.setAuctionMesUrl(auctionMesUrl);
        auction.setAuctionMoney(auctionMoney);
        auction.setAuctionAddMoney(auctionAddMoney);
        auction.setAuctionDescription(auctionDescription);

        auctionMapper.insert(auction);
        return auction.getId();
    }

    @Override
    public List<Auction> searchAuction(List<Auction> list, String value) {

        QueryWrapper<Auction> auctionQueryWrapper = new QueryWrapper<>();

        auctionQueryWrapper.like("auctionName",value)
                .or()
                .like("auctionDescription",value);


        List<Auction> auctions = auctionMapper.selectList(auctionQueryWrapper);

        list.addAll(auctions);

        return list;
    }
}




