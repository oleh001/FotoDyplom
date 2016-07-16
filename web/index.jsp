<%@ page import="configuration.Configure" %>
<%@ page import="controller.Controller" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="model.Picture" %>
<%@ page import="java.awt.*" %>
<%@ page import="model.LoadFotoThread" %>
<%@ page import="java.io.PrintWriter" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 03.07.2016
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Controller controller = new Controller();
    Configure configure = Configure.getConfigure();
%>

<!DOCTYPE HTML>
<html>
<head>
    <title><%out.println(configure.getTitle());%></title>
    <link href="images/logotyp.ico" type="image/x-icon" rel="icon">
</head>
<body>
<%@include file="views/strukture/Header.jsp" %>

<h3>File Upload:</h3>
Select a file to upload: <br/>
<form action="uploadFile.jsp" method="post" enctype="multipart/form-data">
    <input type="file" name="file" id="file" size="50" accept="image/*,image/jpeg,image/png,image/gif"
           onchange="sizeValue(this)"/>
    <p id="err">&nbsp;</p>
    <br/>
    <input type="submit" disabled="disabled" id="submit" value="Upload File"/>
</form>
<script type="text/javascript">
    function sizeValue(val) {
        if (val.files[0].size / 1024 / 1024 > 5) {
            var error = "This file size is: " + val.files[0].size / 1024 / 1024 + "MB" + " > 5MB";
            $("#err").css("color", "red");
            $("#err").append(error);
        } else {
            $("#err").css("color", "green");
            $("#err").text("This file size is: " + val.files[0].size / 1024 / 1024 + "MB" + " < 5MB");
            $("#submit").removeAttr("disabled");
        }
        <%--if (<%out.println(configure.isFoto_colors());%>) {--%>
        <%--alert("true");--%>
        <%--} else {--%>
        <%--// var error = "Pleas weating...";--%>
        <%--//$("#err").css("color", "red");--%>
        <%--//$("#err").append(error);--%>
        <%--//            alert("fg");--%>
        <%--setTimeout(sizeValue(val), 1000);--%>

        <%--}--%>
    }
//    ;


</script>

<%
    if (configure.isFoto_true()) {
        int p = configure.getFoto_original_width() > configure.getFoto_max_width_in_window()
                ? configure.getFoto_max_width_in_window() : configure.getFoto_original_width();
        out.println(configure.getFoto_original_path());

        out.println("<img src = 'images/" + configure.getFoto_original_name()
                + "' width='" + p + "px' alt='Your Foto' title='Your Foto'>");
    } else {
        //out.println(configure.getFoto_original_path());
    }
%>

<%


    //    if (configure.isFoto_true() && configure.isFoto_colors()) {
    if (configure.isFoto_true()) {
        Picture picture = controller.getPicture();
        //picture.setImage();
        //picture.setPixelsColor();
        picture.CopyPicture();

//        Color[][] colors = picture.getColors();
//        int x = picture.getImageWidthOrig();
//        int y = picture.getImageHeightOrig();
//        for (int j = 0; j < y; j++) {
//            out.println("</br>");
//            for (int i = x-1; i < x; i++) {
//                out.print("r=" + colors[i][j].getRed() + ", g=" + colors[i][j].getGreen() + ", b=" + colors[i][j].getBlue() + "; ");
////                out.print("r=" + picture.getColors()[i][j]);
//            }
//        }

    }
%>


<script type="text/javascript">
    <%@include file="js/jquery-3.0.0.min.js" %>
</script>
</body>
</html>
