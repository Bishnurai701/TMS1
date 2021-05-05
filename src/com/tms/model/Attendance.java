package com.tms.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Attendance {
    private int Attendance_id;
    private int Registration_id;
    private Date AttendDate;
    private Time Check_IN;
    private Time Check_OUT;
    private Date TotalPresentDate;
    private Date TotalAbsentDate;
    private int User_id;
    private String Comment;
    private String FirstName;

    /* Constructors */
    public Attendance(int Attendance_id){};
    public Attendance(int Attendance_id, int Registration_id,
                      Date AttendDate, Time Check_IN, Time Check_OUT, Date TotalPresentDate,
                      Date TotalAbsentDate, int User_id, String Comment){
        this.Attendance_id=Attendance_id;
        this.Registration_id=Registration_id;
        this.AttendDate=AttendDate;
        this.Check_IN=Check_IN;
        this.Check_OUT=Check_OUT;
        this.TotalPresentDate=TotalPresentDate;
        this.TotalAbsentDate=TotalAbsentDate;
        this.User_id=User_id;
        this.Comment=Comment;
    }
    public Attendance(Date AttendDate,int Registration_id,Time Check_IN,Time Check_OUT,Date TotalPresentDate,
                      Date TotalAbsentDate,int User_id,String Comment){
        this.AttendDate=AttendDate;
        this.Registration_id=Registration_id;
        this.Check_IN=Check_IN;
        this.Check_OUT=Check_OUT;
        this.TotalPresentDate=TotalPresentDate;
        this.TotalAbsentDate=TotalAbsentDate;
        this.User_id=User_id;
        this.Comment=Comment;
    }
    public Attendance(int Registration_id,
                      Date AttendDate,Time Check_IN,Time Check_OUT,String Comment){
        this.Registration_id=Registration_id;
        this.AttendDate=AttendDate;
        this.Check_IN=Check_IN;
        this.Check_OUT=Check_OUT;
        this.Comment=Comment;
    }
    public Attendance(int Attendance_id,String FirstName,Date AttendDate,Time Check_IN,Time Check_OUT,String Comment)
    {
        this.Attendance_id=Attendance_id;
        this.FirstName=FirstName;
        this.AttendDate=AttendDate;
        this.Check_IN=Check_IN;
        this.Check_OUT=Check_OUT;
        this.Comment=Comment;
    }
    /* here is getter */

    public int getAttendance_id() {
        return Attendance_id;
    }

    public int getRegistration_id() {
        return Registration_id;
    }


    public Date getAttendDate() {
        return AttendDate;
    }

    public Time getCheck_IN() {
        return Check_IN;
    }

    public Time getCheck_OUT() {
        return Check_OUT;
    }

    public Date getTotalPresentDate() {
        return TotalPresentDate;
    }

    public Date getTotalAbsentDate() {
        return TotalAbsentDate;
    }

    public int getUser_id() {
        return User_id;
    }

    public String getComment() {
        return Comment;
    }

    public String getFirstName(){return FirstName;}
    /* Here is setter */

    public void setAttendance_id(int Attendance_id) {
        this.Attendance_id = Attendance_id;
    }

    public void setRegistration_id(int Registration_id) {
        this.Registration_id = Registration_id;
    }


    public void setAttendDate(Date AttendDate) {
        this.AttendDate = AttendDate;
    }

    public void setCheck_IN(Time Check_IN) {
        this.Check_IN = Check_IN;
    }

    public void setCheck_OUT(Time Check_OUT) {
        this.Check_OUT = Check_OUT;
    }

    public void setTotalPresentDate(Date TotalPresentDate) {
        this.TotalPresentDate = TotalPresentDate;
    }

    public void setTotalAbsentDate(Date TotalAbsentDate) {
        this.TotalAbsentDate = TotalAbsentDate;
    }

    public void setUser_id(int User_id) {
        this.User_id = User_id;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public void setFirstName(String FirstName){this.FirstName=FirstName;}
}
