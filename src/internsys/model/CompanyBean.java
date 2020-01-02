package internsys.model;

public class CompanyBean {

	private String comid;
	private String comname;
	private String comaddress;
	private String comdesc;
	private String compass;
	private String comemail;
	private String comstate;
	private String comphone;
	private String comfax;
	private String usertype;
	boolean valid;
	
	
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
	
	//setter getter comaddress
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
	
	//setter getter compass
	public String getCompass(){
		return compass;
	}
	
	public void setCompass(String compass){
		this.compass = compass;
	}
	
	//setter getter compass
	public String getComemail(){
		return comemail;
	}
		
	public void setComemail(String comemail){
		this.comemail = comemail;
	}

	//setter getter compass
	public String getComstate(){
		return comstate;
	}
		
	public void setComstate(String comstate){
		this.comstate = comstate;
	}
	
	//setter getter compass
	public String getUsertype(){
		return usertype;
	}
			
	public void setUsertype(String usertype){
		this.usertype = usertype;
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
	
	//setter getter valid
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
