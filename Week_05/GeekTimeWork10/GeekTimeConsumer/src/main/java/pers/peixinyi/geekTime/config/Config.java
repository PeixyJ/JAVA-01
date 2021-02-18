package pers.peixinyi.geekTime.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.peixinyi.geektime.Clazz;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-02-10 19:30
 */
//@Configuration
public class Config {
    @Bean
    public Clazz clazz() {
        return new Clazz("一班", 45);
    }
}
