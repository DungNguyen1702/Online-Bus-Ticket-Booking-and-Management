package Tests;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedDomainCategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.AreaRenderer;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import com.orsoncharts.util.json.parser.ParseException;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import Algorithm.floydWarshall2;
import BUS.JDBCUtil;
import DAO.DAOBill;
import DAO.DAOBus;
import DAO.DAOCity;
import DAO.DAOCustomer;
import DAO.DAOInfoCustomer;
import DAO.DAORoute;
import DAO.DAOTrip;
import Models.Bill;
import Models.Bus;
import Models.City;
import Models.Customer;
import Models.InfoCustomer;
import Models.Route;
import Models.Trip;

public class Test1 {
	public static void main(String[] args) {
		String dateString = "2023-05-17"; // Chuỗi ngày tháng cần chuyển đổi
        String pattern = "yyyy-MM-dd"; // Định dạng của chuỗi ngày tháng

        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            Date date = dateFormat.parse(dateString);
            System.out.println("Date: " + date);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
	}
}
