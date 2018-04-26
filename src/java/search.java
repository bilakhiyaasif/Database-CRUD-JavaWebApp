/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.*;
import javax.sql.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;


/**
 *
 * @author Bilakhiya
 */
public class search extends HttpServlet {

    protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
    {
     String name=req.getParameter("name");
     resp.setContentType("text/html");
    
     PrintWriter write=resp.getWriter();
     write.print("<body style='color:white;background:black;'>");
    
     
  
  try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/database_student","root","");
        Statement stmt=cn.createStatement();
        String sql="select * from student where sname='"+name+"' ";
        // q = "select * from users_sys where u_nm='" + name + "' && u_pass='" + password + "' "; 
        ResultSet rs=stmt.executeQuery(sql);
        int sno=0;
        String sname="",sbranch="",sclass="",saddr="";
        
        
        if(rs.next())
        {
            sno=rs.getInt("sid");
            sname=rs.getString("sname");
            sbranch=rs.getString("sbranch");
            sclass=rs.getString("sclass");
            saddr=rs.getString("saddr");
        }
       
        else
        {
            write.print("Record Not Found");
        }
        write.print("<div>");
        write.print("<table style='border-collapse:collapse;padding:5px' border=1>");
        write.print("<tr>");
        write.print("<td>"+sno+"</td>");
        
        write.print("<td>"+sname+"</td>");
        write.print("<td>"+sbranch+"</td>");
        write.print("<td>"+sclass+"</td>");
        write.print("<td>"+saddr+"</td>");
        write.print("</tr>"+"</table>");
        write.print("</div>");
  }
  
   catch (Exception e) {
          write.println(e);
  }
}
}

