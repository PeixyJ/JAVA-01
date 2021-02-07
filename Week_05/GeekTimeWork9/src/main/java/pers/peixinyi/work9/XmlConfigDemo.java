package pers.peixinyi.work9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-02-06 21:30
 */
public class XmlConfigDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springApplication.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student);
        Student peixinyi = (Student) context.getBean("peixinyi");
        System.out.println(peixinyi);
    }
}
