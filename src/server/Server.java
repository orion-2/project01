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

public class Server extends Thread {
	private Socket withClient = null;
	private InputStream reC = null;
	private OutputStream senC = null;
	private SCenter sc = null;
	private ArrayList<Thread> tList = new ArrayList<>();
	private CDAO myDao = new CDAO();
	private CDTO ex2 = new CDTO();
	

	Server(Socket c, SCenter s) {
		this.withClient = c;
		this.sc = s;
	}

	@Override
	public void run() {
		try {
//			receive();
			streamSet();
			myDao.insertOne(ex2);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	private void receive() {
//		// TODO Auto-generated method stub
//		
//	}

	private void streamSet() throws IOException, Exception {
		byte[] reBuffer = new byte[1024];
		reC = withClient.getInputStream();
		reC.read(reBuffer);
		ByteArrayInputStream bais = new ByteArrayInputStream(reBuffer);
		ObjectInputStream ois = new ObjectInputStream(bais);
		Object indata = ois.readObject();
		ArrayList<String> ex = (ArrayList <String>) indata;
			ex2.setId(ex.get(0));
			ex2.setPw(ex.get(1));
			ex2.setName(ex.get(2));
			ex2.setPNum(ex.get(3));
			ex2.setShipNum(ex.get(4));
			ex2.setShipName(ex.get(5));
			ex2.setShipAddr(ex.get(6));
		System.out.println("성공하였습니다.");
		
//        ois.close();
//        reC.close();
//        withClient.close();

	}

}
