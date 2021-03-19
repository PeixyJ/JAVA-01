package pers.peixinyi.account.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.peixinyi.account.FreezeMoney;
import pers.peixinyi.account.FreezeMoneyService;
import pers.peixinyi.account.aop.ChangeDB;
import pers.peixinyi.account.mapper.FreezeMoneyMapper;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-03-17 16:01
 */
@DubboService
@Service
public class FreezeMoneyServiceImpl implements FreezeMoneyService {

    @Autowired
    FreezeMoneyMapper freezeMoneyMapper;

    @Override
    @ChangeDB
    public Boolean addFreezeMoney(int userID, FreezeMoney freezeMoney) {
        return freezeMoneyMapper.addFreezeMoney(freezeMoney);
    }

    @Override
    @ChangeDB
    public FreezeMoney getFreezeMoney(int userID, int orderID) {
        return freezeMoneyMapper.getFreezeMoney(userID, orderID);
    }

    @Override
    @ChangeDB
    public Boolean updateFreezeMoneyStatus(int userID, int orderID, int status) {
        return freezeMoneyMapper.updateFreezeMoneyStatus(userID, orderID, status);
    }

    @Override
    @ChangeDB
    public FreezeMoney getFreeMoney(int userID, int orderID, int status) {
        return freezeMoneyMapper.getFreezeMoneyStatus(userID, orderID, status);
    }
}
