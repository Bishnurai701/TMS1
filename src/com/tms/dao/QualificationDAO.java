package com.tms.dao;

import com.tms.db.DBConnection;
import com.tms.model.*;


import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QualificationDAO {
    private static final String INSERT_QUALIFICATION_SQL = "INSERT INTO tbl_qualification" + "(Level_id,InstituteName,PercentOrGPA,PassedYear,Address,Board_id,Faculty_id,University_id,Registration_id,FilePath,FileName) VALUES" + "(?,?,?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_QUALIFICATION_BY_ID = "select Qualification_id,level_id,InstituteName,PercentOrGPA,PassedYear, Address,Board_id,Faculty_id,University_id,Registration_id,FilePath,FileName from tbl_qualification where Qualification_id=?";
    private static final String SELECT_ALL_QUALIFICATION = "SELECT University_id, UniversityName from tbl_university";
    private static final String DELETE_QUALIFICATION_SQL = "delete from tbl_qualification where Qualification_id=?;";
    private static final String UPDATE_QUALIFICATION_SQL = "update tbl_qualification set Level_id=?,InstituteName=?,PercentOrGPA=?,PassedYear=?,Address=?,Board_id=?,Faculty_id=?,University_id=?,Registration_id=?,FilePath=?,FileName=? where Qualification_id=?;";


    public static boolean insertQualification(Qualification qualification) throws IOException,ClassNotFoundException {
        boolean scope_qualification=false;
        try{
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(INSERT_QUALIFICATION_SQL);
            ps.setInt(1,qualification.getLevel_id());
            ps.setString(2,qualification.getInstituteName());
            ps.setString(3,qualification.getPercentOrGPA());
            ps.setDate(4, (Date) qualification.getPassedYear());
            ps.setString(5,qualification.getAddress());
            ps.setInt(6,qualification.getBoard_id());
            ps.setInt(7,qualification.getFaculty_id());
            ps.setInt(8,qualification.getUniversity_id());
            ps.setInt(9,qualification.getRegistration_id());
            ps.setString(10,qualification.getFilePath());
            ps.setString(11,qualification.getFileName());
             scope_qualification=ps.executeUpdate()>0;

        }catch (SQLException e){e.printStackTrace();}
        return scope_qualification;
    }

    public List<Registration> droplistFirstName()throws IOException {
        List<Registration> listRegistrationDrop = new ArrayList<Registration>();
        try
        {
            Connection conn= DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement("select Registration_id,concat(FirstName,' ',MiddleName,' ',LastName) as FirstName from tbl_registration");
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int Registration_id=rs.getInt("Registration_id");
                String FirstName=rs.getString("FirstName");
                Registration firstNamelist=new Registration(Registration_id,FirstName);
                listRegistrationDrop.add(firstNamelist);
            }
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return listRegistrationDrop;
    }

    public List<Level> droplistLevelName()throws IOException {
        List<Level> listLevelDrop=new ArrayList<Level>();
        try{
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement("select Level_id,LevelName from tbl_level");
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int Level_id=rs.getInt("Level_id");
                String LevelName=rs.getString("LevelName");
                Level LevelNamelist=new Level(Level_id,LevelName);
                listLevelDrop.add(LevelNamelist);
            }
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return listLevelDrop;
    }

    public List<Board> droplistBoardName()throws IOException,ClassNotFoundException {
        List<Board> listBoardDrop=new ArrayList<Board>();
        try{
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement("select Board_id,BoardName from tbl_board");
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int Board_id=rs.getInt("Board_id");
                String BoardName=rs.getString("BoardName");
                Board BoardNamelist=new Board(Board_id,BoardName);
                listBoardDrop.add(BoardNamelist);
            }

        }catch (SQLException e){e.printStackTrace();}
        return listBoardDrop;
    }

    public List<Faculty> droplistFacultyName()throws IOException,ClassNotFoundException {
        List<Faculty> listFacultyDrop=new ArrayList<Faculty>();
        try{
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement("select Faculty_id, FacultyName from tbl_faculty");
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
            while (rs.next())
            {
                int Faculty_id=rs.getInt("Faculty_id");
                String FacultyName=rs.getString("FacultyName");
                Faculty FacultyNamelist=new Faculty(Faculty_id,FacultyName);
                listFacultyDrop.add(FacultyNamelist);
            }
        }catch (SQLException e){e.printStackTrace();}
        return listFacultyDrop;
    }

    public List<University> droplistUniversityName()throws IOException,ClassNotFoundException {
        List<University> listUniversityDrop=new ArrayList<University>();
        try{
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement("select University_id, UniversityName from tbl_university");
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int University_id=rs.getInt("University_id");
                String UniversityName=rs.getString("UniversityName");
                University UniversityNamelist=new University(University_id,UniversityName);
                listUniversityDrop.add(UniversityNamelist);
            }
        }catch (SQLException e){e.printStackTrace();}
        return listUniversityDrop;
    }

    public boolean deleteQualification(int Qualification_id)throws IOException,ClassNotFoundException {
        boolean delete_qualification=false;
        try{
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(DELETE_QUALIFICATION_SQL);
            ps.setInt(1,Qualification_id);
            delete_qualification=ps.executeUpdate()>0;
        }catch (SQLException e){e.printStackTrace();}
        return delete_qualification;
    }

    public List<Qualification> selectAllQualifications(String SearchQualification)throws IOException,ClassNotFoundException {
        List<Qualification> qualification=new ArrayList<Qualification>();
        try{
            Connection conn=DBConnection.createConnection();
            Statement st=null;
            st=conn.createStatement();
            ResultSet rs=null;
            String query=null;
            if(SearchQualification != null){
                query="select Qualification_id, concat(FirstName,' ',MiddleName,' ',LastName)as FirstName,LevelName,InstituteName,PercentOrGPA,PassedYear,Address,BoardName,FacultyName,UniversityName\n" +
                        "from tbl_qualification\n" +
                        "inner join tbl_registration using(Registration_id)\n" +
                        "inner join tbl_level using(Level_id)\n" +
                        "inner join tbl_board using(Board_id)\n" +
                        "inner join tbl_faculty using(Faculty_id)\n" +
                        "inner join tbl_university using(University_id)" +
                        "where FirstName like '%"+SearchQualification+"%' or LevelName like '%"+SearchQualification+"%' or InstituteName like '%"+SearchQualification+"%' or BoardName like '%"+SearchQualification+"%' or FacultyName like '%"+SearchQualification+"%' or UniversityName like '%"+SearchQualification+"%'";
            }
            else
            {
                query="select Qualification_id, concat(FirstName,' ',MiddleName,' ',LastName)as FirstName,LevelName,InstituteName,PercentOrGPA,PassedYear,Address,BoardName,FacultyName,UniversityName\n" +
                        "from tbl_qualification\n" +
                        "inner join tbl_registration using(Registration_id)\n" +
                        "inner join tbl_level using(Level_id)\n" +
                        "inner join tbl_board using(Board_id)\n" +
                        "inner join tbl_faculty using(Faculty_id)\n" +
                        "inner join tbl_university using(University_id)";
            }
            System.out.println(st);
            rs=st.executeQuery(query);
            while (rs.next()){
                int Qualification_id=rs.getInt("Qualification_id");
                String LevelName=rs.getString("LevelName");
                String InstituteName=rs.getString("InstituteName");
                String PercentOrGPA=rs.getString("PercentOrGPA");
                Date PassedYear=rs.getDate("PassedYear");
                String Address=rs.getString("Address");
                String BoardName=rs.getString("BoardName");
                String FacultyName=rs.getString("FacultyName");
                String UniversityName=rs.getString("UniversityName");
                String FirstName=rs.getString("FirstName");
                qualification.add(new Qualification(Qualification_id,LevelName,InstituteName,PercentOrGPA,PassedYear,Address,BoardName,FacultyName,UniversityName,FirstName));
            }
        }catch (SQLException e){e.printStackTrace();}
        return qualification;
    }

    public Qualification selectQualificationById(int Qualification_id)throws IOException,ClassNotFoundException {
        Qualification qualification=null;
        try{
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(SELECT_QUALIFICATION_BY_ID);
            ps.setInt(1,Qualification_id);
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
              int Level_id=rs.getInt("Level_id");
              String InstituteName=rs.getString("InstituteName");
              String PercentOrGPA=rs.getString("PercentOrGPA");
              Date PassedYear=rs.getDate("PassedYear");
              String Address=rs.getString("Address");
              int Board_id=rs.getInt("Board_id");
              int Faculty_id=rs.getInt("Faculty_id");
              int University_id=rs.getInt("University_id");
              int Registration_id=rs.getInt("Registration_id");
              String FilePath=rs.getString("FilePath");
              String FileName=rs.getString("FileName");
              qualification=new Qualification(Qualification_id,Level_id,InstituteName,PercentOrGPA,PassedYear, Address,Board_id,Faculty_id,University_id,Registration_id,FilePath,FileName);
            }
        }catch (SQLException e){e.printStackTrace();}
        return qualification;
    }

    public boolean updateQualification(Qualification qualification)throws IOException,ClassNotFoundException {
        boolean update_qualification=false;
        try{
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(UPDATE_QUALIFICATION_SQL);
            ps.setInt(1,qualification.getLevel_id());
            ps.setString(2,qualification.getInstituteName());
            ps.setString(3,qualification.getPercentOrGPA());
            ps.setDate(4, (Date) qualification.getPassedYear());
            ps.setString(5,qualification.getAddress());
            ps.setInt(6,qualification.getBoard_id());
            ps.setInt(7,qualification.getFaculty_id());
            ps.setInt(8,qualification.getUniversity_id());
            ps.setInt(9,qualification.getRegistration_id());
            ps.setString(10,qualification.getFilePath());
            ps.setString(11,qualification.getFileName());
            ps.setInt(12,qualification.getQualification_id());
            update_qualification=ps.executeUpdate()>0;

        }catch (SQLException e){e.printStackTrace();}
        return update_qualification;
    }
}
