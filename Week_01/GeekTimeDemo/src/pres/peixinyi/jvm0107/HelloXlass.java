package pres.peixinyi.jvm0107;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description: 第一课 题目二
 * @Author: PeiXy
 * @Date: 2021-01-07 09:25
 */
public class HelloXlass extends ClassLoader {
    public static void main(String[] args) {
        try {
            Object o = new HelloXlass().findClass("Hello").newInstance();
            Method m = o.getClass().getMethod("hello");
            m.invoke(o);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | ClassNotFoundException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String xlassPath = "Hello.xlass";
        File file = new File(xlassPath);

        long fileSize = file.length();
        //判断文件是否过大
        if (fileSize > Integer.MAX_VALUE) {
            System.out.println("file too big...");
            return null;
        }
        //Xlass文件
        byte[] buffer = new byte[(int) fileSize];
        //Class文件
        byte[] realBuffer = new byte[(int) fileSize];
        try {
            int offset = 0;
            int numRead = 0;
            FileInputStream fis = new FileInputStream(file);
            //读取文件 fis.read(buffer, offset, buffer.length - offset)
            while (offset < buffer.length && (numRead = fis.read(buffer, offset, buffer.length - offset)) >= 0) {
                offset += numRead;
            }
            if (offset != buffer.length) {
                throw new IOException("could not completely read file "
                        + file.getName());
            }
            fis.close();
            System.out.println(buffer.length);
            //转换文件
            byte b;
            for (int i = 0; i < buffer.length; i++) {
                b = (byte) (255 - buffer[i]);
                realBuffer[i] = b;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name, realBuffer, 0, realBuffer.length);
    }
}
