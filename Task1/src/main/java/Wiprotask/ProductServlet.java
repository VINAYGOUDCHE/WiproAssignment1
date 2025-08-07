package Wiprotask;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ProductServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String product = req.getParameter("product");
        int price = 0;

        switch (product) {
            case "Pen": price = 10; break;
            case "Notebook": price = 50; break;
            case "Bag": price = 300; break;
        }

        out.println("<html><body>");
        out.println("<h2>Enter Quantity</h2>");
        out.println("<form action='order' method='post'>");
        out.println("Quantity: <input type='number' name='quantity'><br><br>");
        out.println("<input type='hidden' name='product' value='" + product + "'>");
        out.println("<input type='hidden' name='price' value='" + price + "'>");
        out.println("<input type='submit' value='Place Order'>");
        out.println("</form></body></html>");
    }
}
