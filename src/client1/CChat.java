package client1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JTextField;

import JFrame.JFrameC1;
import JFrame.JFrameHome;

public class CChat extends Thread{
	private Socket withServer = null;
	private InputStream reC = null;
	private OutputStream senC = null;
	private JFrameHome home = null;
	private JFrameC1 join = null;
	ArrayList <JTextField[]> in = new ArrayList<>();
	
	CChat(Socket c){
		this.withServer = c;
		home();
//		startJoin();
		
	}
	private void home() {
		home = new JFrameHome(this, null);
	}
	private void startJoin() {
		join = new JFrameC1(this);
	}
	public void send() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("리시브스타트");
				try {
					reC = withServer.getInputStream();
					byte[] reBuffer = new byte[1024];
					reC.read(reBuffer);
					String in = new String (reBuffer);
					in = in.trim();
					System.out.println("입력되었습니다.");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	
	public void streamSet(ArrayList<String> data) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(data);
		byte[] bowl = baos.toByteArray();
		senC = withServer.getOutputStream();
		senC.write(bowl);
		System.out.println("여기까지");
		
//		oos.close();
//		senC.close();
//		withServer.close();
	}
}
