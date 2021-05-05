<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="numguess" class="com.tms.dao.UserDAO" scope="session" />

<%--
  Created by IntelliJ IDEA.
  User: Server
  Date: 24-04-2020
  Time: 2:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="frm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.tms.db.DBConnection" %>
<%@ page import="com.tms.dao.UserDAO" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin | TMS Add User </title>

    <style type="text/css">
        <%@include file="bootstrap/css/bootstrap.css" %>
        <%@include file="bootstrap/css/bootstrap.min.css" %>
        <%@include file="bootstrap/css/hover-min.css" %>
        <%@include file="bootstrap/css/stylesheet.css" %>
    </style>



    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="bootstrap/css/stylesheet.css" />
    <link rel="stylesheet" type="text/css" href="bootstrap/css/hover.css" />
    <link rel="stylesheet" type="text/css" href="bootstrap/css/sweetalert.css"/>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"/>


    <script src="https://cdn.ckeditor.com/4.14.0/standard/ckeditor.js" />
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"  />
    <script type="text/javascript" src="bootstrap/js/sweetalert.min.js" />
    <script type="text/javascript" src="jquery-ui/jquery.validate.min.js" />
    <script type="text/javascript" src="jquery-ui/jquery.validate.js" />
    <script type="text/javascript" src="jquery-ui/jquery.form.js" />
    <script type="text/javascript" src="jquery-ui/jquery.js" />
    <script>
        CKEDITOR.replace( 'editor1' );
    </script>
    <script>
        $(document).on("click", "#buttonSubmit", function() {
            var params = {category : $("#listUserGroupDrop option:selected").text()};
            $.post("listajax", $.param(params), function(responseText) {
                alert(responseText);
            });
        });
    </script>
    <script>
    $(document).ready(function(){
    $("#regform").validate({
    rules: {
        cfPassword :
    {
    equalTo: "#Password"
    }
    }
    });
    });
    </script>
    <script type="text/javascript">
        $(function () {
            $('[data-toggle="tooltip"]').tooltip()
        })
    </script>

    <script type="text/javascript">
        function confirmAction(path, noPath) {
            if (confirm('Do, you want to  Delete This Data !')) {
                window.location = path;
            }
            else {
                window.location = noPath;
            }
        }

        $(document).ready(function (e) {
            $("#liUserGroup").addClass("active");
            $('#MainContent_MainContent_close').click(function (e) {
                $('#new').removeClass('active')
                $('.nav-custom li').removeClass('active')
            })
        });
    </script>
<script type="text/javascript">
    function validate() {
        var UserName=document.myform.UserName.value;
        if(UserName==""){
            alert("Please Enater UserName");
            document.myform.UserName.focus();
            return false;
        }
        if((UserName.length<5)||(UserName.length>30)){
            alert("UserName Invalid length");
            document.myform.UserName.focus();
            return false;
        }

        var UserLoginName=document.myform.UserLoginName.value;
        if(UserLoginName==""){
            alert("Please Enater UserLoginName");
            document.myform.UserLoginName.focus();
            return false;
        }
        if((UserLoginName.length<5)||(UserLoginName.length>30)){
            alert("UserLoginName Invalid length");
            document.myform.UserLoginName.focus();
            return false;
        }

        var Password=document.myform.Password.value;
        var illegalChar=/[\W_]/;
        if(Password==""){
            alert("Please Enater Password");
            document.myform.Password.focus();
            return false;
        }
        else if((Password.length<7) || (Password.length)>10){
            alert("Password should be between 7 and 10 characters");
            document.myform.Password.focus();
            return false;
        }
        else if(illegalChar.test(Password)){
            alert("Password contain illegal characters")
            document.myform.Password.focus();
            return false;
        }
    }
