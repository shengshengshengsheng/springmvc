package cn.itcast.service;

import cn.itcast.domain.Account;

import java.util.List;

public interface AccountService {
    /**
     * 查询所有方法
     * @return
     */
    List<Account> findAll();

    /**
     * 保存账户的方法
     * @param account
     */
    void saveAccount(Account account);
}
