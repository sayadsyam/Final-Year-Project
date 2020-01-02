package internsys.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import internsys.model.StudentBean;
import internsys.dao.StudentDao;
import internsys.model.CompanyBean;
import internsys.dao.CompanyDao;
import internsys.model.AdminBean;
import internsys.dao.AdminDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException 
	{
		try 
		{
			StudentBean student = new StudentBean();
			student.setStdemail(request.getParameter("email"));
			student.setStdpass(request.getParameter("pass"));
			
			
			AdminBean admin = new AdminBean();
			admin.setAdminemail(request.getParameter("email"));
			admin.setAdminpass(request.getParameter("pass"));
			
			
			CompanyBean com = new CompanyBean();
			com.setComemail(request.getParameter("email"));
			com.setCompass(request.getParameter("pass"));
			
			student = StudentDao.login(student);
			admin = AdminDao.login(admin);
			com = CompanyDao.login(com);
			
			if ((student.isValid())&&(student.getUsertype().equalsIgnoreCase("student")))
			{
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", student);
				response.sendRedirect("student/studentHome.jsp"); // logged-in page
			}
			else if((admin.isValid())&&(admin.getUsertype().equalsIgnoreCase("admin")))
			{
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", admin);
				response.sendRedirect("admin/adminHome.jsp"); // logged-in page
			}
			else if((com.isValid())&&(com.getUsertype().equalsIgnoreCase("company")))
			{
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", com);
				response.sendRedirect("company/companyHome.jsp"); // logged-in page
			}
			else
				response.sendRedirect("invalidLogin.jsp"); // error page
			
		}
		
		catch (Throwable theException)
		{
			System.out.println(theException);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
