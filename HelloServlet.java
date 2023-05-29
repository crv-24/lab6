package com.example.lab6;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.servlet.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html; charset=UTF8");
        PrintWriter out = response.getWriter();

        try {

            String header = request.getParameter("header");
            int rows = Integer.parseInt(request.getParameter("rows"));
            int columns = Integer.parseInt(request.getParameter("columns"));
            String color = request.getParameter("color");

            out.println("<html>");
            out.println("<head><title>"+header+"</title></head>");
            out.println("<body>");
            out.println("<br>");
            out.println("<center>");
            out.println("<h2>" + header + "</h2>");
            out.println("</center>");
            out.println("<center><table style='background-color:"+color+";' border=1; cellspacing = 5; cellpadding = 5>");
            for (int i=0; i < rows; i++) {
                out.println("<tr>");
                for (int j=0; j < columns; j++) {
                    out.println("<td>"+i+"/"+j+"</td>");
                }
                out.println("</tr>");
            }
            out.println("</center></table>");

            out.println("</body></html>");
        } finally {
            out.close();
        }
    }
}