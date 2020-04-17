package client1;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class CDTO1 implements Serializable {
	private String Id;
	private String Pw;
	private String Name;
	private String PNum;
	private String ShipNum;
	private String ShipName;
	private String ShipAddr;
	
	public ArrayList<String> data = new ArrayList<>();
		
	
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
	public String getShipNum() {
		return ShipNum;
	}
	public void setShipNum(String shipNum) {
		ShipNum = shipNum;
	}
	public String getShipName() {
		return ShipName;
	}
	public void setShipName(String shipName) {
		ShipName = shipName;
	}
	public String getShipAddr() {
		return ShipAddr;
	}
	public void setShipAddr(String shipAddr) {
		ShipAddr = shipAddr;
	}
	
	public String[] getArray() {
		String[] returnData = new String[7];
		returnData[0]=this.Id;
		returnData[1]=this.Pw;
		returnData[2]=this.Name;
		returnData[3]=this.PNum;
		returnData[4]=this.ShipNum;
		returnData[5]=this.ShipName;
		returnData[6]=this.ShipAddr;
		
		return returnData;
	}
	
}
