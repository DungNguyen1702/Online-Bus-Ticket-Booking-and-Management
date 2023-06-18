package view.Customer;

import javax.swing.JPanel;

import controller.Customer.Buoc5Listener;

import java.awt.Color;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCamOn_B5 extends JPanel {
	public FormBookTicket fbt;
	
	public void GUI()
	{
		this.setBounds(0,0,529,500);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(170,244,240));
		panel.setBounds(10, 11, 509, 478);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon icon = new ImageIcon(PanelCamOn_B5.class.getResource("/photo/BusImage.png"));
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		lblNewLabel.setIcon(newIcon);
		lblNewLabel.setBounds(44, 0, 170, 153);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Hạng xe GAVN xin cảm ơn quý khách \r\n");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1.setForeground(new Color(244,55,13));
		lblNewLabel_1.setBounds(64, 96, 493, 171);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("đã tin tưởng và đặt vé xe ");
		lblNewLabel_1_1.setForeground(new Color(244,55,13));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(123, 109, 493, 211);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Chúc quý khách có một chuyến đi vui vẻ ");
		lblNewLabel_1_2.setForeground(new Color(48,118,15));
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_2.setBounds(54, 164, 493, 171);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("và trải nghiệm tốt khi sử dụng dịch vụ của GAVN");
		lblNewLabel_1_2_1.setForeground(new Color(48,118,15));
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_2_1.setBounds(10, 199, 493, 171);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Xin cảm ơn !!");
		lblNewLabel_1_2_1_1.setForeground(new Color(48,118,15));
		lblNewLabel_1_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_2_1_1.setBounds(185, 233, 493, 171);
		panel.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Mọi thông tin và thắc mắc xin vui lòng liên hệ ");
		lblNewLabel_1_2_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2_1_2.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel_1_2_1_2.setBounds(54, 262, 493, 171);
		panel.add(lblNewLabel_1_2_1_2);
		
		JLabel lblNewLabel_1_2_1_2_1 = new JLabel("Hotline : 0965582649 ( Phạm Duy Tin ) ");
		lblNewLabel_1_2_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1_2_1.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel_1_2_1_2_1.setBounds(87, 296, 493, 171);
		panel.add(lblNewLabel_1_2_1_2_1);
		
		JButton btnNewButton = new JButton("Thoát");
		
		btnNewButton.setBackground(new Color(255,224,164));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(386, 432, 123, 46);
		btnNewButton.addActionListener(new Buoc5Listener(this));
		panel.add(btnNewButton);
		
	}
	
	public PanelCamOn_B5(FormBookTicket fbt) {
		this.fbt = fbt;
		this.GUI();
	}

}
