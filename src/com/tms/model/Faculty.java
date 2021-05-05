package com.tms.model;

public class Faculty {
    private int Faculty_id;
    private String FacultyName;
    private int Qualification_id;

    /*Constructor*/
    public Faculty(int Faculty_id){}

    public Faculty(int Faculty_id,String FacultyName){
        this.Faculty_id=Faculty_id;
        this.FacultyName=FacultyName;
    }
    public Faculty(String FacultyName){
        this.FacultyName=FacultyName;
    }

    /*Here is Getter*/
    public int getFaculty_id(){
        return Faculty_id;
    }
    public String getFacultyName(){
        return FacultyName;
    }

    /*Here is Setter*/
    public void setFaculty_id(int Faculty_id){
        this.Faculty_id=Faculty_id;
    }
    public void setFacultyName(String FacultyName){
        this.FacultyName=FacultyName;
    }
}
