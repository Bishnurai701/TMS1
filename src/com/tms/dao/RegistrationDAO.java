package com.tms.dao;

import com.tms.db.DBConnection;
import com.tms.model.*;


import java.io.DataInput;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegistrationDAO {
    /* for tbl_registration*/
    private static final String INSERT_REGISTRATION_SQL = "INSERT INTO tbl_registration" + "(RegistrationDate, FirstName,MiddleName, LastName, MothersName,FathersName,DOB,Gender, Email,MobileNo,LandLine,PersonalIDNumber,Post_id,Section_id,Department_id,PhotoName,PhotoPath) VALUES" + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_REGISTRATION_BY_ID = "select Registration_id,RegistrationDate, FirstName, MiddleName, LastName, MothersName,fathersName,DOB,Gender,Email,MobileNo,LandLine,PersonalIDNumber,Post_id,Section_id,Department_id  from tbl_registration where Registration_id=?";
    private static final String SELECT_ALL_REGISTRATION = "SELECT Board_id, BoardName from tbl_board";
    private static final String DELETE_REGISTRATION_SQL = "delete from tbl_registration where Registration_id=?;";
    private static final String UPDATE_REGISTRATION_SQL = "update tbl_registration set RegistrationDate=?,FirstName=?,MiddleName=?,LastName=?,MothersName=?,FathersName=?,DOB=?,Gender=?,Email=?,MobileNo=?,LandLine=?,PersonalIDNumber=?,Post_id=?,Section_id=?,Department_id=? where Registration_id=?;";

    /*Create or insert Item:By BR Khaling*/
    public static boolean insertRegistration(Registration registration) throws SQLException {
        boolean scop_registration = false;
        try {
            Connection conn = DBConnection.createConnection();
            PreparedStatement ps = conn.prepareStatement(INSERT_REGISTRATION_SQL);
            ps.setDate(1, (Date) registration.getRegistrationDate());
            ps.setString(2,registration.getFirstName());
            ps.setString(3,registration.getMiddleName());
            ps.setString(4,registration.getLastName());
            ps.setString(5,registration.getMothersName());
            ps.setString(6,registration.getFathersName());
            ps.setDate(7, (Date) registration.getDOB());
            ps.setString(8,registration.getGender());
            ps.setString(9,registration.getEmail());
            ps.setString(10,registration.getMobileNo());
            ps.setString(11,registration.getLandLine());
            ps.setInt(12,registration.getPersonalIDNumber());
            ps.setInt(13,registration.getPost_id());
            ps.setInt(14,registration.getSection_id());
            ps.setInt(15,registration.getDepartment_id());
            ps.setString(16,registration.getPhotoName());
            ps.setString(17,registration.getPhotoPath());
            scop_registration=ps.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return scop_registration;
    }


    public static boolean existRegistration(int personalIDNumber,String email, String mobileNo, String landLine) throws SQLException {
        boolean Count_registration = false;
        try {
            Connection conn = DBConnection.createConnection();
            Statement st = null;
            st = conn.createStatement();
            ResultSet rs = null;
            String existquery = "select *from tbl_registration where PersonalIDNumber='" + personalIDNumber + "' or Email='" + email + "' or MobileNo='"+mobileNo+"' or LandLine='"+landLine+"'";
            rs = st.executeQuery(existquery);
            rs.next();
            Count_registration = rs.getBoolean(1);
            System.out.println(Count_registration);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Count_registration;
    }


    public List<Post> droplistPostName() throws SQLException, IOException {
        List<Post> listPostDrop = new ArrayList<Post>();
        try {
            Connection conn = DBConnection.createConnection();
            PreparedStatement ps = conn.prepareStatement("select Post_id,PostName from tbl_post");
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int Post_id = rs.getInt("Post_id");
                String PostName = rs.getString("PostName");
                Post postlist = new Post(Post_id, PostName);
                listPostDrop.add(postlist);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listPostDrop;
    }

    public List<Section> droplistSectionName() throws IOException, ClassNotFoundException {
        List<Section> listSectionDrop = new ArrayList<Section>();
        try {
            Connection conn = DBConnection.createConnection();
            PreparedStatement ps = conn.prepareStatement("select Section_id,SectionName from tbl_section");
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int Section_id = rs.getInt("Section_id");
                String SectionName = rs.getString("SectionName");
                Section sectionlist = new Section(Section_id, SectionName);
                listSectionDrop.add(sectionlist);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSectionDrop;
    }

    public List<Department> droplistDepartmentName() throws SQLException, IOException, ClassNotFoundException {
        List<Department> listDepartmentDrop = new ArrayList<Department>();
        try {
            Connection conn = DBConnection.createConnection();
            PreparedStatement ps = conn.prepareStatement("select Department_id,DepartmentName from tbl_department");
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int Department_id = rs.getInt("Department_id");
                String DepartmentName = rs.getString("DepartmentName");
                Department departmentlist = new Department(Department_id, DepartmentName);
                listDepartmentDrop.add(departmentlist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDepartmentDrop;
    }




    public List<Board> droplistBoardName() throws SQLException {
        List<Board> listBoardDrop = new ArrayList<Board>();
        try {
            Connection conn = DBConnection.createConnection();
            PreparedStatement ps = conn.prepareStatement("select Board_id,BoardName from tbl_board");
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int Board_id = rs.getInt("Board_id");
                String BoardName = rs.getString("BoardName");
                Board boardlist = new Board(Board_id, BoardName);
                listBoardDrop.add(boardlist);

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listBoardDrop;
    }


    public List<Faculty> droplistFacultyName()throws SQLException {
        List<Faculty> listFacultyDrop = new ArrayList<Faculty>();
        try {
            Connection conn = DBConnection.createConnection();
            PreparedStatement ps = conn.prepareStatement("select Faculty_id,FacultyName from tbl_faculty");
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int Faculty_id = rs.getInt("Faculty_id");
                String FacultyName = rs.getString("FacultyName");
                Faculty facultylist = new Faculty(Faculty_id, FacultyName);
                listFacultyDrop.add(facultylist);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listFacultyDrop;
    }


    public List<University> droplistUniversityName() {
        List<University> listUniversityDrop=new ArrayList<University>();
        try {
            Connection conn = DBConnection.createConnection();
            PreparedStatement ps = conn.prepareStatement("select University_id,UniversityName from tbl_university");
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int University_id = rs.getInt("University_id");
                String UniversityName = rs.getString("UniversityName");
                University universitylist = new University(University_id, UniversityName);
                listUniversityDrop.add(universitylist);
            }

        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return listUniversityDrop;
    }

    public List<Registration> selectAllRegistrations(String SearchPerson) {
        List<Registration> registrations=new ArrayList<Registration>();
        try {
            Connection conn=DBConnection.createConnection();
            Statement st=null;
            st=conn.createStatement();
            ResultSet rs=null;
            String query=null;
            if(SearchPerson != null){
                query="select Registration_id, RegistrationDate,concat(FirstName,' ',MiddleName,' ',LastName)as FirstName,Gender, DOB,\n" +
                        "PersonalIDNumber,PostName, SectionName, DepartmentName, Email,MobileNo\n" +
                        "from tbl_registration\n" +
                        "inner join tbl_post using (Post_id)\n" +
                        "inner join tbl_section using (Section_id)\n" +
                        "inner join tbl_department using (Department_id)" +
                        "where FirstName like '%"+ SearchPerson +"%' or Email like '%"+ SearchPerson +"%' or PersonalIDNumber like '%"+ SearchPerson +"%' or MobileNo like '%"+ SearchPerson +"%' or PostName like '%"+ SearchPerson +"%' or SectionName like '%"+ SearchPerson +"%' or DepartmentName like '%"+ SearchPerson +"%'";
            }
            else {
                query="select Registration_id, RegistrationDate,concat(FirstName,' ',MiddleName,' ',LastName)as FirstName,Gender, DOB,\n" +
                        "PersonalIDNumber,PostName, SectionName, DepartmentName, Email,MobileNo\n" +
                        "from tbl_registration\n" +
                        "inner join tbl_post using (Post_id)\n" +
                        "inner join tbl_section using (Section_id)\n" +
                        "inner join tbl_department using (Department_id)";
            }
            System.out.println(st);
            rs=st.executeQuery(query);
            while (rs.next()){
                int Registration_id=rs.getInt("Registration_id");
                Date RegistrationDate=rs.getDate("RegistrationDate");
                String FirstName=rs.getString("FirstName");
                //String MiddleName=rs.getString("MiddleName");
                //String LastName=rs.getString("LastName");
                String Gender=rs.getString("Gender");
                Date DOB=rs.getDate("DOB");
                int PersonalIDNumber=rs.getInt("PersonalIDNumber");
                String PostName=rs.getString("PostName");
                String SectionName=rs.getString("SectionName");
                String DepartmentName=rs.getString("DepartmentName");
                String Email=rs.getString("Email");
                String MobileNo=rs.getString("MobileNo");
                registrations.add(new Registration(Registration_id,RegistrationDate,FirstName,Gender,DOB,PersonalIDNumber,PostName,SectionName,DepartmentName,Email,MobileNo));
            }

        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return registrations;
    }

    public boolean deleteRegistration(int Registration_id)throws IOException,ClassNotFoundException {
        boolean delete_registration=false;
        try {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(DELETE_REGISTRATION_SQL);
            ps.setInt(1,Registration_id);
            delete_registration=ps.executeUpdate()>0;
        }catch (SQLException e){e.printStackTrace();}
        return delete_registration;
    }

    public Registration selectRegistrationById(int Registration_id)throws IOException,ClassNotFoundException {
        Registration registration=null;
        try {
           Connection conn=DBConnection.createConnection();
           PreparedStatement ps=conn.prepareStatement(SELECT_REGISTRATION_BY_ID);
           ps.setInt(1,Registration_id);
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Date RegistrationDate=rs.getDate("RegistrationDate");
                String FirstName=rs.getString("FirstName");
                String MiddleName=rs.getString("MiddleName");
                String LastName=rs.getString("LastName");
                String MothersName=rs.getString("MothersName");
                String FathersName=rs.getString("FathersName");
                Date DOB=rs.getDate("DOB");
                String Gender=rs.getString("Gender");
                String Email=rs.getString("Email");
                String MobileNo=rs.getString("MobileNo");
                String LandLine=rs.getString("LandLine");
                int PersonalIDNumber=rs.getInt("PersonalIDNumber");
                int Post_id=rs.getInt("Post_id");
                int Section_id=rs.getInt("Section_id");
                int Department_id=rs.getInt("Department_id");
                registration=new Registration(Registration_id,RegistrationDate,FirstName,MiddleName,LastName,MothersName,FathersName,DOB,Gender,Email,MobileNo,LandLine,PersonalIDNumber,Post_id,Section_id,Department_id);
            }

        }catch (SQLException e){e.printStackTrace();}
        return registration;
    }

    public boolean updateRegistration(Registration registration)throws IOException,ClassNotFoundException {
        boolean update_registration=false;
        try {
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(UPDATE_REGISTRATION_SQL);
            ps.setDate(1, (Date) registration.getRegistrationDate());
            ps.setString(2,registration.getFirstName());
            ps.setString(3,registration.getMiddleName());
            ps.setString(4,registration.getLastName());
            ps.setString(5,registration.getMothersName());
            ps.setString(6,registration.getFathersName());
            ps.setDate(7, (Date) registration.getDOB());
            ps.setString(8,registration.getGender());
            ps.setString(9,registration.getEmail());
            ps.setString(10,registration.getMobileNo());
            ps.setString(11,registration.getLandLine());
            ps.setInt(12,registration.getPersonalIDNumber());
            ps.setInt(13,registration.getPost_id());
            ps.setInt(14,registration.getSection_id());
            ps.setInt(15,registration.getDepartment_id());
            ps.setInt(16,registration.getRegistration_id());
            update_registration=ps.executeUpdate()>0;
        }catch (SQLException e){e.printStackTrace();}
        return update_registration;
    }
}
