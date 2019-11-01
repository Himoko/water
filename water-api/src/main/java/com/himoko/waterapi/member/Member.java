package com.himoko.waterapi.member;

import com.himoko.waterapi.member.pojo.User;
import com.himoko.waterapi.member.rpc.GetUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @author: peng.zhang11@ucarinc.com
 * @create: 2019-11-01 16:45
 */
@RestController
@RequestMapping("/member")
public class Member {

    @Autowired
    private GetUser getUser;

    @RequestMapping("/getUser")
    public List<User> getUser() {
        return getUser.getUser();
    }

    @RequestMapping("/test")
    public String test(String name) {
        return getUser.test(name);
    }

    @RequestMapping("/test1")
    public String test1(String name) {
        return getUser.test1(name);
    }

    @RequestMapping("/test2")
    public String test2(String name) {
        User user = new User();
        user.setUsername(name);
        user.setPassword("123123");
        return getUser.test2(user);
    }
}
