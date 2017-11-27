<%-- 
    Document   : Kadai08_4
    Created on : 2017/11/26, 22:54:08
    Author     : try
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<%!
double calBMI(String weight,String height){
    double ws=Double.parseDouble(weight);
    double hs=Double.parseDouble(height);
    double bmi=ws/((hs/100)*(hs/100));
    return bmi;
    
}
%>
<%
String weight=request.getParameter("weight");
String height=request.getParameter("height");
double BMI=calBMI(weight, height);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <dvi>BMI判定結果</dvi>
    <hr>
    あなたのBMIは<%=BMI%>です。
    <hr>
    <%
    if (BMI<18.5) {
            out.println("<h1>"+"痩せ気味です"+"</h1>");
        }else if(BMI>=25.0){
            out.println("<h1>"+"太り気味です"+"</h1>");
        }else{
        out.println("<h1>"+"標準"+"</h1>");
        }
    %>
    </body>
</html>
