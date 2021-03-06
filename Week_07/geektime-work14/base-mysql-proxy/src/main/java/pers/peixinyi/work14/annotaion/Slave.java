package pers.peixinyi.work14.annotaion;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-03-05 14:26
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface Slave {
}
