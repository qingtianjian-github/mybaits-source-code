package com.jiagouedu.mapper;

import com.jiagouedu.po.UserPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author cjw
 */
@Mapper
public interface UserMapper {

    /**
     * 获取user信息
     *
     * @param userId
     * @return
     */
    UserPo getUser(Integer userId);
}
