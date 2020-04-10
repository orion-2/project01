package client1;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JTextField;

public class CChat {
	private Socket withServer = null;
	private InputStream reC = null;
	private OutputStream senC = null;
	JFrameC1 join = null;
	ArrayList <JTextField> in = new ArrayList<>();
	
	CChat(Socket c){
		this.withServer = c;
		startJoin();
		
	}
	private void startJoin() {
		join = new JFrameC1(this, this);
	}
	public void send() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("리시브스타트");
				try {
					reC = withServer.getInputStream();
					byte[] reBuffer = new byte[100];
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
	public void receive() {
		
	}
	
	public void streamSet(JTextField[] indata) throws IOException {
		senC = withServer.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(senC);
		oos.writeObject(indata);
		oos.close();
		senC.close();
		withServer.close();
	}
}
