package view.Customer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class PanelFindTripTop extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelFindTripTop() {
		this.setBounds(0, 0, 529, 129);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("GAVN");
		lblNewLabel_3.setBounds(334, 10, 182, 59);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(0, 128, 128));
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 55));
		lblNewLabel_3.setBackground(new Color(128, 255, 255));
		this.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Hotline: 0909090909");
		lblNewLabel_2.setBounds(337, 69, 181, 26);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		this.add(lblNewLabel_2);
		
		JLabel txtFielt1 = new JLabel();
		txtFielt1.setFont(new Font("Verdana", Font.BOLD, 20));
		txtFielt1.setBackground(new Color(240,240,240));
		txtFielt1.setText("Tìm kiếm lộ trình");
		txtFielt1.setBounds(130, 24, 208, 71);
		add(txtFielt1);
		
		ImageIcon icon = new ImageIcon(PanelFindTripTop.class.getResource("/photo/BusImage.png"));
		Image image = icon.getImage();
		Image scaledImage = image.getScaledInstance(90, 80, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(12, 15, 90, 80);
		lblLogo.setIcon(scaledIcon);
		add(lblLogo);
	}
}
