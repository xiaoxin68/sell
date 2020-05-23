package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
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
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        ProductCategory productCategory = repository.findById(1).get();
        System.out.println(productCategory.toString());
    }

    /*@Test
    @Transactional
    @Rollback(false)// 事务自动回滚，默认是true。可以不写
    //junit 单元测试事务会自动回滚。通过@Rollback(true)注解来实现，默认是true，事务会回滚，可以不写。false时事务不会回滚，数据会写到数据库中。
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(8);
        productCategory.setCategoryName("男生最爱的");
        productCategory.setCategoryType(3);
        repository.save(productCategory);
    }*/

    @Test
    @Transactional
    @Rollback(false)// 事务自动回滚，默认是true。可以不写
    //junit 单元测试事务会自动回滚。通过@Rollback(true)注解来实现，默认是true，事务会回滚，可以不写。false时事务不会回滚，数据会写到数据库中。
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory("妈妈最爱",6);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
       // Assert.assertNotEquals(null,result);
    }

    @Test
    @Transactional
    @Rollback(false)// 事务自动回滚，默认是true。可以不写
    public void updateTest() {
        ProductCategory productCategory = repository.findById(2).get();
        productCategory.setCategoryType(5);
        repository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer>  list = Arrays.asList(1,2,3);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }
}