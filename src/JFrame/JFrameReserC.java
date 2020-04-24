package JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import client1.CChat;
import client1.CDAO;
import client1.RCDAO;
import client1.RCDTO;

public class JFrameReserC extends JFrame{
	private String id = null;
	private JPanel contentPane;
	private JTextField[] indata = new JTextField[7];
	CChat myLog = null;
	RCDTO rcDTO = new RCDTO();
	RCDAO myDao = RCDAO.getInstance();
	
	JFrameReserC(CChat c) {
		myLog = c;
		reservation(id);
	}
	
	public void reservation(String id) {
		setBackground(Color.WHITE);
		setTitle("낚시가자 1.0v");
		setBounds(500, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("CheckBox.background"));
		panel_1.setBounds(12, 15, 560, 273);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("출 항 등 록");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));		
		lblNewLabel_1.setBounds(12, 10, 110, 28);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 48, 549, 225);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel(" ID");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 36, 57, 15);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("선박번호");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(79, 36, 57, 15);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("선박이름");
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(139, 36, 57, 15);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(" 날  짜 ");
		lblNewLabel_5.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(231, 36, 57, 15);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("출 항 지");
		lblNewLabel_6.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(356, 36, 57, 15);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("가  격");
		lblNewLabel_7.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(460, 33, 57, 21);
		panel_2.add(lblNewLabel_7);
		
		
		indata[1] = new JTextField();
		indata[1].setBounds(10, 61, 57, 21);
		panel_2.add(indata[1]);
		indata[1].setColumns(10);
		
		indata[2] = new JTextField();
		indata[2].setBounds(79, 61, 48, 21);
		panel_2.add(indata[2]);
		indata[2].setColumns(10);
		
		indata[3] = new JTextField();
		indata[3].setBounds(139, 61, 80, 21);
		panel_2.add(indata[3]);
		indata[3].setColumns(10);
		
		indata[4] = new JTextField();
		indata[4].setBounds(231, 61, 113, 21);
		panel_2.add(indata[4]);
		indata[4].setColumns(10);
		
		indata[5] = new JTextField();
		indata[5].setBounds(356, 61, 69, 21);
		panel_2.add(indata[5]);
		indata[5].setColumns(10);
		
		indata[6] = new JTextField();
		indata[6].setBounds(437, 61, 80, 21);
		panel_2.add(indata[6]);
		indata[6].setColumns(10);
		
		JButton reg = new JButton("등 록");
		reg.setForeground(Color.WHITE);
		reg.setBackground(new Color(0, 102, 153));
		reg.setFont(new Font("굴림", Font.PLAIN, 12));
		reg.setBounds(356, 119, 69, 23);
		panel_2.add(reg);
		
		JButton cancel = new JButton("취 소");
		cancel.setForeground(new Color(0, 0, 0));
		cancel.setBackground(Color.WHITE);
		cancel.setFont(new Font("굴림", Font.PLAIN, 12));
		cancel.setBounds(437, 119, 74, 23);
		panel_2.add(cancel);
		
		setSize(600,358);
		setVisible(true);

		reg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object cobj = e.getSource();
				if (cobj.equals(reg)) {
					
					rcDTO.data.add(0, "addC");
					try {
						for (int i = 1; i < 7; i++) {
							rcDTO.data.add(indata[i].getText());
						}
						myLog.streamSet(rcDTO.data);
						dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}
}
