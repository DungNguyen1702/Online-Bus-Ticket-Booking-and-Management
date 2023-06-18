package view.Test;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.IDateEditor;
import com.toedter.calendar.JDateChooser;

public class TestCalendar extends JFrame{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestCalendar frame = new TestCalendar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestCalendar() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JDateChooser dateChooser =  new JDateChooser();
		Date d = new Date(2023-1901,12-1,3);
		dateChooser.setPreferredSize(new Dimension(200, 30));
		dateChooser.setDate(d);
		
		dateChooser.getDateEditor().addPropertyChangeListener(e -> {
		    // Handle date change event here
		    java.util.Date selectedDate = dateChooser.getDate();
		    // Perform desired actions with the selected date
		    
		    System.out.println(selectedDate.getMonth()+1);
		});
		contentPane.add(dateChooser);
		setContentPane(contentPane);
	}


}
