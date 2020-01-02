package internsys.dao;

//import java.util.*;
import java.sql.*;

import javax.swing.JOptionPane;

//import java.util.*;
import internsys.connection.ConnectionManager;
import internsys.model.AdminBean;

public class AdminDao {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;

	public static AdminBean login(AdminBean bean) {
		// preparing some objects for connection
		System.out.println("JIJIJI");
		Statement stmt = null;
		String adminemail = bean.getAdminemail();
		String adminpass = bean.getAdminpass();
		String searchQuery = "select * from admin where adminemail='"
				+ adminemail + "' AND adminpass='" + adminpass + "'";
		// "System.out.println" prints in the console; Normally used to trace
		// the process
		System.out.println("Your admin email is " + adminemail);
		System.out.println("Your password is " + adminpass);
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
				String adminName = rs.getString("adminname");
				String adminId = rs.getString("adminid");
				String usertype = rs.getString("usertype");
				System.out.println("Welcome " + adminName);
				bean.setAdminname(adminName);
				bean.setAdminid(adminId);
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
	
	
	

}