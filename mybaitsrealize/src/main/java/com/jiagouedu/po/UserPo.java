package com.jiagouedu.po;


import java.io.Serializable;

/**
 * 用户实体类
 *
 * @author cjw
 */
public class UserPo implements Serializable {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名称
     */
    private String userName;

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserPo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
