package pers.hongdenglv.work13;

import java.sql.Timestamp;
import java.util.Random;

import static pers.hongdenglv.work13.Value.PROVINCES_LIST;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-02-27 17:19
 */
public class GenerateOrderSqlImpl implements GenerateOrderSql {

    @Override
    public String getId() {
        return new RandomIdGenerateImpl().generate();
    }

    @Override
    public Integer getConsumerId() {
        return new Random().nextInt(10000);
    }

    @Override
    public String getCountries() {
        return "中国";
    }

    @Override
    public String getProvinces() {
        return PROVINCES_LIST[new Random().nextInt(PROVINCES_LIST.length)];
    }

    @Override
    public String getCity() {
        return PROVINCES_LIST[new Random().nextInt(PROVINCES_LIST.length)];
    }

    @Override
    public String getAres() {
        return PROVINCES_LIST[new Random().nextInt(PROVINCES_LIST.length)];
    }

    @Override
    public String getDetail() {
        return String.format("%s-%s-%s-%s", getCountries(), getProvinces(), getCity(), getAres());
    }

    @Override
    public Integer getOrderAmount() {
        return new Random().nextInt(1000000);
    }

    @Override
    public Integer getLogisticsAmount() {
        return new Random().nextInt(10000);
    }

    @Override
    public Integer getLogisticsStatus() {
        return new Random().nextInt(2);
    }

    @Override
    public Integer getOrderStatus() {
        return new Random().nextInt(2);
    }

    @Override
    public Timestamp getUpdateTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    @Override
    public Timestamp getCreateTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    @Override
    public String getNote() {
        return "";
    }

    @Override
    public String generate() {
        return String.format("('%s',%d,'%s','%s','%s','%s','%s',%d,%d,%d,%d,'%s','%s','%s')"
                , getId(), getConsumerId(), getCountries(), getProvinces(), getCity(), getAres(), getDetail(), getOrderAmount(), getLogisticsAmount(), getLogisticsStatus(), getOrderStatus(), getUpdateTime().toString(), getCreateTime().toString(), getNote());
    }
}
