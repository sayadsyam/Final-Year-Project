package internsys.model;
import java.util.*;

public class InternInfoBean{
	
	private String stdid;
	private String stdname;
	private String appid;
	private String appstatus;
	private String comid;
	private String comname;
	private String comaddress;
	private String comdesc;
	private String comemail;
	private String comstate;
	private String jobid;
	private String jobname;
	private String jobstatus;
	private String joballowance;
	private String jobdesc;
	private String interviewstatus;
	private Date startdate;
	private Date enddate;
	private String confirmation;
	private String comphone;
	private String comfax;
	private String jobinterview;
	boolean valid; 
	
	//setter getter appid
	public String getAppid(){
		return appid;
	}
			
	public void setAppid(String appid){
		this.appid = appid;
	}
	
	//setter getter appstatus
	public String getAppstatus(){
		return appstatus;
	}
				
	public void setAppstatus(String appstatus){
		this.appstatus = appstatus;
	}
	
		//setter getter stdid
	public String getStdid(){
		return stdid;
	}
				
	public void setStdid(String stdid){
		this.stdid = stdid;
	}
		
	//setter getter stdname
	public String getStdname(){
		return stdname;
	}
			
	public void setStdname(String stdname){
		this.stdname = stdname;
	}
	
	//setter getter comid
	public String getComid(){
		return comid;
	}
		
	public void setComid(String comid){
		this.comid = comid;
	}
	
	//setter getter comname
	public String getComname(){
		return comname;
	}
			
	public void setComname(String comname){
		this.comname = comname;
	}
	
	//setter getter comid
	public String getComaddress(){
		return comaddress;
	}
			
	public void setComaddress(String comaddress){
		this.comaddress = comaddress;
	}	
	
	//setter getter comdesc
	public String getComdesc(){
		return comdesc;
	}
		
	public void setComdesc(String comdesc){
		this.comdesc = comdesc;
	}
	
	//setter getter comdesc
	public String getComemail(){
		return comemail;
	}
			
	public void setComemail(String comemail){
		this.comemail = comemail;
	}
	
	//setter getter comdesc
	public String getInterviewstatus(){
		return interviewstatus;
	}
				
	public void setInterviewstatus(String interviewstatus){
		this.interviewstatus = interviewstatus;
	}
	
	//setter getter jobdesc
		public String getJobinterview(){
			return jobinterview;
		}
			
		public void setJobinterview(String jobinterview){
			this.jobinterview = jobinterview;
		}	

		//setter getter comphone
		public String getComphone(){
			return comphone;
		}
					
		public void setComphone(String comphone){
			this.comphone = comphone;
		}
		
		//setter getter comphone
		public String getComfax(){
			return comfax;
		}
						
		public void setComfax(String comfax){
			this.comfax = comfax;
		}
	
	//setter getter comstate
	public String getComstate(){
		return comstate;
	}
			
	public void setComstate(String comstate){
		this.comstate = comstate;
	}
		
	//setter getter jobid
	public String getJobid(){
		return jobid;
	}
		
	public void setJobid(String jobid){
		this.jobid = jobid;
	}
		
	//setter getter jobname
	public String getJobname(){
		return jobname;
	}
		
	public void setJobname(String jobname){
		this.jobname = jobname;
	}
		
	//setter getter jobstatus
	public String getJobstatus(){
		return jobstatus;
	}
			
	public void setJobstatus(String jobstatus){
		this.jobstatus = jobstatus;
	}

	//setter getter joballowance
	public String getJoballowance(){
		return joballowance;
	}
		
	public void setJoballowance(String joballowance){
		this.joballowance = joballowance;
	}
		
	//setter getter jobdesc
	public String getJobdesc(){
		return jobdesc;
	}
		
	public void setJobdesc(String jobdesc){
		this.jobdesc = jobdesc;
	}
	
	//setter getter startdate
	public Date getStartdate(){
		return startdate;
	}
			
	public void setStartdate(Date startdate){
		this.startdate = startdate;
	}
	
	//setter getter enddate
	public Date getEnddate(){
		return enddate;
	}
				
	public void setEnddate(Date enddate){
		this.enddate = enddate;
	}
	
	//setter getter enddate
	public String getConfirmation(){
		return confirmation;
	}
					
	public void setConfirmation(String confirmation){
		this.confirmation = confirmation;
	}
	
	//setter getter valid
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
