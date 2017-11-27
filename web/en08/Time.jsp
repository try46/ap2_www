<%-- 
    Document   : Time
    Created on : 2017/11/23, 16:11:39
    Author     : try
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<%!String getData(){
     SimpleDateFormat sdf
                = new SimpleDateFormat("yyyy年MM月dd日(E) HH:mm:ss");
        return sdf.format(new Date());
}
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h2>送信時間:<%=getData()%></h2>
    </body>
</html>
