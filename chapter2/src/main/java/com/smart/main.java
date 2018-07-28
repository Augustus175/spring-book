package com.smart;

import com.smart.domain.User;
import com.smart.service.UserService;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.sql.DataSource;

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
        //    @Autowired
        UserService userService = (UserService) ctx.getBean("userService");
        boolean b1 = userService.hasMatchUser("admin", "1234");
        System.out.println(b1);
    }
}
