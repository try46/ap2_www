<%-- 
    Document   : Kadai11_2
    Created on : 2017/12/14, 15:21:11
    Author     : try
--%>

<%@page import="en11.Human"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Kadai11_2.jsp</h3>
        <%
            Human hm=(Human)request.getAttribute("hm");
            %>
            <%=hm.getName()%>(<%=hm.getAge()%>)<%=hm.getKind()%>
    </body>
</html>
