
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class delete extends HttpServlet
{

   @Override
   public void doPost(HttpServletRequest req,HttpServletResponse res)
   {
       System.out.print("hello");
       String name=req.getParameter("name");
       System.out.println(name);
       try{
       PrintWriter p=res.getWriter();
        p.println(name);
       }
       catch(Exception e)
       {
           
       }
       
      
   }
}