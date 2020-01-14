package com.yyf.bigplan;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.Banner;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.SpringVersion;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@EnableSwagger2Doc
public class BigPlanApplication {

    public static void main(String[] args) {
        AnsiOutput.setEnabled(AnsiOutput.Enabled.ALWAYS);
        new SpringApplicationBuilder(BigPlanApplication.class)
                .main(SpringVersion.class) // 设置可以加载Spring 版本
                .bannerMode(Banner.Mode.CONSOLE)// 控制台打印Banner
                .run(args);
    }

}
