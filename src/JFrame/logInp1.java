package JFrame;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class logInp1 extends JFrame {

	public void login(String id)  {
		JPanel panel = new JPanel();
		setBounds(600, 420, 175, 121);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(id + "님 로그인 되었습니다.");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		lblNewLabel.setBounds(12, 10, 281, 57);
		panel.add(lblNewLabel);
		setVisible(true);

	}	
}
