import org.apache.shardingsphere.driver.jdbc.core.datasource.ShardingSphereDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.util.Assert;
import pers.peixinyi.framwork_mysql_proxy.ApplicationRun;
import pers.peixinyi.framwork_mysql_proxy.entity.Order;
import pers.peixinyi.framwork_mysql_proxy.service.OrderService;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.xml.crypto.Data;
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
    DataSource dataSource;

    @Autowired
    OrderService orderService;

    @Test
    public void getDatasource() throws SQLException {
        Assert.notNull(dataSource.getConnection(), "don't connect Master Datasource");
    }

    @Test
    public void addOrderTableTest() throws SQLException {
        dataSource.getConnection().prepareStatement("insert into t_order (user_id,order_id)values(1,1);").execute();
        //dataSource.getConnection().prepareStatement("select * from order o where id = 1;").executeQuery();
    }

    @Test
    public void operationOrderTable() {
        Order order1 = orderService.getOrdersById(dataSource, "XXXX");
        System.out.println(order1.toString());
        Assert.notNull(order1, "order不能是空");
    }
}
