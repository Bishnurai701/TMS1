package com.tms.model;

import java.util.Date;

public class Post {
    private int Post_id;
    private String PostName;
    private int Person_id;
    private int Registration_id;
    private String CreatedBy;
    private String ModifiedBy;
    private Date CreatedDate;
    private Date ModifiedDate;

    /*Here is constructors*/
    public Post(int Post_id){}

    public Post(int Post_id, String PostName){
        this.Post_id=Post_id;
        this.PostName=PostName;
    }
    public Post(String PostName){
        this.PostName=PostName;
    }

    /*Here is Getter*/
    public int getPost_id(){
        return Post_id;
    }
    public String getPostName(){
        return PostName;
    }
    /*Here is Setter*/
    public void setPost_id(int Post_id){
        this.Post_id=Post_id;
    }
    public void setPostName(String PostName){
        this.PostName=PostName;
    }
}
