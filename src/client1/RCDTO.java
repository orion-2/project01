package client1;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class RCDTO implements Serializable {
	private String Id;
	private String ShipNum;
	private String ShipName;
	private String ShipAddr;
	private String TotalNum;
	private String Date;
	
	public ArrayList<String> data = new ArrayList<>();
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
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
	public String getTotalNum() {
		return TotalNum;
	}
	public void setTotalNum(String totalNum) {
		TotalNum = totalNum;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	
	public String[] getArray() {
		String[] returnData = new String[6];
		returnData[0]= this.Id;
		returnData[0]= this.ShipNum;
		returnData[0]= this.ShipName;
		returnData[0]= this.ShipAddr;
		returnData[0]= this.TotalNum;
		returnData[0]= this.Date;
		return returnData;
	}
}
