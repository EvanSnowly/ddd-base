package me.wuxuefeng.dddbase;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * DDD-Base 项目启动类
 * <p>
 * 负责 Spring Boot 应用的引导与启动，并配置 MyBatis Plus 的 Mapper 扫描路径。
 * </p>
 *
 * @author wuxuefeng
 * @since 1.0.0
 */
@SpringBootApplication
@MapperScan("me.wuxuefeng.dddbase.infuastructure.mp.mapper")
public class DddBaseApplication {

    /**
     * 应用主入口
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(DddBaseApplication.class, args);
    }

}
