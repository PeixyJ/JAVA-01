package pers.peixinyi.kafka.notice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import pers.peixinyi.kafka.client.KafkaProducer;

import javax.annotation.Resource;

/**
 * @author peixinyi
 * @version 0.0.0.0
 * @date 2021-04-15 17:24
 * @describe none
 */
@Aspect
@Component
public class RegisterNotice {

    public static final String registerTopic = "demo.user.register";

    @Resource
    KafkaProducer kafkaProducer;

    @After(value = "@annotation(RegisterNoticeAnnotation)")
    public void notion(JoinPoint joinPoint) {
        String username = (String) joinPoint.getArgs()[0];
        System.out.println("用户" + username + "注册成功");
        kafkaProducer.send(registerTopic, username);
    }

}
