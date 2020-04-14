package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JTextField;

public class SChat extends Thread {
	private Socket withClient = null;
	private InputStream reC = null;
	private OutputStream senC = null;
	private SCenter sc = null;
	private ArrayList<Thread> tList = new ArrayList<>();
	
	
	SChat(Socket c, SCenter s){
		this.withClient = c;
		this.sc = s;
	}


	@Override
	public void run() {
		try {
//			receive();
			streamSet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	private void receive() {
//		// TODO Auto-generated method stub
//		
//	}

	private void streamSet() throws IOException, Exception  {
		reC = withClient.getInputStream();
		final ObjectInputStream ois = new ObjectInputStream(reC);
		JTextField[] indata = (JTextField[])ois.readObject();
        System.out.println("data size : " + indata.length);
        System.out.println("성공하였습니다.");
        
//        ois.close();
//        reC.close();
//        withClient.close();
        
	}
	
	
	
	
}
