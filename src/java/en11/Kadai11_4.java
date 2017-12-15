/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package en11;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author try
 */
@WebServlet(name = "Kadai11_4", urlPatterns = {"/en11/Kadai11_4"})
public class Kadai11_4 extends HttpServlet {

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
            out.println("<title>Servlet Kadai11_4</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Kadai11_4 at " + request.getContextPath() + "</h1>");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String driverUrl = "jdbc:derby://localhost:1527/shop";
            con = DriverManager.getConnection(driverUrl, "db", "db");
            stmt = con.createStatement();
            request.setCharacterEncoding("UTF-8");
            String name = request.getParameter("name");
            String price = request.getParameter("price");
            String stock = request.getParameter("stock");
            String sql2 = "insert into T_ITEM (itemname,price,stock) values (?,?,?)";
            ps = con.prepareStatement(sql2);
            ps.setString(1, name);
            ps.setInt(2, Integer.parseInt(price));
            ps.setInt(3, Integer.parseInt(stock));

            int count = ps.executeUpdate();

            String sql = "select * from T_ITEM";
            ResultSet rs = stmt.executeQuery(sql);
            List<Item> ilist = new ArrayList<>();
           int id=0;
           String nameString;
           int price1=0;
           int stock1=0;
            while (rs.next()) {
                Item it = new Item(id, name, price1, stock1);
                id=rs.getInt("item_id");
                name=rs.getString("itemname");
                price1=rs.getInt("price");
                stock1=rs.getInt("stock");

                ilist.add(it);

            }
            Item i=new Item(id, name, price1, stock1);
            out.println("データベースに下記のデータ<br>"+i+"<br>を埋め込みました");
               out.println("<p><a href=\"Kadai11_4.html\">戻る</a></p>");
            rs.close();
            // Item it = new Item(rs.getInt("item_id"), rs.getString("itemname"),
            //               rs.getInt("price"), rs.getInt("stock"));

            for (Item item : ilist) {

                out.println("item_id=" + item.getItem_id() + "<br>");
                out.println("ITEMNAME=" + item.getItemname() + "<br>");
                out.println("PRICE=" + item.getPrice() + "<br>");
                out.println("STOCK=" + item.getStock() + "<hr>");
            }
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
