package internsys.dao;

//import java.util.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;



//import java.util.*;
import internsys.connection.ConnectionManager;
import internsys.model.CompanyBean;
import internsys.model.JobBean;

public class CompanyDao {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;

	// add new order
	public CompanyBean addCompanyInfo(CompanyBean com) {

		//int staff_id = staff.getStaffId();
		String comname = com.getComname();
		String comaddress = com.getComaddress();
		String comdesc = com.getComdesc();		
		String compass = com.getCompass();
		String comemail = com.getComemail();
		String comstate = com.getComstate();
		String comphone = com.getComphone();
		String comfax = com.getComfax();
		String usertype = com.getUsertype();
		
		System.out.println("INSERT INTO COMPANY"
				+ "(COMNAME, COMADDRESS, COMDESC, COMPASS,USERTYPE, COMEMAIL, COMSTATE,COMPHONE,COMFAX) "
				+ "VALUES('" + comname + "','"
				+ comaddress + "','" + comdesc + "','" + compass + "','" + usertype + "','" + comemail + "','" + comstate + "','" + comphone + "','" + comfax + "')");
		
		
		String insertTableSQL = "INSERT INTO COMPANY"
				+ "(COMNAME, COMADDRESS, COMDESC, COMPASS,USERTYPE, COMEMAIL, COMSTATE,COMPHONE,COMFAX) "
				+ "VALUES('" + comname + "','"
				+ comaddress + "','" + comdesc + "','" + compass + "','" + usertype + "','" + comemail + "','" + comstate + "','" + comphone + "','" + comfax + "')";

		try {
			currentCon = ConnectionManager.getConnection();
			// stmt = currentCon.createStatement();
			// System.out.println(insertTableSQL);
			ps = currentCon.prepareStatement(insertTableSQL);
			ps.executeUpdate();
			System.out.println("Record is inserted into Company table!");
			JOptionPane.showMessageDialog(null,"You have succesfully register! Please login to access the system");
			
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
		return com;
	}

	public static CompanyBean login(CompanyBean bean) {
		// preparing some objects for connection
		System.out.println("JIJIJI");
		Statement stmt = null;
		String comemail = bean.getComemail();
		String compass = bean.getCompass();
		String searchQuery = "select * from company where comemail='"
				+ comemail + "' AND compass='" + compass + "'";
		// "System.out.println" prints in the console; Normally used to trace
		// the process
		System.out.println("Your company email is " + comemail);
		System.out.println("Your password is " + compass);
		System.out.println("Query: " + searchQuery);
		try {
			// connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();
			// if user does not exist set the isValid variable to false
			if (!more) {
				System.out.println("Sorry, you are not a registered user! Please sign up first");
				bean.setValid(false);
			}
			// if user exists set the isValid variable to true
			else if (more) {
				String comName = rs.getString("comname");
				String comId = rs.getString("comid");
				String usertype = rs.getString("usertype");
				System.out.println("Welcome " + comName);
				bean.setComname(comName);
				bean.setComid(comId);
				bean.setUsertype(usertype);
				bean.setValid(true);
				JOptionPane.showMessageDialog(null,"You have succesfully login into the system");
			}
		} catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		}
		// some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
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
		return bean;
	}
	
	
	public void updateComInfo(CompanyBean bean) {

		int comid = Integer.parseInt(bean.getComid());
		String comname = bean.getComname();
		String comaddress = bean.getComaddress();
		String compass = bean.getCompass();
		String comdesc = bean.getComdesc();
		String comemail = bean.getComemail();
		String comstate = bean.getComstate();
		String comphone = bean.getComphone();
		String comfax = bean.getComfax();
		
		System.out.println("UPDATE company SET comname= '" + comname 
				+ "', comaddress='" + comaddress + "', compass='" + compass + "', comdesc='" + comdesc+ "', comphone='" + comphone + "', comfax='" + comfax 
				+  "', comemail='" + comemail + "', comstate='" + comstate +  "' WHERE comid= '" + comid + "'");
		String searchQuery = "UPDATE company SET comname= '" + comname 
				+ "', comaddress='" + comaddress + "', compass='" + compass + "', comdesc='" + comdesc+ "', comphone='" + comphone + "', comfax='" + comfax 
				+  "', comemail='" + comemail + "', comstate='" + comstate +  "' WHERE comid= '" + comid + "'";
		JOptionPane.showMessageDialog(null,"You have succesfully updated your data. You will be directed to Home Page");
		try {

	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public CompanyBean getComById(String id) {
	    CompanyBean com = new CompanyBean();
	    try {
	    	currentCon = ConnectionManager.getConnection();
	        ps=currentCon.prepareStatement("select * from company where comid=?");
	        
	        ps.setString(1, id);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	        	com.setComid(rs.getString("comid"));
	        	com.setComname(rs.getString("comname"));
	        	com.setComaddress(rs.getString("comaddress"));
	        	com.setCompass(rs.getString("compass"));
	        	com.setComdesc(rs.getString("comdesc"));
	        	com.setComstate(rs.getString("comstate"));
	        	com.setComemail(rs.getString("comemail"));
	        	com.setComphone(rs.getString("comphone"));
	        	com.setComfax(rs.getString("comfax"));
	        	com.setValid(true);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return com;
	}
	
	public static List<CompanyBean> viewComInfo() {
		List<CompanyBean> coms = new ArrayList<CompanyBean>();
		
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			ResultSet rs = stmt.executeQuery("select * from company" );

			while (rs.next()) {
				CompanyBean com = new CompanyBean();
				com.setComid(rs.getString("comid"));
	        	com.setComname(rs.getString("comname"));
	        	com.setComaddress(rs.getString("comaddress"));
	        	com.setCompass(rs.getString("compass"));
	        	com.setComdesc(rs.getString("comdesc"));
	        	com.setComstate(rs.getString("comstate"));
	        	com.setComemail(rs.getString("comemail"));
	        	com.setComphone(rs.getString("comphone"));
	        	com.setComfax(rs.getString("comfax"));
				coms.add(com);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return coms;
	}
	
	
	public void deleteComInfo(int id) {
		   
	    try {
	    	currentCon = ConnectionManager.getConnection();
	        ps=currentCon.prepareStatement("delete from company where comid=?");
	        
	        ps.setInt(1, id);

	        ps.executeQuery();
	        
	        ps=currentCon.prepareStatement("delete from job where comid=?");
	        
	        ps.setInt(1, id);

	        ps.executeQuery();
	        
	        ps=currentCon.prepareStatement("delete from apply where comid=?");
	        
	        ps.setInt(1, id);

	        ps.executeQuery();

	        System.out.println("data delete");
	        JOptionPane.showMessageDialog(null,"You have succesfully deleted your account. You can no longer log into the system");
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	   
	}


}