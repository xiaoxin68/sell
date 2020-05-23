package com.imooc.service;

import com.imooc.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Description:
 * @Source: JDK 1.8
 * @author: ZhangXiaoxin
 * @date: 2019/3/3$ 19:09$
 * @Since: 1.0
 */
public interface OrderService {

    /*创建订单*/
    OrderDTO create(OrderDTO orderDTO);

    /*查询单个订单*/
    OrderDTO findOne(String orderId);

    /*查询订单列表*/
    Page<OrderDTO> findList(String buyerOpenId, Pageable pageable);

    /*取消订单*/
    OrderDTO cancle(OrderDTO orderDTO);

   /* 完结订单*/
    OrderDTO finish(OrderDTO orderDTO);

    /*支付订单*/
    OrderDTO paid(OrderDTO orderDTO);

    /*查询订单列表*/
    Page<OrderDTO> findList(Pageable pageable);
}
