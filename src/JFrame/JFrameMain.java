package JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import client1.CChat;

public class JFrameMain extends JFrame {
	
	private JPanel contentPane;
	CChat myLog = null;
	JFrameMain(CChat c){
		myLog = c;
	}
	
	public void JMain() {
		
		setTitle("낚시가자 1.0v");
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
		
		JLabel lblImage = new JLabel();
		lblImage.setBounds(34, 103, 323, 285);
		contentPane.setLayout(null);
		contentPane.add(lblImage, BorderLayout.CENTER);
		
		lblImage.setIcon(new ImageIcon("지도.jpg"));
		contentPane.add(lblImage);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(34, 125, 323, 230);
		contentPane.add(panel_1);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(34, 398, 320, 190);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton reservation = new JButton("예 약");
		reservation.setFont(new Font("굴림", Font.PLAIN, 17));
		reservation.setForeground(new Color(230, 230, 250));
		reservation.setBackground(new Color(0, 102, 153));
		reservation.setBounds(0, 6, 106, 96);
		panel_2.add(reservation);
		reservation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFrameReserC r = new JFrameReserC(myLog);
				r.reservation();
			}
		});
		
		JButton cancel = new JButton("취 소");
		cancel.setFont(new Font("굴림", Font.PLAIN, 17));
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(new Color(0, 102, 153));
		cancel.setBounds(106, 6, 106, 96);
		panel_2.add(cancel);
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		JButton list = new JButton("목 록");
		list.setFont(new Font("굴림", Font.PLAIN, 17));
		list.setForeground(new Color(230, 230, 250));
		list.setBackground(new Color(0, 102, 153));
		list.setBounds(212, 6, 106, 96);
		panel_2.add(list);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		JButton notice = new JButton("공 지");
		notice.setBackground(Color.WHITE);
		notice.setFont(new Font("굴림", Font.PLAIN, 14));
		notice.setBounds(0, 107, 151, 33);
		panel_2.add(notice);
		notice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		JButton board = new JButton("게 시 판");
		board.setBackground(Color.WHITE);
		board.setFont(new Font("굴림", Font.PLAIN, 14));
		board.setBounds(156, 107, 162, 33);
		panel_2.add(board);
		board.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		
		JButton btnNewButton_5 = new JButton("19");
		btnNewButton_5.setForeground(Color.RED);
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_5.setFont(new Font("굴림", Font.PLAIN, 9));
		btnNewButton_5.setBounds(0, 145, 45, 39);
		panel_2.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("20");
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.setFont(new Font("굴림", Font.PLAIN, 9));
		btnNewButton_6.setBounds(45, 145, 45, 39);
		panel_2.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("21");
		btnNewButton_7.setBackground(Color.WHITE);
		btnNewButton_7.setFont(new Font("굴림", Font.PLAIN, 9));
		btnNewButton_7.setBounds(90, 145, 45, 39);
		panel_2.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("22");
		btnNewButton_8.setBackground(Color.WHITE);
		btnNewButton_8.setFont(new Font("굴림", Font.PLAIN, 9));
		btnNewButton_8.setBounds(136, 145, 45, 39);
		panel_2.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("23");
		btnNewButton_9.setBackground(Color.WHITE);
		btnNewButton_9.setFont(new Font("굴림", Font.PLAIN, 9));
		btnNewButton_9.setBounds(182, 145, 45, 39);
		panel_2.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("24");
		btnNewButton_10.setBackground(Color.WHITE);
		btnNewButton_10.setFont(new Font("굴림", Font.PLAIN, 9));
		btnNewButton_10.setBounds(228, 145, 45, 39);
		panel_2.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("25");
		btnNewButton_11.setForeground(Color.BLUE);
		btnNewButton_11.setBackground(Color.WHITE);
		btnNewButton_11.setFont(new Font("굴림", Font.PLAIN, 9));
		btnNewButton_11.setBounds(274, 145, 45, 39);
		panel_2.add(btnNewButton_11);
		setVisible(true);
	}
}
