package com.imooc.service.impl;

import com.imooc.constant.WxConstants;
import com.imooc.service.LoginService;
import com.imooc.utils.SignUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

/**
 * @Description:
 * @Source: JDK 1.8
 * @author: ZhangXiaoxin
 * @date: 2019/3/5$ 19:34$
 * @Since: 1.0
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public void doWxLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authUrl = WxConstants.AUTH_BASE_URL + "appid=" + WxConstants.APPID
                + "&redirect_uri=" + URLEncoder.encode(WxConstants.REDIRECT_URL)
                + "&response_type=code"
                + "&scope=" + WxConstants.SCOPE
                + "&state=STATE#wechat_redirect";


        String signature = request.getParameter("signature");/// 微信加密签名
        String timestamp = request.getParameter("timestamp");/// 时间戳
        String nonce = request.getParameter("nonce"); /// 随机数
        String echostr = request.getParameter("echostr"); // 随机字符串

        PrintWriter out = response.getWriter();

        if (signature != null && timestamp != null && nonce != null && echostr != null) {
            if (SignUtil.checkSignature(signature, timestamp, nonce)) {
                out.print(echostr);
            }
            out.close();
        } else {
            response.sendRedirect(authUrl);
        }

    }
}
