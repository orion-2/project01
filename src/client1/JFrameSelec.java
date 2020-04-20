package client1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client2.GChat;
import client2.JFrameG1;

@SuppressWarnings("serial")
public class JFrameSelec extends JFrame {
	
	private JPanel contentPane;
	private JFrameC1 a = null;
	private CChat myC = null;
	private JFrameG1 b = null;
	private GChat myG = null;
		
	public JFrameSelec() {
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setSize(410, 670);

		JLabel lblImage = new JLabel();
		lblImage.setBounds(12, 140, 371, 255);
		setTitle("임시제목 1.0v");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setLayout(null);
		contentPane.add(lblImage, BorderLayout.CENTER);

		lblImage.setIcon(new ImageIcon("2.jpg"));
		contentPane.add(lblImage);

		JPanel panel = new JPanel();
		panel.setBounds(34, 35, 323, 59);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 34));
		panel.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(5, 107, 10, 291);
		contentPane.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(373, 107, 10, 291);
		contentPane.add(panel_3);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(6, 446, 377, 124);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		JButton btnNewButton = new JButton("일반 회원");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b = new JFrameG1(myG);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btnNewButton.setBounds(37, 10, 137, 39);
		panel_4.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("선주 회원");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = new JFrameC1(myC);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btnNewButton_1.setBounds(202, 10, 137, 39);
		panel_4.add(btnNewButton_1);
		setVisible(true);

	}
}
