package Wiprotask;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class BalanceServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        HttpSession session = req.getSession(false);

        if (session != null && session.getAttribute("name") != null) {
            String name = (String) session.getAttribute("name");
            String balance = (String) session.getAttribute("balance");

            out.println("<html><body>");
            out.println("<h2>Welcome, " + name + "</h2>");
            out.println("<p>Your balance is: Rs. " + balance + "</p>");
            out.println("<a href='logout'>Logout</a>");
            out.println("</body></html>");
        } else {
            res.sendRedirect("login.html");
        }
    }
}
