package com.smart;

import com.smart.domain.User;
import com.smart.service.UserService;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.sql.DataSource;
import java.util.Date;

/**
 * @author zhangzhibo-linux
 * @date 18-7-28 上午9:05
 */
public class main {
    public static void main(String[] args) {
        FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("classpath*:/smart-context.xml");
        ctx.start();
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        System.out.println(dataSource.toString());
        UserService userService = (UserService) ctx.getBean("userService");
        boolean b1 = userService.hasMatchUser("admin", "123456");
        User user = userService.findUserByUserName("admin");
        System.out.println(b1);
        user.setUserId(1);
        user.setUserName("admin");
        user.setLastIp("192.168.12.7");
        user.setLastVisit(new Date());
        userService.loginSuccess(user);
    }
}
