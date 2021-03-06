import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import pers.peixinyi.work14.ApplicationRun;
import pers.peixinyi.work14.entity.Order;
import pers.peixinyi.work14.service.OrderService;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-03-05 10:55
 */

@SpringBootTest(classes = ApplicationRun.class)
public class DataConfigTest {

    @Autowired
    DataSource master;

    @Autowired
    List<DataSource> slaves;

    @Autowired
    OrderService orderService;

    @Test
    public void getDatasource() {
        try {
            Assert.notNull(master.getConnection(), "don't connect Master Datasource");
            slaves.forEach(o -> {
                try {
                    Assert.notNull(o.getConnection(), "don't connect slave Datasource");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addOrderTableTest(){
        Order order = new Order("XXXX", 1);
        Assert.isTrue(orderService.addOrder(master, order), "插入Order失败");
    }

    @Test
    public void operationOrderTable() {
        Order order1 = orderService.getOrdersById(master, "XXXX");
        System.out.println(order1.toString());
        Assert.notNull(order1, "order不能是空");
    }
}
