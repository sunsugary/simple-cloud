package com.iukme.simpleweb.common.utils;

import com.iukme.simpleweb.common.vo.LoginUser;
import lombok.Data;

public class LoginUtil {


    public static LoginUser loginUser(){
        LoginUser loginUser = new LoginUser();
        loginUser.setUserId(1L);
        loginUser.setUserName("admin");
        return loginUser;
    }
}
