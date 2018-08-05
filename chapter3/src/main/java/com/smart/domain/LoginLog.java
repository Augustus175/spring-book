package com.smart.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangzhibo-linux
 * @date 18-7-15 上午11:08
 */
public class LoginLog implements Serializable {
    private String loginLogId;
    private int userId;
    private String ip;
    private Date loginDate;

    public String getLoginLogId() {
        return loginLogId;
    }

    public void setLoginLogId(String loginLogId) {
        this.loginLogId = loginLogId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

}
