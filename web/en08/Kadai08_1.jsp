<%-- 
    Document   : Kadai08_1
    Created on : 2017/11/23, 15:11:25
    Author     : try
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>基本情報の表示</h1>
        <table border="1">
            <tr>
                <td>名前</td>
                <td><%=request.getParameter("name")%></td>
            </tr>
            <tr>
                <td>住所</td>
                <td><%=request.getParameter("radio")%></td>
            </tr>
            <tr>
                <td>興味</td>
                <td><%
                    for(int i=1;i<=6;i++){
                        String getString=request.getParameter("check"+i);
                        if(getString!=null){
                            out.println(getString+"<br>");
                    }
                    }%></td>
            </tr>
        </table>
    </body>
</html>
