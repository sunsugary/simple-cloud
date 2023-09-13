package com.iukme.common.utils;


import com.iukme.common.vo.LoginUser;

public class LoginUtil {


    public static LoginUser loginUser(){
        LoginUser loginUser = new LoginUser();
        loginUser.setUserId(1L);
        loginUser.setUserName("admin");
        return loginUser;
    }
}
