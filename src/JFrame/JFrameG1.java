package JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import client1.CChat;
import client1.CDAO;
import client1.CDTO;
import client2.GChat;
import client2.GDAO;
import client2.GDTO;

@SuppressWarnings("serial")
public class JFrameG1 extends JFrame{
	
	private JPanel contentPane;
	JTextField[] indata = new JTextField[5];
	GChat myLog = null;
	GDAO myDao = GDAO.getInstance();
	GDTO ex = new GDTO();
	CDTO ex1 = new CDTO();
	private ArrayList<GDTO> gList = new ArrayList<>();
	private ArrayList<CDTO> cList = new ArrayList<>();
	
	public JFrameG1(GChat g) {
		myLog = g;
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
		setSize(410,670);
		this.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(34, 35, 323, 59);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fishing Day");
		lblNewLabel.setBounds(69, 10, 274, 46);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD | Font.ITALIC, 34));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(64, 160, 276, 272);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("아  이  디");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(13, 117, 57, 15);
		panel_1.add(lblNewLabel_1);
		
		indata[1] = new JTextField();
		indata[1].setBounds(96, 114, 78, 21);
		panel_1.add(indata[1]);
		indata[1].setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("비 밀 번 호");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(13, 171, 70, 15);
		panel_1.add(lblNewLabel_2);
		
		indata[2] = new JTextField();
		indata[2].setBounds(96, 168, 106, 21);
		panel_1.add(indata[2]);
		indata[2].setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("이       름");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(13, 203, 57, 15);
		panel_1.add(lblNewLabel_3);
		
		indata[3] = new JTextField();
		indata[3].setBounds(96, 200, 106, 21);
		panel_1.add(indata[3]);
		indata[3].setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("휴대폰 번호");
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(13, 235, 70, 18);
		panel_1.add(lblNewLabel_4);
		
		indata[4] = new JTextField();
		indata[4].setBounds(96, 234, 106, 21);
		panel_1.add(indata[4]);
		indata[4].setColumns(10);
		
		JButton btnNewButton_2 = new JButton("중복확인");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(100, 149, 237));
		
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.setFont(new Font("굴림", Font.PLAIN, 10));
		btnNewButton_2.setBounds(183, 113, 76, 23);
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_8 = new JLabel(" ");
		lblNewLabel_8.setForeground(new Color(220, 20, 60));
		lblNewLabel_8.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_8.setBounds(40, 142, 162, 19);
		panel_1.add(lblNewLabel_8);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(67, 460, 276, 68);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JButton btnNewButton = new JButton("가입하기");
		btnNewButton.setBounds(31, 10, 92, 28);
		panel_2.add(btnNewButton);
		
		JLabel idchk = new JLabel(" ");
		idchk.setBounds(40, 74, 165, 15);
		panel_1.add(idchk);
		setVisible(true);
		
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// 아이디 글자수 제한, 중복확인
				gList = myDao.selAll();
				if (indata[1].getText().length() <= 8) {
					for (int i = 0; i < gList.size(); i++) {
						if(gList.get(i).getId().equals(indata[1].getText())) {
							idchk.setText("아이디가 중복되었습니다.");
						}else {
							idchk.setText("사용가능한 아이디입니다.");
						}
					}
				} else { // 8글자 이하가 아닌 경우
					idchk.setText("아이디는 8글자 이하로 가능합니다");
					indata[1].setText(" ");
					
				}

			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object cobj = e.getSource();
				if(cobj.equals(btnNewButton)) {
					ex.data.add(0, "addA");
					System.out.println(ex.data.get(0));
					try {
						for (int i = 1; i < 5; i++) {
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
