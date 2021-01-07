package pres.peixinyi.jvm0106;

public class MovingAverage {
    private int count;
    private double sum = 0.0D;

    public void submit(double value) {
        this.count++;
        this.sum += value;
    }

    public double getSum() {
        if (0 == this.count) {
            return sum;
        }
        return this.sum / this.count;
    }
    public void say(){
        System.out.println("Call");
    }
}
