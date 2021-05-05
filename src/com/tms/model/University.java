package com.tms.model;

public class University {
    private int University_id;
    private String UniversityName;
    private int Qualification_id;

    /* Constructors */
    public University(int University_id){}
    public University(int University_id,String UniversityName){
        this.University_id=University_id;
        this.UniversityName=UniversityName;
    }
    public University(String UniversityName){
        this.UniversityName=UniversityName;
    }

    /* Here is Getter */
    public int getUniversity_id(){
        return University_id;
    }
    public String getUniversityName(){
        return UniversityName;
    }
    /*Here is Setter*/
    public void setUniversity_id(int University_id){
        this.University_id=University_id;
    }
    public void setUniversityName(String UniversityName){
        this.UniversityName=UniversityName;
    }



}
