package view.admin;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PanelHomeAdmin extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelHomeAdmin() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(188, 0, 614, 553);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 31));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(130, 116, 337, 136);
		add(lblNewLabel);
	}
}
