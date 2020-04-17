package client1;

import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class JFrameC1 extends JFrame {
	
	private JPanel contentPane;
	private JButton addBtn = new JButton("가입하기");
	JTextField[] indata = new JTextField[7];
	CChat myLog = null;
	CDTO1 ex = new CDTO1();
	
	JFrameC1(CChat c) {
		myLog = c;
		init();
	}

	public void init() {

		setTitle("낚시가자 1.0v");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setSize(410, 670);

		JPanel panel = new JPanel();
		panel.setBounds(34, 35, 323, 59);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(74, 10, 237, 46);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 34));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(67, 174, 238, 272);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("아  이  디");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(23, 25, 57, 15);
		panel_1.add(lblNewLabel_1);

		indata[0] = new JTextField();
		indata[0].setBounds(113, 22, 116, 21);
		panel_1.add(indata[0]);
		indata[0].setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("비 밀 번 호");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(23, 53, 70, 15);
		panel_1.add(lblNewLabel_2);

		indata[1] = new JTextField();
		indata[1].setBounds(113, 50, 116, 21);
		panel_1.add(indata[1]);
		indata[1].setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("이       름");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(23, 81, 57, 15);
		panel_1.add(lblNewLabel_3);

		indata[2] = new JTextField();
		indata[2].setBounds(113, 78, 116, 21);
		panel_1.add(indata[2]);
		indata[2].setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("휴대폰 번호");
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(23, 109, 70, 18);
		panel_1.add(lblNewLabel_4);

		indata[3] = new JTextField();
		indata[3].setBounds(113, 108, 116, 21);
		panel_1.add(indata[3]);
		indata[3].setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("배  번  호");
		lblNewLabel_5.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(24, 145, 57, 15);
		panel_1.add(lblNewLabel_5);

		indata[4] = new JTextField();
		indata[4].setBounds(113, 139, 116, 21);
		panel_1.add(indata[4]);
		indata[4].setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("배  이  름");
		lblNewLabel_6.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(24, 176, 57, 15);
		panel_1.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("출 조 지 역");
		lblNewLabel_7.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(24, 208, 69, 15);
		panel_1.add(lblNewLabel_7);

		indata[5] = new JTextField();
		indata[5].setBounds(113, 207, 116, 21);
		panel_1.add(indata[5]);
		indata[5].setColumns(10);

		indata[6] = new JTextField();
		indata[6].setBounds(113, 174, 116, 21);
		panel_1.add(indata[6]);
		indata[6].setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(67, 460, 238, 68);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		addBtn.setBounds(31, 10, 92, 28);
	
		panel_2.add(addBtn);
		setVisible(true);
		
		
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object cobj = e.getSource();
				if(cobj.equals(addBtn)) {
					try {
						for (int i = 0; i < indata.length; i++) {
							ex.data.add(indata[i].getText());
							System.out.println(ex.data.get(i));
						}
						myLog.streamSet(ex.data);
						dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		JButton cancelBtn = new JButton("취소");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelBtn.setBounds(146, 10, 92, 28);
		panel_2.add(cancelBtn);
	}
	
	
}

