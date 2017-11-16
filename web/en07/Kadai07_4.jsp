<%-- 
    Document   : Kadai07_4
    Created on : 2017/11/16, 15:26:00
    Author     : try
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    String getDate() {
        SimpleDateFormat sdf
                = new SimpleDateFormat("yyyy年MM月dd日");
        return sdf.format(new Date());
    }
%>

<%!
    int year,month,day;
    int getAge(int year, int  month,int day) {
    int age;
Date date=new Date();

    Calendar cal = Calendar.getInstance();
    
    age=cal.get(Calendar.YEAR);
    age=age-year;
    

      //  int age = Calendar.YEAR - year;
        if (cal.get(Calendar.MONTH)<= month || cal.get(Calendar.MONTH+1) == month && cal.get(
                Calendar.DATE) < day) {
            
            age--;
        }
       
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        
        return age;
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Kadai07_4.jsp</h1>
        誕生日:1994年10月31日<br>

        <%=getDate()%>現在で<%=getAge(1998, 11, 31) %>歳です

    </body>
</html>
