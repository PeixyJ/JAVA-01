package pers.hongdenglv.work13;

import sun.nio.ch.ThreadPool;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Run {
    final private static int createNum = 1000000;
    final private static int createNumGroup = 100000;

    final static String sqlPath = "/Users/peixinyi/Desktop/million1-"+createNumGroup+".sql";

    public static void main(String[] args) {
        File file = new File(sqlPath);
        try (
                OutputStream outputStream = new FileOutputStream(file);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        ) {
            GenerateOrderSql generateOrderSql = new GenerateOrderSqlImpl();
            outputStreamWriter.write("insert into orders values ");
            for (int i = 0; i < createNum; i++) {
                outputStreamWriter.write(generateOrderSql.generate());
                if ( i % createNumGroup != 0 && i != createNum - 1 || i == 0){
                    outputStreamWriter.write(",");
                }
                if (i % createNumGroup == 0 && i != 0) {
                    outputStreamWriter.write(";\ninsert into orders values ");
                }
            }
            outputStreamWriter.write(";");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
