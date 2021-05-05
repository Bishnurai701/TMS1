package com.tms.model;

import java.util.Date;

public class UserRoll {
    private int UserRoll_id;
    private String UserRollName;

    public UserRoll(){}
    public UserRoll(int UserRoll_id,String UserRollName){
        super();
        this.UserRoll_id=UserRoll_id;
        this.UserRollName=UserRollName;
    }
    public UserRoll(String UserRollName){
        super();
        this.UserRollName=UserRollName;

    }
    /*getter here*/
    public int getUserRoll_id(){
        return UserRoll_id;
    }
    public String getUserRollName(){
        return UserRollName;
    }


    /*setter here*/
    public void setUserRoll_id(int UserRoll_id){
        this.UserRoll_id=UserRoll_id;
    }
    public void setUserRollName(String UserRollName){
        this.UserRollName=UserRollName;
    }



}
