package com.carbon.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.carbon.system.mapper") // Quét các file SQL
public class CarbonSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarbonSystemApplication.class, args);
        System.out.println("(♥) Module System khởi động thành công! (♥)");
    }
}
