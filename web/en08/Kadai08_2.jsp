<%-- 
    Document   : Kadai08_2
    Created on : 2017/11/23, 15:48:40
    Author     : try
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>アンケート結果</h1>
        <hr>
        名前:<%=request.getParameter("name")%><br>
        
        製品名:<%=request.getParameter("seihin")%><br>
        評価:<%=request.getParameter("radio")%><br>
        自由意見:<br>
       <%=request.getParameter("textarea")%>
    </body>
</html>
