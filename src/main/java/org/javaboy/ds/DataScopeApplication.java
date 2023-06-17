package org.javaboy.ds;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@MapperScan(basePackages = "org.javaboy.ds.mapper")
public class DataScopeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataScopeApplication.class, args);
    }

}
