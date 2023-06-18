package view.Test;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.data.general.DefaultPieDataset;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import Models.myDate;
import view.Customer.PanelFindTrip;
import view.Customer.PanelFindTripTop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Test() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout());
		
		JDateChooser dateChooser = new JDateChooser();
		
		dateChooser.setDateFormatString("dd/MM/yyyy");
		
		JTextFieldDateEditor editor = (JTextFieldDateEditor) dateChooser.getDateEditor();
        editor.setEditable(false);
        
        
        JButton temp = new JButton();
        temp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String dateString = "2023-05-17"; // Chuỗi ngày tháng cần chuyển đổi
		        String pattern = "yyyy-MM-dd"; // Định dạng của chuỗi ngày tháng

		        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		        try {
		            Date date = dateFormat.parse(dateString);
		            dateChooser.setDate(date);
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
			}
		});
        
        contentPane.add(temp);
        
		dateChooser.setBounds(167, 10, 132, 20);
		contentPane.add(dateChooser);
		
	}
}
