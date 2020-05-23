package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * @Description:消息模板推送
 * @Source: JDK 1.8
 * @author: ZhangXiaoxin
 * @date: 2019/3/14$ 9:19$
 * @Since: 1.0
 */
public interface PushMessageService {

    /**
     * 订单状态变更消息
     *
     * @param orderDTO
     */
    void orderStatus (OrderDTO orderDTO);
}
