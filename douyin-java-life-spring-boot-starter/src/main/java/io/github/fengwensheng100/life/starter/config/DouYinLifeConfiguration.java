package io.github.fengwensheng100.life.starter.config;

import io.github.fengwensheng100.common.config.DouYinConfig;
import io.github.fengwensheng100.core.service.DouYinService;
import io.github.fengwensheng100.core.service.impl.DouYinServiceImpl;
import io.github.fengwensheng100.life.starter.properties.DouYinLifeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName DouYinLifeConfiguration
 * @Description: TODO
 * @Author fengwensheng
 * @Date 2023/3/24
 * @Version V1.0
 **/
@Configuration
@EnableConfigurationProperties(DouYinLifeProperties.class)
public class DouYinLifeConfiguration {

    private DouYinLifeProperties douYinLifeProperties;

    @Autowired
    public DouYinLifeConfiguration(DouYinLifeProperties douYinLifeProperties) {
        this.douYinLifeProperties = douYinLifeProperties;
    }

    @Bean
    public DouYinService douYinService() {
        DouYinConfig config = new DouYinConfig();
        config.setClientKey(douYinLifeProperties.getClientKey());
        config.setClientSecret(douYinLifeProperties.getClientSecret());
        DouYinService douYinService = new DouYinServiceImpl(config);
        return douYinService;
    }
}
