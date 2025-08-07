package Wiprotask;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class OrderServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String product = req.getParameter("product");
        int price = Integer.parseInt(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int total = price * quantity;

        out.println("<html><body>");
        out.println("<h2>Order Receipt</h2>");
        out.println("<p>Product: " + product + "</p>");
        out.println("<p>Price: " + price + "</p>");
        out.println("<p>Quantity: " + quantity + "</p>");
        out.println("<p><strong>Total: Rs. " + total + "</strong></p>");
        out.println("</body></html>");
    }
}
