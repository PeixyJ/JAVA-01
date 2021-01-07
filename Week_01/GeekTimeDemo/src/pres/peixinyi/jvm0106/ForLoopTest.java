package pres.peixinyi.jvm0106;

/**
 * @Description:
 * @Author: PeiXy
 * @Date: 2021-01-06 14:44
 */
public class ForLoopTest {
    private static int[] numbers = {1, 3, 5};
    static {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        System.out.println("-----");
        MovingAverage ma = new MovingAverage();
        for (int number : numbers) {
            ma.submit(number);
        }
        double avg = ma.getSum();
    }
}
