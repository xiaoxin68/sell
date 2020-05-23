package com.imooc.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Description:订单详情表
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: ${date}
 * @Since: 1.0
 */
@Entity
@Data
@DynamicUpdate
public class OrderDetail {

    @Id
    /*订单详情id*/
    private String detailId;

    /*订单id*/
    private String orderId;

    /*商品id*/
    private  String productId;

    /*商品名称*/
    private String productName;

    /*商品单价*/
    private BigDecimal productPrice;

    /*商品数量*/
    private Integer productQuantity;

    /*商品图片*/
    private  String productIcon;
}
