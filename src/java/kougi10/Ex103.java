/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kougi10;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author try
 */
@WebServlet(name = "Ex103", urlPatterns = {"/kougi10/Ex103"})
public class Ex103 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Connection con = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Ex103</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Ex103 at " + request.getContextPath() + "</h1>");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String driverUrl = "jdbc:derby://localhost:1527/meibo";
            con = DriverManager.getConnection(driverUrl, "db", "db");
            stmt = con.createStatement();
            request.setCharacterEncoding("UTF-8");
            String fullname = request.getParameter("fullname");
            String gid = request.getParameter("gid");
            String grade = request.getParameter("grade");
            //sqlの発行(挿入)
            String sql2 = "insert into T_STUDENT_A"
                    + "(fullname,gakubu_id,grade)"
                    + "values(?,?,?)";
            ps = con.prepareStatement(sql2);
            ps.setString(1, fullname);
            ps.setInt(2, Integer.parseInt(gid));
            ps.setInt(3, Integer.parseInt(grade));
            int count = ps.executeUpdate();
            //sql文の発行
            String sql = "select * from T_STUDENT_A";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                out.println("STUDENT_ID=" + rs.getInt("STUDENT_ID") + "<br>");
                out.println("FULLNAME=" + rs.getString("FULLNAME") + "<br>");
                out.println("GAKUBU_ID=" + rs.getInt("GAKUBU_ID") + "<br>");
                out.println("GRADE=" + rs.getInt("GRADE") + "<hr>");
            }
            rs.close();
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            throw new ServletException(e);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new ServletException(e);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException es) {
                    throw new ServletException(es);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new ServletException(e);
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
