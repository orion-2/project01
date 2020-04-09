package client1;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {

	public static void main(String[] args) throws IOException, IOException {
		// TODO Auto-generated method stub
		Socket withServer = null;
		withServer = new Socket("10.0.0.119", 9999);
		new CChat(withServer);
	}

}
