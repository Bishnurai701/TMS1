package com.tms.model;

import java.util.Date;

public class Qualification {
    private int Qualification_id;
    private int Level_id;
    private String InstituteName;
    private String PercentOrGPA;
    private Date PassedYear;
    private String Address;
    private int Board_id;
    private int Faculty_id;
    private int University_id;
    private int Registration_id;
    private String FileName;
    private String FilePath;

    private String LevelName;
    private String BoardName;
    private String FacultyName;
    private String UniversityName;
    private String FirstName;

    /* here constructor */
    public Qualification(int Qualification_id){}

    public Qualification(int Qualification_id, int Level_id, String InstituteName, String PercentOrGPA, Date PassedYear, String Address, int Board_id, int Faculty_id, int University_id, int Registration_id, String FilePath,String FileName) {
        this.Qualification_id = Qualification_id;
        this.Level_id = Level_id;
        this.InstituteName = InstituteName;
        this.PercentOrGPA = PercentOrGPA;
        this.PassedYear = PassedYear;
        this.Address = Address;
        this.Board_id = Board_id;
        this.Faculty_id = Faculty_id;
        this.University_id = University_id;
        this.Registration_id = Registration_id;
        this.FilePath = FilePath;
        this.FileName=FileName;

    }
    public Qualification(int Level_id, String InstituteName, String PercentOrGPA, Date PassedYear, String Address, int Board_id, int Faculty_id, int University_id, int Registration_id, String FilePath,String FileName) {

        this.Level_id = Level_id;
        this.InstituteName = InstituteName;
        this.PercentOrGPA = PercentOrGPA;
        this.PassedYear = PassedYear;
        this.Address = Address;
        this.Board_id = Board_id;
        this.Faculty_id = Faculty_id;
        this.University_id = University_id;
        this.Registration_id = Registration_id;
        this.FilePath = FilePath;
        this.FileName=FileName;
    }

    public Qualification(int Qualification_id,String LevelName, String InstituteName, String PercentOrGPA, Date PassedYear, String Address, String BoardName, String FacultyName, String UniversityName, String FirstName) {

        this.Qualification_id=Qualification_id;
        this.LevelName = LevelName;
        this.InstituteName = InstituteName;
        this.PercentOrGPA = PercentOrGPA;
        this.PassedYear = PassedYear;
        this.Address = Address;
        this.BoardName = BoardName;
        this.FacultyName = FacultyName;
        this.UniversityName = UniversityName;
        this.FirstName = FirstName;
    }

    /* Here is getter */

    public int getQualification_id() {
        return Qualification_id;
    }

    public int getLevel_id() {
        return Level_id;
    }

    public String getInstituteName() {
        return InstituteName;
    }

    public String getPercentOrGPA() {
        return PercentOrGPA;
    }

    public Date getPassedYear() {
        return PassedYear;
    }

    public String getAddress() {
        return Address;
    }

    public int getBoard_id() {
        return Board_id;
    }

    public int getFaculty_id() {
        return Faculty_id;
    }

    public int getUniversity_id() {
        return University_id;
    }

    public int getRegistration_id() {
        return Registration_id;
    }

    public String getFileName() {
        return FileName;
    }

    public String getFilePath() {
        return FilePath;
    }

    public String getLevelName() {
        return LevelName;
    }

    public String getBoardName() {
        return BoardName;
    }

    public String getFacultyName() {
        return FacultyName;
    }

    public String getUniversityName() {
        return UniversityName;
    }

    public String getFirstName() {
        return FirstName;
    }
    /* Here is setter */

    public void setQualification_id(int Qualification_id) {
        this.Qualification_id = Qualification_id;
    }

    public void setLevel_id(int Level_id) {
        this.Level_id = Level_id;
    }

    public void setInstituteName(String InstituteName) {
        this.InstituteName = InstituteName;
    }

    public void setPercentOrGPA(String PercentOrGPA) {
        this.PercentOrGPA = PercentOrGPA;
    }

    public void setPassedYear(Date PassedYear) {
        this.PassedYear = PassedYear;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setBoard_id(int Board_id) {
        this.Board_id = Board_id;
    }

    public void setFaculty_id(int Faculty_id) {
        this.Faculty_id = Faculty_id;
    }

    public void setUniversity_id(int University_id) {
        this.University_id = University_id;
    }

    public void setRegistration_id(int Registration_id) {
        this.Registration_id = Registration_id;
    }

    public void setFileName(String FileName) {
        this.FileName = FileName;
    }

    public void setFilePath(String FilePath) {
        this.FilePath = FilePath;
    }

    public void setLevelName(String LevelName) {
        this.LevelName = LevelName;
    }

    public void setBoardName(String BoardName) {
        this.BoardName = BoardName;
    }

    public void setFacultyName(String FacultyName) {
        this.FacultyName = FacultyName;
    }

    public void setUniversityName(String UniversityName) {
        this.UniversityName = UniversityName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }
}
