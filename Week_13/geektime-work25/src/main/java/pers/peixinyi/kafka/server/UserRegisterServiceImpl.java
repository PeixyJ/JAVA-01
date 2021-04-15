package pers.peixinyi.kafka.server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.peixinyi.kafka.notice.RegisterNoticeAnnotation;

import javax.websocket.server.PathParam;

/**
 * @author peixinyi
 * @version 0.0.0.0
 * @date 2021-04-15 17:22
 * @describe none
 */
@RestController
public class UserRegisterServiceImpl implements UserRegisteredService {

    @GetMapping(value = "register/{username}")
    @RegisterNoticeAnnotation
    public String register(@PathVariable String username) {
        System.out.println(getClass().getName() + " - " + username);
        return getClass().getName() + " - " + username;
    }

}