</script>




    <script>
        function validate()
        {
            var UserName = document.form.UserName.value;
            var UserLoginName = document.form.UserLoginName.value;
            var Password = document.form.Password.value;
            var cfPassword = document.form.cfPassword.value;

            if (UserName==null || UserName=="")
            {
                alert("UserName can't be blank");
                return false;
            }
            else if (UserLoginName==null || UserLoginName=="")
            {
                alert("UserLoginName can't be blank");
                return false;
            }
            else if (Password==null || Password=="")
            {
                alert("Password can't be blank");
                return false;
            }
            else if(password.length<6)
            {
                alert("Password must be at least 6 characters long.");
                return false;
            }
            else if (Password!=cfPassword)
            {
                alert("Confirm Password should match with the Password");
                return false;
            }
        }
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
                            <span class="glyphicon glyphicon-user"></span> &nbsp; Admin / New User
                        </h3>
                    </div>
                </div>
                <div class="col-md-8">
                    <ul class="breadcrumb breadcrumb-modified pull-right" style="background-color: transparent;">
                        <li><a href="index.jsp">Home</a> <span class="divider"></span></li>
                        <li><a href="ConfigurationDashBoard.jsp">Configuration</a> <span class="divider"></span></li>
                        <li><a href="SecurityDashBoard.jsp">Security</a> <span class="divider"></span></li>
                        <li class="active"><a href="<%=request.getContextPath()%>/list_user">Users</a> <span class="divider"></span></li>

                    </ul>
                </div>
            </div>

           <c:if test="${user == null}">
            <div class="row">
                <div id="alert"  class="col-md-12 row-fluid-icon-modified">
                    <div id="messaging_alert"  class="col-md-6 pull-left alert" visible="false">
                        <div class="alert alert-warning" >${alertMessage}  ${notnullMessage}  ${errorMessage}  ${existMessage}</div>
                        <button  class="close" id="button-close" data-dismiss="alert" Visible="false">
                        </button>

                        <strong>
                            <Label  ID="alertMessage" Text="" ></Label>
                        </strong>
                    </div>
                </div>
            </div>
           </c:if>

            <div class="row-fluid">
                <hr class="hline" />
            </div>

            <div class="row placeholders">

               <c:if test="${user != null}">
                   <form action="update_user" method="post" class="form-horizontal">
               </c:if>

               <c:if test="${user == null}">
                   <form action="insert_user" method="post" class="form-horizontal" name="myform">
               </c:if>

                    <div class="form-group" style="color:#0269A4">
                        <div class="col-md-5">
                       <caption>
                           <h4>
                               <c:if test="${user != null}">
                                   <label class="control-label"><span class="glyphicon glyphicon-user"></span>  Edit User </label>
                               </c:if>
                               <c:if test="${user == null}">
                                   <label class="control-label"><span class="glyphicon glyphicon-user"></span>  Add New User </label>
                               </c:if>
                           </h4>
                       </caption>
                        </div>
                    </div>
                        <!--    ---------------------new form-------------------------   -->
                       <c:if test="${user == null}">

                           <input type="hidden" name="User_id" value="<c:out value='${user.User_id}' />"/>
                           <hr>
                           <div class="form-group" style="color:#0269A4">
                               <label class="col-md-2 control-label">User Name: </label>
                               <div class="col-md-3  has-success">

                                   <input type="text"  value="<c:out value='${user.UserName}' />" class="form-control " name="UserName" placeholder="Enter User Name..." >

                               </div>
                           </div>
                           <div class="form-group" style="color:#0269A4">
                               <label class="col-md-2 control-label">Login Name: </label>
                               <div class="col-md-3  has-success">
                                   <input type="text" value="<c:out value='${user.UserLoginName}' />" class="form-control" name="UserLoginName" placeholder="Enter Login Name..." >
                               </div>
                           </div>
                           <div class="form-group" style="color:#0269A4">
                               <label class="col-md-2 control-label">Password: </label>
                               <div class="col-md-3  has-success">
                                   <input type="password" value="<c:out value='${user.Password}' />" class="form-control has-success" name="Password" id="Password" placeholder="Enter Password...">
                               </div>
                           </div>
                           <div class="form-group" style="color:#0269A4">
                               <label class="col-md-2 control-label">Confirm Password: </label>
                               <div class="col-md-3  has-success">
                                   <input type="password" value="<c:out value='${user.Password}' />" class="form-control" name="cfPassword"  id="cfPassword" placeholder=" Confirm Password...">
                               </div>
                           </div>
                           <div class="form-group" style="color:#0269A4">
                               <label class="col-md-2 control-label">User Group Name: </label>
                               <div class="col-md-2  has-success">
                                   <select name="UserGroup_id" class="form-control ">
                                       <option value="-1" style="text-align: center">--Select UserGroup--</option><%
                                       Connection conn=DBConnection.createConnection();
                                       PreparedStatement ps=conn.prepareStatement("select UserGroup_id, UserGroupName from tbl_usergroup");
                                       ResultSet rs=ps.executeQuery();
                                       while (rs.next()){
                                           %>
                                       <option value="<%=rs.getInt("UserGroup_id")%>"> <%=rs.getString("UserGroupName")%> </option>
                                       <%
                                       }%>
                                   </select>
                               </div>
                           </div>
                           <div class="form-group" style="color:#0269A4">
                               <label class="col-md-2 control-label ">User Roll Name: </label>
                               <div class="col-md-2  has-success">
                                   <select name="UserRoll_id" class="form-control">
                                       <option value="-1">--Select UserRoll--</option>
                                       <%
                                           Connection con=DBConnection.createConnection();
                                           PreparedStatement pss=con.prepareStatement("select UserRoll_id, UserRollName from tbl_userroll");
                                           ResultSet rss=pss.executeQuery();
                                           while (rss.next()){%>
                                       <option value="<%=rss.getInt("UserRoll_id")%>"> <%=rss.getString("UserRollName")%> </option>
                                       <%
                                           }
                                           %>
                                   </select>
                               </div>
                           </div>
                           <div class="form-group" style="color:#0269A4">
                               <label class="col-md-2 control-label">Status:</label>
                               <div class="col-md-1  has-success">
                                   <input type="radio"  name="Status"   value=1 required>  Active
                               </div>
                               <div class="col-md-2  has-success">
                                   <input type="radio" name="Status" value=0>  Deactivate
                               </div>
                           </div>
                           <div class="form-group">
                               <label class="col-md-2 control-label"></label>
                               <label class="col-md-1 control-label">
                                   <button type="submit" class="btn btn-primary pull-left" onclick="return validate();" name="action">Register</button>
                               </label>
                               <label class="col-md-1 control-label">
                                   <button type="reset" class="btn btn-primary pull-left">Cancel</button>
                               </label>
                           </div>
                    </c:if>


                   <!-- --------------------------update form----------------------------    -->
                   <c:if test="${user != null}">
                       <input type="hidden" name="User_id" value="<c:out value='${user.getUser_id()}' />"/>

                       <hr>

                       <div class="form-group has-success" style="color:#0269A4">
                           <label class="col-md-2 control-label">User Name: </label>
                           <div class="col-md-3">
                               <input type="text" value="<c:out value='${user.getUserName()}' />" class="form-control" name="UserName" placeholder="Enter User Name...">
                           </div>
                       </div>

                       <div class="form-group has-success" style="color:#0269A4">
                           <label class="col-md-2 control-label">Login Name: </label>
                           <div class="col-md-3">
                               <input type="text" value="<c:out value='${user.getUserLoginName()}' />" class="form-control" name="UserLoginName" placeholder="Enter Login Name...">
                           </div>
                       </div>

                       <c:set var="UserGroupName" scope="session" value="${user.getUserGroupName()}"/>
                       <c:if test="${UserGroupName == user.getUserGroupName()}">
                       <div class="form-group has-success" style="color:#0269A4">
                           <label class="col-md-2 control-label">User Group Name: </label>
                           <div class="col-md-2">
                               <select name="UserGroup_id" class="form-control" required>
                                   <c:forEach items="${listUserGroupDrop}" var="user">
                                       <option value="${user.getUserGroup_id()}">${user.getUserGroupName()}
                                       </option>
                                   </c:forEach>

                               </select>
                           </div>
                       </div>
                       </c:if>
                       <div class="form-group has-success" style="color:#0269A4">
                           <label class="col-md-2 control-label">User Roll Name: </label>
                           <div class="col-md-2">
                               <select name="UserRoll_id" class="form-control">
                                   <c:forEach items="${listUserRollDrop}" var="user">
                                       <option value="${user.getUserRoll_id()}">
                                           ${user.getUserRollName()}
                                       </option>
                                   </c:forEach>
                               </select>
                           </div>
                       </div>
                       <c:set var="Status" scope="session" value="${user.getStatus()}"/>
                       <c:if test="${Status==1}">
                       <div class="form-group has-success" style="color:#0269A4">
                           <label class="col-md-2 control-label">Status:</label>
                           <div class="col-md-1">
                                <input type="radio"  name="Status"  value=1  checked/>   Active
                           </div>
                           <div class="col-md-2">
                               <input type="radio" name="Status" value=0  /> Deactivate
                           </div>
                       </div>
                       </c:if>
                       <c:if test="${Status==0}">
                           <div class="form-group has-success" style="color:#0269A4">
                               <label class="col-md-2 control-label">Status:</label>
                               <div class="col-md-1">
                                   <input type="radio"  name="Status"  value=1  />   Active
                               </div>
                               <div class="col-md-1">
                                   <input type="radio" name="Status" value=0  checked/> Deactivate
                               </div>
                           </div>
                       </c:if>
                       <div class="form-group has-success">
                           <label class="col-md-2 control-label"></label>
                           <label class="col-md-1 control-label">
                               <button type="submit" class="btn btn-primary pull-left">Update</button>
                           </label>
                       </div>
                   </c:if>

                   </form>




                <!--
                <form class="form-horizontal" action="adduser.jsp" method="post">


                    <div class="form-group">
                        <label class="col-md-2 control-label">Name :</label>
                        <div class="col-md-2">
                            <input type="text" class="form-control"  name="name" id="txtName" placeholder="Enter Your Name...">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 control-label">Password :</label>
                        <div class="col-md-2">
                            <input type="password" class="form-control" name="password" id="txtpassword" placeholder="Enter Your Password...">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 control-label">Email :</label>
                        <div class="col-md-2">
                            <input type="email" class="form-control" name="email" id="txtemail" placeholder="Enter Your Email...">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 control-label">Sex :</label>
                        <div class="col-md-1">
                            <input type="radio"  name="sex" value="male" id="rdmale">  Male
                        </div>
                        <div class="col-md-1">
                            <input type="radio" name="sex" value="female" id="rdfemale">  Female
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">Country :</label>
                        <div class="col-sm-2">
                            <select name="country"  class="form-control" id="ckcountry">
                                <option>Nepal</option>
                                <option>India</option>
                                <option>Pakistan</option>
                                <option>Afghanistan</option>
                                <option>Berma</option>
                                <option>Other</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">
                            <input type="submit" class="btn btn-primary" value="Save">
                        </label>
                        <div class="col-md-4">

                        </div>
                    </div>
                </form>-->

            </div>
        </div>
    </div>
</div>

</body>
</html>
