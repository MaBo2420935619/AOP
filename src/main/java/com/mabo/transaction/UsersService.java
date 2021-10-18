package com.mabo.transaction;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.TransactionStatus;

public class UsersService {

    private UsersDao usersDao;
    private TransactionManager manager;

    public void setManager(TransactionManager manager) {
        this.manager = manager;
    }

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public void add(){
        TransactionStatus begin=null;
        try {
            //开启事务
            begin = manager.begin();
            usersDao.addUser("吴大宝01",18);
            int i=1/0;//故意制造异常
            usersDao.addUser("吴大宝02",20);
            System.out.println("添加用户成功！");
            //提交事务
            manager.commit(begin);
        } catch (Exception e) {
            //发生异常回滚事务
            manager.rollback(begin);
            System.out.println("发生异常回滚事务！");
        } finally {

        }
    }


    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-transation.xml");
        UsersService usersService = (UsersService) applicationContext.getBean("usersService");
        usersService.add();
    }

}
