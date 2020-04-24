package server;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JTextField;

import client1.CDAO;
import client1.CDTO;
import client1.RCDAO;
import client1.RCDTO;
import client2.GDAO;
import client2.GDTO;

public class Server extends Thread {
	private Socket withClient = null;
	private InputStream reC = null;
	private OutputStream senC = null;
	private SCenter sc = null;
	private ArrayList<Thread> tList = new ArrayList<>();
	private CDAO myDao = new CDAO();
	private GDAO myGDao = new GDAO();
	private RCDAO myrcDao = new RCDAO();

	Server(Socket c, SCenter s) {
		this.withClient = c;
		this.sc = s;
	}
	
	@Override
	public void run() {
		try {
			streamSet();
//			receive();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	private void receive() {
//		// TODO Auto-generated method stub
//	}

	@SuppressWarnings({ "unused", "unchecked" })
	private void streamSet() throws IOException, Exception {
		byte[] reBuffer = new byte[1024];
		reC = withClient.getInputStream();
		reC.read(reBuffer);
		ByteArrayInputStream bais = new ByteArrayInputStream(reBuffer);
		ObjectInputStream ois = new ObjectInputStream(bais);
		Object indata = ois.readObject();
		
		ArrayList<String> ex = (ArrayList <String>) indata;
			if(ex.get(0).equals("addB")) {
				CDTO ex2 = new CDTO();
				ex2.setId(ex.get(1));
				ex2.setPw(ex.get(2));
				ex2.setName(ex.get(3));
				ex2.setPNum(ex.get(4));
				ex2.setShipNum(ex.get(5));
				ex2.setShipName(ex.get(6));
				ex2.setShipAddr(ex.get(7));
				
				myDao.insertOne(ex2);
//				System.out.println("성공하였대.");
			}else if(ex.get(0).equals("addA")) {
				GDTO ex3 = new GDTO();
				ex3.setId(ex.get(1));
				ex3.setPw(ex.get(2));
				ex3.setName(ex.get(3));
				ex3.setPNum(ex.get(4));
//				System.out.println("성공하였습니다.");
				
				myGDao.insertOne(ex3);
				
			}else if(ex.get(0).equals("addC")) {
				RCDTO ex4 = new RCDTO();
				ex4.setId(ex.get(1));
				ex4.setShipNum(ex.get(2));
				ex4.setShipName(ex.get(3));
				ex4.setDate(ex.get(4));
				ex4.setShipAddr(ex.get(5));
				ex4.setPrice(ex.get(6));
				
				myrcDao.insertOne(ex4);
//				System.out.println("성공하였습니다.");
			}
			
			
	}
	
	
//	private void close() {
//      ois.close();
//      reC.close();
//      withClient.close();
//	}


}
