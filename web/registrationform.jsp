<%--
  Created by IntelliJ IDEA.
  User: Server
  Date: 06-06-2020
  Time: 3:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.tms.db.DBConnection"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin | TMS Registration</title>
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
                <li><a href="#"><span class="glyphicon glyphicon-user"></span>  Profile</a></li>
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
                <li><a href="index.jsp" class="main-color-bg"> <span class="glyphicon glyphicon-th-large"></span> Dashbaord <span class="sr-only">(current)</span></a></li>
                <li><a href="userlist.jsp"> <span class="glyphicon glyphicon-paperclip"></span>  View Users</a></li>
                <li><a href="viewusers.jsp"> <span class="glyphicon glyphicon-paperclip"></span>  View Users</a></li>
                <li><a href="#"> <span class="glyphicon glyphicon-paperclip"></span>  Export</a></li>
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
        </div><!--Sidebar end-->

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <div class="row">
                <div class="col-md-4 col-xs-4">
                    <div class="page-heading">
                        <h3 style="color:#0269A4">
                            <span class="glyphicon glyphicon-user"></span> &nbsp; Admin / New Registration
                        </h3>
                    </div>
                </div>
                <div class="col-md-8">
                    <ul class="breadcrumb breadcrumb-modified pull-right" style="background-color: transparent;">
                        <li><a href="index.jsp">Home</a> <span class="divider"></span></li>
                        <li><a href="RegistrationDhashBoard.jsp">RegisterDashBoard</a> <span class="divider"></span></li>
                        <li class="active"><a href="<%=request.getContextPath()%>/list_registration">Registration</a> <span class="divider"></span></li>
                    </ul>
                </div>
            </div>



            <div class="row-fluid">
                <hr class="hline" />
            </div>

            <div class="row placeholders">

                <c:if test="${registration != null}">
                <form action="update_registration" method="post" class="form-horizontal">
                    </c:if>

                    <c:if test="${registration == null}">
                    <form action="insert_registration" method="post" class="form-horizontal" name="myform" enctype="multipart/form-data">
                        </c:if>

                        <div class="form-group" style="color:#0269A4">
                            <div class="col-md-8">
                                <caption>
                                    <h4>
                                        <c:if test="${registration != null}">
                                            <label class="control-label"><span class="glyphicon glyphicon-user"></span>  Edit Registration </label>
                                        </c:if>

                                        <c:if test="${registration == null}">
                                            <label class="col-md-6 control-label"><span class="glyphicon glyphicon-user"></span>  Add New Registration</label>
                                            <div class="col-md-6 alert alert-warning" >${alertMessage}  ${notnullMessage}  ${errorMessage}  ${existMessage}</div>
                                        </c:if>
                                    </h4>
                                </caption>
                            </div>
                        </div>

                        <!--    ---------------------new form-------------------------   -->
                        <c:if test="${registration == null}">

                            <input type="hidden" name="Registration_id" value="<c:out value='${registration.Registration_id}' />"/>
                            <hr>
                            <!-- Person block -->
                             <div class="col-md-11">
                                  <div class="form-group" style="color:#0269A4">
                                      <label class="col-md-1 control-label">First Name :</label>
                                      <div class="col-md-3  has-success">
                                          <input type="text"  value="<c:out value='${registration.FirstName}' />" class="form-control " name="FirstName" placeholder="Enter First Name..." >
                                      </div>
                                      <div class="col-md-2  has-success">
                                          <input type="text"  value="<c:out value='${registration.MiddleName}' />" class="form-control " name="MiddleName" placeholder="Middle Name..." >
                                      </div>
                                      <div class="col-md-2  has-success">
                                          <input type="text"  value="<c:out value='${registration.LastName}' />" class="form-control " name="LastName" placeholder="Last Name..." >
                                      </div>
                                      <label class="col-md-1 control-label">Identity Code :</label>
                                      <div class="col-md-3  has-success">
                                          <input type="text"  value="<c:out value='${registration.getPersonalIDNumber()}' />" class="form-control " name="PersonalIDNumber" placeholder="Enter ID Number..." >
                                      </div>

                                  </div>

                                 <div class="form-group" style="color:#0269A4">
                                     <label class="col-md-1 control-label">Mother's Name :</label>
                                     <div class="col-md-3  has-success">
                                         <input type="text"  value="<c:out value='${registration.MothersName}' />" class="form-control " name="MothersName" placeholder="Enter MothersName Name..." >
                                     </div>
                                     <label class="col-md-1 control-label">Father's Name :</label>
                                     <div class="col-md-3  has-success">
                                         <input type="text"  value="<c:out value='${registration.FathersName}' />" class="form-control " name="FathersName" placeholder="Enter FathersName Name..." >
                                     </div>
                                     <label class="col-md-1 control-label">Register Date : </label>
                                     <div class="col-md-3  has-success">
                                         <input type="date"  value="<c:out value='${registration.RegistrationDate}' />" class="form-control " name="RegistrationDate" placeholder="dd-mm-yyyy" >
                                     </div>
                                 </div>


                                 <div class="form-group" style="color:#0269A4">
                                       <label class="col-md-1 control-label">DOB : </label>
                                       <div class="col-md-3  has-success">
                                           <input type="date"  value="<c:out value='${registration.DOB}' />" class="form-control " name="DOB" placeholder="dd-mm-yyyy" >
                                       </div>
                                     <label class="col-md-1 control-label">Gender :</label>
                                     <div class="col-md-1  has-success">
                                         <input type="radio"  name="Gender"   value="Male" required>&nbsp;&nbsp;Male
                                     </div>
                                     <div class="col-md-2  has-success nopadding">
                                         <input type="radio" name="Gender" value="Female">&nbsp;&nbsp;Female
                                     </div>
                                     <label class="col-md-1 control-label">Upload Photo :</label>
                                     <div class="col-md-3  has-success">
                                         <input type="file"  value="<c:out value='${registration.file}' />" accept="image/*"  name="file" id="file">
                                     </div>
                                 </div>


                                 <div class="form-group" style="color:#0269A4">
                                     <label class="col-md-1 control-label">Post :</label>
                                     <div class="col-md-3  has-success">
                                         <select name="Post_id" class="form-control">
                                             <option value="-1">--Select Post--</option>
                                             <c:forEach items="${listPostDrop}" var="post">
                                                 <option value="${post.getPost_id()}">${post.getPostName()}</option>
                                             </c:forEach>
                                         </select>
                                     </div>

                                     <label class="col-md-1 control-label"> Section :</label>
                                     <div class="col-md-3  has-success">
                                         <select name="Section_id" class="form-control">
                                             <option value="-1">--Select Section--</option>
                                             <c:forEach items="${listSectionDrop}" var="section">
                                                 <option value="${section.getSection_id()}">${section.getSectionName()}</option>
                                             </c:forEach>
                                         </select>
                                     </div>

                                     <label class="col-md-1 control-label">Department :</label>
                                     <div class="col-md-3  has-success">
                                         <select name="Department_id" class="form-control">
                                             <option value="-1">--Select Department--</option>
                                             <c:forEach items="${listDepartmentDrop}" var="department">
                                                 <option value="${department.getDepartment_id()}">${department.getDepartmentName()}</option>
                                             </c:forEach>
                                         </select>
                                     </div>
                                 </div>

                                 <div class="form-group" style="color:#0269A4">
                                     <label class="col-md-1 control-label ">Email :</label>
                                     <div class="col-md-3  has-success">
                                         <input type="text"  value="<c:out value='${registration.Email}' />" class="form-control " name="Email" placeholder="Enter Email..." >
                                     </div>
                                     <label class="col-md-1 control-label">Mobile :</label>
                                     <div class="col-md-3  has-success">
                                         <input type="text"  value="<c:out value='${registration.MobileNo}' />" class="form-control " name="MobileNo" placeholder="Enter Mobile Number..." >
                                     </div>
                                     <label class="col-md-1 control-label nopadding">Land Line:</label>
                                     <div class="col-md-3  has-success ">
                                         <input type="text"  value="<c:out value='${registration.LandLine}' />" class="form-control " name="LandLine" placeholder="Enter LandLine..." >
                                     </div>
                                 </div>

                             </div>

                             <div class="col-md-1 img-rounded nopadding">
                                 <img src="image/bishnu.jpg" class="img-rounded nopadding" />
                             </div>

                            <!-- Person block ended -->

                            <div class="col-md-12">
                                <div class="row-fluid">
                                    <hr class="hline" />
                                </div>
                            </div>


                            <div class="col-md-12">
                                <div class="form-group">
                                    <label class="col-md-1 control-label"></label>
                                    <label class="col-md-1 control-label nopadding">
                                        <button type="submit" class="btn btn-primary pull-left" onclick="return validate();" name="action">Save</button>
                                    </label>
                                    <label class="col-md-1 control-label">
                                        <button type="reset" class="btn btn-primary pull-left">Cancel</button>
                                    </label>
                                </div>
                            </div>
                        </c:if>


                        <!-- --------------------------update form----------------------------    -->
                        <c:if test="${registration != null}">

                            <input type="hidden" name="Registration_id" value="<c:out value='${registration.getRegistration_id()}' />"/>
                            <hr>
                            <div class="col-md-11">
                                <div class="form-group" style="color:#0269A4">
                                    <label class="col-md-2 control-label">First Name :</label>
                                    <div class="col-md-2  has-success">
                                        <input type="text"  value="<c:out value='${registration.getFirstName()}' />" class="form-control " name="FirstName" placeholder="Enter First Name..." >
                                    </div>
                                    <div class="col-md-2  has-success">
                                        <input type="text"  value="<c:out value='${registration.getMiddleName()}' />" class="form-control " name="MiddleName" placeholder="Enter Middle Name..." >
                                    </div>
                                    <div class="col-md-2  has-success">
                                        <input type="text"  value="<c:out value='${registration.getLastName()}' />" class="form-control " name="LastName" placeholder="Enter Last Name..." >
                                    </div>
                                    <label class="col-md-2 control-label">Identity Code :</label>
                                    <div class="col-md-2  has-success">
                                        <input type="text" value="<c:out value='${registration.getPersonalIDNumber()}' />" class="form-control " name="PersonalIDNumber" placeholder="Enter ID Number..." >
                                    </div>

                                </div>

                                <div class="form-group" style="color:#0269A4">
                                    <label class="col-md-2 control-label">Mother's Name :</label>
                                    <div class="col-md-2  has-success">
                                        <input type="text"  value="<c:out value='${registration.getMothersName()}' />" class="form-control " name="MothersName" placeholder="Enter MothersName Name..." >
                                    </div>
                                    <label class="col-md-2 control-label">Father's Name :</label>
                                    <div class="col-md-2  has-success">
                                        <input type="text"  value="<c:out value='${registration.getFathersName()}' />" class="form-control " name="FathersName" placeholder="Enter FathersName Name..." >
                                    </div>
                                    <label class="col-md-2 control-label">Registration Date : </label>
                                    <div class="col-md-2  has-success">
                                        <input type="date"  value="<c:out value='${registration.getRegistrationDate()}' />" class="form-control " name="RegistrationDate" placeholder="dd-mm-yyyy" >
                                    </div>
                                </div>


                                <div class="form-group" style="color:#0269A4">
                                    <label class="col-md-2 control-label">DOB : </label>
                                    <div class="col-md-2  has-success">
                                        <input type="date"  value="<c:out value='${registration.getDOB()}' />" class="form-control " name="DOB" placeholder="dd-mm-yyyy" >
                                    </div>

                                    <c:set var="Gender" scope="session" value="${registration.getGender()}"/>
                                    <c:if test="${Gender.equals('Male')==true}">
                                    <label class="col-md-2 control-label">Gender :</label>
                                    <div class="col-md-1  has-success">
                                        <input type="radio"  name="Gender"   value="Male" required checked> &nbsp; Male
                                    </div>
                                    <div class="col-md-1  has-success nopadding">
                                        <input type="radio" name="Gender" value="Female"> &nbsp; Female
                                    </div>
                                    </c:if>
                                    <c:if test="${Gender.equals('Female')==true}">
                                        <label class="col-md-2 control-label">Gender :</label>
                                        <div class="col-md-1  has-success">
                                            <input type="radio"  name="Gender"   value="Male" required> &nbsp; Male
                                        </div>
                                        <div class="col-md-1  has-success nopadding">
                                            <input type="radio" name="Gender" value="Female" checked> &nbsp; Female
                                        </div>
                                    </c:if>




                                    <label class="col-md-2 control-label">Upload Photo :</label>
                                    <div class="col-md-2  has-success">
                                        <input type="file"  value="<c:out value='${registration.getPhotoPath()}' />" accept="image/*" class=""  name="PhotoPath" >
                                    </div>
                                </div>


                                <div class="form-group" style="color:#0269A4">
                                    <label class="col-md-2 control-label">Post :</label>
                                    <div class="col-md-2  has-success">
                                        <select name="Post_id" class="form-control">
                                            <option value="-1">--Select Post--</option>
                                            <c:forEach items="${listPostDrop}" var="post">
                                                <option value="${post.getPost_id()}">${post.getPostName()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <label class="col-md-2 control-label"> Section :</label>
                                    <div class="col-md-2  has-success">
                                        <select name="Section_id" class="form-control">
                                            <option value="-1">--Select Section--</option>
                                            <c:forEach items="${listSectionDrop}" var="section">
                                                <option value="${section.getSection_id()}">${section.getSectionName()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <label class="col-md-2 control-label">Department :</label>
                                    <div class="col-md-2  has-success">
                                        <select name="Department_id" class="form-control">
                                            <option value="-1">--Select Department--</option>
                                            <c:forEach items="${listDepartmentDrop}" var="department">
                                                <option value="${department.getDepartment_id()}">${department.getDepartmentName()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group" style="color:#0269A4">
                                    <label class="col-md-2 control-label ">Email :</label>
                                    <div class="col-md-2  has-success">
                                        <input type="text"  value="<c:out value='${registration.getEmail()}' />" class="form-control " name="Email" placeholder="Enter Email..." >
                                    </div>
                                    <label class="col-md-2 control-label">Mobile :</label>
                                    <div class="col-md-2  has-success">
                                        <input type="text"  value="<c:out value='${registration.getMobileNo()}' />" class="form-control " name="MobileNo" placeholder="Enter Mobile Number..." >
                                    </div>
                                    <label class="col-md-2 control-label nopadding">Land Line:</label>
                                    <div class="col-md-2  has-success ">
                                        <input type="text"  value="<c:out value='${registration.getLandLine()}' />" class="form-control " name="LandLine" placeholder="Enter LandLine..." >
                                    </div>
                                </div>

                            </div>
                            <div class="col-md-1 img-rounded nopadding">
                                <img src="bootstrap/image/profile.svg " class="img-rounded nopadding" name="PhotoName">
                            </div>


                            <div class="form-group has-success">
                                <label class="col-md-2 control-label"></label>
                                <label class="col-md-1 control-label">
                                    <button type="submit" class="btn btn-primary pull-left">Update</button>
                                </label>
                            </div>
                        </c:if>
                    </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
