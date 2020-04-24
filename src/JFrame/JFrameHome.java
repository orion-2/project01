package JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import client1.CChat;
import client1.CDAO;
import client1.CDTO;
import client2.GChat;
import client2.GDAO;
import client2.GDTO;

@SuppressWarnings("serial")
public class JFrameHome extends JFrame {

	private JPanel contentPane;
	JTextField[] indata = new JTextField[2];
	CChat myHome = null;
	GChat myHome1 = null;
	CDTO ex = new CDTO();
	CDAO myDao = CDAO.getInstance();
	GDTO ex1 = new GDTO();
	GDAO myDao1 = GDAO.getInstance();
	private ArrayList<CDTO> cList = new ArrayList<>();
	private ArrayList<GDTO> gList = new ArrayList<>();
	logInp1 s = new logInp1();
	logInp2 p = new logInp2();

	public JFrameHome(CChat c, GChat g) {
		myHome = c;
		myHome1 = g;
		init();
	}

	public void init() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setSize(410, 670);

		JLabel lblImage = new JLabel();
		lblImage.setBounds(5, 143, 371, 255);
		setTitle("임시제목 1.0v");
		contentPane.setLayout(null);
		contentPane.add(lblImage, BorderLayout.CENTER);

		lblImage.setIcon(new ImageIcon("2.jpg"));
		contentPane.add(lblImage);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(5, 107, 10, 291);
		contentPane.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(373, 107, 10, 291);
		contentPane.add(panel_3);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(6, 446, 377, 31);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		JLabel ID = new JLabel(" 아 이 디     ");
		ID.setBounds(94, 8, 68, 15);
		panel_4.add(ID);

		indata[0] = new JTextField();
		indata[0].setBounds(161, 5, 116, 21);
		panel_4.add(indata[0]);
		indata[0].setColumns(10);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(5, 487, 377, 37);
		contentPane.add(panel_5);
		panel_5.setLayout(null);

		JLabel PW = new JLabel("비밀번호   ");
		PW.setBounds(95, 8, 65, 15);
		panel_5.add(PW);

		indata[1] = new JTextField();
		indata[1].setBounds(161, 5, 116, 21);
		panel_5.add(indata[1]);
		indata[1].setColumns(10);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(6, 534, 377, 33);
		contentPane.add(panel_6);

		JButton btnNewButton = new JButton("회원가입");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new JFrameSelec(myHome, myHome1);
			}
		});

		btnNewButton.setBackground(Color.WHITE);
		panel_6.add(btnNewButton);

		JButton logIn = new JButton("로 그 인");
		logIn.setForeground(new Color(255, 255, 255));
		logIn.setBackground(new Color(30, 144, 255));
		panel_6.add(logIn);
		logIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrameMain m = new JFrameMain(myHome);
				logInp1 l = new logInp1();
				cList = myDao.selAll();
				for (int i = 0; i < cList.size(); i++) {
					if (cList.get(i).getId().equals(indata[0].getText())
							&& cList.get(i).getPw().equals(indata[1].getText())) {
						m.JMain(cList.get(i).getId());
						l.login(cList.get(i).getId());
						dispose(); 
						
					}else {
						gList = myDao1.selAll();
						for (int j = 0; j < gList.size(); j++) {
							
						if (gList.get(j).getId().equals(indata[0].getText())
								&& gList.get(j).getPw().equals(indata[1].getText())) {
							m.JMain(gList.get(j).getId());
							l.login(gList.get(j).getId());
							dispose(); 
						}
						}
					}
					
				}
			}
		});

		JPanel panel = new JPanel();
		panel.setBounds(34, 35, 323, 59);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("Fishing Day");
		lblNewLabel.setBounds(69, 10, 274, 46);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD | Font.ITALIC, 34));
		panel.add(lblNewLabel);

		setVisible(true);
	}
}
