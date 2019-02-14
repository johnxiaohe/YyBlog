package com.hxy.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;


@SpringBootApplication
@EnableAutoConfiguration
@EnableTransactionManagement
@Configuration("com.hxy.blog.config")
@MapperScan("com.hxy.blog.dao")
public class BlogApplication {
    public static void main(String[] args) {
         Logger logger = Logger.getLogger(BlogApplication.class.getName());
        logger.info("小和的博客启动啦！！！...");
        SpringApplication.run(BlogApplication.class, args);
    }

}
