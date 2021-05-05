package com.tms.model;


import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


public class Registration {
    private int Registration_id;
    private Date RegistrationDate;
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private String MothersName;
    private String FathersName;
    private Date DOB;
    private String Gender;
    private String Email;
    private String MobileNo;
    private String LandLine;
    private int PersonalIDNumber;
    private int Post_id;
    private int Section_id;
    private int Department_id;
    private int Salary_id;

    private String PhotoName;
    private String PhotoPath;

    private String CreatedBy;
    private String ModifiedBy;
    private Date CreatedDate;
    private Date ModifiedDate;
    private int User_id;
    private int QRAndThump_id;

    private String SectionName;
    private String PostName;
    private String DepartmentName;

    /*Constructors*/


    public Registration(int Registration_id,Date RegistrationDate, String FirstName, String MiddleName,String LastName,
                        String MothersName, String FathersName, Date DOB, String Gender,
                        String Email, String MobileNo, String LandLine, int PersonalIDNumber,int Post_id,
                        int Section_id, int Department_id,String PhotoName,String PhotoPath)
    {
        this.Registration_id=Registration_id;
        this.RegistrationDate=RegistrationDate;
        this.FirstName=FirstName;
        this.MiddleName=MiddleName;
        this.LastName=LastName;
        this.MothersName=MothersName;
        this.FathersName=FathersName;
        this.DOB=DOB;
        this.Gender=Gender;
        this.Email=Email;
        this.MobileNo=MobileNo;
        this.LandLine=LandLine;
        this.Section_id=Section_id;
        this.Department_id=Department_id;
        this.PersonalIDNumber=PersonalIDNumber;
        this.Post_id=Post_id;
        this.PhotoName=PhotoName;
        this.PhotoPath=PhotoPath;
    }

    public Registration(int Registration_id,Date RegistrationDate, String FirstName, String MiddleName,String LastName,
                        String MothersName, String FathersName, Date DOB, String Gender,
                        String Email, String MobileNo, String LandLine, int PersonalIDNumber,int Post_id,
                        int Section_id, int Department_id)
    {
        this.Registration_id=Registration_id;
        this.RegistrationDate=RegistrationDate;
        this.FirstName=FirstName;
        this.MiddleName=MiddleName;
        this.LastName=LastName;
        this.MothersName=MothersName;
        this.FathersName=FathersName;
        this.DOB=DOB;
        this.Gender=Gender;
        this.Email=Email;
        this.MobileNo=MobileNo;
        this.LandLine=LandLine;
        this.PersonalIDNumber=PersonalIDNumber;
        this.Post_id=Post_id;
        this.Section_id=Section_id;
        this.Department_id=Department_id;
    }
    public Registration(Date RegistrationDate, String FirstName,String MiddleName,String LastName,
                        String MothersName, String FathersName, Date DOB, String Gender,
                        String Email, String MobileNo, String LandLine, int PersonalIDNumber,int Post_id,
                        int Section_id, int Department_id,String PhotoName,String PhotoPath)
    {
        this.RegistrationDate=RegistrationDate;
        this.FirstName=FirstName;
        this.MiddleName=MiddleName;
        this.LastName=LastName;
        this.MothersName=MothersName;
        this.FathersName=FathersName;
        this.DOB=DOB;
        this.Gender=Gender;
        this.Email=Email;
        this.MobileNo=MobileNo;
        this.LandLine=LandLine;
        this.PersonalIDNumber=PersonalIDNumber;
        this.Post_id=Post_id;
        this.Section_id=Section_id;
        this.Department_id=Department_id;
        this.PhotoName=PhotoName;
        this.PhotoPath=PhotoPath;
    }

