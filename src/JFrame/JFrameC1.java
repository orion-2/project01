package JFrame;

import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.Socket;
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
import client2.GDTO;

@SuppressWarnings("serial")
public class JFrameC1 extends JFrame {

	private JPanel contentPane;
	JTextField[] indata = new JTextField[8];
	CChat myLog = null;
	CDTO ex = new CDTO();
	CDAO myDao = CDAO.getInstance();
	GDTO ex1 = new GDTO();
	private ArrayList<CDTO> cList = new ArrayList<>();
	private ArrayList<GDTO> gList = new ArrayList<>();

	public JFrameC1(CChat c) {
		myLog = c;
		init();
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void init() {

		setTitle("Fishing Day 1.0v");
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

		JLabel lblNewLabel = new JLabel("Fishing Day");
		lblNewLabel.setBounds(69, 10, 274, 46);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD | Font.ITALIC, 34));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(65, 158, 276, 272);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("아  이  디");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(23, 17, 57, 15);
		panel_1.add(lblNewLabel_1);

		indata[1] = new JTextField();
		indata[1].setBounds(106, 14, 78, 21);
		panel_1.add(indata[1]);
		indata[1].setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("비 밀 번 호");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(23, 71, 70, 15);
		panel_1.add(lblNewLabel_2);

		indata[2] = new JTextField();
		indata[2].setBounds(106, 68, 106, 21);
		panel_1.add(indata[2]);
		indata[2].setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("이       름");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(23, 103, 57, 15);
		panel_1.add(lblNewLabel_3);

		indata[3] = new JTextField();
		indata[3].setBounds(106, 100, 106, 21);
		panel_1.add(indata[3]);
		indata[3].setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("휴대폰 번호");
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(23, 135, 70, 18);
		panel_1.add(lblNewLabel_4);
		
		indata[4] = new JTextField();
		indata[4].setBounds(106, 134, 106, 21);
		panel_1.add(indata[4]);
		indata[4].setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("배  번  호");
		lblNewLabel_5.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(24, 173, 57, 15);
		panel_1.add(lblNewLabel_5);

		indata[5] = new JTextField();
		indata[5].setBounds(106, 167, 106, 21);
		panel_1.add(indata[5]);
		indata[5].setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("배  이  름");
		lblNewLabel_6.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(24, 204, 57, 15);
		panel_1.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("출 조 지 역");
		lblNewLabel_7.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(24, 234, 69, 15);
		panel_1.add(lblNewLabel_7);

		indata[6] = new JTextField();
		indata[6].setBounds(106, 231, 106, 21);
		panel_1.add(indata[6]);
		indata[6].setColumns(10);

		indata[7] = new JTextField();
		indata[7].setBounds(106, 201, 106, 21);
		panel_1.add(indata[7]);
		indata[7].setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(67, 460, 238, 68);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JButton addBtn = new JButton("가입하기");
		addBtn.setBounds(31, 10, 92, 28);
		panel_2.add(addBtn);
		
		JButton btnNewButton_2 = new JButton("중복확인");
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.setFont(new Font("굴림", Font.PLAIN, 10));
		btnNewButton_2.setBounds(193, 13, 76, 23);
		panel_1.add(btnNewButton_2);
		
		JLabel idchk = new JLabel();
		idchk.setText(" ");
		idchk.setFont(new Font("굴림", Font.PLAIN, 11));
		idchk.setBounds(50, 42, 162, 19);
		panel_1.add(idchk);
		setVisible(true);

		idchk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// 아이디 글자수 제한, 중복확인
				cList = myDao.selAll();
				if (indata[1].getText().length() <= 8) {
					for (int i = 0; i < cList.size(); i++) {
						if(!cList.get(i).getId().equals(indata[1].getText())) {
							idchk.setText("사용가능한 아이디입니다.");
						}else {
							idchk.setText("중복된 아이디입니다.");
						}
					}
				} else { // 8글자 이하가 아닌 경우
					idchk.setText("아이디는 8글자 이하로 가능합니다");
					indata[1].setText("");
					
				}

			}
		});

		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object cobj = e.getSource();
				if (cobj.equals(addBtn)) {
					ex.data.add(0, "addB");
					System.out.println(ex.data.get(0));
					try {
						for (int i = 1; i < 8; i++) {
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
