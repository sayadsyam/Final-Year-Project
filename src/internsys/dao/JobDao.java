package internsys.dao;

//import java.util.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;



//import java.util.*;
import internsys.connection.ConnectionManager;
import internsys.model.JobBean;
//import internsys.model.CompanyBean;

public class JobDao {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;

	// add new order
	public JobBean addJobInfo(JobBean job) {

		//int staff_id = staff.getStaffId();
		String jobname = job.getJobname();
		String jobstatus = job.getJobstatus();
		String joballowance = job.getJoballowance();		
		String jobdesc = job.getJobdesc();
		String comid = job.getComid();
		String jobinterview = job.getComid();
		
		System.out.println("INSERT INTO JOB"
				+ "(JOBNAME, JOBSTATUS, JOBALLOWANCE, JOBDESC, JOBINTERVIEW, COMID) "
				+ "VALUES('" + jobname + "','"
				+ jobstatus + "','" + joballowance + "','" + jobdesc + "','" + jobinterview + "','" + comid +"')");
		
		
		String insertTableSQL = "INSERT INTO JOB"
				+ "(JOBNAME, JOBSTATUS, JOBALLOWANCE, JOBDESC, JOBINTERVIEW, COMID) "
				+ "VALUES('" + jobname + "','"
				+ jobstatus + "','" + joballowance + "','" + jobdesc + "','" + jobinterview + "','" + comid +"')";

		try {
			currentCon = ConnectionManager.getConnection();
			// stmt = currentCon.createStatement();
			// System.out.println(insertTableSQL);
			ps = currentCon.prepareStatement(insertTableSQL);
			ps.executeUpdate();
			System.out.println("Record is inserted into Job table!");
			JOptionPane.showMessageDialog(null,"You have succesfully added a new job!");
			
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
		return job;
	}

	
	
	public void updateJobInfo(JobBean bean) {

		int jobid = Integer.parseInt(bean.getJobid());
		int comid = Integer.parseInt(bean.getComid());
		String jobname = bean.getJobname();
		String jobstatus = bean.getJobstatus();
		String joballowance = bean.getJoballowance();
		String jobdesc = bean.getJobdesc();
		String jobinterview = bean.getComid();
		
		System.out.println("UPDATE job SET jobname= '" + jobname 
				+ "', jobstatus='" + jobstatus + "', joballowance='" + joballowance + "', jobdesc='" + jobdesc+ "' WHERE jobid= '" + jobid + "'");
		String searchQuery = "UPDATE job SET jobname= '" + jobname 
				+ "', jobstatus='" + jobstatus + "', joballowance='" + joballowance + "', jobinterview='" + jobinterview + "', jobdesc='" + jobdesc+ "' WHERE jobid= '" + jobid + "'";
		JOptionPane.showMessageDialog(null,"You have succesfully updated your data. You will be directed to Home Page");
		try {

	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public JobBean getJobById(String id) {
	    JobBean com = new JobBean();
	    try {
	    	currentCon = ConnectionManager.getConnection();
	        ps=currentCon.prepareStatement("select * from job where jobid=?");
	        
	        ps.setString(1, id);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	        	com.setComid(rs.getString("comid"));
	        	com.setJobid(rs.getString("jobid"));
	        	com.setJobname(rs.getString("jobname"));
	        	com.setJobstatus(rs.getString("jobstatus"));
	        	com.setJoballowance(rs.getString("joballowance"));
	        	com.setJobdesc(rs.getString("jobdesc"));
	        	com.setJobinterview(rs.getString("jobinterview"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return com;
	}
	
	
	public static List<JobBean> viewJobInfo(String id) {
		List<JobBean> jobs = new ArrayList<JobBean>();
		int cid = Integer.parseInt(id);
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			ResultSet rs = stmt.executeQuery("select * from job where comid = '" + cid + "'" );

			while (rs.next()) {
				JobBean job = new JobBean();
				job.setJobid(rs.getString("jobid"));
				job.setJobname(rs.getString("jobname"));
				job.setJobstatus(rs.getString("jobstatus"));
				job.setJoballowance(rs.getString("joballowance"));
				job.setJobdesc(rs.getString("jobdesc"));
				job.setComid(rs.getString("comid"));
				job.setJobinterview(rs.getString("jobinterview"));
				jobs.add(job);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return jobs;
	}
	
	public void deleteJobInfo(int id) {
	   
	    try {
	    	currentCon = ConnectionManager.getConnection();
	        ps=currentCon.prepareStatement("delete from job where jobid=?");
	        
	        ps.setInt(1, id);

	        ps.executeQuery();
	        
	        ps=currentCon.prepareStatement("delete from apply where jobid=?");
	        
	        ps.setInt(1, id);

	        ps.executeQuery();

	        System.out.println("data delete");
	        JOptionPane.showMessageDialog(null,"You have succesfully deleted the selected job. You will be directed to Home Page");
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	   
	}

}