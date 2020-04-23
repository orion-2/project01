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
	private JPanel contentPane;
	private JTextField[] indata = new JTextField[7];
	CChat myLog = null;
	
	RCDTO rcDTO = new RCDTO();
	RCDAO myDao = RCDAO.getInstance();
	
	JFrameReserC(CChat c) {
		myLog = c;
		reservation();
	}
	
	public void reservation() {
		setBackground(Color.WHITE);
		setTitle("낚시가자 1.0v");
		setBounds(500, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("CheckBox.background"));
		panel_1.setBounds(12, 20, 370, 273);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("출 항 등 록");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(12, 10, 110, 28);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 48, 370, 225);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("배 번호");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(12, 39, 57, 15);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("배 이름");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(72, 39, 57, 15);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("날  짜");
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(180, 40, 64, 15);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("인  원");
		lblNewLabel_5.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(286, 38, 57, 15);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("출 항 지");
		lblNewLabel_7.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(70, 95, 57, 21);
		panel_2.add(lblNewLabel_7);
		
		indata[2] = new JTextField();
		indata[2].setBounds(12, 64, 45, 21);
		panel_2.add(indata[2]);
		indata[2].setColumns(10);
		
		indata[6] = new JTextField();
		indata[6].setBounds(75, 64, 61, 21);
		panel_2.add(indata[6]);
		indata[6].setColumns(10);
		
		indata[4] = new JTextField();
		indata[4].setBounds(162, 63, 90, 21);
		panel_2.add(indata[4]);
		indata[4].setColumns(10);
		
		indata[5] = new JTextField();
		indata[5].setBounds(276, 61, 49, 21);
		panel_2.add(indata[5]);
		indata[5].setColumns(10);
		
		indata[3] = new JTextField();
		indata[3].setBounds(75, 123, 116, 21);
		panel_2.add(indata[3]);
		indata[3].setColumns(10);
		
		JButton reg = new JButton("등 록");
		reg.setFont(new Font("굴림", Font.PLAIN, 12));
		reg.setBounds(195, 172, 64, 23);
		panel_2.add(reg);
		
		JButton cancel = new JButton("취 소");
		cancel.setFont(new Font("굴림", Font.PLAIN, 12));
		cancel.setBounds(272, 172, 64, 23);
		panel_2.add(cancel);
		
		setSize(410,360);
		setVisible(true);

		reg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object cobj = e.getSource();
				if (cobj.equals(reg)) {
					
					rcDTO.data.add(0, "addC");
					rcDTO.data.add(1, "Id" );
					try {
						for (int i = 2; i < 7; i++) {
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
