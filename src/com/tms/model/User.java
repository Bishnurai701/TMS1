package com.tms.model;
import java.util.Date;

public class User{
    private int User_id;
    private String UserName;
    private String UserLoginName;
    private String Password;
    private int UserGroup_id;
    private int QRAndThump_id;
    private int Registration_id;
    private String CreatedBy;
    private String ModifiedBy;
    private Date CreatedDate;
    private Date ModifiedDate;
    private String UserGroupName;
    private String UserRollName;
    private int UserRoll_id;
    private int Status;

    public User(int UserGroup_id){}

    public User(int UserGroup_id,String UserGroupName){
        super();
        this.UserGroup_id=UserGroup_id;
        this.UserGroupName=UserGroupName;
    }
    public User(String UserName,String UserLoginName,String Password){
        this.UserName=UserName;
        this.UserLoginName=UserLoginName;
        this.Password=Password;
    }


    /*Constructor with id */
    public User(int User_id,String UserName, String UserLoginName,String Password, int UserGroup_id, int QRAndThump_id, int Registration_id, String CreatedBy, String ModifiedBy, Date CreatedDate, Date ModifiedDate,int UserRoll_id,int Status) {
        super();
        this.User_id = User_id;
        this.UserName=UserName;
        this.UserLoginName = UserLoginName;
        this.Password=Password;
        this.UserGroup_id = UserGroup_id;
        this.QRAndThump_id = QRAndThump_id;
        this.Registration_id = Registration_id;
        this.CreatedBy = CreatedBy;
        this.ModifiedBy = ModifiedBy;
        this.CreatedDate = CreatedDate;
        this.ModifiedDate = ModifiedDate;
        this.UserRoll_id=UserRoll_id;
        this.Status=Status;
    }

    /*Constructor without id*/

    public User(String UserName,String UserLoginName,String Password, int UserGroup_id, int QRAndThump_id, int Registration_id, String CreatedBy, String ModifiedBy, Date CreatedDate, Date ModifiedDate ,int UserRoll_id,int Status) {
       super();
       this.UserName=UserName;
        this.UserLoginName = UserLoginName;
        this.Password=Password;
        this.UserGroup_id = UserGroup_id;
        this.QRAndThump_id = QRAndThump_id;
        this.Registration_id = Registration_id;
        this.CreatedBy = CreatedBy;
        this.ModifiedBy = ModifiedBy;
        this.CreatedDate = CreatedDate;
        this.ModifiedDate = ModifiedDate;
        this.UserRoll_id=UserRoll_id;
        this.Status=Status;

    }
    public User(int User_id,String UserName, String UserLoginName,String Password, int UserGroup_id,int UserRoll_id,int Status){
        super();
        this.User_id=User_id;
        this.UserName=UserName;
        this.UserLoginName=UserLoginName;
        this.Password=Password;
        this.UserGroup_id=UserGroup_id;
        this.UserRoll_id=UserRoll_id;
        this.Status=Status;
    }
    public User(int User_id,String UserName, String UserLoginName,int UserGroup_id,int UserRoll_id,int Status){
        super();
        this.User_id=User_id;
        this.UserName=UserName;
        this.UserLoginName=UserLoginName;
        this.UserGroup_id=UserGroup_id;
        this.UserRoll_id=UserRoll_id;
        this.Status=Status;
    }
    public User(String UserName, String UserLoginName,String Password, int UserGroup_id,int UserRoll_id,int Status){
        super();
        this.UserName=UserName;
        this.UserLoginName=UserLoginName;
        this.Password=Password;
        this.UserGroup_id=UserGroup_id;
        this.UserRoll_id=UserRoll_id;
        this.Status=Status;
    }
    public User(int User_id,String UserName, String UserLoginName,String UserGroupName, String UserRollName,int Status){
        super();
        this.User_id=User_id;
        this.UserName=UserName;
        this.UserLoginName=UserLoginName;
        this.UserGroupName=UserGroupName;
        this.UserRollName=UserRollName;
        this.Status=Status;
    }


    /*Here is Getter*/
    public int getUser_id(){
        return User_id;
    }
    public String getUserName(){return UserName;}
    public String getUserLoginName() {
        return UserLoginName;
    }
    public String getPassword(){
        return Password;
    }
    public int getUserGroup_id(){
        return UserGroup_id;
    }
    public int getQRAndThump_id(){
        return QRAndThump_id;
    }
    public int getRegistration_id(){
        return Registration_id;
    }
    public String getCreatedBy(){
        return CreatedBy;
    }
    public String getModifiedBy(){
        return ModifiedBy;
    }
    public Date getCreatedDate(){
        return CreatedDate;
    }
    public Date getModifiedDate(){
        return ModifiedDate;
    }
    public String getUserGroupName(){
        return UserGroupName;
    }
    public String getUserRollName(){return UserRollName;}
    public int getUserRoll_id(){return UserRoll_id;}
    public int getStatus(){return  Status;}

    /*Here is Setter*/
    public void setUser_id(int User_id){
        this.User_id=User_id;
    }
    public void setUserName(String UserName){ this.UserName=UserName;}
    public void setUserLoginName(String UserLoginName){
        this.UserLoginName=UserLoginName;
    }
    public void setPassword(String Password){
        this.Password=Password;
    }
    public void setUserGroup_id(int UserGroup_id){
        this.UserGroup_id=UserGroup_id;
    }
    public void setQRAndThump_id(int QRAndThump_id){
        this.QRAndThump_id=QRAndThump_id;
    }
    public void setRegistration_id(int Registration_id){
        this.Registration_id=Registration_id;
    }
    public void setCreatedBy(String CreatedBy){
        this.CreatedBy=CreatedBy;
    }
    public void setModifiedBy(String ModifiedBy){
        this.ModifiedBy=ModifiedBy;
    }
    public void setCreatedDate(Date CreatedDate){
        this.CreatedDate=CreatedDate;
    }
    public void setModifiedDate(Date ModifiedDate){
        this.ModifiedDate=ModifiedDate;
    }
    public void setUserGroupName(String UserGroupName){
        this.UserGroupName=UserGroupName;
    }
    public void setUserRollName(String UserRollName){this.UserRollName=UserRollName;}
    public void setUserRoll_id(int UserRoll_id){this.UserRoll_id=UserRoll_id;}
    public void setStatus(int Status){this.Status=Status;}
}
