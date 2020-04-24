package client1;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class RCDTO implements Serializable {
	private String Id;
	private String ShipNum;
	private String ShipName;
	private String Date;
	private String ShipAddr;
	private String Price;
	
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

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getShipAddr() {
		return ShipAddr;
	}

	public void setShipAddr(String shipAddr) {
		ShipAddr = shipAddr;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public ArrayList<String> getData() {
		return data;
	}

	public void setData(ArrayList<String> data) {
		this.data = data;
	}
	
	public String[] getArray() {
		String[] returnData = new String[6];
		returnData[0]= this.Id;
		returnData[0]= this.ShipNum;
		returnData[0]= this.ShipName;
		returnData[0]= this.Date;
		returnData[0]= this.ShipAddr;
		returnData[0]= this.Price;
		return returnData;
	}
	
	
}
