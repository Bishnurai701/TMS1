<%--
  Created by IntelliJ IDEA.
  User: Server
  Date: 23-04-2020
  Time: 8:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
  <head>
      <meta name="viewport" content="width=device-width, initial-scale=1" http-equiv="content-type">
    <title>Admin | TMS Dashboard</title>

      <style type="text/css">
          <%@include file="bootstrap/css/bootstrap.min.css" %>
          <%@include file="bootstrap/css/hover-min.css" %>
          <%@include file="bootstrap/css/stylesheet.css" %>
          <%@include file="fontawesome/css/fontawesome.min.css" %>
      </style>

    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="bootstrap/css/stylesheet.css" />
    <link rel="stylesheet" type="text/css" href="bootstrap/css/hover.css" />
    <link rel="stylesheet" type="text/css" href="Hover-master/css/hover-min.css" />
    <link rel="stylesheet" type="text/css" href="bootstrap/css/sweetalert.css" />
    <link rel="stylesheet" type="text/css" href="fontawesome/css/fontawesome.css" />
    <link rel="stylesheet" type="text/css" href="fontawesome/css/fontawesome.min.css" />
    <link rel="stylesheet" type="text/css" href="fontawesome/css/all.css" />
    <link rel="stylesheet" type="text/css" href="fontawesome/css/all.min.css" />
    <link rel="stylesheet" type="text/css" href="fontawesome/css/svg-with-js.css" />
    <link rel="stylesheet" type="text/css" href="fontawesome/css/svg-with-js.min.css" />


    <script src="fontawesome/js/fontawesome.min.js" type="text/javascript"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.ckeditor.com/4.14.0/standard/ckeditor.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/sweetalert.min.js"></script>

    <script>
      CKEDITOR.replace( 'editor1' );
    </script>

    <script>
      $('#myDropdown').on('show.bs.dropdown', function () {
        $('.dropdown-toggle').dropdown()
      })
    </script>


  </head>

  <body>
  <nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="index.jsp">&nbsp; &nbsp;&nbsp; <i class="fab fa-renren"></i>&nbsp;TMS<small> | Time Management System</small></a>
      </div>


      <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
          <li><a href="#"> Dashboard</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <li><a href="login.jsp"><i class="fas fa-power-off"></i> Logout</a></li>
          <li><a href="#"><span class="glyphicon glyphicon-cog"/> Settings</a></li>
          <li><a href="#"><span class="glyphicon glyphicon-bell"/>  Profile</a></li>
          <li><a href="#"><span class="glyphicon glyphicon-question-sign"/>  Help</a></li>
        </ul>
        <form class="navbar-form navbar-right" id="search">
          <input type="text" class="form-control" placeholder="Search...">
        </form>
      </div>
    </div>
  </nav><!--Header part-->

  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-3 col-md-2 sidebar">
        <ul class="nav nav-sidebar">
          <li class="active"><a href="index.jsp" class="main-color-bg"> <i class="fa fa-home"></i> Dashbaord <span class="sr-only">(current)</span></a></li>
          <li> <a href="StaffDashboard.jsp"><span class="glyphicon glyphicon-list-alt"></span>  Attendance</a></li>
          <li><a href="SalaryDashboard.jsp"> <span class="glyphicon glyphicon-file"></span>  Salary</a></li>
          <li><a href="userform.jsp"> <span class="glyphicon glyphicon-paperclip"></span>  Admin</a></li>
          <li><a href="userform.jsp"> <span class="glyphicon glyphicon-paperclip"></span>  Report</a></li>
        </ul>
        <ul class="nav nav-sidebar">
          <li><a href="">Nav item</a></li>
          <li><a href="">Nav item again</a></li>
          <li><a href="">One more nav</a></li>
          <li><a href="">Another nav item</a></li>
          <li><a href="">More navigation</a></li>
        </ul>
        <ul class="nav nav-sidebar">
          <li><a href="">Nav item again</a></li>
          <li><a href="">One more nav</a></li>
          <li><a href="ConfigurationDashBoard.jsp"> <span class="glyphicon glyphicon-cog"> Configuration </span></a></li>
        </ul>
      </div>



      <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        <%
          String message = null;
          String loginname=null;
          String sessionID = null;
          Cookie[] cookies = request.getCookies();
          if(cookies != null){
            for(Cookie cookie : cookies){
              if(cookie.getName().equals("message")) message = cookie.getValue();
              if(cookie.getName().equals("loginname"))loginname=cookie.getValue();
              if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
            }
          }
        %>
        <h4 class="page-header" style="color: #0269A4"> <i class="fas fa-th"></i>  Welcome Admin Dashboard | <%=message%>  <%=loginname%></h4>



        <div class="row placeholders">
          <div class="col-xs-6 col-sm-3 hvr-hang" >
              <div class="well dash-box">
                <a href="<%=request.getContextPath()%>/new_attendance">
                  <h3> <span class="glyphicon glyphicon-list-alt"></span> </h3>
                  <h4>Attendance</h4>
                </a>
              </div>

              <h4>Staff Attendance</h4>
              <span class="text-muted">Daily Staff Attendance</span>
          </div>

          <div class="col-xs-6 col-sm-3 hvr-hang">
            <div class="well dash-box">
              <a href="SalaryDashboard.jsp">
                <h3> <span class="glyphicon glyphicon-file"></span> </h3>
                <h4>Salary</h4>
              </a>
            </div>
            <h4>Monthly Salary</h4>
            <span class="text-muted">Monthly Salary Sheet</span>
          </div>
          <div class="col-xs-6 col-sm-3 hvr-hang">
            <div class="well dash-box">
              <a href="">
                <h3> <span class="glyphicon glyphicon-user"></span> </h3>
                <h4>Reports</h4>
              </a>
            </div>
            <h4>All Reports</h4>
            <span class="text-muted">All Reports Daily/Monthly</span>
          </div>
          <div class="col-xs-6 col-sm-3 hvr-hang">
            <div class="well dash-box">
              <a href="">
                <h3> <span class="glyphicon glyphicon-user"></span> </h3>
                <h4>Admin</h4>
              </a>
            </div>
            <h4>Admin Details</h4>
            <span class="text-muted">Admin Detail Entry</span>
          </div>
        </div>
        <hr><br>

        <!--Second line icons-->
        <div class="row placeholders">
          <div class="col-xs-6 col-sm-3 hvr-hang">
            <div class="well dash-box">
              <a href="<%=request.getContextPath()%>/list_registration">
                <h3> <span class="glyphicon glyphicon-user"></span> </h3>
                <h4>Registration</h4>
              </a>
            </div>
            <h4>Registration List</h4>
            <span class="text-muted">Registration Detail List</span>
          </div>
          <div class="col-xs-6 col-sm-3 hvr-hang">
            <div class="well dash-box">
              <a href="">
                <h3> <span class="glyphicon glyphicon-user"></span> </h3>
                <h4>Salary</h4>
              </a>
            </div>
            <h4>Monthly Salary</h4>
            <span class="text-muted">Monthly Salary Sheet</span>
          </div>
          <div class="col-xs-6 col-sm-3 hvr-hang">
            <div class="well dash-box">
              <a href="RegistrationDhashBoard.jsp">
                <h3> <span class="glyphicon glyphicon-user"></span> </h3>
                <h4>Registration</h4>
              </a>
            </div>
            <h4>Admin</h4>
            <span class="text-muted">Registration DashBoard</span>
          </div>
          <div class="col-xs-6 col-sm-3 hvr-hang">
            <div class="well dash-box">
              <a href="ConfigurationDashBoard.jsp">
                <h3> <span class="glyphicon glyphicon-cog"></span> </h3>
                <h4>Configuration</h4>
              </a>
            </div>
            <h4>Admin</h4>
            <span class="text-muted">Configuration</span>
          </div>
        </div>

        <hr><br>





        <h2 class="sub-header">Section title</h2>
        <div class="table-responsive">
          <table class="table table-striped">
            <thead>
            <tr>
              <th>#</th>
              <th>Header</th>
              <th>Header</th>
              <th>Header</th>
              <th>Header</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>1,001</td>
              <td>Lorem</td>
              <td>ipsum</td>
              <td>dolor</td>
              <td>sit</td>
            </tr>
            <tr>
              <td>1,001</td>
              <td>Lorem</td>
              <td>ipsum</td>
              <td>dolor</td>
              <td>sit</td>
            </tr>

            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
  </body>
</html>
