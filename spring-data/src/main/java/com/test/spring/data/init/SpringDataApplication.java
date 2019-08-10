package com.test.spring.data.init;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.Arrays;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration()
public class SpringDataApplication {




    public static void main(String[] args)
    {

        SpringApplication.run(SpringDataApplication.class, args);


    }




}


@RestController
@Repository
@Component
class TestController
{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    TestController(JdbcTemplate template)
    {
        this.jdbcTemplate = template;
    }


    @GetMapping("/create")
    public void createtable()
    {
//
//        DataSource ds = (DataSource)ApplicationContextProvider.getApplicationContext().getBean("dataSource");
//        Connection c = ds.getConnection();
        try {
            jdbcTemplate.execute("create table test_table (first_name VARCHAR (255))");


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}