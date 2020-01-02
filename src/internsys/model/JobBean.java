package internsys.model;

public class JobBean {

	private String jobid;
	private String jobname;
	private String jobstatus;
	private String joballowance;
	private String jobdesc;
	private String jobinterview;
	private String comid;
	boolean valid;
	
	
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
	
	//setter getter jobdesc
	public String getJobinterview(){
		return jobinterview;
	}
		
	public void setJobinterview(String jobinterview){
		this.jobinterview = jobinterview;
	}	

	//setter getter compass
	public String getComid(){
		return comid;
	}
		
	public void setComid(String comid){
		this.comid = comid;
	}
	
	//setter getter valid
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
