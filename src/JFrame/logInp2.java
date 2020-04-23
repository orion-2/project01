package JFrame;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class logInp2 extends JFrame {

	public void login() {
		
		JPanel panel = new JPanel();
		setBounds(600, 420, 321, 121);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("아이디와 비밀번호를 확인하세요");
		lblNewLabel.setBounds(43, 10, 233, 57);
		panel.add(lblNewLabel);
		setVisible(true);
//		try {
//			Thread.sleep(1000);
//			dispose();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}	
}
