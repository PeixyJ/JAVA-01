package pres.peixinyi.jvm0106;

/**
 * @author peixinyi
 */
public class LocalVariableTest {
    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage();
        int num1 = 1;
        int num2 = 2;
        movingAverage.submit(num1);
        movingAverage.submit(num2);
        System.out.println(movingAverage.getSum());
    }
}
