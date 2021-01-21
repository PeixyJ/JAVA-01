package pers.peixinyi.router.load;

/**
 * @Description:
 * @Author: PeiXy
 * @Date: 2021-01-21 17:21
 */
public class RatioAddress {
    /**
     * 地址
     */
    private String address;
    /**
     * 占比
     */
    private int ratio;

    public RatioAddress(String address, int ratio) {
        this.address = address;
        this.ratio = ratio;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRatio() {
        return ratio;
    }

    public void setRatio(int ratio) {
        this.ratio = ratio;
    }

    @Override
    public String toString() {
        return "RatioAddress{" +
                "address='" + address + '\'' +
                ", ratio=" + ratio +
                '}';
    }
}
