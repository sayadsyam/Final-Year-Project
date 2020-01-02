package internsys.model;
import java.util.*;
import javax.servlet.http.Part;

public class StudentBean {

	private String stdid;
	private String stdpass;
	private String stdmatric;
	private String stdfname;
	private String stdlname;
	private String stdemail;
	private String stdaddress;
	private String stdcgpa;
	private String stdphone;
	private String stdgender;
	private String stdprogram;
	private String usertype;
	private Part resume;
	boolean valid;
	
	
	//setter getter stdid
	public String getStdid(){
		return stdid;
	}
	
	public void setStdid(String stdid){
		this.stdid = stdid;
	}
	
	//setter getter stdpass
	public String getStdpass(){
		return stdpass;
	}
	
	public void setStdpass(String stdpass){
		this.stdpass = stdpass;
	}
	
	//setter getter stdmatric
	public String getStdmatric(){
		return stdmatric;
	}
		
	public void setStdmatric(String stdmatric){
		this.stdmatric = stdmatric;
	}

	
	//setter getter stdfname
	public String getStdfname(){
		return stdfname;
	}
	
	public void setStdfname(String stdfname){
		this.stdfname = stdfname;
	}
	
	//setter getter stdlname
	public String getStdlname(){
		return stdlname;
	}
	
	public void setStdlname(String stdlname){
		this.stdlname = stdlname;
	}
	
	//setter getter stdemail
	public String getStdemail(){
		return stdemail;
	}
	
	public void setStdemail(String stdemail){
		this.stdemail = stdemail;
	}
	
	//setter getter stdaddress
	public String getStdaddress(){
		return stdaddress;
	}
	
	public void setStdaddress(String stdaddress){
		this.stdaddress = stdaddress;
	}
	
	//setter getter stdcgpa
	public String getStdcgpa(){
		return stdcgpa;
	}
	
	public void setStdcgpa(String stdcgpa){
		this.stdcgpa = stdcgpa;
	}
	
	//setter getter stdphone
	public String getStdphone(){
		return stdphone;
	}
	
	public void setStdphone(String stdphone){
		this.stdphone = stdphone;
	}
	
	//setter getter stdgender
	public String getStdgender(){
		return stdgender;
	}
	
	public void setStdgender(String stdgender){
		this.stdgender = stdgender;
	}
	
	//setter getter stdgender
	public String getStdprogram(){
		return stdprogram;
	}
		
	public void setStdprogram(String stdprogram){
		this.stdprogram = stdprogram;
	}
	
	
	//setter getter usertype
	public String getUsertype(){
		return usertype;
	}
		
	public void setUsertype(String usertype){
		this.usertype = usertype;
	}
	
	//setter getter usertype
	public Part getResume(){
		return resume;
	}
			
	public void setResume(Part resume){
		this.resume = resume;
	}
	
	//setter getter valid
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
