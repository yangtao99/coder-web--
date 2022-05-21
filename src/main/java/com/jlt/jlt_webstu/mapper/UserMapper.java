package com.jlt.jlt_webstu.mapper;

import com.jlt.jlt_webstu.model.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author jinlintao
* @description 针对表【user(用户)】的数据库操作Mapper
* @createDate 2022-05-06 12:11:15
* @Entity com.jlt.jlt_webstu.model.domain.User
*/
public interface UserMapper extends BaseMapper<User> {


    List<User> selectForCondition(@Param("userAccount") String userAccount, @Param("Gender") String Gender);
}




