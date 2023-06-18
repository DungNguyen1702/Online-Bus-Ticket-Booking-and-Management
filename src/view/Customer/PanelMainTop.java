package view.Customer;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class PanelMainTop extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelMainTop() {
		setBounds(0, 0, 529, 129);
		setLayout(null);
		
		JLabel lblBusImage = new JLabel("");
		ImageIcon icon = new ImageIcon(FormMainPage.class.getResource("/photo/BusImage.png"));
		Image image = icon.getImage();
		Image scaledImage = image.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		lblBusImage.setIcon(scaledIcon);
		lblBusImage.setBounds(22, 11, 165, 107);
		add(lblBusImage);
		
		JLabel lblNewLabel_3 = new JLabel("GAVN");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(0, 128, 128));
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 55));
		lblNewLabel_3.setBackground(new Color(128, 255, 255));
		lblNewLabel_3.setBounds(263, 21, 235, 59);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Hotline: 0909090909");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNewLabel.setBounds(295, 80, 181, 26);
		add(lblNewLabel);
	}

}
