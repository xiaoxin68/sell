package com.imooc.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Map;

/**
 * @Description:
 * @Source: JDK 1.8
 * @author: ZhangXiaoxin
 * @date: 2019/3/4$ 10:58$
 * @Since: 1.0
 */
@Data
public class OrderForm {
    /*name: "张三"
    phone: "18868822111"
    address: "慕课网总部"
    openid: "ew3euwhd7sjw9diwkq" //用户的微信openid
    items: [{
        productId: "1423113435324",
                productQuantity: 2 //购买数量
    }]*/

    /*买家姓名*/
    @NotEmpty(message = "姓名必填")
    private String name;

    /*买家手机号*/
    @NotEmpty(message = "手机号必填")
    private String phone;

    /*买家地址*/
    @NotEmpty(message = "地址必填")
    private String address;

    /*买家openid*/
    @NotEmpty(message = "openid必填")
    private String openid;

    /*所买产品id及购买数量*/
    @NotEmpty(message = "购物车必填")
    private String items;

}
