package com.himoko.order.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @version 1.0
 * @description: order
 * @author: peng.zhang11@ucarinc.com
 * @create: 2019-11-01 16:14
 */
@Data
public class Order implements Serializable {

    private Integer id;

    private Integer orderNum;

    private Double money;
}
