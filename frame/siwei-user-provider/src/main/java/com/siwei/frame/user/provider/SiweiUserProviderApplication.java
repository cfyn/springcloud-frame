package com.siwei.frame.user.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RefreshScope
@EnableSwagger2
@MapperScan(basePackages = "com.siwei.frame.user.provider.dao")
// 开启druid监控页面
@ServletComponentScan
public class SiweiUserProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SiweiUserProviderApplication.class, args);
    }
}
