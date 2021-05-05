package com.tms.dao;

import com.tms.db.DBConnection;
import com.tms.model.Address;
import com.tms.model.Attendance;
import com.tms.model.Registration;

import javax.servlet.ServletException;
import java.io.IOException;
import java.net.IDN;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {
    private static final String INSERT_ATTENDANCE_SQL = "INSERT INTO tbl_attendance" + "(Registration_id,AttendDate,Check_IN,Check_OUT,Comment) VALUES" + "(?,?,?,?,?);";
    private static final String SELECT_ATTENDANCE_BY_ID = "select Attendance_id,Registration_id,AttendDate,Check_IN,Check_OUT,TotalPresentDate,TotalAbsentDate,User_id,Comment from tbl_attendance where Attendance_id=?";
    private static final String SELECT_ALL_ATTENDANCE = "SELECT University_id, UniversityName from tbl_university";
    private static final String DELETE_ATTENDANCE_SQL = "delete from tbl_attendance where Attendance_id=?;";
    private static final String UPDATE_ATTENDANCE_SQL = "update tbl_attendance set Registration_id=?,AttendDate=?,Check_IN=?,Check_OUT=?,TotalPresentDate=?,TotalAbsentDate=?,User_id=?,Comment=? where Attendance_id=?;";


    public List<Registration> droplistName()throws IOException {
        List<Registration> listNameDrop=new ArrayList<Registration>();
        try{
            String query="";
            Connection conn= DBConnection.createConnection();
            query=("select Registration_id,concat(PersonalIDNumber,' - ',FirstName,' ',MiddleName,' ',LastName)as FirstName  from tbl_registration");
            PreparedStatement ps = conn.prepareStatement(query);
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int Registration_id=rs.getInt("Registration_id");
                String FirstName=rs.getString("FirstName");
                Registration FirstNamelist=new Registration(Registration_id,FirstName);
                listNameDrop.add(FirstNamelist);
            }
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return listNameDrop;
    }


    public static boolean insertAttendance(Attendance attendance)throws IOException, ServletException {
        boolean scope_attendance=false;
        try{
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(INSERT_ATTENDANCE_SQL);
            ps.setInt(1,attendance.getRegistration_id());
            ps.setDate(2, (Date) attendance.getAttendDate());
            ps.setTimestamp(3,new Timestamp(attendance.getCheck_IN().getTime()));
            ps.setTimestamp(4,new Timestamp(attendance.getCheck_OUT().getTime()));
            ps.setString(5,attendance.getComment());
            scope_attendance=ps.executeUpdate()>0;
        }catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
        return scope_attendance;
    }

    public static List<Attendance> selectAllAttendance(String searchAttendance)throws IOException,ClassNotFoundException {
        List<Attendance> attendance=new ArrayList<Attendance>();
        try{
            Connection conn=DBConnection.createConnection();
            Statement st=null;
            st=conn.createStatement();
            ResultSet rs=null;
            String query=null;
            if(searchAttendance != null)
            {
                query="select Attendance_id,concat(PersonalIDNumber,' - ',FirstName,' ',MiddleName,' ',LastName)as FirstName, AttendDate,Check_IN,Check_OUT,Comment\n" +
                        "from tbl_attendance\n" +
                        "inner join tbl_registration using (Registration_id)" +
                        "where FirstName like'%"+searchAttendance+"%'";
            }
            else
            {
                query="select Attendance_id,concat(PersonalIDNumber,' - ',FirstName,' ',MiddleName,' ',LastName)as FirstName, AttendDate,Check_IN,Check_OUT,Comment\n" +
                        "from tbl_attendance\n" +
                        "inner join tbl_registration using (Registration_id)\n" +
                        "order by Attendance_id";

            }
            System.out.println(st);
            rs=st.executeQuery(query);
            while (rs.next()){
                int Attendance_id=rs.getInt("Attendance_id");
                String FirstName=rs.getString("FirstName");
                Date AttendDate=rs.getDate("AttendDate");
                Time Check_IN=rs.getTime("Check_IN");
                Time Check_OUT=rs.getTime("Check_OUT");
                String Comment=rs.getString("Comment");
                attendance.add(new Attendance(Attendance_id,FirstName,AttendDate,Check_IN,Check_OUT,Comment));
            }
        }catch (SQLException e){e.printStackTrace();}
        return attendance;
    }
}
