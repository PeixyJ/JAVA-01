package pers.peixinyi.work9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-02-07 10:53
 */

public class AnnotationsConfigDemo {


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("pers.peixinyi.work9");
        Student peixinyi = (Student) context.getBean("student");
        System.out.println(peixinyi);
    }
}
