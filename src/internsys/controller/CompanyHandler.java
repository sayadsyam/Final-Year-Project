package internsys.controller;

//import javax.servlet.RequestDispatcher;
import java.io.IOException;


//import java.util.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;

//import java.text.SimpleDateFormat;
import internsys.model.CompanyBean;
import internsys.dao.CompanyDao;
import internsys.dao.JobDao;
//import java.io.PrintWriter;
/**
 * Servlet implementation class StaffServlet
 */
@WebServlet("/CompanyHandler")
public class CompanyHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String CTD = "/company/companyHome.jsp";
	private static String CU = "/company/companyUpdate.jsp";
	private static String CA = "/company/companyAccount.jsp";
	private static String ALC = "/admin/adminListCom.jsp";
	private static String ACU = "/admin/adminComUpdate.jsp";
	private static String AH = "/admin/adminHome.jsp";
	//private static String STAFFf = "/StaffForm.jsp";
	private CompanyDao dao;
	String forward = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompanyHandler() {
		super();
		dao = new CompanyDao();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	    String action = request.getParameter("action");
		System.out.println(action);
		if (action.equalsIgnoreCase("listComAdmin")) {
			forward = ALC;
			request.setAttribute("coms", CompanyDao.viewComInfo());
			
		}else if (action.equalsIgnoreCase("updateCom")){
			System.out.println("Update Company Account");
			
			String id = request.getParameter("id");
			forward = CU;
			CompanyBean com = dao.getComById(id);
			request.setAttribute("com", com);	
		}else if (action.equalsIgnoreCase("updateComAdmin")){
			System.out.println("Update Company Account by Admin");
			
			String id = request.getParameter("id");
			forward = ACU;
			CompanyBean com = dao.getComById(id);
			request.setAttribute("com", com);	
		}else if (action.equalsIgnoreCase("getCom")){
			System.out.println("Get company by id");
			
			String id = request.getParameter("id");
			forward = CA;
			CompanyBean com = dao.getComById(id);
			request.setAttribute("com", com);	
		}else if (action.equalsIgnoreCase("deleteCom")){
			String id = request.getParameter("id");
			dao.deleteComInfo(Integer.parseInt(id));
			forward = "/logout.jsp";
		}else if (action.equalsIgnoreCase("deleteComAdmin")){
			String id = request.getParameter("id");
			dao.deleteComInfo(Integer.parseInt(id));
			forward = ALC;
			request.setAttribute("coms", CompanyDao.viewComInfo());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		CompanyBean com = new CompanyBean();
		String comid = request.getParameter("comid");
		String comname = request.getParameter("comname");
		String comaddress = request.getParameter("comaddress");
		String comdesc = request.getParameter("comdesc");
		String compass = request.getParameter("compass");
		String comemail = request.getParameter("comemail");
		String comstate = request.getParameter("comstate");
		String comphone = request.getParameter("comphone");
		String comfax = request.getParameter("comfax");
		String usertype = request.getParameter("usertype");
		String user = request.getParameter("user");
		
		
		System.out.println(comname + " " + comname);
		
		
		
		

			// StaffDAO s = new StaffDAO();
		try {
			
			com.setComid(comid);
			com.setComname(comname);
			com.setComaddress(comaddress);
			com.setComdesc(comdesc);
			com.setCompass(compass);
			com.setComemail(comemail);
			com.setComstate(comstate);
			com.setComphone(comphone);
			com.setComfax(comfax);
			com.setUsertype(usertype);
			
//			PrintWriter pw =response.getWriter();
			
			if (comid == null || comid.isEmpty()) {
				
				dao.addCompanyInfo(com);
				
				System.out.print("HAAI");
				forward = "/loginpage.jsp";
				//request.setAttribute("users", StaffDAO.viewStaffInfo());
				RequestDispatcher view = request.getRequestDispatcher(forward);
				view.forward(request, response);
				
			}
			else{
				com.setComid(comid);
				System.out.print("HAAI ni update");
				dao.updateComInfo(com);
				
				System.out.print("HAAI");
				
				//request.setAttribute("users", StaffDAO.viewStaffInfo());
				
				RequestDispatcher view = request.getRequestDispatcher(CTD);
				view.forward(request, response);
				
			}
			
			
			
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}

	// get all user
	
}
