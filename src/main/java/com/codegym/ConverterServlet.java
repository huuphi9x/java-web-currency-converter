package com.codegym;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ConverterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String display = "<head>\n" +
                "    <title>Currency Converter</title>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2>Currency Converter</h2>\n" +
                "<form method=\"post\" action=\"/converter\">\n" +
                "    <label>Rate: </label><br/>\n" +
                "    <input type=\"text\" name=\"rate\" placeholder=\"RATE\" value=\"22000\"/><br/>\n" +
                "    <label>USD: </label><br/>\n" +
                "    <input type=\"text\" name=\"usd\" placeholder=\"USD\" value=\"0\"/><br/>\n" +
                "    <input type = \"submit\" id = \"submit\" value = \"Converter\"/>\n" +
                "</form>\n" +
                "</body>";
        resp.getOutputStream().println(display);
        resp.setContentType("text/html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float rate = Float.parseFloat(req.getParameter("rate"));
        float usd = Float.parseFloat(req.getParameter("usd"));

        float vnd = rate * usd;
        resp.getOutputStream().println("VND: "+ vnd);
    }
}
