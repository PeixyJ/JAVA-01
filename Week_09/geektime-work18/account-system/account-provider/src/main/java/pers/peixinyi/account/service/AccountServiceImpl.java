package pers.peixinyi.account.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.peixinyi.account.Account;
import pers.peixinyi.account.AccountService;
import pers.peixinyi.account.aop.ChangeDB;
import pers.peixinyi.account.mapper.AccountMapper;

/**
 * @author: peixinyi
 * @version: V1.0.0.0
 * @date: 2021-03-16 14:43
 */
@DubboService
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    @Override
    @ChangeDB
    public Account getAccount(int userId) {
        return accountMapper.queryAccount(userId);
    }

    @Override
    @ChangeDB
    public Boolean updateCNYWallet(int userId, int cnyWallet) {
        return accountMapper.updateCNYWallet(cnyWallet, userId);
    }

    @Override
    @ChangeDB
    public Boolean updateUSDWallet(int userId, int cnyWallet) {
        return accountMapper.updateUSDWallet(cnyWallet, userId);
    }
}
