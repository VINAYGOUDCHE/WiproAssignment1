package Wiprotask;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String accno = req.getParameter("accno");
        String pass = req.getParameter("password");

        // Simple hardcoded validation
        if (accno.equals("12345") && pass.equals("12345")) {
            HttpSession session = req.getSession();
            session.setAttribute("name", "Vinay Goud");
            session.setAttribute("balance", "10000");

            res.sendRedirect("balance");
        } else {
            out.println("<html><body>");
            out.println("<h3>Invalid Credentials</h3>");
            out.println("<a href='login.html'>Try Again</a>");
            out.println("</body></html>");
        }
    }
}
