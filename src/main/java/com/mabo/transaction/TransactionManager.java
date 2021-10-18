package com.mabo.transaction;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

/**
 * @program: TransactionDemo
 * @description:
 * @author: hq.zheng
 * @create: 2019-08-04 13:02
 */

public class TransactionManager {


    private DataSourceTransactionManager manager;

    public void setManager(DataSourceTransactionManager manager) {
        this.manager = manager;
    }
    /**
     * 开启事务
     */
    public TransactionStatus begin(){
        //获取事务状态
        TransactionStatus transaction = manager.getTransaction(new DefaultTransactionAttribute());
        return transaction;
    }

    /**
     * 提交事务
     * @param transaction
     */
    public void commit(TransactionStatus transaction){
        //提交到数据库
        manager.commit(transaction);
    }

    /**
     * 回滚事务
     * @param transaction
     */
    public void rollback(TransactionStatus transaction){
        manager.rollback(transaction);
    }
}
