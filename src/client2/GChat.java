package client2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JTextField;

public class GChat {
	private Socket withServer = null;
	private InputStream reG = null;
	private OutputStream senG = null;
	JFrameG1 join = null;
	ArrayList <JTextField> in = new ArrayList<>();
	public GChat(Socket withServer) {
		join = new JFrameG1();
	}
	
	
}
