package com.tms.model;

public class User_Roll_Drop {
    private int UserRoll_id;
    private String UserRollName;

    public User_Roll_Drop(int UserRoll_id, String UserRollName){
        super();
        this.UserRoll_id=UserRoll_id;
        this.UserRollName=UserRollName;
    }
    public User_Roll_Drop(String UserRollName){
        super();
        this.UserRollName=UserRollName;
    }
    public int getUserRoll_id(){
        return UserRoll_id;
    }
    public String getUserRollName(){
        return UserRollName;
    }
    public void setUserRoll_id(int UserRoll_id){
        this.UserRoll_id=UserRoll_id;
    }
    public void setUserRollName(String UserRollName){
        this.UserRollName=UserRollName;
    }
}
