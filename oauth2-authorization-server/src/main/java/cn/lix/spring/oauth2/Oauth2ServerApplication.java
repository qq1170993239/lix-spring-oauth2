package cn.lix.spring.oauth2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("cn.lix.spring.oauth2.sdk.dao")
public class Oauth2ServerApplication {


    public static void main(String[] args) {
        SpringApplication.run(Oauth2ServerApplication.class, args);
    }



}
