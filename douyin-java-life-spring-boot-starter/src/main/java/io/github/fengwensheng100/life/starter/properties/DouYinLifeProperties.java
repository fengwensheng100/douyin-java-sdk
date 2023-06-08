package io.github.fengwensheng100.life.starter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName DouYinLifeProperties
 * @Description: TODO
 * @Author fengwensheng
 * @Date 2023/3/24
 * @Version V1.0
 **/
@Data
@ConfigurationProperties(prefix = "dy.life")
public class DouYinLifeProperties {

    /**
     * 应用唯一标识.
     */
    private String clientKey;

    /**
     * 应用唯一标识对应的密钥.
     */
    private String clientSecret;

}
