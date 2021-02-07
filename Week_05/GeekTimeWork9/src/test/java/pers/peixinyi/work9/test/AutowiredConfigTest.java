package pers.peixinyi.work9.test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pers.peixinyi.work9.AutowiredConfig;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-02-07 11:12
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AutowiredConfig.class})
public class AutowiredConfigTest {

    @Autowired
    AutowiredConfig config;

    @Test
    public void test(){
        config.sayHi();
    }
}
