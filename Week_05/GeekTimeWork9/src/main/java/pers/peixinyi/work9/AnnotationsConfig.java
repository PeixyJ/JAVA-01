package pers.peixinyi.work9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-02-07 10:56
 */
@Component
public class AnnotationsConfig {

    @Bean
    public Student student() {
        return new Student(1, "peixinyi", "2班");
    }
}
