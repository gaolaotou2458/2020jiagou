package com.imooc.spring.escape.service;

import com.imooc.spring.escape.transaction_lost.CustomException;
import com.imooc.spring.escape.transaction_lost.ISpringTransaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestTransactionLost {

    @Autowired
    private ISpringTransaction springTransaction;

    @Test
    public void testCatchExceptionCanNotRollback() {

        springTransaction.CatchExceptionCanNotRollback();
    }

    @Test
    public void testNotRuntimeExceptionCanNotRollback() throws CustomException {

        springTransaction.NotRuntimeExceptionCanNotRollback();
    }

    /**
     * unchecked 异常可以回滚
     */
    @Test
    public void testRuntimeExceptionCanRollback() {

        springTransaction.RuntimeExceptionCanRollback();
    }

    /**
     * 指定 rollbackFor , 事务可以回滚
     */
    @Test
    public void testAssignExceptionCanRollback() throws CustomException {

        springTransaction.AssignExceptionCanRollback();
    }

    /**
     * 同一个类中, 一个不标注事务的方法去调用标注了事务的方法, 事务会失效
     */
    @Test
    public void testNonTransactionalCanNotRollback() {

        springTransaction.NonTransactionalCanNotRollback();
    }

}


