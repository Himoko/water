package com.himoko.waterapi.member.rpc;

import com.himoko.waterapi.member.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "member", path = "/member")
public interface GetUser {

    @RequestMapping(value = "/user/getUser", method = RequestMethod.GET)
    List<User> getUser();

    /**
     * description: get方式传参
     * @author peng.zhang11@ucarinc.com
     * @date   2019/11/1 17:22
     * @params * @Param name:
     * @return * @return: java.lang.String
     */
    @RequestMapping(value = "/user/test", method = RequestMethod.GET)
    String test(@RequestParam("name") String name);

    /**
     * description: post方式传参
     * @author peng.zhang11@ucarinc.com
     * @date   2019/11/1 17:23
     * @params * @Param name:
     * @return * @return: java.lang.String
     */
    @RequestMapping(value = "/user/test1", method = RequestMethod.POST)
    String test1(@RequestBody String name);

    /**
     * description: post方式传对象
     * @author peng.zhang11@ucarinc.com
     * @date   2019/11/1 17:23
     * @params * @Param name:
     * @return * @return: java.lang.String
     */
    @RequestMapping(value = "/user/test2", method = RequestMethod.POST)
    String test2(@RequestBody User user);
}
