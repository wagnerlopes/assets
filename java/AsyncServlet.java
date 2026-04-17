package org.techzoo.async;
 
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/async")
public class AsyncServlet extends HttpServlet {
 
  public AsyncServlet() {
    super();
  }
 
  @Override
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
    throws ServletException, IOException {
 
    String heardeName = request.getHeader("x-requested-with");
     
    if(null == heardeName){
      PrintWriter out = response.getWriter();
      String html = "<h3>Clinet send a Synchronous request</h3>" +
        "<p><a href=\"index.jsp\">Go Back</a> to main page</p>";
      out.write(html);
    }
    else {
      ServletOutputStream out = response.getOutputStream();
      out.print("Ajax Request Detected");
      out.flush();
    }
  }
 
}
