package com.himoko.member.dao;

import com.himoko.member.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    List<User> getUser();
}
