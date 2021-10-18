package com.mabo.aop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserService {


    public void add() {
        System.out.println("增加用户");
    }

    public void delete() {
        System.out.println("删除用户");
    }

    public void update() {
        System.out.println("更新用户");
    }

    public void search() {
        System.out.println("查询用户");
    }

    public static void main(String[] args) {
        ApplicationContext context =new ClassPathXmlApplicationContext("spring-aop.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.search();
    }
}
