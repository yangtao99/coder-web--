package com.jlt.jlt_webstu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jlt.jlt_webstu.model.domain.Auction;
import com.jlt.jlt_webstu.model.domain.AuctionBag;
import com.jlt.jlt_webstu.service.AuctionService;
import com.jlt.jlt_webstu.service.AuctionbagService;
import com.jlt.jlt_webstu.mapper.AuctionBagMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author jinlintao
* @description 针对表【auctionBag】的数据库操作Service实现
* @createDate 2022-05-27 09:18:35
*/
@Service
public class AuctionbagServiceImpl extends ServiceImpl<AuctionBagMapper, AuctionBag>
    implements AuctionbagService{

    @Resource
    private AuctionBagMapper auctionBagMapper;

    @Override
    public List<AuctionBag> queryAuctionBag(String userID) {

        QueryWrapper<AuctionBag> auctionBagQueryWrapper = new QueryWrapper<>();

        auctionBagQueryWrapper.eq("userID",userID);

        return auctionBagMapper.selectList(auctionBagQueryWrapper);
    }
}




