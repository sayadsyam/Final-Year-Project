package internsys.controller;

//import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;

import java.text.SimpleDateFormat;

import internsys.model.StudentBean;
import internsys.model.InternInfoBean;
import internsys.dao.InternInfoDao;
import internsys.dao.JobDao;
import internsys.dao.StudentDao;

import java.io.PrintWriter;
/**
 * Servlet implementation class StaffServlet
 */
@WebServlet("/StudentHandler")
@MultipartConfig(maxFileSize = 16177215)
public class StudentHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String STD = "/student/studentHome.jsp";
	private static String STDU = "/student/studentUpdate.jsp";
	private static String STDV = "/student/studentProfile.jsp";
	private static String CVS = "/company/comViewStd.jsp";
	private static String ALS = "/admin/adminListStd.jsp";
	private static String ASU = "/admin/adminStdUpdate.jsp";
	private static String AVS = "/admin/adminViewStd.jsp";
	private static String AH = "/admin/adminHome.jsp";
	private static String Log = "/logout.jsp";
	private StudentDao dao;
	String forward = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentHandler() {
		super();
		dao = new StudentDao();
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
		if (action.equalsIgnoreCase("updateStd")){
			System.out.println("OHOI");
			
			String id = request.getParameter("id");
			forward = STDU;
			StudentBean std = dao.getStdById(id);
			request.setAttribute("std", std);	
		}else if (action.equalsIgnoreCase("updateStdAdmin")){
			System.out.println("OHOI");
			
			String id = request.getParameter("id");
			forward = ASU;
			StudentBean std = dao.getStdById(id);
			request.setAttribute("std", std);	
		}else if (action.equalsIgnoreCase("getStd")){
			System.out.println("OHOI");
			
			String id = request.getParameter("id");
			forward = STDV;
			StudentBean std = dao.getStdById(id);
			request.setAttribute("std", std);	
		}else if (action.equalsIgnoreCase("getStdByIdCom")){
			
			String id = request.getParameter("id");
			System.out.println("Company nak display studdent" + id);
			
			forward = CVS;
			InternInfoDao dao2 = new InternInfoDao();
			String id2 = request.getParameter("id2");
			
			InternInfoBean intern = dao2.getAppById(id2);
			
			request.setAttribute("intern", intern);	
			StudentBean std = dao.getStdById(id);
			request.setAttribute("std", std);	
		}else if (action.equalsIgnoreCase("getStdByIdAdmin")){
			
			
			String id = request.getParameter("id");
			System.out.println("Id nak display studdent" + id);
			
			forward = AVS;
			StudentBean std = dao.getStdById(id);
			request.setAttribute("std", std);	
		}
		else if (action.equalsIgnoreCase("listStdAdmin")){
			forward = ALS;
			request.setAttribute("stds", StudentDao.viewStudentInfo());
		}else if (action.equalsIgnoreCase("deleteStd")){
			String id = request.getParameter("id");
			dao.deleteStudentInfo(Integer.parseInt(id));
			forward = Log;
		}else if (action.equalsIgnoreCase("deleteStdAdmin")){
			String id = request.getParameter("id");
			dao.deleteStudentInfo(Integer.parseInt(id));
			forward = ALS;
			request.setAttribute("stds", StudentDao.viewStudentInfo());
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
		StudentBean std = new StudentBean();
		String stdid = request.getParameter("stdid");
		String stdfname = request.getParameter("stdfname");
		String stdlname = request.getParameter("stdlname");
		String stdpass = request.getParameter("stdpass");
		String stdemail = request.getParameter("stdemail");
		String stdaddress = request.getParameter("stdaddress");
		String stdcgpa = request.getParameter("stdcgpa");
		String stdphone = request.getParameter("stdphone");
		String stdgender = request.getParameter("stdgender");
		String std_dob = request.getParameter("stddob");
		String stdmatric = request.getParameter("stdmatric");
		String stdprogram = request.getParameter("stdprogram");
		
		System.out.println(stdfname + "ooii " + stdlname);
		
		
		

			// StaffDAO s = new StaffDAO();
		try {
			
			
			std.setStdfname(stdfname);
			std.setStdlname(stdlname);
			std.setStdpass(stdpass);
			std.setStdemail(stdemail);
			std.setStdaddress(stdaddress);
			std.setStdcgpa(stdcgpa);
			std.setStdphone(stdphone);
			std.setStdgender(stdgender);
			std.setStdmatric(stdmatric);
			std.setStdprogram(stdprogram);
			Part resume = request.getPart("file_uploaded");
			
			
			if (resume != null) 
            {
                System.out.println(resume.getName());
                System.out.println(resume.getSize());
                System.out.println(resume.getContentType());
            } 
			
			std.setResume(resume);
			PrintWriter pw =response.getWriter();
			
			if (stdid == null || stdid.isEmpty()) {
				//System.out.println(resume);
				dao.addStudentInfo(std);
				
				System.out.print("HAAI");
				forward = "/loginpage.jsp";
				//request.setAttribute("users", StaffDAO.viewStaffInfo());
				RequestDispatcher view = request.getRequestDispatcher(forward);
				view.forward(request, response);
				
			}
			else{
				std.setStdid(stdid);
				System.out.print("HAAI ni update");
				dao.updateStdInfo(std);
				
				System.out.print("HAAI");
				//request.setAttribute("users", StaffDAO.viewStaffInfo());
				
					RequestDispatcher view = request.getRequestDispatcher("student/studentHome.jsp");
					view.forward(request, response);
				
			}
			
			
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}

	// get all user
	
}
