package com.imooc.controller;

import com.imooc.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @Source: JDK 1.8
 * @author: ZhangXiaoxin
 * @date: 2019/3/5$ 16:40$
 * @Since: 1.0
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code) {
        log.info("进入auth方法。。。");
        log.info("code={}", code);

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx085c556cb1d22b1f&secret=306416745e957da269b33ac134df28fd&code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}", response);
    }

    //微信访问：http://t238997p11.qicp.vip/sell/weixin/wx/wxLogin
    @GetMapping("/wx/wxLogin")
    public void doWxLogin (HttpServletRequest request, HttpServletResponse response) {

        try {
            loginService.doWxLogin(request, response);
            System.out.println("==================================>");
        } catch (Exception e) {
            e.printStackTrace();
            //相应的处理
        }

    }
}
