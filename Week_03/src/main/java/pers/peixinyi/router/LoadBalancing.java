package pers.peixinyi.router;

import pers.peixinyi.router.load.RatioAddress;

import java.util.List;
import java.util.Random;

/**
 * @Description: 负载
 * @Author: PeiXy
 * @Date: 2021-01-21 17:17
 */
public class LoadBalancing {

    private static int index;

    /**
     * <p> 随机负载 </p>
     *
     * @param address
     * @return java.lang.String
     * @author PeiXy
     * @version 1.0.0.0
     * @since 17:24 2021/1/21
     */
    public static String randomAddress(String[] address) {
        return address[new Random().nextInt(address.length)];
    }

    /**
     * <p> 轮询分发 </p>
     *
     * @param address
     * @return java.lang.String
     * @author PeiXy
     * @version 1.0.0.0
     * @since 17:55 2021/1/21
     */
    public static String loopAddress(String[] address) {
        index = index % address.length;
        return address[index];
    }

    /**
     * <p> 比例分发 </p>
     *
     * @param ratioAddresses
     * @return java.lang.String
     * @author PeiXy
     * @version 1.0.0.0
     * @since 17:55 2021/1/21
     */
    public static String ratioAddress(List<RatioAddress> ratioAddresses) {
        int ratioMax = 0;
        for (RatioAddress ratioAddress : ratioAddresses) {
            ratioMax += ratioAddress.getRatio();
        }
        int index = new Random().nextInt(ratioMax);
        int indexRatio = 0;
        for (int i = 0; i < ratioAddresses.size(); i++) {
            if (i == 0) {
                if (index < ratioAddresses.get(i).getRatio()) {
                    return ratioAddresses.get(i).getAddress();
                }
                indexRatio = indexRatio + ratioAddresses.get(i).getRatio();
            } else {
                if (index < (indexRatio = indexRatio + ratioAddresses.get(i).getRatio())) {
                    return ratioAddresses.get(i).getAddress();
                }
            }
        }
        return null;
    }
}
