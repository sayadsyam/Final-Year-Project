package internsys.model;

public class AdminBean {
	private String adminid;
	private String adminname;
	private String adminemail;
	private String adminpass;
	private String usertype;
	boolean valid;
	
	
	//setter getter Adminid
	public String getAdminid(){
		return adminid;
	}
	
	public void setAdminid(String adminid){
		this.adminid = adminid;
	}
	
	//setter getter adminname
	public String getAdminname(){
		return adminname;
	}
	
	public void setAdminname(String adminname){
		this.adminname = adminname;
	}
	
	//setter getter adminemail
	public String getAdminemail(){
		return adminemail;
	}
		
	public void setAdminemail(String adminemail){
		this.adminemail = adminemail;
	}

	//setter getter adminpass
	public String getAdminpass(){
		return adminpass;
	}
	
	public void setAdminpass(String adminpass){
		this.adminpass = adminpass;
	}
	
	//setter getter usertype
	public String getUsertype(){
		return usertype;
	}
		
	public void setUsertype(String usertype){
		this.usertype = usertype;
	}

	
	//setter getter valid
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
