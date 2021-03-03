package pers.hongdenglv.work13;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-03-03 16:06
 */
public class InsertThreadPool implements Runnable {

    private String sql;
    private Connection connection;
    private CountDownLatch countDownLatch;

    public InsertThreadPool(String sql, Connection connection, CountDownLatch countDownLatch) {
        this.sql = sql;
        this.connection = connection;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "start");
            connection.prepareStatement(sql).execute();
            System.out.println(Thread.currentThread().getName() + "end");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            countDownLatch.countDown();
        }
    }


}
