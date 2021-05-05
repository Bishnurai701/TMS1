<%--
  Created by IntelliJ IDEA.
  User: Server
  Date: 03-06-2020
  Time: 9:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin | TMS Master</title>

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
                            <span class="glyphicon glyphicon-user"></span> &nbsp; Admin / MasterMaintance
                        </h3>
                    </div>
                </div>
                <div class="col-md-8">
                    <ul class="breadcrumb breadcrumb-modified pull-right" style="background-color: transparent;">
                        <li><a href="index.jsp">Home</a> <span class="divider"></span></li>
                        <li><a href="ConfigurationDashBoard.jsp">Configuration</a> <span class="divider"></span></li>
                        <li class="active"><a href="<%=request.getContextPath()%>/list_country">Countries</a> <span class="divider"></span></li>

                    </ul>
                </div>
            </div>


            <div class="row-fluid">
                <hr class="hline" />
            </div>

            <div class="row">
                    <ul class="nav nav-tabs" id="list_master">

                        <li class="active"><a href="#liPost" >Post </a></li>
                        <li id="liCountry"><a href="<%=request.getContextPath()%>/list_country" >Country </a></li>
                        <li id="liMunicipality"><a href="<%=request.getContextPath()%>/list_municipality" >Municipality </a></li>
                        <li id="liDistrict"><a href="<%=request.getContextPath()%>/list_district" >District </a></li>
                        <li id="liSection"><a href="<%=request.getContextPath()%>/list_section" >Section </a></li>
                        <li id="liDepartment"><a href="<%=request.getContextPath()%>/list_department" >Department </a></li>
                        <li id="liFaculty"><a href="<%=request.getContextPath()%>/list_faculty" >Faculty </a></li>
                        <li id="liUniversity"><a href="<%=request.getContextPath()%>/list_university" >University </a></li>
                        <li id="liBoard"><a href="<%=request.getContextPath()%>/list_board" >Board </a></li>
                    </ul>
            </div>



            <div class="row">
                <div id="alert"  class="col-md-12 row-fluid-icon-modified">
                    <div id="messaging_alert"  class="col-md-6 pull-left alert" visible="false">
                        <button  class="close" id="button-close" data-dismiss="alert" Visible="false"> </button>
                            <div class="alert alert-warning" >${alertMessage}  ${notnullMessage}  ${errorMessage}  ${existMessage}</div>
                            <p style="color:green;">${successMessage}  ${deleteMessage}  ${updateMessage} </p>
                        <strong>
                            <Label  ID="alertMessage" Text="" ></Label>
                        </strong>
                    </div>
                </div>
            </div>

            <!-- this is Post Page-->
            <div class="row placeholders" id="liPost">

                <%
                    String action = request.getServletPath();
                %>

                <%if (action == "post")
                { %>
                <c:if test="${post != null}">
                    <form action="update_post" method="post" class="form-horizontal">
                </c:if>

                 <c:if test="${post == null}">
                     <form action="insert_post" method="post" class="form-horizontal" name="myform">
                 </c:if>

                        <div class="form-group" style="color:#0269A4">
                            <div class="col-md-5">
                                <caption>
                                    <h4>
                                        <c:if test="${post != null}">
                                            <label class="control-label"><span class="glyphicon glyphicon-user"></span>  Edit Post </label>
                                        </c:if>
                                        <c:if test="${post == null}">
                                            <label class="control-label"><span class="glyphicon glyphicon-user"></span>  Add New Post </label>
                                        </c:if>
                                    </h4>
                                </caption>
                            </div>
                        </div>

                        <!--    ---------------------new form-------------------------   -->
                        <c:if test="${post == null}">

                            <input type="hidden" name="Country_id" value="<c:out value='${post.Post_id}' />"/>
                            <hr>

                            <div class="form-group" style="color:#0269A4">
                                <label class="col-md-2 control-label">Post Name: </label>
                                <div class="col-md-3  has-success">
                                    <input type="text"  value="<c:out value='${post.PostName}' />" class="form-control " name="PostName" placeholder="Enter PostName..." >
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-2 control-label"></label>
                                <label class="col-md-1 control-label">
                                    <button type="submit" class="btn btn-primary pull-left" onclick="return validate();" name="action">Save</button>
                                </label>
                                <label class="col-md-1 control-label">
                                    <button type="reset" class="btn btn-primary pull-left">Cancel</button>
                                </label>
                            </div>

                        </c:if>
                        <!-- --------------------------update form----------------------------    -->
                        <c:if test="${post != null}">
                            <input type="hidden" name="Post_id" value="<c:out value='${post.getPost_id()}' />"/>

                            <hr>

                            <div class="form-group has-success" style="color:#0269A4">
                                <label class="col-md-2 control-label">Post Name: </label>
                                <div class="col-md-3">
                                    <input type="text" value="<c:out value='${post.getPost()}' />" class="form-control" name="PostName" placeholder="Enter Post...">
                                </div>
                            </div>
                            <div class="form-group has-success">
                                <label class="col-md-2 control-label"></label>
                                <label class="col-md-1 control-label">
                                    <button type="submit" class="btn btn-primary pull-left">Update</button>
                                </label>
                            </div>
                        </c:if>




                    <c:if test="${post != null}">
                     <form action="list_post" method="post" class="form-horizontal">
                     <div class="row">
                         <div class="form-group" style="color:#0269A4">
                             <label class="col-md-12   control-label">
                                 <h3> List of Post </h3>
                             </label>
                         </div>
                     </div>
                     <div class="row">
                         <div class="form-group">
                             <label class="col-md-1 control-label">
                                 <a href="<%=request.getContextPath()%>/new_post" class="btn btn-success">Add New Post</a>
                             </label>
                         </div>
                     </div>

                     <div class="col-md-12">
                         <ul class="breadcrumb breadcrumb-modified pull-right" style="background-color: transparent;">
                             <li><a href="<%=request.getContextPath()%>/new_post" class="btn btn-primary" data-toggle="tooltip" data-placement="top" title="New">+</a></li>
                             <li><a href="<%=request.getContextPath()%>/list_post" class="btn btn-primary" data-toggle="tooltip" data-placement="top" title="View">*</a></li>
                         </ul>
                     </div>


                         <div class="row">
                             <div class="col-md-10 form-group has-success">
                                 <Label Class="col-md-2 control-label">* Search Post Name</Label>
                                 <div class="col-md-3">
                                     <input  type="text" ID="SearchPost" placeholder="Search By Post Name" class="form-control" name="SearchPost">
                                 </div>
                                 <label class="col-md-1 control-label">
                                     <button type="submit" class="btn btn-primary pull-left" value="Search">Search</button>
                                 </label>
                             </div>
                         </div>

                         <hr>

                         <table class="table table-striped">
                             <thead>
                             <tr>
                                 <th>ID</th>
                                 <th>Post Name</th>
                                 <th>Actions</th>
                             </tr>
                             </thead>
                             <tbody>
                             <c:forEach var="post" items="${listPost}">
                                 <tr>
                                     <td><c:out value="${post.getPost_id()}"/> </td>
                                     <td><c:out value="${post.getPostName()}" /></td>
                                     <td>
                                         <a href="edit_post?Post_id=<c:out value='${post.getPost_id()}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                         <a href="delete_post?Post_id=<c:out value='${post.getPost_id()}' />">Delete</a>

                                     </td>
                                 </tr>
                             </c:forEach>
                             </tbody>
                         </table>
                    </c:if>



                    </form>
                         <%}%>
            </div>
            <!-- this is Post Page end -->






        </div>
    </div>
</div>























</body>
</html>
