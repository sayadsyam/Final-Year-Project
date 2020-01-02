package internsys.dao;

//import java.util.*;
import javax.swing.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;

import internsys.connection.ConnectionManager;
import internsys.model.StudentBean;

import javax.servlet.http.Part;

public class StudentDao {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;

	// add new order
	public StudentBean addStudentInfo(StudentBean std) throws IOException {

		//int staff_id = staff.getStaffId();
		String stdfname = std.getStdfname();
		String stdlname = std.getStdlname();
		String stdpass = std.getStdpass();		
		String stdemail = std.getStdemail();
		String stdaddress = std.getStdaddress();
		double stdcgpa = Double.parseDouble(std.getStdcgpa());
		String stdphone = std.getStdphone();
		String stdgender = std.getStdgender();
		String stdmatric = std.getStdmatric();
		String stdprogram = std.getStdprogram();
		String usertype = "student";
		Part filePart = std.getResume();

		InputStream resume = null;
		if (filePart != null) 
        {
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            resume = filePart.getInputStream();
        }
		
		/*System.out.println("INSERT INTO STUDENT"
				+ "(STDFNAME, STDLNAME, STDPASS,STDEMAIL,STDADDRESS,STDCGPA,STDPHONE,STDGENDER,STDDOB,STDMATRIC,STDPROGRAM) "
				+ "VALUES('" + stdfname + "','"
				+ stdlname + "','" + stdpass + "','" + stdemail + "','" + stdaddress
				+ "','" + stdcgpa + "','" + stdphone + "','" + stdgender + "',TO_DATE('" 
						+ stddob + "','DD/MM/YYYY')" + ",'" + stdmatric + ",'" + stdprogram + "')");*/
		/*String insertTableSQL = "INSERT INTO STUDENT"
				+ "(STDFNAME, STDLNAME, STDPASS,STDEMAIL,STDADDRESS,STDCGPA,STDPHONE,STDGENDER,STDDOB,STDMATRIC,USERTYPE,STDPROGRAM,RESUME) "
				+ "VALUES('" + stdfname + "','"
				+ stdlname + "','" + stdpass + "','" + stdemail + "','" + stdaddress
				+ "','" + stdcgpa + "','" + stdphone + "','" + stdgender + "',TO_DATE('" 
						+ stddob + "','YYYY-MM-DD')" + ",'" + stdmatric + "','" + usertype + "','" + stdprogram + "','" + resume + "')";
		*/
		
		
		
		try {
			
			currentCon = ConnectionManager.getConnection();
            System.out.print("masuk insert");
            
            String sql = "INSERT INTO STUDENT(stdfname,stdlname,stdpass,stdemail,stdaddress,stdcgpa,stdphone,stdgender,stdmatric,usertype,stdprogram,resume) "
            		+ "values (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = currentCon.prepareStatement(sql);
            stmt.setString(1, stdfname);
            stmt.setString(2, stdlname);
            stmt.setString(3, stdpass);
            stmt.setString(4, stdemail);
            stmt.setString(5, stdaddress);
            stmt.setDouble(6, stdcgpa);
            stmt.setString(7, stdphone);
            stmt.setString(8, stdgender);
            stmt.setString(9, stdmatric);
            stmt.setString(10, usertype);
            stmt.setString(11, stdprogram);
            
            
            if (resume != null) 
            {
                stmt.setBinaryStream(12, resume, (int) filePart.getSize());
            }
           
			
			System.out.println(sql);
			//currentCon = ConnectionManager.getConnection();
            System.out.print("masuk insert");
           // System.out.print(insertTableSQL);
	        //stmt = currentCon.createStatement();
	        stmt.executeUpdate();
			 
			
			System.out.println("Record is inserted into Student table!");
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
		return std;
	}

	public static StudentBean login(StudentBean bean) {
		// preparing some objects for connection
		System.out.println("JIJIJI");
		Statement stmt = null;
		String stdemail = bean.getStdemail();
		String stdpass = bean.getStdpass();
		String searchQuery = "select * from student where stdemail='"
				+ stdemail + "' AND stdpass='" + stdpass + "'";
		// "System.out.println" prints in the console; Normally used to trace
		// the process
		System.out.println("Your email is " + stdemail);
		System.out.println("Your password is " + stdpass);
		System.out.println("Query: " + searchQuery);
		try {
			// connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();
			// if user does not exist set the isValid variable to false
			if (!more) {
				System.out
						.println("Sorry, you are not a registered user! Please sign up first");
				bean.setValid(false);
			}
			// if user exists set the isValid variable to true
			else if (more) {
				String stdfname = rs.getString("stdfname");
				String stdid = rs.getString("stdid");
				String usertype = rs.getString("usertype");
				System.out.println("Welcome " + stdfname);
				bean.setStdfname(stdfname);
				bean.setStdid(stdid);
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
	
	
	public void updateStdInfo(StudentBean bean) {

		int stdid = Integer.parseInt(bean.getStdid());
		String stdfname = bean.getStdfname();
		String stdlname = bean.getStdlname();
		String stdpass = bean.getStdpass();
		String stdemail = bean.getStdemail();
		String stdcgpa = bean.getStdcgpa();
		String stdphone = bean.getStdphone();
		String stdaddress = bean.getStdaddress();
		String stdgender = bean.getStdgender();
		String stdmatric = bean.getStdmatric();
		String stdprogram = bean.getStdprogram();
		System.out.println( "UPDATE student SET stdfname= '" + stdfname 
				+ "', stdlname='" + stdlname + "', stdpass='" + stdpass + "', stdemail='" + stdemail 
				+ "', stdaddress='" + stdaddress + "', stdcgpa='" + stdcgpa + "', stdphone='" + stdphone 
				+ "', stdgender='" + stdgender + "', stdmatric='" + stdmatric + "', stdprogram='" + stdprogram +"' WHERE stdid= '" + stdid + "'");
		
		String searchQuery = "UPDATE student SET stdfname= '" + stdfname 
				+ "', stdlname='" + stdlname + "', stdpass='" + stdpass + "', stdemail='" + stdemail 
				+ "', stdaddress='" + stdaddress + "', stdcgpa='" + stdcgpa + "', stdphone='" + stdphone 
				+ "', stdgender='" + stdgender + "',  stdmatric='" + stdmatric + "', stdprogram='" + stdprogram +"' WHERE stdid= '" + stdid + "'";
		JOptionPane.showMessageDialog(null,"You have succesfully update your data! You will be redirected to Home Page");
		try {

	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public StudentBean getStdById(String id) {
	    StudentBean std = new StudentBean();
	    try {
	    	currentCon = ConnectionManager.getConnection();
	        ps=currentCon.prepareStatement("select * from student where stdid=?");
	        
	        ps.setString(1, id);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	        	std.setStdid(rs.getString("stdid"));
	        	std.setStdfname(rs.getString("stdfname"));
	        	std.setStdlname(rs.getString("stdlname"));
	        	std.setStdpass(rs.getString("stdpass"));
	        	std.setStdemail(rs.getString("stdemail"));
	        	std.setStdaddress(rs.getString("stdaddress"));
	        	std.setStdcgpa(rs.getString("stdcgpa"));
	        	std.setStdphone(rs.getString("stdphone"));
	        	std.setStdgender(rs.getString("stdgender"));
	        	std.setStdmatric(rs.getString("stdmatric"));
	        	std.setStdprogram(rs.getString("stdprogram"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return std;
	}
	
	
	public static List<StudentBean> viewStudentInfo() {
		List<StudentBean> stds = new ArrayList<StudentBean>();
		
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student");

			while (rs.next()) {
				StudentBean std = new StudentBean();
				std.setStdid(rs.getString("stdid"));
	        	std.setStdfname(rs.getString("stdfname"));
	        	std.setStdlname(rs.getString("stdlname"));
	        	std.setStdpass(rs.getString("stdpass"));
	        	std.setStdemail(rs.getString("stdemail"));
	        	std.setStdaddress(rs.getString("stdaddress"));
	        	std.setStdcgpa(rs.getString("stdcgpa"));
	        	std.setStdphone(rs.getString("stdphone"));
	        	std.setStdgender(rs.getString("stdgender"));
	        	std.setStdmatric(rs.getString("stdmatric"));
	        	std.setStdprogram(rs.getString("stdprogram"));
				stds.add(std);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return stds;
	}
	
	public void deleteStudentInfo(int id) {
	   
	    try {
	    	currentCon = ConnectionManager.getConnection();
	        ps=currentCon.prepareStatement("delete from student where stdid=?");
	        
	        ps.setInt(1, id);

	        ps.executeQuery();
	         System.out.println("Student id : " + id);
	        ps=currentCon.prepareStatement("delete from apply where stdid=?");
	        
	        ps.setInt(1, id);

	        ps.executeQuery();

	        System.out.println("data delete");
	        JOptionPane.showMessageDialog(null,"You have succesfully deleted your account. You can no longer log into the system");
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	   
	}

}