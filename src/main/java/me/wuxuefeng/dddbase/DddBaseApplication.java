package me.wuxuefeng.dddbase;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("me.wuxuefeng.dddbase.infuastructure.mp.mapper")
public class DddBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(DddBaseApplication.class, args);
    }

}
