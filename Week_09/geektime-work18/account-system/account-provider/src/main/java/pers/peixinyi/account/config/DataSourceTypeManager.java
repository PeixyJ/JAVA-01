package pers.peixinyi.account.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-03-16 15:35
 */
@Component
public class DataSourceTypeManager{

    private static final ThreadLocal<String> dataSourceType = ThreadLocal.withInitial(() -> "db0");


    public static String getDataSourceType() {
        return dataSourceType.get();
    }

    public static void setDataSourceType(String db) {
        dataSourceType.set(db);
    }

    public static void resetDataSourceType() {
        dataSourceType.set("db0");
    }
}
