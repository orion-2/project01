package client2;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import client1.CChat;

public class Main {

	public static void main(String[] args) throws IOException, IOException {
		Socket withServer = null;
		withServer = new Socket("10.0.0.119", 9999);
		new GChat(withServer);
	}
}
