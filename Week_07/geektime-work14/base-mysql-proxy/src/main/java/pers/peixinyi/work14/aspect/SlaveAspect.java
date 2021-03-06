package pers.peixinyi.work14.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.peixinyi.work14.entity.Order;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-03-05 14:30
 */
@Aspect
@Component
public class SlaveAspect {

    @Autowired
    List<DataSource> slaveDatasourceList;

    @Pointcut("@annotation(pers.peixinyi.work14.annotaion.Slave)")
    public void slave() {
    }

    @Around("slave()")
    public Order setDataSource(ProceedingJoinPoint point) throws Throwable {
        Object[] arg = point.getArgs();
        DataSource dataSource = slaveDatasourceList.get(new Random().nextInt(slaveDatasourceList.size()));
        arg[0] = dataSource;
        return (Order) point.proceed(arg);
    }

}
