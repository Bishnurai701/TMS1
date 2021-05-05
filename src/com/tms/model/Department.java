package com.tms.model;

public class Department {
    private int Department_id;
    private String DepartmentName;

    /* Constructors */
    public Department(int Department_id){}
    public Department(int Department_id,String DepartmentName){
        this.Department_id=Department_id;
        this.DepartmentName=DepartmentName;
    }
    public Department(String DepartmentName){
        this.DepartmentName=DepartmentName;
    }

    /*Here is getter*/
    public int getDepartment_id(){
        return Department_id;
    }
    public String getDepartmentName(){
        return DepartmentName;
    }

    /*Here is Setter*/
    public void setDepartment_id(int Department_id){
        this.Department_id=Department_id;
    }
    public void setDepartmentName(String DepartmentName){
        this.DepartmentName=DepartmentName;
    }

}
