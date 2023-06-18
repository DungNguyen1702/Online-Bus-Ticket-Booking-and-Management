package view.admin;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedDomainCategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import DAO.DAOCity;
import DAO.DAOStatistic;
import DAO.DAOTrip;
import controller.admin.StatisticAllListener;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class PanelStatisticAll extends JPanel {
	private JTextField txtIncome;
	private JTextField txtNumTicket;
	private JTextField txtNumUser;
	private JTextField txtNumBill;
	private List<Object[]> dataYear = new ArrayList<>();
	private DefaultTableModel dtmYear = new DefaultTableModel() {
	    @Override
	    public boolean isCellEditable(int row, int column) {
	        return false;
	    }
	};
	private DefaultTableModel dtmTop = new DefaultTableModel() {
	    @Override
	    public boolean isCellEditable(int row, int column) {
	        return false;
	    }
	};
	private JTable tableYear, tableTop;
	public JComboBox<String> cbTop;
	public JPanel panelChart;
	public JLabel lblReset;

	private void GUI()
	{
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(188, 0, 614, 553);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THỐNG KÊ CẢ DOANH NGHIỆP");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel.setBounds(128, 10, 380, 34);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 41, 297, 192);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1.setBounds(87, 0, 101, 27);
		panel.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 26, 277, 161);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Tổng doanh thu");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 13, 108, 24);
		panel_4.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Số vé đã bán");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(10, 50, 108, 24);
		panel_4.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Số lượng người dùng");
		lblNewLabel_3_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_3_1_1.setBounds(10, 87, 108, 24);
		panel_4.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Số lượng hóa đơn");
		lblNewLabel_3_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_3_1_2.setBounds(10, 124, 108, 24);
		panel_4.add(lblNewLabel_3_1_2);
		
		txtIncome = new JTextField();
		txtIncome.setEditable(false);
		txtIncome.setBounds(120, 13, 147, 24);
		panel_4.add(txtIncome);
		txtIncome.setColumns(10);
		
		txtNumTicket = new JTextField();
		txtNumTicket.setEditable(false);
		txtNumTicket.setColumns(10);
		txtNumTicket.setBounds(120, 50, 147, 24);
		panel_4.add(txtNumTicket);
		
		txtNumUser = new JTextField();
		txtNumUser.setEditable(false);
		txtNumUser.setColumns(10);
		txtNumUser.setBounds(120, 87, 147, 24);
		panel_4.add(txtNumUser);
		
		txtNumBill = new JTextField();
		txtNumBill.setEditable(false);
		txtNumBill.setColumns(10);
		txtNumBill.setBounds(120, 124, 147, 24);
		panel_4.add(txtNumBill);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(301, 41, 303, 192);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Được ưu chuộng");
		lblNewLabel_1_1.setForeground(Color.ORANGE);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(70, 0, 175, 27);
		panel_1.add(lblNewLabel_1_1);
		
		dtmTop.addColumn("RouteID");
		dtmTop.addColumn("Nơi đi");
		dtmTop.addColumn("Nơi đến");
		dtmTop.addColumn("Vé đã bán");
		
		tableTop = new JTable(dtmTop);
		tableTop.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JScrollPane scrollPane = new JScrollPane(tableTop);
		scrollPane.setBounds(10, 57, 283, 130);
		panel_1.add(scrollPane);
		
		JLabel lblNewLabel_2 = new JLabel("Top");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 31, 30, 21);
		panel_1.add(lblNewLabel_2);
		
		cbTop = new JComboBox<>();
		cbTop.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		cbTop.addItem("Top 1");
		cbTop.addItem("Top 2");
		cbTop.addItem("Top 3");
		cbTop.addItem("Top 4");
		cbTop.addItem("Top 5");
		cbTop.addItem("Top 6");
		cbTop.addItem("Top 7");
		cbTop.addItem("Top 8");
		cbTop.setBounds(46, 31, 226, 21);
		panel_1.add(cbTop);
		cbTop.addActionListener(new StatisticAllListener(this));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 232, 297, 311);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Doanh thu qua các năm");
		lblNewLabel_1_2.setForeground(Color.ORANGE);
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(39, 0, 236, 27);
		panel_2.add(lblNewLabel_1_2);
		
		dtmYear.addColumn("Năm");
		dtmYear.addColumn("Doanh thu");
		dtmYear.addColumn("Vé đã bán");
		
		tableYear = new JTable(dtmYear);
		tableYear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JScrollPane scrollPaneYear = new JScrollPane(tableYear);
		scrollPaneYear.setBounds(10, 37, 277, 264);
		panel_2.add(scrollPaneYear);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(301, 232, 303, 311);
		add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Biểu đồ doanh thu");
		lblNewLabel_1_2_1.setForeground(Color.ORANGE);
		lblNewLabel_1_2_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_2_1.setBounds(54, 0, 181, 27);
		panel_3.add(lblNewLabel_1_2_1);
		
		 panelChart = new JPanel();
		panelChart.setLayout(new GridLayout(1,1));
		panelChart.setBounds(10, 37, 283, 264);
		panel_3.add(panelChart);
		
		ImageIcon icon = new ImageIcon(PanelTripInDay.class.getResource("/photo/reset.png"));
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(33, 33, Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		
		
		lblReset = new JLabel("");
		lblReset.setBounds(558, 11, 33, 33);
		lblReset.setIcon(newIcon);
		add(lblReset);
		
		lblReset.addMouseListener(new StatisticAllListener(this));
	}
	
	
	public PanelStatisticAll() throws ClassNotFoundException, SQLException {
		this.GUI();
		this.Init_Info();
		this.cbTop.setSelectedIndex(2);
		cbTop_picked();
		this.setTableYear();
		this.setChart();
	}
	
	public void btnReset_Click() throws SQLException, ClassNotFoundException
	{
		this.Init_Info();
		this.cbTop.setSelectedIndex(2);
		cbTop_picked();
		this.setTableYear();
		this.setChart();
	}
	
	private void Init_Info() throws ClassNotFoundException, SQLException
	{
		Object[] data = DAOStatistic.getInstance().StatisticAll_Info();
		
		this.txtIncome.setText(data[0] + "");
		this.txtNumTicket.setText(data[1] + "");
		this.txtNumUser.setText(data[2] + "");
		this.txtNumBill.setText(data[3] + "");
	}
	
	public void SetTableTop(List<Object[]> data)
	{
		int n = tableTop.getRowCount();
		for(int i = 0; i <n ; i++)
		{
			dtmTop.removeRow(0);
		}
		
		for(Object[] item : data)
		{
			dtmTop.addRow(item);
		}
	}
	
	public void cbTop_picked() throws SQLException
	{
		String TopS = cbTop.getSelectedItem() + "";
		int Top = Integer.parseInt(TopS.substring(4));
		List<Object[]> data = DAOStatistic.getInstance().DataTopStatisticAll(Top);
		SetTableTop(data);
	}
	
	public void setTableYear() throws SQLException
	{		
		List<Integer> ListYear = DAOTrip.getInstance().getListYear();
		
		int k = dataYear.size();
		
		for(int i = 0 ; i < k ; i++)
		{
			dataYear.remove(0);
		}
		
		for(Integer item : ListYear)
		{
			Object[] temp = DAOStatistic.getInstance().getStatisticByYearInAll(item);
			Object[] temp2 = new Object[] {item, temp[0], temp[1]};
			this.dataYear.add(temp2);
		}
		
		int n = tableYear.getRowCount();
		for(int i = 0 ; i < n ; i ++)
		{
			dtmYear.removeRow(0);
		}
		
		for(Object[] item : dataYear)
		{
			dtmYear.addRow(item);
		}
	}
	
	public void setChart()
	{
		
		panelChart.removeAll();
		panelChart.repaint();
		panelChart.revalidate();
		
		 // Tạo dataset
        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
//        dataset.addValue(200, "Series 1", "Category 1");
//        dataset.addValue(300, "Series 2", "Category 1");
//        dataset.addValue(400, "Series 1", "Category 2");
//        dataset.addValue(500, "Series 2", "Category 2");

        for(Object[] item : dataYear)
        {
        	dataset1.addValue(Double.parseDouble(item[1] + ""), "Doanh thu", item[0] + "");
        	dataset2.addValue(Double.parseDouble(item[2] + ""), "Số lượng vé", item[0] + "");
        }
        
//        // Tạo biểu đồ cột ghép
//        JFreeChart chart = ChartFactory.createBarChart(
//            "", "Category", "Value", dataset, PlotOrientation.VERTICAL,
//            true, true, false
//        );
//        
//        // Tùy chỉnh biểu đồ
//        CategoryPlot plot = chart.getCategoryPlot();
//        plot.setDomainAxis(new CategoryAxis("Category"));
//        plot.setRangeAxis(new NumberAxis("Value"));
//
//        // Tạo chart panel
//        ChartPanel chartPanel = new ChartPanel(chart);
//        
//        panelChart.add(chartPanel);
        
     // Tạo biểu đồ cột
        CategoryPlot barPlot = new CategoryPlot();
        BarRenderer barRenderer = new BarRenderer();
        barPlot.setDataset(dataset1);
        barPlot.setRenderer(barRenderer);
        barPlot.setRangeAxis(new NumberAxis("Đồng")); // Thiết lập trục giá trị

        // Tạo biểu đồ miền
        CategoryPlot areaPlot = new CategoryPlot();
        BarRenderer areaRenderer = new BarRenderer();
        areaPlot.setDataset(dataset2);
        areaPlot.setRenderer(areaRenderer);
        areaPlot.setRangeAxis(new NumberAxis("Vé")); // Thiết lập trục giá trị

        // Tạo CombinedDomainCategoryPlot và thêm cả hai plot vào
        CombinedDomainCategoryPlot combinedPlot = new CombinedDomainCategoryPlot();
        combinedPlot.add(barPlot);
        combinedPlot.add(areaPlot);

        // Tạo JFreeChart từ CombinedDomainCategoryPlot
        JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, combinedPlot, true);

        // Hiển thị biểu đồ trong cửa sổ
        ChartPanel frame = new ChartPanel(chart);

	    panelChart.add(frame);
	}
}
