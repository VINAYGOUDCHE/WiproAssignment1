package Wiprotask;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.UUID;

public class AddToCartServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String item = req.getParameter("item");

        // Generate unique cookie name to avoid overwriting
        String cookieName = "item_" + UUID.randomUUID().toString();
        Cookie cookie = new Cookie(cookieName, item);
        cookie.setMaxAge(60 * 60); // 1 hour

        res.addCookie(cookie);

        out.println("<html><body>");
        out.println("<h3>" + item + " added to cart!</h3>");
        out.println("<a href='cart.html'>Add More</a><br>");
        out.println("<a href='viewcart'>View Cart</a>");
        out.println("</body></html>");
    }
}
