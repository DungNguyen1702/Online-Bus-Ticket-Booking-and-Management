package view.Customer;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class PanelUserTop extends JPanel{


	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public PanelUserTop() {
		this.setBounds(0, 0, 529, 129);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông tin cá nhân");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(25, 11, 158, 55);
		this.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PanelUserTop.class.getResource("/photo/Graphicloads-Flat-Finance-Person.96.png")));
		lblNewLabel_1.setBounds(193, 11, 96, 96);
		this.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("GAVN");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(0, 128, 128));
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 55));
		lblNewLabel_3.setBackground(new Color(128, 255, 255));
		lblNewLabel_3.setBounds(280, 7, 235, 59);
		this.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Hotline: 0909090909");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNewLabel_2.setBounds(312, 66, 181, 26);
		this.add(lblNewLabel_2);
	}
}
