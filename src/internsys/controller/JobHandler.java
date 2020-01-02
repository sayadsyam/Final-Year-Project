package internsys.controller;

//import javax.servlet.RequestDispatcher;
import java.io.IOException;

//import java.util.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;

//import java.text.SimpleDateFormat;
import internsys.model.JobBean;
import internsys.dao.JobDao;
//import java.io.PrintWriter;
/**
 * Servlet implementation class StaffServlet
 */
@WebServlet("/JobHandler")
public class JobHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String CTD = "/company/companyHome.jsp";
	private static String JV = "/company/jobView.jsp";
	private static String JU = "/company/jobUpdate.jsp";
	private static String CA = "/company/companyAccount.jsp";
	private static String ALJ = "/admin/adminListJob.jsp";
	private static String AJU = "/admin/adminJobUpdate.jsp";
	private static String AH = "/admin/adminHome.jsp";
	//private static String STAFFf = "/StaffForm.jsp";
	private JobDao dao;
	String forward = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JobHandler() {
		super();
		dao = new JobDao();
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
		if (action.equalsIgnoreCase("listJob")) {
			String id = request.getParameter("id");
			forward = JV;
			request.setAttribute("jobs", JobDao.viewJobInfo(id));
			
		}else if (action.equalsIgnoreCase("listJobAdmin")) {
			String id = request.getParameter("id");
			forward = ALJ;
			request.setAttribute("jobs", JobDao.viewJobInfo(id));
			
		}else if (action.equalsIgnoreCase("updateJob")){
			System.out.println("Update Job Account");
			
			String id = request.getParameter("id");
			forward = JU;
			JobBean job = dao.getJobById(id);
			request.setAttribute("job", job);	
		}else if (action.equalsIgnoreCase("updateJobAdmin")){
			System.out.println("Update Job Account by Admin");
			
			String id = request.getParameter("id");
			forward = AJU;
			JobBean job = dao.getJobById(id);
			request.setAttribute("job", job);	
		}
		else if (action.equalsIgnoreCase("deleteJob")){
			String id = request.getParameter("id");
			String cid = request.getParameter("cid");
			dao.deleteJobInfo(Integer.parseInt(id));
			forward = JV;
			request.setAttribute("jobs", JobDao.viewJobInfo(cid));
		}else if (action.equalsIgnoreCase("deleteJobAdmin")){
			String id = request.getParameter("id");
			String cid = request.getParameter("cid");
			dao.deleteJobInfo(Integer.parseInt(id));
			forward = ALJ;
			request.setAttribute("jobs", JobDao.viewJobInfo(cid));
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
		JobBean job = new JobBean();
		String jobid = request.getParameter("jobid");
		String jobname = request.getParameter("jobname");
		String jobstatus = request.getParameter("jobstatus");
		String joballowance = request.getParameter("joballowance");
		String jobdesc = request.getParameter("jobdesc");
		String comid = request.getParameter("comid");
		String user = request.getParameter("user");
		
		System.out.println("Job allowance :" + joballowance);
		
			// StaffDAO s = new StaffDAO();
		try {
			
			job.setJobid(jobid);
			job.setJobname(jobname);
			job.setJobstatus(jobstatus);
			job.setJoballowance(joballowance);
			job.setJobdesc(jobdesc);
			job.setComid(comid);
			
			System.out.println(jobid);
//			PrintWriter pw =response.getWriter();
			
			if (jobid == null || jobid.isEmpty()) {
				
				dao.addJobInfo(job);
				
				System.out.print("HAAI");
				//forward = "/loginpage.jsp";
				//request.setAttribute("users", StaffDAO.viewStaffInfo());
				RequestDispatcher view = request.getRequestDispatcher(CTD);
				view.forward(request, response);
				
			}
			else{
				job.setJobid(jobid);
				System.out.print("HAAI ni update");
				dao.updateJobInfo(job);
				
				System.out.print("HAAI");
				
				//request.setAttribute("users", StaffDAO.viewStaffInfo());
				
				if(user.equalsIgnoreCase("admin")){
					RequestDispatcher view = request.getRequestDispatcher(AH);
					view.forward(request, response);
				}else{
				RequestDispatcher view = request.getRequestDispatcher(CTD);
				view.forward(request, response);
				}
			}
			
			
			
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}

	// get all user
	
}
