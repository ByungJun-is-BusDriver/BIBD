package TCP;
import java.util.Date;

public class LoginInfo {

	private String ID;
	private String Name;
	private String SEX;
	private String Loveid;
	private Date First_day;
	
	
	
	public void setID(String ID) {
		this.ID = ID;
	}
	
	public String getID() {
		return ID;
	}
	public void setLoveid(String loveid) {
		Loveid = loveid;
	}
	public String getLoveid() {
		return Loveid;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getName() {
		return Name;	
	}
	public void setSex(String sex) {
		SEX = sex;
	}
	public String getSex() {
		return SEX;
	}
	public String getSEX() {
		return SEX;
	}

	public void setSEX(String sEX) {
		SEX = sEX;
	}

	public Date getFirst_day() {
		return First_day;
	}

	public void setFirst_day(Date first_day) {
		First_day = first_day;
	}
	
	private static class InnerInstanceClazz { // singleton
		private static final LoginInfo instance = new LoginInfo();
	}

	public static LoginInfo get() { // singleton
		return InnerInstanceClazz.instance;
	}

	
	
	
	
}
