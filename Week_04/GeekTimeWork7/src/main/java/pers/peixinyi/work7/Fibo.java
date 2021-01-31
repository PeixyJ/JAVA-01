package pers.peixinyi.work7;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-01-29 16:03
 */
public abstract class Fibo {

    public static int fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }

}
