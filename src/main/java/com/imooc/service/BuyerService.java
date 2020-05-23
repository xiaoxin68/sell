package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * @Description:买家
 * @Source: JDK 1.8
 * @author: ZhangXiaoxin
 * @date: 2019/3/4$ 16:34$
 * @Since: 1.0
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);

    //取消订单
    OrderDTO cancleOrder(String openid,String orderId);
}
