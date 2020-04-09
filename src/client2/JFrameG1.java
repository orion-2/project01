package client2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class JFrameG1 extends JFrame {

	private JPanel contentPane;
	JTextField[] indata = new JTextField[4];
	
	public JFrameG1() {
		init();
	}
	
	public void init() {
		setTitle("낚시가자 1.0v");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setSize(410,670);
		
		JPanel panel = new JPanel();
		panel.setBounds(34, 35, 323, 59);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(74, 10, 237, 46);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 34));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(66, 166, 238, 272);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("아  이  디");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(30, 49, 57, 15);
		panel_1.add(lblNewLabel_1);
		
		indata[0] = new JTextField();
		indata[0].setBounds(99, 46, 116, 21);
		panel_1.add(indata[0]);
		indata[0].setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("비밀번호");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(30, 113, 57, 15);
		panel_1.add(lblNewLabel_2);
		
		indata[1] = new JTextField();
		indata[1].setBounds(99, 113, 116, 21);
		panel_1.add(indata[1]);
		indata[1].setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("이       름");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(30, 178, 57, 15);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("휴대폰번호");
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(30, 232, 70, 15);
		panel_1.add(lblNewLabel_4);
		
		indata[2] = new JTextField();
		indata[2].setBounds(100, 175, 116, 21);
		panel_1.add(indata[2]);
		indata[2].setColumns(10);
		
		indata[3] = new JTextField();
		indata[3].setBounds(100, 229, 116, 21);
		panel_1.add(indata[3]);
		indata[3].setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(66, 460, 238, 68);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton addBtn = new JButton("가입하기");
		setVisible(true);
		addBtn.setBounds(64, 10, 112, 35);
		panel_2.add(addBtn);
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String in[] = new String[4];
				for (int i = 0; i < indata.length; i++) {
					in[i] = indata[i].getText();
					indata[i].setText("");
				}
				saveToDB(in);
				System.out.println("DB success!");
			}

		});
		
		
	}
	public void saveToDB(String[] in) {
		// TODO Auto-generated method stub
		
		
	}
}


