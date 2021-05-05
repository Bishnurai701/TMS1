<%--
  Created by IntelliJ IDEA.
  User: Server
  Date: 26-05-2020
  Time: 1:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin | Login</title>

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




    <link rel="stylesheet" href="bootstrap/css/style.css" type="text/css" />

    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@600&display=swap" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"/>


    <script src="https://cdn.ckeditor.com/4.14.0/standard/ckeditor.js"/>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js" />
    <script type="text/javascript" src="bootstrap/js/sweetalert.min.js"/>
    <script type="text/javascript" src="bootstrap/js/main.js" />
    <script type="text/javascript" src="jquery-ui/jquery.validate.min.js" />
    <script type="text/javascript" src="jquery-ui/jquery.validate.js" />
    <script type="text/javascript" src="jquery-ui/jquery.form.js" />
    <script type="text/javascript" src="jquery-ui/jquery.js" />


    <script>
        CKEDITOR.replace( 'editor1' );
    </script>
    <script type="text/javascript">

        $(document).ready(function() {
            $("#loginForm").validate({
                rules: {
                    UserLoginName: {
                        required: true,
                        UserLoginName: true
                    },

                    Password: "required",
                },

                alertMessages: {
                    UserLoginName: {
                        required: "Please enter UserName",
                        UserLoginName: "Please enter a valid UserName"
                    },

                    Password: "Please enter password"
                }
            });

        });
    </script>

</head>
<body>

<%
    String alertMessage = null;
    String sessionID = null;
    Cookie[] cookies = request.getCookies();
    if(cookies != null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("alertMessage")) alertMessage = cookie.getValue();
            if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
        }
    }
    else
    {
        alertMessage="";
    }
%>
<div class="container">

    <div class="login-container">
        <form action="<%=request.getContextPath()%>/LoginServlet" method="post">
            <img class="avatar" src="bootstrap/image/profile.svg">
            <h2>Welcome</h2>

            <div class="input-div one focus">
                <div class="i">
                    <i class="fas fa-user"></i>
                </div>
                <div>
                    <h5>Login Name</h5>
                    <input class="input" type="text" name="UserLoginName">
                </div>
            </div>

            <div class="input-div two focus">
                <div class="i">
                    <i class="fa fa-lock"></i>
                </div>
                <div>
                    <h5>Password</h5>
                    <input class="input" type="password" name="Password">
                </div>
            </div>
            <input type="submit" class="btn" value="Login">
            <p style="color: red"><%=alertMessage%></p>
        </form>
    </div>
</div>

</body>
</html>
