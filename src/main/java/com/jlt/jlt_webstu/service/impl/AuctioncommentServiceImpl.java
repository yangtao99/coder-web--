package com.jlt.jlt_webstu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jlt.jlt_webstu.model.domain.Auctioncomment;
import com.jlt.jlt_webstu.service.AuctioncommentService;
import com.jlt.jlt_webstu.mapper.AuctioncommentMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author jinlintao
 * @description 针对表【auctionComment】的数据库操作Service实现
 * @createDate 2022-05-28 20:52:55
 */
@Service
public class AuctioncommentServiceImpl extends ServiceImpl<AuctioncommentMapper, Auctioncomment>
        implements AuctioncommentService {

    @Override
    public Long addAuctionComment(Auctioncomment auctioncomment) {
        if (!Objects.equals(auctioncomment.getPrice(), "")) {
            try {
                Integer.parseInt(auctioncomment.getPrice());
            } catch (NumberFormatException e) {
                return -1L;
            }
        }
        if(Objects.equals(auctioncomment.getContent(), "") && Objects.equals(auctioncomment.getPrice(), "")){
            return -1L;
        }
        this.save(auctioncomment);
        return auctioncomment.getId();
    }
}




