package com.test.spring.data.init;

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;


@Component
public class RestTemplateClass {


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder)
    {

        return builder.build();

    }

//    @Bean
//    public JdbcTemplate jdbcTemplate(DataSource dataSource)
//    {
//        return  new JdbcTemplate(dataSource);
//    }
}
