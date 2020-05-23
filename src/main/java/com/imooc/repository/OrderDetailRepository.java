package com.imooc.repository;

import com.imooc.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: ${date}
 * @Since: 1.0
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
    /**
     * 根据订单id查询订单详情（全部商品）
     *
     * @param orderId
     * @return
     */
    List<OrderDetail> findByOrderId(String orderId);
}
