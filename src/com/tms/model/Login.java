package com.tms.model;


import java.io.Serializable;
public class Login implements Serializable{
    private static final long serialVersionUID=1L;
    private static Object LoginDAO;
    private String UserName;
    private String UserLoginName;
    private String Password;

    public String getUserLoginName(){
        return UserLoginName;
    }
    public String getPassword(){
        return Password;
    }
    public String getUserName(){
        return UserName;
    }
    public void setUserLoginName(String UserLoginName){
        this.UserLoginName=UserLoginName;
    }
    public void setPassword(String Password){
        this.Password=Password;
    }
    public void setUserName(String UserName){
        this.UserName=UserName;
    }

}
