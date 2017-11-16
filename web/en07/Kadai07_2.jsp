<%-- 
    Document   : Kadai07_2
    Created on : 2017/11/16, 15:13:21
    Author     : try
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    double volume(int r, int h) {
        return Math.PI * r * r * h;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Kadai07_2.jsp</h1>
        半径3,高さ7の円柱の体積は<%=volume(3, 7)%>です。<br>
        半径3,高さ7の円柱の体積は<%=String.format("%.2f", volume(3, 7))%>です。

    </body>
</html>
