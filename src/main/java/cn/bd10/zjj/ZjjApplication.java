package cn.bd10.zjj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "cn.bd10.zjj.dao")
public class ZjjApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZjjApplication.class, args);
    }

}
