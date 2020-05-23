package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
import com.imooc.enums.PayStatusEnum;
import com.imooc.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: ${date}
 * @Since: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private  ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo result = productService.findOne("123456");
        Assert.assertNotEquals(123456,result.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productServiceAll = productService.findUpAll();
        Assert.assertNotEquals(0,productServiceAll.size());
    }

    @Test
    public void findAll() {
        PageRequest page = new PageRequest(0,2);
        Page<ProductInfo> productServiceList = productService.findAll(page);
        //System.out.println(productServiceList.getTotalElements());
        Assert.assertNotEquals(0,productServiceList.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("蛋炒饭");
        productInfo.setProductPrice(new BigDecimal(7.8));
        productInfo.setProductStock(30);
        productInfo.setProductDescription("很好吃的蛋炒饭！！！");
        productInfo.setProductIcon("http:2.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);
        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void offSaleTest(){
        ProductInfo productInfo = productService.offSale("1");
        Assert.assertEquals(ProductStatusEnum.DOWN,productInfo.getProductStatusEnum());
    }

    @Test
    public void onSaleTest(){
        ProductInfo productInfo = productService.onSale("1");
        Assert.assertEquals(ProductStatusEnum.UP,productInfo.getProductStatusEnum());
    }
}