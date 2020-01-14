package com.yyf.bigplan.util;

import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author 杨宇飞 2019-11-21 5:57 上午
 * @version 1.0
 * @apiNote <p>生成开发文档</p>
 */
public class DocumentAutoGeneration {

    public static void main(String[] args) throws MalformedURLException {
        URL remoteSwaggerFile = new URL("http://localhost:8888/v2/api-docs");
        Path outputDirectory = Paths.get("src/docs/markdown/generated/all");

        // 输出MARKDOWN 格式
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.MARKDOWN)
                .build();

        Swagger2MarkupConverter.from(remoteSwaggerFile)
                .withConfig(config)
                .build()
                .toFile(outputDirectory);

    }

}
