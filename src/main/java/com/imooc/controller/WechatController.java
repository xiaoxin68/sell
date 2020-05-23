package com.imooc.controller;

import com.imooc.config.ProjectUrlConfig;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLEncoder;

/**
 * @Description:
 * @Source: JDK 1.8
 * @author: ZhangXiaoxin
 * @date: 2019/3/6$ 15:28$
 * @Since: 1.0
 */
@Controller
@RequestMapping("/wechat")
@Slf4j
public class WechatController {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WxMpService wxOpenService;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    /**
     * 微信公众平台授权登录
     *
     * @param returnUrl
     * @return
     */
    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl){
        //访问：http://t238997p11.qicp.vip/sell/wechat/authorize?returnUrl=http://www.imooc.com

        //访问：http://127.0.0.1:8080/sell/wechat/authorize?returnUrl=http://www.imooc.com
        //若用注解@RestController（会自动解析成json）
        //返回：redirect:https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx085c556cb1d22b1f&redirect_uri=http%3A%2F%2Ft238997p11.qicp.vip%2Fsell%2Fwechat%2FuserInfo&response_type=code&scope=snsapi_userinfo&state=http%3A%2F%2Fwww.imooc.com&connect_redirect=1#wechat_redirect
        //若用注解@Controller
        //返回：直接重定向，请在微信打开，访问http://t238997p11.qicp.vip/sell/wechat/authorize?returnUrl=http://www.imooc.com，在微信打开后会跳转到returnUrl，即http://www.imooc.com

        //配置(配置已经完成)

        //回调方法
        //String url = "http://t238997p11.qicp.vip/sell/wechat/userInfo";
        //1. 配置
        //2. 调用方法
        String url = projectUrlConfig.getWechatMpAuthorize() + "/sell/wechat/userInfo";
        //String url = "http://api.xdclass.net";
        //构造网页授权url
        //可使用WxConsts.OAuth2Scope.SNSAPI_USERINFO模式，也可使用WxConsts.OAuth2Scope.SNSAPI_BASE模式，SNSAPI_BASE模式用户是无感知的
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, URLEncoder.encode(returnUrl));
        log.info("微信网页授权获取code，redirectUrl={}",redirectUrl);
        return "redirect:" + redirectUrl;
    }

     //鉴于目前没办法测试下面的功能，那么以下链接可以在微信端实现卖家后台登录
    // http://t238997p11.qicp.vip/sell/wechat/authorize?returnUrl=http://t238997p11.qicp.vip/sell/seller/login
    /**
     * 微信公众平台授权登录后获取到openid并跳转
     *
     * @param code
     * @param returnUrl
     * @return
     */
    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,@RequestParam("state") String returnUrl){
        //获得access token
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.info("[微信网页授权] {}",e);
            throw new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(),e.getError().getErrorMsg());
        }
        //获取openid
        String openId = wxMpOAuth2AccessToken.getOpenId();

        return "redirect:" + returnUrl+"?openid=" + openId;
    }

    /**
     * 微信开放平台授权登录
     *
     * @param returnUrl
     * @return
     */
    //访问：http://127.0.0.1:8080/sell/wechat/qrAuthorize?returnUrl=http://www.imooc.com
    //访问：http://t238997p11.qicp.vip/sell/wechat/qrAuthorize?returnUrl=http://t238997p11.qicp.vip/sell/seller/login
    @GetMapping("/qrAuthorize")
    public String qrAuthorize(@RequestParam("returnUrl") String returnUrl){
       // String url = "http://t238997p11.qicp.vip/sell/wechat/qrUserInfo";
        String url = projectUrlConfig.getWechatOpenAuthorize() + "/sell/wechat/qrUserInfo";
        String redirectUrl = wxOpenService.buildQrConnectUrl(url,WxConsts.QrConnectScope.SNSAPI_LOGIN, URLEncoder.encode(returnUrl));
        log.info("微信开放平台授权获取code，redirectUrl={}",redirectUrl);
        return "redirect:" + redirectUrl;
    }

    /**
     * 微信开放平台扫码获取openid
     *
     * @param code
     * @param returnUrl
     * @return
     */
    @GetMapping("/qrUserInfo")
    public String qrUserInfo(@RequestParam("code") String code,
                             @RequestParam("state") String returnUrl){
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxOpenService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.info("[微信网页授权] {}",e);
            throw new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(),e.getError().getErrorMsg());
        }
        //获取openid
        String openId = wxMpOAuth2AccessToken.getOpenId();

        return "redirect:" + returnUrl+"?openid=" + openId;
    }
}
