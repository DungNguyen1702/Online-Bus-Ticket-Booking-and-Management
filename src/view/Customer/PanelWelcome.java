package view.Customer;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PanelWelcome extends JPanel {

	
	public void GUI()
	{
		this.setBackground(new Color(255, 255, 204));
		this.setBounds(0, 127, 529, 371);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GAVN Xin chào kính quý khách");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 31));
		lblNewLabel.setBounds(57, 121, 434, 43);
		add(lblNewLabel);
		
		JLabel lblChcQuKhch = new JLabel(" Chúc quý khách có những trải nghiệm");
		lblChcQuKhch.setBackground(Color.CYAN);
		lblChcQuKhch.setForeground(Color.ORANGE);
		lblChcQuKhch.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblChcQuKhch.setBounds(57, 167, 423, 43);
		add(lblChcQuKhch);
		
		JLabel lblTuytViKhi = new JLabel("  tuyệt vời khi sử dụng dịch vụ tại đây\r\n");
		lblTuytViKhi.setForeground(Color.RED);
		lblTuytViKhi.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTuytViKhi.setBounds(57, 214, 423, 43);
		add(lblTuytViKhi);
		
		JLabel lblNewLabel_1 = new JLabel("");
		ImageIcon icon = new ImageIcon(PanelWelcome.class.getResource("/photo/Heart.png"));
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		
		lblNewLabel_1.setIcon(newIcon);
		lblNewLabel_1.setBounds(20, 27, 60, 60);
		add(lblNewLabel_1);
	}
	
	public PanelWelcome() {
		this.GUI();
	}
}
