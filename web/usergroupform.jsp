<%--
  Created by IntelliJ IDEA.
  User: Server
  Date: 10-05-2020
  Time: 5:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin | TMS UserGroup</title>
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


    <script src="https://cdn.ckeditor.com/4.14.0/standard/ckeditor.js"/>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js" />
    <script type="text/javascript" src="bootstrap/js/sweetalert.min.js"/>
    <script>
        CKEDITOR.replace( 'editor1' );
    </script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#reg_form').validate({
                feedbackIcon:{
                    valid:'glyphicon glyphicon-ok',
                    oninvalid:'glyphicon glyphicon-remove',
                    validating:'glyphicon glyphicon-refresh',
                },
                fields:{
                    UserGroupName:{
                        validators:{
                            stringlength:{
                                min: 2,
                            },
                            notEmpty:{
                                message:'Please Enter UserGroup'
                            }
                        }
                    },
                }

            })
            .on('success.form.bv'),function (e) {
                $('#success_message').slideDown({opacity:"show"},"show")
                $('#reg_form').data('validate').resetForm();
                e.preventDefault();
                var $form=$(e.target());
                var bv=$form.data('validate');
                $.post($form.attr('action'),$form.serialize(),function (result) {
                    console.log(result);


                },'json');
            };

        });

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
                            <span class="glyphicon glyphicon-user"></span> &nbsp; Admin / UserGroup
                        </h3>
                    </div>
                </div>
                <div class="col-md-8">
                    <ul class="breadcrumb breadcrumb-modified pull-right" style="background-color: transparent;">
                        <li><a href="index.jsp">Home</a> <span class="divider"></span></li>
                        <li><a href="ConfigurationDashBoard.jsp">Configuration</a> <span class="divider"></span></li>
                        <li><a href="SecurityDashBoard.jsp">Security</a> <span class="divider"></span></li>
                        <li class="active"><a href="usergrouplist.jsp">User Group</a> <span class="divider"></span></li>

                    </ul>
                </div>
            </div>

            <c:if test="${usergroup == null}">
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

                <c:if test="${usergroup != null}">
                    <form action="updategroup" method="post" class="form-horizontal">
                </c:if>

                 <c:if test="${usergroup == null}">
                    <form action="insertgroup" method="post" class="form-horizontal">
                 </c:if>

                        <div class="form-group" style="color:#0269A4">
                            <div class="col-md-5">
                                <caption>
                                    <h4>
                                        <c:if test="${usergroup != null}">
                                            <label class="control-label"><i class="fas fa-user-tag"></i>  Edit UserGroup </label>
                                        </c:if>
                                        <c:if test="${usergroup == null}">
                                            <label class="control-label"><i class="fas fa-user-tag"></i>  New UserGroup </label>
                                        </c:if>
                                    </h4>
                                </caption>
                            </div>
                        </div>

                        <c:if test="${usergroup == null}">
                            <input type="hidden" name="UserGroup_id" value="<c:out value='${usergroup.UserGroup_id}' />"/>

                        <hr>

                        <div class="form-group" style="color:#0269A4">
                            <label class="col-md-2 control-label">User Group Name: </label>
                            <div class="col-md-2">
                                <input type="text" value="<c:out value='${usergroup.UserGroupName}' />" class="form-control" name="UserGroupName" placeholder="Enter UserGroup Name...">
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

                        <c:if test="${usergroup != null}">
                            <input type="hidden" name="UserGroup_id" value="<c:out value='${usergroup.getUserGroup_id()}' />"/>

                            <hr>

                            <div class="form-group" style="color:#0269A4">
                                <label class="col-md-2 control-label">User Group Name: </label>
                                <div class="col-md-2 inputGroupContainer">
                                    <input type="text" value="<c:out value='${usergroup.getUserGroupName()}' />" class="form-control" name="UserGroupName"  required>
                                    </div>
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