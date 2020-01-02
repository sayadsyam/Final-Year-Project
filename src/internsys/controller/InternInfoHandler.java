package internsys.controller;

//import javax.servlet.RequestDispatcher;
import java.io.IOException;


//import java.util.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.text.SimpleDateFormat;

//import java.text.SimpleDateFormat;
import internsys.model.InternInfoBean;
import internsys.dao.InternInfoDao;
import internsys.dao.JobDao;
//import java.io.PrintWriter;
/**
 * Servlet implementation class StaffServlet
 */
@WebServlet("/InternInfoHandler")
public class InternInfoHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String JL = "/student/jobList.jsp";
	private static String JD = "/student/jobDesc.jsp";
	private static String JA = "/student/jobApply.jsp";
	private static String SH = "/student/studentHome.jsp";
	private static String AV = "/student/applicationView.jsp";
	private static String AU = "/student/applicationUpdate.jsp";
	private static String CV = "/company/comViewApp.jsp";
	private static String ALA = "/admin/adminListApp.jsp";
	private static String AAU = "/admin/adminAppUpdate.jsp";
	private static String AH = "/admin/adminHome.jsp";
	
	//private static String STAFFf = "/StaffForm.jsp";
	private InternInfoDao dao;
	String forward = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InternInfoHandler() {
		super();
		dao = new InternInfoDao();
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
		if (action.equalsIgnoreCase("listIntern")) {
			forward = JL;
			request.setAttribute("interns", InternInfoDao.viewInternInfo());
			
		}else if (action.equalsIgnoreCase("viewApply")) {
			String id = request.getParameter("id");
			forward = AV;
			request.setAttribute("interns", InternInfoDao.viewApplyInfo(id));
			
		}else if (action.equalsIgnoreCase("updateApply")){
			System.out.println("Update Application");
			
			String id = request.getParameter("id");
			forward = AU;
			InternInfoBean intern = dao.getAppById(id);
			request.setAttribute("intern", intern);	
		}else if (action.equalsIgnoreCase("listStdApp")) {
			System.out.println("List out student application for company");
			String id = request.getParameter("id");
			forward = CV;
			request.setAttribute("interns", InternInfoDao.viewApplyInfoCom(id));
			
		}else if (action.equalsIgnoreCase("listAppAdmin")) {
			System.out.println("List out student application for admin");
			String id = request.getParameter("id");
			forward = ALA;
			request.setAttribute("interns", InternInfoDao.viewApplyInfo(id));
			
		}else if (action.equalsIgnoreCase("updateAppAdmin")){
			System.out.println("Update Application");
			
			String id = request.getParameter("id");
			forward = AAU;
			InternInfoBean intern = dao.getAppById(id);
			request.setAttribute("intern", intern);	
		}else if (action.equalsIgnoreCase("view")){
			System.out.println("view job description");
			
			String id = request.getParameter("id");
			
			forward = JD;
			InternInfoBean intern = dao.getInternById(id);
			request.setAttribute("intern", intern);	
		}
		else if (action.equalsIgnoreCase("apply")){
			System.out.println("apply job");
			
			String id = request.getParameter("id");
			
			forward = JA;
			InternInfoBean intern = dao.getInternById(id);
			request.setAttribute("intern", intern);	
		}else if (action.equalsIgnoreCase("deleteApply")){
			String id = request.getParameter("id");
			dao.deleteApplyInfo(Integer.parseInt(id));
			forward = AV;
			request.setAttribute("intern", InternInfoDao.viewApplyInfo(id));
		}else if (action.equalsIgnoreCase("deleteAppAdmin")){
			String id = request.getParameter("id");
			dao.deleteApplyInfo(Integer.parseInt(id));
			forward = ALA;
			request.setAttribute("interns", InternInfoDao.viewApplyInfoCom(id));
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
		InternInfoBean intern = new InternInfoBean();
		String appid = request.getParameter("appid");
		String appstatus = request.getParameter("appstatus");
		String stdid = request.getParameter("stdid");
		String stdname = request.getParameter("stdname");
		String jobid = request.getParameter("jobid");
		String jobname = request.getParameter("jobname");
		String start_date = request.getParameter("startdate");
		String end_date = request.getParameter("enddate");
		String confirmation = request.getParameter("confirmation");
		String comid = request.getParameter("comid");
		String comname = request.getParameter("comname");
		String interviewstatus = request.getParameter("interviewstatus");
		String comemail = request.getParameter("comemail");
		
		
		
		
		SimpleDateFormat parsedate = new SimpleDateFormat("yyyy-MM-dd");
		
			// StaffDAO s = new StaffDAO();
		try {
			
			java.util.Date dt = (java.util.Date)parsedate.parse(start_date);
			java.sql.Date startdate = new java.sql.Date(dt.getTime());
			
			java.util.Date dt2 = (java.util.Date)parsedate.parse(end_date);
			java.sql.Date enddate = new java.sql.Date(dt2.getTime());
			
			
			intern.setAppid(appid);
			
			intern.setStdid(stdid);
			intern.setStdname(stdname);
			intern.setJobid(jobid);
			intern.setJobname(jobname);
			intern.setStartdate(startdate);
			intern.setEnddate(enddate);
			intern.setConfirmation(confirmation);
			intern.setComid(comid);
			intern.setComname(comname);
			intern.setInterviewstatus(interviewstatus);

			//System.out.println(expertise);
//			PrintWriter pw =response.getWriter();
			
			if (appid == null || appid.isEmpty()) {
			//if (intern.isValid()) {
				
				if(appstatus == null){	
					intern.setComemail(comemail);
					dao.addApplyInfo(intern);
					
					System.out.print("Masuk insert application");
					//forward = "/loginpage.jsp";
					//request.setAttribute("users", StaffDAO.viewStaffInfo());
					
					RequestDispatcher view = request.getRequestDispatcher(SH);
					view.forward(request, response);
					}else if(appstatus.equalsIgnoreCase("Accept") || appstatus.equalsIgnoreCase("Reject"))
				{
					System.out.println("Hai ni tukar status");
					dao.updateApplyStatus(appstatus,stdid);
					
					RequestDispatcher view = request.getRequestDispatcher("company/companyHome.jsp");
					view.forward(request, response);
				}
			}
			else{
				System.out.print("HAAI");
				//request.setAttribute("intern", I.viewStaffInfo());
					
				
					intern.setAppid(appid);
					intern.setAppstatus(appstatus);
					System.out.print("HAAI ni update");
					dao.updateApplyInfo(intern);
					RequestDispatcher view = request.getRequestDispatcher(SH);
					view.forward(request, response);
				
				
			}
			
			
			
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}

	// get all user
	
}
