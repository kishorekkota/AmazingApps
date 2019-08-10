package com.test.spring.data.init;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@EnableAutoConfiguration
public class SpringContextInitializer implements InitializingBean {


    @Autowired
    private Environment environment;



    @Autowired
    RestTemplate restTemplate;



    @PostConstruct
    public void init()
    {
        System.out.println("*** Asas ***");



//        restTemplate.getForObject("https://rds.amazonaws.com/\n" +
//                "    ?Action=StartDBInstance\n" +
//                "    &DBInstanceIdentifier=amazingapps\n" +
//                "    &X-Amz-Credential=AKIAJ3UXZWOLHLDE3QSA/20180903/us-east-1/rds/aws4_request\n" +
//                "    &X-Amz-SignedHeaders=host;range;x-amz-date\n" +
//                "    &X-Amz-Signature=fe5f80f77d5fa3beca038a248ff027d0445342fe2855ddc963176630326f1024",String.class);


    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("*** After Properties Set Asas ***"+ Arrays.asList(environment.getDefaultProfiles()));
    }
}