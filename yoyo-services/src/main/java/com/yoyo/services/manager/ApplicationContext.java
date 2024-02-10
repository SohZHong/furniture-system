package com.yoyo.services.manager;

import com.yoyo.services.entity.User;

    public class ApplicationContext {
    private static User loginUser;

    public static User getLoginUser() {
        return loginUser;
    }

    public static void setLoginUser(User loginUser) {
        ApplicationContext.loginUser = loginUser;
    }
    
    public static void removeLoginUser(){
        loginUser=null;
    }
}
