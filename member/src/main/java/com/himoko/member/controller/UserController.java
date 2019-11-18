package com.himoko.member.controller;

import com.himoko.member.config.MySQLPropertise;
import com.himoko.member.pojo.User;
import com.himoko.member.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @version 1.0
 * @description: 用户
 * @author: peng.zhang11@ucarinc.com
 * @create: 2019-11-01 14:11
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public List<User> getUser() {
        return userService.getUser();
    }

    @RequestMapping("/test")
    public String test(String name) {
        return "ttest" + name;
    }

    @RequestMapping("/test1")
    public String test1(@RequestBody String name) {
        return "ttest" + name;
    }

    @RequestMapping("/test2")
    public String test2(@RequestBody User user) {
        return "ttest" + user.getUsername();
    }

    @Autowired
    MySQLPropertise mySQLPropertise;

    @RequestMapping("/testData")
    public String testData() {
        String nullTest = "1123";
        Assert.notNull(nullTest, "NullPointException ");
        logger.info("我炸了啊！");
        return mySQLPropertise.getDriverClassName() + mySQLPropertise.getPassword() + mySQLPropertise.getPassword();
    }
}
