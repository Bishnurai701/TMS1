package com.tms.model;



public class Contact {
    private int Contact_id;
    private String Email;
    private String MobileNo;
    private String LandLine;
    private int Registration_id;
    private int Person_id;

    /*Constructors */
    public Contact(int Contact_id){}
    public Contact(int Contact_id, String Email, String MobileNo, String LandLine, int Registration_id,int Person_id){
        this.Contact_id= Contact_id;
        this.Email=Email;
        this.MobileNo=MobileNo;
        this.LandLine=LandLine;
        this.Registration_id=Registration_id;
        this.Person_id=Person_id;
    }

    public Contact(String Email, String MobileNo, String LandLine, int Registration_id,int Person_id){
        this.Email=Email;
        this.MobileNo=MobileNo;
        this.LandLine=LandLine;
        this.Registration_id=Registration_id;
        this.Person_id=Person_id;
    }
    public Contact(String Email, String MobileNo, String LandLine){
        this.Email=Email;
        this.MobileNo=MobileNo;
        this.LandLine=LandLine;
    }

    /* Here is getter*/

    public int getContact_id() {
        return Contact_id;
    }

    public String getEmail() {
        return Email;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public String getLandLine() {
        return LandLine;
    }

    public int getRegistration_id() {
        return Registration_id;
    }
    public int getPerson_id(){
        return Person_id;
    }

    /*Here is Setter*/

    public void setContact_id(int Contact_id) {
        this.Contact_id = Contact_id;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setMobileNo(String MobileNo) {
        this.MobileNo = MobileNo;
    }

    public void setLandLine(String LandLine) {
        this.LandLine = LandLine;
    }

    public void setRegistration_id(int Registration_id) {
        this.Registration_id = Registration_id;
    }

    public void setPerson_id(int Person_id) {
        this.Person_id = Person_id;
    }
}
