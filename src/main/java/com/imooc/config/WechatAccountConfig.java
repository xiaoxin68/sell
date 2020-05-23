package com.imooc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description:
 * @Source: JDK 1.8
 * @author: ZhangXiaoxin
 * @date: 2019/3/6$ 15:41$
 * @Since: 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    /*公众平台appid*/
    private String myAppId;

   /* 公众平台秘钥*/
    private String myAppSecret;

    /*开放平台id*/
    private String openAppId;

    /*开放平台秘钥*/
    private String openAppSecret;

    /*商户号*/
    private String mchId;

    /*商户秘钥*/
    private String mchKey;

    /*商户证书路径*/
    private String keyPath;

    /*微信支付异步通知地址*/
    private String notifyUrl;

    /*微信模板id*/
    private Map<String,String> templateId;
}
