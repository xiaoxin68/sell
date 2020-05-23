package com.imooc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Source: JDK 1.8
 * @author: ZhangXiaoxin
 * @date: 2019/3/11$ 11:01$
 * @Since: 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "ftp")
public class ImageServerConfig {

    private String address;

    private Integer port;

    private String username;

    private String password;

    private String bastPath;

    private String imageBaseUrl;
}
