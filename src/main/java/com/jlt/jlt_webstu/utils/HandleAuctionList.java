package com.jlt.jlt_webstu.utils;

import com.jlt.jlt_webstu.model.domain.Auction;
import com.jlt.jlt_webstu.model.domain.AuctionBag;

import java.util.ArrayList;
import java.util.List;

public class HandleAuctionList {

    public  static <T> List repeatListWayOne(List<T> list){
        for(int i = 0;i < list.size();i++){
            for(int j = i+1;j < list.size();j++){
                if(list.get(i).equals(list.get(j))){
                    list.remove(j--);
                }
            }
        }
        return list;
    }


}
