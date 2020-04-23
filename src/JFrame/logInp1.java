package JFrame;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class logInp1 extends JFrame {

	public void login()  {
		JPanel panel = new JPanel();
		setBounds(600, 420, 175, 121);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("로그인 되었습니다.");
		lblNewLabel.setBounds(26, 10, 133, 57);
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
