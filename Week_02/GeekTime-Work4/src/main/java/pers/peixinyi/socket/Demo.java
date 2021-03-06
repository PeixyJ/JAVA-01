package pers.peixinyi.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: PeiXy
 * @Date: 2021-01-19 17:32
 */
public abstract class Demo {
    public static void service(Socket socket) {
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            String hello = "hello,nio";
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf8");
            printWriter.println("Content-Length:" + hello.getBytes().length);
            printWriter.println();
            printWriter.write(hello);
            printWriter.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
