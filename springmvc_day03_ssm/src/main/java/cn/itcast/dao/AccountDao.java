package cn.itcast.dao;

import cn.itcast.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账户dao接口
 * @author Administrator
 */
@Repository
public interface AccountDao {

    /**
     * 查询所有方法
     * @return
     */
    @Select("select * from account")
    List<Account> findAll();

    /**
     * 保存账户的方法
     * @param account
     */
    @Insert("insert into account(name,money,uid) values (#{name},#{money},#{uid})")
    void saveAccount(Account account);
}
