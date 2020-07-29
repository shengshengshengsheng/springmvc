package cn.itcast.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author:Administrator
 * @date:2020/7/29
 * @description:
 */
public class Account implements Serializable {
    private String username;

    private String password;

    private Double money;

    private User user;

    private List<User> userList;

    private Map<String,User> userMap;

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", user=" + user +
                ", userList=" + userList +
                '}';
    }
}