    public Registration(int Registration_id, java.sql.Date RegistrationDate, String FirstName,String Gender, java.sql.Date DOB, int PersonalIDNumber, String PostName,
                        String SectionName, String DepartmentName, String Email, String MobileNo)
    {
       this.Registration_id=Registration_id;
        this.RegistrationDate=RegistrationDate;
        this.FirstName=FirstName;
        this.Gender=Gender;
        this.DOB=DOB;
        this.PersonalIDNumber=PersonalIDNumber;
        this.SectionName=SectionName;
        this.PostName=PostName;
        this.DepartmentName=DepartmentName;
        this.Email=Email;
        this.MobileNo=MobileNo;
    }
    public Registration(int Registration_id, int PersonalIDNumber)
    {
        this.Registration_id=Registration_id;
        this.PersonalIDNumber=PersonalIDNumber;
    }
    public  Registration(int Registration_id,String FirstName)
    {
        this.Registration_id=Registration_id;
        this.FirstName=FirstName;
    }


    /* Here is Getter*/

    public int getRegistration_id() {
        return Registration_id;
    }

    public Date getRegistrationDate() {
        return RegistrationDate;
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

    public String getMothersName() {
        return MothersName;
    }

    public String getFathersName() {
        return FathersName;
    }

    public Date getDOB() {
        return DOB;
    }

    public String getGender() {
        return Gender;
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

    public int getPersonalIDNumber() {
        return PersonalIDNumber;
    }

    public int getPost_id() {
        return Post_id;
    }

    public int getSection_id() {
        return Section_id;
    }

    public int getDepartment_id() {
        return Department_id;
    }


    public int getSalary_id() {
        return Salary_id;
    }

    public String getPhotoName() {
        return PhotoName;
    }

    public String getPhotoPath() {
        return PhotoPath;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public String getModifiedBy() {
        return ModifiedBy;
    }

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public Date getModifiedDate() {
        return ModifiedDate;
    }

    public int getUser_id() {
        return User_id;
    }

    public int getQRAndThump_id() {
        return QRAndThump_id;
    }


    public String getSectionName() {
        return SectionName;
    }

    public String getPostName() {
        return PostName;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    /* Here is Setter*/

    public void setRegistration_id(int Registration_id) {
        this.Registration_id = Registration_id;
    }

    public void setRegistrationDate(Date RegistrationDate) {
        this.RegistrationDate = RegistrationDate;
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

    public void setMothersName(String MothersName) {
        this.MothersName = MothersName;
    }

    public void setFathersName(String FathersName) {
        this.FathersName = FathersName;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
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

    public void setPersonalIDNumber(int PersonalIDNumber) {
        this.PersonalIDNumber = PersonalIDNumber;
    }

    public void setPost_id(int Post_id) {
        this.Post_id = Post_id;
    }

    public void setSection_id(int Section_id) {
        this.Section_id = Section_id;
    }

    public void setDepartment_id(int Department_id) {
        this.Department_id = Department_id;
    }


    public void setSalary_id(int Salary_id) {
        this.Salary_id = Salary_id;
    }

    public void setPhotoName(String PhotoName) {
        this.PhotoName = PhotoName;
    }

    public void setPhotoPath(String PhotoPath) {
        this.PhotoPath = PhotoPath;
    }

    public void setCreatedBy(String CreatedBy) {
        this.CreatedBy = CreatedBy;
    }

    public void setModifiedBy(String ModifiedBy) {
        this.ModifiedBy = ModifiedBy;
    }

    public void setCreatedDate(Date CreatedDate) {
        this.CreatedDate = CreatedDate;
    }

    public void setModifiedDate(Date ModifiedDate) {
        this.ModifiedDate = ModifiedDate;
    }

    public void setUser_id(int User_id) {
        this.User_id = User_id;
    }

    public void setQRAndThump_id(int QRAndThump_id) {
        this.QRAndThump_id = QRAndThump_id;
    }


    public void setSectionName(String SectionName) {
        this.SectionName = SectionName;
    }

    public void setPostName(String PostName) {
        this.PostName = PostName;
    }

    public void setDepartmentName(String DepartmentName) {
        this.DepartmentName = DepartmentName;
    }
}
