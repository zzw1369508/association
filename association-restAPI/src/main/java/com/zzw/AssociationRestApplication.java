package com.zzw;

import com.zzw.util.ApplicationContextInfoUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan("com.feng.dao")
@EnableCaching
public class AssociationRestApplication {

    public static void main(String[] args) {
       ApplicationContext applicationContext = SpringApplication.run(AssociationRestApplication.class, args);
        ApplicationContextInfoUtils.printSystemInfo(applicationContext);
    }

}
