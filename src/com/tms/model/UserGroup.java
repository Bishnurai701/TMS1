package com.tms.model;

import java.util.Date;


public class UserGroup {
    private int UserGroup_id;
    private String UserGroupName;
    private Date CreatedDate;
    //private Date ModifiedDate;

    public UserGroup(int UserGroup_id, String UserGroupName) {
        super();
        this.UserGroup_id = UserGroup_id;
        this.UserGroupName = UserGroupName;

    }
    public UserGroup( String UserGroupName) {
        super();
        this.UserGroupName = UserGroupName;

    }

    public UserGroup() {

    }

    public UserGroup(String UserGroupName, Date CreatedDate){
        this.UserGroup_id=UserGroup_id;
        this.UserGroupName=UserGroupName;
        this.CreatedDate=CreatedDate;
    }


    /*Getter*/
    public int getUserGroup_id(){
        return UserGroup_id;
    }
    public String getUserGroupName(){
        return UserGroupName;
    }
    public java.sql.Date getCreatedDate(){
        return (java.sql.Date) CreatedDate;
    }



    /*Setter*/
    public void setUserGroup_id(int UserGroup_id){
        this.UserGroup_id=UserGroup_id;
    }
    public void setUserGroupName(String UserGroupName){
        this.UserGroupName=UserGroupName;
    }
    public void setCreatedDate(Date CreatedDate){this.CreatedDate=CreatedDate;}


}
