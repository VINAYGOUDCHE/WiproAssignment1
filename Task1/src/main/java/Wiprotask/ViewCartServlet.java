package Wiprotask;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ViewCartServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        Cookie[] cookies = req.getCookies();

        out.println("<html><body>");
        out.println("<h2>Your Shopping Cart</h2>");

        boolean hasItems = false;

        if (cookies != null) {
            out.println("<ul>");
            for (Cookie c : cookies) {
                if (c.getName().startsWith("item_")) {
                    out.println("<li>" + c.getValue() + "</li>");
                    hasItems = true;
                }
            }
            out.println("</ul>");
        }

        if (!hasItems) {
            out.println("<p>Your cart is empty.</p>");
        }

        out.println("<a href='cart.html'>Add More Items</a>");
        out.println("</body></html>");
    }
}
