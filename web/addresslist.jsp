<%--
  Created by IntelliJ IDEA.
  User: Server
  Date: 13-06-2020
  Time: 7:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin | TMS AddressList</title>
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
                <li><a href="index.jsp" class="main-color-bg"> <span class="glyphicon glyphicon-th-large"></span> Dashbaord <span class="sr-only">(current)</span></a></li>
                <li><a href="userlist.jsp"> <span class="glyphicon glyphicon-paperclip"></span>  View Users</a></li>
                <li><a href="userform.jsp"> <span class="glyphicon glyphicon-paperclip"></span>  View Users</a></li>
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
                            <span class="glyphicon glyphicon-user"></span> &nbsp; Admin / Address List
                        </h3>
                    </div>
                </div>

                <div class="col-md-8">
                    <ul class="breadcrumb breadcrumb-modified pull-right" style="background-color: transparent;">
                        <li><a href="index.jsp">Home</a> <span class="divider"></span></li>
                        <li><a href="RegistrationDhashBoard.jsp">RegisterDashBoard</a> <span class="divider"></span></li>
                        <li class="active"><a href="<%=request.getContextPath()%>/list_address">AddressList</a> <span class="divider"></span></li>
                    </ul>
                </div>
            </div>



            <c:if test="${address == null }">
                <div class="row">
                    <div id="alert"  class="col-md-12 row-fluid-icon-modified">
                        <div id="messaging_alert"  class="col-md-6 pull-left alert" visible="false">

                            <p style="color:green;">${successMessage}  ${deleteMessage}  ${updateMessage} </p>

                        </div>
                    </div>
                </div>
            </c:if>

            <div class="row-fluid">
                <hr class="hline" />
            </div>

            <div class="row placeholders">

                <div class="row">
                    <div class="form-group" style="color:#0269A4">
                        <label class="col-md-12   control-label">
                            <h3> List of Address </h3>
                        </label>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <label class="col-md-1 control-label">
                            <a href="<%=request.getContextPath()%>/new_address" class="btn btn-success">Add New Address</a>
                        </label>
                    </div>
                </div>

                <div class="col-md-12">
                    <ul class="breadcrumb breadcrumb-modified pull-right" style="background-color: transparent;">
                        <li><a href="<%=request.getContextPath()%>/new_address" class="btn btn-primary" data-toggle="tooltip" data-placement="top" title="New">+</a></li>
                        <li><a href="<%=request.getContextPath()%>/list_address" class="btn btn-primary" data-toggle="tooltip" data-placement="top" title="View">*</a></li>
                    </ul>
                </div>


                <form action="list_address" method="post" class="form-horizontal">
                    <div class="row">
                        <div class="col-md-10 form-group has-success">
                            <Label Class="col-md-2 control-label">* Search Address </Label>
                            <div class="col-md-3">
                                <input  type="text" ID="SearchAddress" placeholder="Search By Address" class="form-control" name="SearchAddress">
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
                            <th class="mdl-data-table_cell-non-numeric">ID</th>
                            <th>AddressType</th>
                            <th>Name</th>
                            <th>MunicipalityName</th>
                            <th>Type</th>
                            <th>Country</th>
                            <th>State</th>
                            <th>District</th>
                            <th>City</th>
                            <th>StreetName</th>
                            <th>Ward No</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="address" items="${listAddress}">
                            <tr>
                                <td><c:out value="${address.getAddress_id()}" /></td>
                                <td><c:out value="${address.getAddressTypeName()}" /></td>
                                <td><c:out value="${address.getFirstName()}" /></td>
                                <td><c:out value="${address.getAddress_MunicipalityName()}" /></td>
                                <td><c:out value="${address.getMunicipalityName()}" /></td>
                                <td><c:out value="${address.getCountryName()}" /></td>
                                <td><c:out value="${address.getStateName()}" /></td>
                                <td><c:out value="${address.getDistrictName()}" /></td>
                                <td><c:out value="${address.getCityName()}" /></td>
                                <td><c:out value="${address.getStreetName()}" /></td>
                                <td><c:out value="${address.getWardNo()}" /></td>
                                <td>
                                    <a href="edit_address?Address_id=<c:out value='${address.getAddress_id()}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <a href="delete_address?Address_id=<c:out value='${address.getAddress_id()}' />">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </form>

            </div>
        </div>
    </div>
</div>
</body>
</html>
