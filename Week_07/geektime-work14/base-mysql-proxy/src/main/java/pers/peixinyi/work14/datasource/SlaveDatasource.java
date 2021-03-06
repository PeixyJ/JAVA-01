package pers.peixinyi.work14.datasource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-03-05 13:16
 */
@Configuration
@ConfigurationProperties(prefix = "datasource")
public class SlaveDatasource {

    List<BaseDataSourceAttribute> slave = new ArrayList<BaseDataSourceAttribute>();

    public SlaveDatasource() {
    }

    public SlaveDatasource(List<BaseDataSourceAttribute> slave) {
        this.slave = slave;
    }

    public List<BaseDataSourceAttribute> getSlave() {
        return slave;
    }

    public void setSlave(List<BaseDataSourceAttribute> slave) {
        this.slave = slave;
    }
}
