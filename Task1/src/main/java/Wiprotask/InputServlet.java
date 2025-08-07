package Wiprotask;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class InputServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Get input from form
        String name = req.getParameter("name");
        int marks = Integer.parseInt(req.getParameter("marks"));

        // Set attributes to send to next servlet
        req.setAttribute("name", name);
        req.setAttribute("marks", marks);

        // Forward request to GradeServlet
        RequestDispatcher rd = req.getRequestDispatcher("grade");
        rd.forward(req, res);
    }
}
