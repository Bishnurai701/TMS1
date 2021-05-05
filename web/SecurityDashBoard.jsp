<%--
  Created by IntelliJ IDEA.
  User: Server
  Date: 23-05-2020
  Time: 5:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Security DashBoard</title>
    <style type="text/css">
        <%@include file="bootstrap/css/bootstrap.css" %>
        <%@include file="bootstrap/css/bootstrap.min.css" %>
        <%@include file="bootstrap/css/hover-min.css" %>
        <%@include file="bootstrap/css/stylesheet.css" %>
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


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"/>


    <script src="https://cdn.ckeditor.com/4.14.0/standard/ckeditor.js"/>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js" />
    <script type="text/javascript" src="bootstrap/js/sweetalert.min.js"/>
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
            <a class="navbar-brand" href="index.jsp"><span class="glyphicon glyphicon-home"></span> TMS<small> | Time Management System</small></a>
        </div>


        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="#"> Dashboard</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><i class="fas fa-power-off"></i> Logout</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-cog"></span> Settings</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-bell"></span>  Profile</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-question-sign"></span>  Help</a></li>
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
                <li class="active"><a href="index.jsp" class="main-color-bg"> <span class="glyphicon glyphicon-th-large"></span> Dashbaord <span class="sr-only">(current)</span></a></li>
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
                <li><a href="">Another nav item</a></li>
            </ul>
        </div>



        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 mainsecurity">
            <div class="row">
                <div class="col-md-4 col-xs-4">
                    <div class="page-heading">
                        <h3 style="color:#0269A4">
                            <span class="glyphicon glyphicon-cog"></span> &nbsp; Security Dashboard
                        </h3>
                    </div>
                </div>
                <div class="col-md-8">
                    <ul class="breadcrumb breadcrumb-modified pull-right" style="background-color: transparent;">
                        <li><a href="index.jsp">Home</a> <span class="divider"></span></li>
                        <li><a href="ConfigurationDashBoard.jsp">Configuration</a> <span class="divider"></span></li>
                        <li class="active"><a href="SecurityDashBoard.jsp">Security</a> <span class="divider"></span></li>

                    </ul>
                </div>
            </div>


            <div class="row-fluid">
                <hr class="hline" />
            </div>

            <div class="row placeholders">
                <div class="col-xs-6 col-sm-3 hvr-hang">
                    <a href="<%=request.getContextPath()%>/list_user">
                        <div class="well dash-box">
                            <h3> <span class="glyphicon glyphicon-user"></span> </h3>
                            <h4>User</h4>
                        </div>
                    </a>
                    <h4>User List</h4>
                    <span class="text-muted">Display User List</span>
                </div>

                <div class="col-xs-6 col-sm-3 hvr-hang">
                    <div class="well dash-box">
                        <a href="<%=request.getContextPath()%>/listgroup">
                            <h3> <i class="fas fa-user-tag"></i> </h3>
                            <h4>Group</h4>
                        </a>
                    </div>
                    <h4>UserGroup List</h4>
                    <span class="text-muted">Display User Group List</span>
                </div>

                <div class="col-xs-6 col-sm-3 hvr-hang">
                    <div class="well dash-box">
                        <a href="<%=request.getContextPath()%>/listroll">
                            <h3> <i class="fas fa-user-cog"></i> </h3>
                            <h4>Roll</h4>
                        </a>
                    </div>
                    <h4>UserRoll List</h4>
                    <span class="text-muted">Display User Roll</span>
                </div>

                <div class="col-xs-6 col-sm-3 hvr-hang">
                    <div class="well dash-box">
                        <a href="">
                            <h3> <i class="fas fa-user-cog"></i> </h3>
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
                        <a href="">
                            <h3> <span class="glyphicon glyphicon-user"></span> </h3>
                            <h4>Attendance</h4>
                        </a>
                    </div>
                    <h4>Attendance</h4>
                    <span class="text-muted">Daily Attendance</span>
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
                            <h4>Security</h4>
                        </a>
                    </div>
                    <h4>Admin</h4>
                    <span class="text-muted">Security Dashboard</span>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
