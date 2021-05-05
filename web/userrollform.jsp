<%--
  Created by IntelliJ IDEA.
  User: Server
  Date: 14-05-2020
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Admin | TMS UserRoll</title>
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
                <li><a href="viewusers.jsp"> <span class="glyphicon glyphicon-paperclip"></span>  View UserGroup</a></li>
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
                            <span class="glyphicon glyphicon-user"></span> &nbsp; Admin / UserRoll
                        </h3>
                    </div>
                </div>
                <div class="col-md-8">
                    <ul class="breadcrumb breadcrumb-modified pull-right" style="background-color: transparent;">
                        <li><a href="index.jsp">Home</a> <span class="divider"></span></li>
                        <li><a href="ConfigurationDashBoard.jsp">Configuration</a> <span class="divider"></span></li>
                        <li><a href="SecurityDashBoard.jsp">Security</a> <span class="divider"></span></li>
                        <li class="active"><a href="userrolllist.jsp">User Roll</a> <span class="divider"></span></li>

                    </ul>
                </div>
            </div>

            <c:if test="${userroll == null}">
                <div class="row">
                    <div id="alert"  class="col-md-12 row-fluid-icon-modified">
                        <div id="messaging_alert"  class="col-md-6 pull-left alert" visible="false">
                            <div class="alert alert-warning" >${alertMessage}  ${notnullMessage}  ${errorMessage}  ${existMessage}</div>
                            <button  class="close" id="button-close" data-dismiss="alert" Visible="false">
                            </button>
                        </div>
                    </div>
                </div>
            </c:if>


            <div class="row-fluid">
                <hr class="hline" />
            </div>

            <div class="row placeholders">

                    <c:if test="${userroll != null}">
                        <form action="updateroll" method="post" class="form-horizontal">
                    </c:if>
                    <c:if test="${userroll == null}">
                        <form action="insertroll" method="post" class="form-horizontal">
                    </c:if>
                        <div class="form-group" style="color:#0269A4">
                            <div class="col-md-5">
                                <caption>
                                    <h4>
                                        <c:if test="${userroll != null}">
                                            <label class="control-label"> <i class="fas fa-user-cog"></i>  Edit UserRoll </label>
                                        </c:if>
                                        <c:if test="${userroll == null}">
                                            <label class="control-label"> <i class="fas fa-user-cog"></i>  New UserRoll </label>
                                        </c:if>
                                    </h4>
                                </caption>
                            </div>
                        </div>

                        <c:if test="${userroll == null}">
                            <input type="hidden" name="UserRoll_id" value="<c:out value='${userroll.UserRoll_id}' />"/>

                        <hr>

                        <div class="form-group" style="color:#0269A4">
                            <label class="col-md-2 control-label">User Group Name: </label>
                            <div class="col-md-2">
                                <input type="text" value="<c:out value='${userroll.UserRollName}' />" class="form-control" name="UserRollName" placeholder="Enter UserRoll Name..." required>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-2 control-label"></label>
                            <label class="col-md-1 control-label">
                                <button type="submit" class="btn btn-primary pull-left">Save</button>
                            </label>
                            <label class="col-md-1 control-label">
                                <button type="reset" class="btn btn-primary">Cancel</button>
                            </label>
                        </div>

                        </c:if>
                            <c:if test="${userroll != null}">
                                <input type="hidden" name="UserRoll_id" value="<c:out value='${userroll.getUserRoll_id()}' />"/>

                                <hr>

                                <div class="form-group" style="color:#0269A4">
                                    <label class="col-md-2 control-label">User Group Name: </label>
                                    <div class="col-md-2">
                                        <input type="text" value="<c:out value='${userroll.getUserRollName()}' />" class="form-control" name="UserRollName"  required>
                                    </div>
                                </div>

                                <div class="form-group">
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
