package com.devpro.android54_day2.object;

import java.io.Serializable;

public class User implements Serializable {

    private String userName, address;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User() {
    }

    public User(String userName, String address) {
        this.userName = userName;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
