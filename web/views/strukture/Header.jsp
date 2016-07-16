<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 03.07.2016
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul class="menu">
    <%
        try {
            ResultSet resultSet = controller.getResultSet();
            while (resultSet.next()) {
                out.println("<li>");
                String page_id = resultSet.getString("page_id");
                String title = resultSet.getString("title");

                out.println("<a href=FydziamaInJava/web/page/" + page_id + ">" + title + "</a>");

                out.println("</li>");
            }
        } catch (SQLException e) {
            out.println("Don't Select from Pages");
        }
    %>
</ul>

