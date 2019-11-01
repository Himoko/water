package com.himoko.member.service.impl;

import com.himoko.member.dao.UserDao;
import com.himoko.member.pojo.User;
import com.himoko.member.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @author: peng.zhang11@ucarinc.com
 * @create: 2019-11-01 14:11
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUser() {
        return userDao.getUser();
    }
}
