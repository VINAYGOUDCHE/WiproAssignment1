package Wiprotask;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String rollno = request.getParameter("rollno");
        String branch = request.getParameter("branch");
        String section = request.getParameter("section");

        out.println("<html><body>");
        out.println("<h2>Student Registration Details</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Roll No: " + rollno + "</p>");
        out.println("<p>Branch: " + branch + "</p>");
        out.println("<p>Section: " + section + "</p>");
        out.println("</body></html>");
    }
}
