package com.imooc.service;

import com.imooc.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**
 * @Description:支付Service
 * @Source: JDK 1.8
 * @author: ZhangXiaoxin
 * @date: 2019/3/7$ 20:21$
 * @Since: 1.0
 */
public interface PayService {
    /**
     * 发起支付
     *
     * @param orderDTO
     */
    PayResponse create(OrderDTO orderDTO);

    /**
     * 微信支付异步通知
     *
     * @param notifyData
     * @return
     */
    PayResponse notify(String notifyData);

    /**
     * 退款
     *
     * @param orderDTO
     */
    RefundResponse refund(OrderDTO orderDTO);

}

