import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.peixinyi.business.BusinessApplication;
import pers.peixinyi.business.ForexOrder;
import pers.peixinyi.business.ForexOrderService;

import java.util.Random;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-03-18 14:32
 */
@SpringBootTest(classes = BusinessApplication.class)
public class ForexOrderServiceTest {

    @Autowired
    ForexOrderService forexOrderService;

    private static int id;

    static {
        id = new Random().nextInt(100000);
    }

    @Test
    public void createOrderTest() {
        //创建寄售订单
        ForexOrder forexOrder = new ForexOrder();
        forexOrder.setId(id);
        forexOrder.setConsignmentUserId(10001);
        forexOrder.setBuyUserId(0);
        forexOrder.setOrderType(0);
        forexOrder.setCurrency(100);
        //0 为人民币 1为美金
        forexOrder.setCurrencyType(1);
        //0 为人民币 1为美金
        forexOrder.setTargetType(0);

         Assert.assertTrue(forexOrderService.createOrder(forexOrder));
    }

    @Test
    public void buyOrderTest() {
        ForexOrder forexOrder = new ForexOrder();

        forexOrder.setId(id);
        forexOrder.setBuyUserId(10000);
        forexOrder.setCreateTime(8888);

        Assert.assertTrue(forexOrderService.buyOrder(forexOrder));
    }


}
