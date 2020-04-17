package client2;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class GDTO implements Serializable {
	private String Id;
	private String Pw;
	private String Name;
	private String PNum;
	
	public ArrayList <String> data = new ArrayList<>();
		
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPw() {
		return Pw;
	}
	public void setPw(String pw) {
		Pw = pw;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPNum() {
		return PNum;
	}
	public void setPNum(String pNum) {
		PNum = pNum;
	}
	
	public String[] getArray() {
		String[] returnData = new String[7];
		returnData[0]=this.Id;
		returnData[1]=this.Pw;
		returnData[2]=this.Name;
		returnData[3]=this.PNum;
		
		return returnData;
	}
	
}

