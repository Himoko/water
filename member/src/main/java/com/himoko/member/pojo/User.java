package com.himoko.member.pojo;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

/**
 * @version 1.0
 * @description: 用户类
 * @author: peng.zhang11@ucarinc.com
 * @create: 2019-11-01 14:48
 */
@Data
public class User implements Serializable {

    private Integer id;

    @NonNull
    private String username;

    @NonNull
    private String password;

    private String email;

}
