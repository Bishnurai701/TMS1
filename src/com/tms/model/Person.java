package com.tms.model;

import java.util.Date;
import java.util.zip.DataFormatException;

public class Person {
    private int Person_id;
    private int Post_id;
    private int Registration_id;
    private int Salary_id;
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private Date DOB;
    private String Gender;
    private int PersonalIDNumber;
    private int Section_id;
    private int Department_id;
    private int PermanentAddress_id;
    private int TemporaryAddress_id;
    private String PhotoName;
    private String PhotoPath;

    /*Here is Getter */
    public Person(int Person_id){}
    public Person(int Person_id,int Post_id, int Registration_id, int Salary_id, String FistName,
                  String MiddleName, String LastName, Date DBO, String Gender, int PersonalIDNumber,
                  int Section_id, int Department_id,int PermanentAddress_id,int TemporaryAddress_id,
                  String PhotoName, String PhotoPath)
    {
        this.Person_id=Person_id;
        this.Post_id=Post_id;
        this.Registration_id=Registration_id;
        this.Salary_id=Salary_id;
        this.FirstName=FistName;
        this.MiddleName=MiddleName;
        this.LastName=LastName;
        this.DOB=DBO;
        this.Gender=Gender;
        this.PersonalIDNumber=PersonalIDNumber;
        this.Section_id=Section_id;
        this.Department_id=Department_id;
        this.PermanentAddress_id=PermanentAddress_id;
        this.TemporaryAddress_id=TemporaryAddress_id;
        this.PhotoName=PhotoName;
        this.PhotoPath=PhotoPath;
    }
    public Person(int Post_id, int Registration_id, int Salary_id, String FistName,
                  String MiddleName, String LastName, Date DBO, String Gender, int PersonalIDNumber,
                  int Section_id, int Department_id,int PermanentAddress_id,int TemporaryAddress_id,
                  String PhotoName, String PhotoPath)
    {
        this.Post_id=Post_id;
        this.Registration_id=Registration_id;
        this.Salary_id=Salary_id;
        this.FirstName=FistName;
        this.MiddleName=MiddleName;
        this.LastName=LastName;
        this.DOB=DBO;
        this.Gender=Gender;
        this.PersonalIDNumber=PersonalIDNumber;
        this.Section_id=Section_id;
        this.Department_id=Department_id;
        this.PermanentAddress_id=PermanentAddress_id;
        this.TemporaryAddress_id=TemporaryAddress_id;
        this.PhotoName=PhotoName;
        this.PhotoPath=PhotoPath;
    }
    public Person(int Post_id,  String FistName, String MiddleName, String LastName, Date DBO, String Gender,
                  int PersonalIDNumber, int Section_id, int Department_id, String PhotoName, String PhotoPath)
    {
        this.Post_id=Post_id;
        this.FirstName=FistName;
        this.MiddleName=MiddleName;
        this.LastName=LastName;
        this.DOB=DBO;
        this.Gender=Gender;
        this.PersonalIDNumber=PersonalIDNumber;
        this.Section_id=Section_id;
        this.Department_id=Department_id;
        this.PhotoName=PhotoName;
        this.PhotoPath=PhotoPath;
    }

    /* Here is Getter */

    public int getPerson_id() {
        return Person_id;
    }

    public int getPost_id() {
        return Post_id;
    }

    public int getRegistration_id() {
        return Registration_id;
    }

    public int getSalary_id() {
        return Salary_id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public String getLastName() {
        return LastName;
    }

    public Date getDOB() {
        return DOB;
    }

    public String getGender() {
        return Gender;
    }

    public int getPersonalIDNumber() {
        return PersonalIDNumber;
    }

    public int getSection_id() {
        return Section_id;
    }

    public int getDepartment_id() {
        return Department_id;
    }

    public int getPermanentAddress_id() {
        return PermanentAddress_id;
    }

    public int getTemporaryAddress_id() {
        return TemporaryAddress_id;
    }

    public String getPhotoName() {
        return PhotoName;
    }

    public String getPhotoPath() {
        return PhotoPath;
    }
    /* Here is Setter */

    public void setPerson_id(int Person_id) {
        this.Person_id = Person_id;
    }

    public void setPost_id(int Post_id) {
        this.Post_id = Post_id;
    }

    public void setRegistration_id(int Registration_id) {
        this.Registration_id = Registration_id;
    }

    public void setSalary_id(int Salary_id) {
        this.Salary_id = Salary_id;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setMiddleName(String MiddleName) {
        this.MiddleName = MiddleName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setPersonalIDNumber(int PersonalIDNumber) {
        this.PersonalIDNumber = PersonalIDNumber;
    }

    public void setSection_id(int Section_id) {
        this.Section_id = Section_id;
    }

    public void setDepartment_id(int Department_id) {
        this.Department_id = Department_id;
    }

    public void setPermanentAddress_id(int PermanentAddress_id) {
        this.PermanentAddress_id = PermanentAddress_id;
    }

    public void setTemporaryAddress_id(int TemporaryAddress_id) {
        this.TemporaryAddress_id = TemporaryAddress_id;
    }

    public void setPhotoName(String PhotoName) {
        this.PhotoName = PhotoName;
    }

    public void setPhotoPath(String PhotoPath) {
        this.PhotoPath = PhotoPath;
    }
}
