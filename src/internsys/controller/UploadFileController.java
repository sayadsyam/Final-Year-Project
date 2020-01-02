package internsys.controller;
import internsys.connection.ConnectionManager;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;

@WebServlet("/UploadFileController")
@MultipartConfig(maxFileSize = 16177215)

public class UploadFileController extends HttpServlet 
{
	
	static Connection currentCon = null;
	static ResultSet rs = null;
	static Statement stmt = null;
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
        
                InputStream inputStream = null;

                //Random rand = new Random();
                //int  n = rand.nextInt(9999) + 1;
               // String idTemp=(String.valueOf(n));

                
                //String title=(request.getParameter("title"));
                Part filePart = request.getPart("file_uploaded");
                
                if (filePart != null) 
                {
                    System.out.println(filePart.getName());
                    System.out.println(filePart.getSize());
                    System.out.println(filePart.getContentType());

                    inputStream = filePart.getInputStream();
                }
        
                try 
                {
                   
                    currentCon = ConnectionManager.getConnection();
                    System.out.print("masuk insert");
                    
                    String sql = "INSERT INTO apply(resume) values (?)";
                    PreparedStatement statement = currentCon.prepareStatement(sql);
                    //statement.setBlob(1, inputStream);
                   // statement.setString(1, idTemp);
                    //statement.setString(2, title);
             
                    if (inputStream != null) 
                    {
                        statement.setBinaryStream(1, inputStream, (int) filePart.getSize());
                    }
                    
                    int row = statement.executeUpdate();
                    if (row > 0) 
                    {
                        out.println("File uploaded!!!");
                        
                        currentCon.close();
                        
                        RequestDispatcher rs = request.getRequestDispatcher("upload_form.jsp");
                        rs.include(request, response);
                    }
                    else
                    {
                        out.println("Couldn't upload your file!!!");
                        
                        currentCon.close();
                        
                        RequestDispatcher rs = request.getRequestDispatcher("upload_form.jsp");
                        rs.include(request, response);
                    }    

                }catch(Exception e){e.printStackTrace();}     
    }   
}