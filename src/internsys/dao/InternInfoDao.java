package internsys.dao;

import internsys.dao.EmailUtil;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import java.sql.*;
import java.sql.Date;

import javax.swing.JOptionPane;

import java.util.*;

import internsys.connection.ConnectionManager;
import internsys.model.InternInfoBean;


public class InternInfoDao {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	
	final String fromEmail = "jasin.eintern@gmail.com"; //requires valid gmail id
	final String password = "jasin1234"; // correct password for gmail id
	
	public static List<InternInfoBean> viewInternInfo() {
		List<InternInfoBean> interns = new ArrayList<InternInfoBean>();
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			ResultSet rs = stmt.executeQuery("select * from company NATURAL JOIN job where jobstatus = 'Available'");

			while (rs.next()) {
				InternInfoBean intern = new InternInfoBean();
				
				intern.setJobid(rs.getString("jobid"));
				intern.setJobname(rs.getString("jobname"));
				intern.setJobstatus(rs.getString("jobstatus"));
				intern.setJoballowance(rs.getString("joballowance"));
				intern.setJobdesc(rs.getString("jobdesc"));
				intern.setComid(rs.getString("comid"));
				intern.setComname(rs.getString("comname"));
				intern.setComemail(rs.getString("comemail"));
				intern.setComaddress(rs.getString("comaddress"));
				intern.setComdesc(rs.getString("comdesc"));
				intern.setComstate(rs.getString("comstate"));
				intern.setJobinterview(rs.getString("jobinterview"));
				interns.add(intern);
				System.out.println(rs.getString("jobid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return interns;
	}
	
	public InternInfoBean getInternById(String id) {
		InternInfoBean intern = new InternInfoBean();
	    try {
	    	currentCon = ConnectionManager.getConnection();
	        ps=currentCon.prepareStatement("select * from company NATURAL JOIN job where jobid = ?");
	        
	        ps.setString(1, id);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {

				
				intern.setJobid(rs.getString("jobid"));
				intern.setJobname(rs.getString("jobname"));
				intern.setJobstatus(rs.getString("jobstatus"));
				intern.setJoballowance(rs.getString("joballowance"));
				intern.setJobdesc(rs.getString("jobdesc"));
				intern.setComemail(rs.getString("comemail"));
				intern.setComid(rs.getString("comid"));
				intern.setComname(rs.getString("comname"));
				intern.setComaddress(rs.getString("comaddress"));
				intern.setComdesc(rs.getString("comdesc"));
				intern.setComstate(rs.getString("comstate"));
				intern.setComphone(rs.getString("comphone"));
				intern.setComfax(rs.getString("comfax"));
				intern.setJobinterview(rs.getString("jobinterview"));
				System.out.print("Haiiiii ini masuk getInternId");
		
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return intern;
	}
	
	public InternInfoBean getAppById(String id) {
		InternInfoBean intern = new InternInfoBean();
	    try {
	    	currentCon = ConnectionManager.getConnection();
	        ps=currentCon.prepareStatement("select * from apply where appid = ?");
	        
	        ps.setString(1, id);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {

				
	        	intern.setAppid(rs.getString("appid"));
				intern.setAppstatus(rs.getString("appstatus"));
				intern.setStdid(rs.getString("stdid"));
				intern.setStdname(rs.getString("stdname"));
				intern.setJobid(rs.getString("jobid"));
				intern.setJobname(rs.getString("jobname"));
				intern.setStartdate(rs.getDate("startdate"));
				intern.setEnddate(rs.getDate("enddate"));
				intern.setConfirmation(rs.getString("confirmation"));
				intern.setComid(rs.getString("comid"));
				intern.setComname(rs.getString("comname"));
				intern.setInterviewstatus(rs.getString("interviewstatus"));
		
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return intern;
	}
	
	// add new order
	public InternInfoBean addApplyInfo(InternInfoBean intern) {

		
		String stdid = intern.getStdid();
		String stdname = intern.getStdname();
		String comname = intern.getComname();
		String comid = intern.getComid();
		String jobid = intern.getJobid();		
		String jobname = intern.getJobname();
		Date enddate = (Date)intern.getEnddate();
		Date startdate = (Date)intern.getStartdate();
		String interviewstatus = intern.getInterviewstatus();
		String confirmation = intern.getConfirmation();
		String toEmail = intern.getComemail();
		
		System.out.println("INSERT INTO APPLY"
				+ "(STDID, STDNAME, JOBID, JOBNAME, INTERVIEWSTATUS, STARTDATE, ENDDATE, CONFIRMATION, COMNAME, COMID, APPSTATUS) "
				+ "VALUES('" + stdid + "','"
				+ stdname + "','" + jobid + "','" + jobname + "','" + interviewstatus + "',TO_DATE('" + startdate +"','DD/MM/YYYY'),TO_DATE('" + enddate + "','DD/MM/YYYY'),'" + confirmation +
				"','" + comname +"','" + comid +"','Not yet approved')");
		
		
		String insertTableSQL = "INSERT INTO APPLY"
				+ "(STDID, STDNAME, JOBID, JOBNAME, INTERVIEWSTATUS, STARTDATE, ENDDATE, CONFIRMATION, COMNAME, COMID, APPSTATUS) "
				+ "VALUES('" + stdid + "','"
				+ stdname + "','" + jobid + "','" + jobname + "','" + interviewstatus + "',TO_DATE('" + startdate +"','YYYY-MM-DD'),TO_DATE('" + enddate + "','YYYY-MM-DD'),'" + confirmation +
				"','" + comname +"','" + comid +"','Not yet approved')";

		try {
			currentCon = ConnectionManager.getConnection();
			// stmt = currentCon.createStatement();
			// System.out.println(insertTableSQL);
			ps = currentCon.prepareStatement(insertTableSQL);
			ps.executeUpdate();
			System.out.println("Record is inserted into Apply table!");
			JOptionPane.showMessageDialog(null,"You have succesfully added a new application!");
			

			/**
			   Outgoing Mail (SMTP) Server
			   requires TLS or SSL: smtp.gmail.com (use authentication)
			   Use Authentication: Yes
			   Port for TLS/STARTTLS: 587
			 */
			
			System.out.println("TLSEmail Start");
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
			props.put("mail.smtp.port", "587"); //TLS Port
			props.put("mail.smtp.auth", "true"); //enable authentication
			props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
			
	                //create Authenticator object to pass in Session.getInstance argument
			Authenticator auth = new Authenticator() {
				//override the getPasswordAuthentication method
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			};
			Session session = Session.getInstance(props, auth);
			
			String messages = "Dear" + comname +", this is to notify you that a student named " + stdname + " had made an application to "
					+ "the job that was offered by your company which the position is" + jobname + ". You can view the student application and profile in the system."
							+ "We hope that your company give the student a careful assessment. Thank you in advance for your cooperation.";
			
			EmailUtil.sendEmail(session, toEmail,"Internship Application", messages);
			
		}

		catch (Exception ex) {
			System.out.println("failed: An Exception has occurred! " + ex);
		}

		finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
				}
				ps = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		
		return intern;
	}

	
	public static List<InternInfoBean> viewApplyInfo(String stdid) {
		List<InternInfoBean> interns = new ArrayList<InternInfoBean>();
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			ResultSet rs = stmt.executeQuery("select * from apply where stdid ='" + stdid + "'");

			while (rs.next()) {
				InternInfoBean intern = new InternInfoBean();
				
				intern.setAppid(rs.getString("appid"));
				intern.setAppstatus(rs.getString("appstatus"));
				intern.setStdid(rs.getString("stdid"));
				intern.setStdname(rs.getString("stdname"));
				intern.setJobid(rs.getString("jobid"));
				intern.setJobname(rs.getString("jobname"));
				intern.setStartdate(rs.getDate("startdate"));
				intern.setEnddate(rs.getDate("enddate"));
				intern.setConfirmation(rs.getString("confirmation"));
				intern.setComid(rs.getString("comid"));
				intern.setComname(rs.getString("comname"));
				intern.setInterviewstatus(rs.getString("interviewstatus"));
				interns.add(intern);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return interns;
	}
	
	public void updateApplyInfo(InternInfoBean bean) {

		//int jobid = Integer.parseInt(bean.getJobid());
		int appid = Integer.parseInt(bean.getAppid());
		//int stdid = Integer.parseInt(bean.getStdid());
		String jobname = bean.getJobname();
		String appstatus = bean.getAppstatus();
		String stdname = bean.getStdname();
		Date enddate = (Date)bean.getEnddate();
		Date startdate = (Date)bean.getStartdate();
		String confirmation = bean.getConfirmation();
		String interviewstatus = bean.getInterviewstatus();
		
		System.out.println("UPDATE apply SET jobname= '" + jobname 
				+ "', appstatus='" + appstatus + "', stdname='" + stdname + ", startdate=TO_DATE('" + startdate +
				"',,'YYYY-MM-DD'), enddate=TO_DATE('" + enddate + "','YYYY-MM-DD'), confirmation='" + confirmation + "' WHERE appid= '" + appid + "'");
		
		String searchQuery = "UPDATE apply SET jobname= '" + jobname 
				+ "', appstatus='" + appstatus + "', interviewstatus='" + interviewstatus + "', stdname='"  +  stdname + "', startdate=TO_DATE('" + startdate +
				"','YYYY-MM-DD'), enddate=TO_DATE('" + enddate + "','YYYY-MM-DD'), confirmation='" + confirmation + "' WHERE appid= '" + appid + "'";
		
		JOptionPane.showMessageDialog(null,"You have succesfully updated your data. You will be directed to Home Page");
		try {

	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static List<InternInfoBean> viewApplyInfoCom(String comid) {
		List<InternInfoBean> interns = new ArrayList<InternInfoBean>();
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			ResultSet rs = stmt.executeQuery("select * from apply where comid ='" + comid + "'");

			while (rs.next()) {
				InternInfoBean intern = new InternInfoBean();
				
				intern.setAppid(rs.getString("appid"));
				intern.setAppstatus(rs.getString("appstatus"));
				intern.setStdid(rs.getString("stdid"));
				intern.setStdname(rs.getString("stdname"));
				intern.setJobid(rs.getString("jobid"));
				intern.setJobname(rs.getString("jobname"));
				intern.setStartdate(rs.getDate("startdate"));
				intern.setEnddate(rs.getDate("enddate"));
				intern.setConfirmation(rs.getString("confirmation"));
				intern.setComid(rs.getString("comid"));
				intern.setComname(rs.getString("comname"));
				intern.setInterviewstatus(rs.getString("interviewstatus"));
				interns.add(intern);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return interns;
	}
	
	public void updateApplyStatus(String appstatus, String stdid) {

		
		System.out.println("UPDATE apply SET appstatus= '" + appstatus + "' where stdid ='" + stdid + "'");
		
		String searchQuery = "UPDATE apply SET appstatus= '" + appstatus + "' where stdid ='" + stdid + "'";
		
		JOptionPane.showMessageDialog(null,"You have succesfully approved the student application");
		try {

	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void deleteApplyInfo(int id) {
		   
	    try {
	    	currentCon = ConnectionManager.getConnection();
	        ps=currentCon.prepareStatement("delete from apply where appid=?");
	        
	        ps.setInt(1, id);

	        ps.executeQuery();
	        System.out.println("data delete");
	        JOptionPane.showMessageDialog(null,"You have succesfully cancel your application. You will be directed to Home Page");
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	   
	}
	
}
