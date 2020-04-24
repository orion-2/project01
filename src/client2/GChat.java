package client2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JTextField;

import JFrame.JFrameG1;
import JFrame.JFrameHome;

public class GChat {
	private Socket withServer = null;
	private InputStream reC = null;
	private OutputStream senC = null;
	private JFrameHome home = null;
	private JFrameG1 join = null;
	
	ArrayList <JTextField[]> in = new ArrayList<>();
	
	GChat(Socket g){
		this.withServer = g;
		home();
	}
	
	private void home() {
		home = new JFrameHome(null, this);
	}
	
	private void startJoin() {
		join = new JFrameG1(this);
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
