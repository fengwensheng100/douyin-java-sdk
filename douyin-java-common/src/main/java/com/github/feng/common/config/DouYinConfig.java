package com.github.feng.common.config;

import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName DouYinConfig
 * @Description: TODO
 * @Author fengwensheng
 * @Date 2023/3/20
 * @Version V1.0
 **/
@Setter
public class DouYinConfig {

    /**
     * 应用唯一标识
     */
    private String clientKey;

    /**
     * 应用唯一标识对应的密钥
     */
    private String clientSecret;

    public String getClientKey() throws Exception {
        if (StringUtils.isBlank(clientKey)) {
            throw new Exception("clientKey不能为空");
        }
        return clientKey;
    }

    public String getClientSecret() throws Exception {
        if (StringUtils.isBlank(clientSecret)) {
            throw new Exception("clientSecret不能为空");
        }
        return clientSecret;
    }
}
