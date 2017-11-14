<%-- 
    Document   : Ex71
    Created on : 2017/11/14, 11:09:39
    Author     : try
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%!
    String getDate(){
    SimpleDateFormat sdf
            =new SimpleDateFormat("yyyy年MM月dd日");
    return sdf.format(new Date());
}
%>    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            for (int i = 1; i <= 15; i++) {
                    out.println("繰り返し"+i+"回<br>");
                }
            %>
            本日は<%=getDate()%>です<br>
            ここに埋め込みます↓<br>
            <%@include file="Ex72.jsp" %>
            ここまで
    </body>
</html>
