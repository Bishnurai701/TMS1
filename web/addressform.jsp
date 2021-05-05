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
    <title>Admin | TMS Add  Address</title>
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
                            <span class="glyphicon glyphicon-user"></span> &nbsp; Admin / New Address
                        </h3>
                    </div>
                </div>
                <div class="col-md-8">
                    <ul class="breadcrumb breadcrumb-modified pull-right" style="background-color: transparent;">
                        <li><a href="index.jsp">Home</a> <span class="divider"></span></li>
                        <li><a href="RegistrationDhashBoard.jsp">RegisterDashBoard</a> <span class="divider"></span></li>
                        <li class="active"><a href="<%=request.getContextPath()%>/list_address">Address</a> <span class="divider"></span></li>
                    </ul>
                </div>
            </div>



            <div class="row-fluid">
                <hr class="hline" />
            </div>

            <div class="row placeholders">

                <c:if test="${address != null}">
                <form action="update_address" method="post" class="form-horizontal">
                    </c:if>

                    <c:if test="${address == null}">
                    <form action="insert_address" method="post" class="form-horizontal" name="myform">
                        </c:if>

                        <div class="form-group" style="color:#0269A4">
                            <div class="col-md-5">
                                <caption>
                                    <h4>
                                        <c:if test="${address != null}">
                                            <label class="control-label"><span class="glyphicon glyphicon-user"></span>  Edit Address </label>
                                        </c:if>

                                        <c:if test="${address == null}">
                                            <label class="col-md-6 control-label"><span class="glyphicon glyphicon-user"></span>  Add New Address</label>
                                            <div class="col-md-6 alert alert-warning" >${alertMessage}  ${notnullMessage}  ${errorMessage}  ${existMessage}</div>
                                        </c:if>
                                    </h4>
                                </caption>
                            </div>
                        </div>

                        <!--    ---------------------new form-------------------------   -->
                        <c:if test="${address == null}">

                            <input type="hidden" name="Address_id" value="<c:out value='${address.Address_id}' />"/>
                            <hr>

                            
                            <!-- Permanent Address block -->
                            <div class="col-md-12">
                                <div class="form-group" style="color:#0269A4">
                                    <label class="col-md-1 control-label ">Address Type:</label>
                                    <div class="col-md-2  has-success">
                                        <select name="AddressType_id" class="form-control">
                                            <option value="-1">--Select AddressType--</option>
                                            <c:forEach items="${listAddressTypeDrop}" var="address">
                                                <option value="${address.getAddressType_id()}">${address.getAddressTypeName()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <div class="col-md-9  has-success">
                                        <hr>
                                    </div>
                                </div>
                                <!--
                                <div class="form-group" style="color:#0269A4">
                                    <label class="col-md-1 control-label ">Municipality Name :</label>
                                    <div class="col-md-3  has-success">
                                        <input type="text"  value="<c:out value='${address.Address_MunicipalityName}' />" class="form-control " name="Address_MunicipalityName" placeholder="Enter MunicipalityName..." >
                                    </div>
                                    <label class="col-md-1 control-label">Municipality :</label>
                                    <div class="col-md-2  has-success">
                                        <select name="Municipality_id" class="form-control">
                                            <option value="-1">--Select Municipality--</option>
                                            <c:forEach items="${listMunicipalityDrop}" var="address">
                                                <option value="${address.getMunicipality_id()}">${address.getMunicipalityName()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <label class="col-md-1 control-label ">Street Name :</label>
                                    <div class="col-md-2  has-success">
                                        <input type="text"  value="<c:out value='${address.StreetName}' />" class="form-control " name="StreetName" placeholder="Enter StreetName..." >
                                    </div>
                                    <label class="col-md-1 control-label">Word No :</label>
                                    <div class="col-md-1  has-success">
                                        <input type="text"  value="<c:out value='${address.WardNo}' />" class="form-control " name="WardNo" placeholder="WardNo..." >
                                    </div>
                                </div>
                                -->

                                <div class="form-group" style="color:#0269A4">
                                    <label class="col-md-1 control-label ">Register Name:</label>
                                    <div class="col-md-2  has-success">
                                        <select name="Registration_id" class="form-control">
                                            <option value="-1">--Select Name--</option>
                                            <c:forEach items="${listRegistrationDrop}" var="address">
                                                <option value="${address.getRegistration_id()}">${address.getFirstName()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>


                                    <label class="col-md-1 control-label ">Country:</label>
                                    <div class="col-md-2  has-success">
                                        <select name="Country_id" class="form-control">
                                            <option value="-1">--Select Country--</option>
                                            <c:forEach items="${listCountryDrop}" var="address">
                                                <option value="${address.getCountry_id()}">${address.getCountryName()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <label class="col-md-1 control-label">State :</label>
                                    <div class="col-md-2  has-success">
                                        <select name="State_id" class="form-control">
                                            <option value="-1">--Select State--</option>
                                            <c:forEach items="${listStateDrop}" var="address">
                                                <option value="${address.getState_id()}">${address.getStateName()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <label class="col-md-1 control-label">District :</label>
                                    <div class="col-md-2  has-success ">
                                        <select name="District_id" class="form-control">
                                            <option value="-1">--Select District--</option>
                                            <c:forEach items="${listDistrictDrop}" var="address">
                                                <option value="${address.getDistrict_id()}">${address.getDistrictName()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>


                                <div class="form-group" style="color:#0269A4">
                                    <label class="col-md-1 control-label ">Municipality Name :</label>
                                    <div class="col-md-8  has-success">
                                        <input type="text"  value="<c:out value='${address.Address_MunicipalityName}' />" class="form-control " name="Address_MunicipalityName" placeholder="Enter MunicipalityName..." >
                                    </div>
                                    <label class="col-md-1 control-label">Municipality:</label>
                                    <div class="col-md-2  has-success">
                                        <select name="Municipality_id" class="form-control">
                                            <option value="-1">--Select Municipality--</option>
                                            <c:forEach items="${listMunicipalityDrop}" var="address">
                                                <option value="${address.getMunicipality_id()}">${address.getMunicipalityName()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>


                                <div class="form-group" style="color:#0269A4">
                                    <label class="col-md-1 control-label ">City Name :</label>
                                    <div class="col-md-3  has-success">
                                        <input type="text"  value="<c:out value='${address.CityName}' />" class="form-control " name="CityName" placeholder="Enter CityName..." >
                                    </div>
                                    <label class="col-md-1 control-label ">Street Name :</label>
                                    <div class="col-md-4  has-success">
                                        <input type="text"  value="<c:out value='${address.StreetName}' />" class="form-control " name="StreetName" placeholder="Enter StreetName..." >
                                    </div>
                                    <label class="col-md-1 control-label">Ward No:</label>
                                    <div class="col-md-2  has-success">
                                        <input type="text"  value="<c:out value='${address.WardNo}' />" class="form-control " name="WardNo" placeholder="Enter WardNo..." >
                                    </div>
                                </div>

                            </div>
                            <!-- Permanent Address block ended  -->


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
                        <c:if test="${address != null}">
                            <input type="hidden" name="Address_id" value="<c:out value='${address.getAddress_id()}' />"/>

                            <hr>
                            <div class="col-md-12">
                                <div class="form-group" style="color:#0269A4">
                                    <label class="col-md-1 control-label ">AddressType:</label>
                                    <div class="col-md-2  has-success">
                                        <select name="AddressType_id" class="form-control">
                                            <option value="-1">--Select AddressType--</option>
                                            <c:forEach items="${listAddressTypeDrop}" var="address">
                                                <option value="${address.getAddressType_id()}">${address.getAddressTypeName()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col-md-9  has-success">
                                        <hr>
                                    </div>

                                </div>

                                <div class="form-group" style="color:#0269A4">
                                    <label class="col-md-1 control-label ">RegisterName:</label>
                                    <div class="col-md-2  has-success">
                                        <select name="Registration_id" class="form-control">
                                            <option value="-1">--Select Name--</option>
                                            <c:forEach items="${listRegistrationDrop}" var="address">
                                                <option value="${address.getRegistration_id()}">${address.getFirstName()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>


                                    <label class="col-md-1 control-label ">Country :</label>
                                    <div class="col-md-2  has-success">
                                        <select name="Country_id" class="form-control">
                                            <option value="-1">--Select Country--</option>
                                            <c:forEach items="${listCountryDrop}" var="address">
                                                <option value="${address.getCountry_id()}">${address.getCountryName()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <label class="col-md-1 control-label">State :</label>
                                    <div class="col-md-2  has-success">
                                        <select name="State_id" class="form-control">
                                            <option value="-1">--Select State--</option>
                                            <c:forEach items="${listStateDrop}" var="address">
                                                <option value="${address.getState_id()}">${address.getStateName()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <label class="col-md-1 control-label">District :</label>
                                    <div class="col-md-2  has-success ">
                                        <select name="District_id" class="form-control">
                                            <option value="-1">--Select District--</option>
                                            <c:forEach items="${listDistrictDrop}" var="address">
                                                <option value="${address.getDistrict_id()}">${address.getDistrictName()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>


                                <div class="form-group" style="color:#0269A4">
                                    <label class="col-md-1 control-label ">Municipality Name :</label>
                                    <div class="col-md-8  has-success">
                                        <input type="text"  value="<c:out value='${address.getAddress_MunicipalityName()}' />" class="form-control " name="Address_MunicipalityName" placeholder="Enter MunicipalityName..." >
                                    </div>
                                    <label class="col-md-1 control-label">Municipality :</label>
                                    <div class="col-md-2  has-success">
                                        <select name="Municipality_id" class="form-control">
                                            <option value="-1">--Select Municipality--</option>
                                            <c:forEach items="${listMunicipalityDrop}" var="address">
                                                <option value="${address.getMunicipality_id()}">${address.getMunicipalityName()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group" style="color:#0269A4">
                                    <label class="col-md-1 control-label ">Street Name :</label>
                                    <div class="col-md-8  has-success">
                                        <input type="text"  value="<c:out value='${address.getStreetName()}' />" class="form-control " name="StreetName" placeholder="Enter StreetName..." >
                                    </div>
                                    <label class="col-md-1 control-label">Ward No :</label>
                                    <div class="col-md-2  has-success">
                                        <input type="text"  value="<c:out value='${address.getWardNo()}' />" class="form-control " name="WardNo" placeholder="Enter WardNo..." >
                                    </div>
                                </div>

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
