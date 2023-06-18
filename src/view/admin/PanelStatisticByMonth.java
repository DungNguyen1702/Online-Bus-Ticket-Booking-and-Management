package view.admin;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartTheme;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

import DAO.DAOTicket;
import controller.admin.StatisticByMonthListener;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class PanelStatisticByMonth extends JPanel {
	private JTextField txtPer;
	private JTextField txtNumBill;
	private JTextField txtRevenue;
	private JTextField txtTotalTicket;
	private JTextField txtFirst;
	private JTextField txtMidle;
	private JTextField txtNormal;
	public JComboBox<String> cbTop, cbMonth;
	public DefaultTableModel dtm = new DefaultTableModel() {
	    @Override
	    public boolean isCellEditable(int row, int column) {
	        return false;
	    }
	};
	public JTable table;
	private JPanel panelChart;

	/**
	 * Create the panel.
	 */
	
	private void GUI()
	{
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(188, 0, 614, 553);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THỐNG KÊ THEO THÁNG");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(169, 10, 313, 39);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 55, 594, 171);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tháng");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 11, 45, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tổng số vé đã bán");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(312, 11, 119, 28);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("Số lượng hóa đơn");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 128, 119, 28);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Số vé hạng nhất");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(312, 50, 104, 28);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Số vé hạng trung");
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(312, 89, 104, 28);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Số vé hạng phổ thông");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1.setBounds(312, 128, 140, 28);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Doanh thu");
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(10, 50, 92, 28);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Chiểm tỉ lệ");
		lblNewLabel_4_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_4_1_1_1.setBounds(10, 89, 96, 28);
		panel.add(lblNewLabel_4_1_1_1);
		
		txtPer = new JTextField();
		txtPer.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtPer.setEditable(false);
		txtPer.setBounds(134, 89, 168, 28);
		panel.add(txtPer);
		txtPer.setColumns(10);
		
		txtNumBill = new JTextField();
		txtNumBill.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtNumBill.setEditable(false);
		txtNumBill.setColumns(10);
		txtNumBill.setBounds(134, 128, 168, 28);
		panel.add(txtNumBill);
		
		txtRevenue = new JTextField();
		txtRevenue.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtRevenue.setEditable(false);
		txtRevenue.setColumns(10);
		txtRevenue.setBounds(134, 50, 168, 28);
		panel.add(txtRevenue);
		
		txtTotalTicket = new JTextField();
		txtTotalTicket.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtTotalTicket.setEditable(false);
		txtTotalTicket.setColumns(10);
		txtTotalTicket.setBounds(453, 11, 131, 28);
		panel.add(txtTotalTicket);
		
		txtFirst = new JTextField();
		txtFirst.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtFirst.setEditable(false);
		txtFirst.setColumns(10);
		txtFirst.setBounds(453, 50, 131, 28);
		panel.add(txtFirst);
		
		txtMidle = new JTextField();
		txtMidle.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtMidle.setEditable(false);
		txtMidle.setColumns(10);
		txtMidle.setBounds(453, 89, 131, 28);
		panel.add(txtMidle);
		
		txtNormal = new JTextField();
		txtNormal.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtNormal.setEditable(false);
		txtNormal.setColumns(10);
		txtNormal.setBounds(453, 128, 131, 28);
		panel.add(txtNormal);
		
		cbMonth = new JComboBox<>();
		cbMonth.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cbMonth.setBounds(134, 11, 168, 28);
		cbMonth.addItem("Tháng 1");
		cbMonth.addItem("Tháng 2");
		cbMonth.addItem("Tháng 3");
		cbMonth.addItem("Tháng 4");
		cbMonth.addItem("Tháng 5");
		cbMonth.addItem("Tháng 6");
		cbMonth.addItem("Tháng 7");
		cbMonth.addItem("Tháng 8");
		cbMonth.addItem("Tháng 9");
		cbMonth.addItem("Tháng 10");
		cbMonth.addItem("Tháng 11");
		cbMonth.addItem("Tháng 12");		
		cbMonth.addActionListener(new StatisticByMonthListener(this));
		panel.add(cbMonth);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(318, 236, 286, 307);
		add(panel_1);
		panel_1.setLayout(null);
		
		 panelChart = new JPanel();
		panelChart.setBounds(10, 37, 266, 260);
		panel_1.add(panelChart);
		panelChart.setLayout(new GridLayout(1,1));
		
		JLabel lblNewLabel_2 = new JLabel("Biểu đồ loại vé");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(68, 10, 163, 21);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 236, 296, 307);
		add(panel_2);
		panel_2.setLayout(null);
		
		dtm.addColumn("Route ID");
		dtm.addColumn("Nơi đi");
		dtm.addColumn("Nơi đến");
		dtm.addColumn("Vé đã đặt");
		
		table = new JTable(dtm);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 63, 276, 234);
		panel_2.add(scrollPane);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tỉnh đi nhiều nhất");
		lblNewLabel_2_1.setForeground(Color.ORANGE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(48, 10, 201, 21);
		panel_2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("Top");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(16, 37, 32, 21);
		panel_2.add(lblNewLabel_3);
		
		cbTop = new JComboBox<>();
		cbTop.addItem("Top 1");
		cbTop.addItem("Top 2");
		cbTop.addItem("Top 3");
		cbTop.addItem("Top 4");
		cbTop.addItem("Top 5");
		cbTop.addItem("Top 6");
		cbTop.addItem("Top 7");
		cbTop.addItem("Top 8");
		cbTop.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		cbTop.setBounds(58, 37, 228, 21);
		cbTop.addActionListener(new StatisticByMonthListener(this));
		panel_2.add(cbTop);
	}
	
	public PanelStatisticByMonth() throws ClassNotFoundException, SQLException {
		this.GUI();
		this.cbMonth.setSelectedIndex(0);
		this.cbMonth_Pick();
	}
	
	public void cbMonth_Pick() throws ClassNotFoundException, SQLException
	{
		this.cbTop.setSelectedIndex(2);
		this.cbTop_Pick();
		
		String monthS = cbMonth.getSelectedItem() + "";
		int month = Integer.parseInt(monthS.substring(6));
		
		Object[] data = DAOTicket.getInstance().StatisticByMonth(month);
		
		this.txtRevenue.setText(data[0] + "");
		this.txtPer.setText(data[1]+ "%");
		this.txtNumBill.setText(data[2] + "");
		this.txtTotalTicket.setText(data[3] + "");
		this.txtFirst.setText(data[4] + "");
		this.txtMidle.setText(data[5] + "");
		this.txtNormal.setText(data[6] + "");
		
		this.ChangeChart();
	}
	
	public void SetTable(List<Object[]> list)
	{
		int n = table.getRowCount();
		for(int i = 0 ; i < n ; i ++)
		{
			dtm.removeRow(0);
		}
		
		for(Object[] temp : list)
		{
			dtm.addRow(temp);
		}
	}
	
	public void cbTop_Pick() throws SQLException
	{
		String monthS = cbMonth.getSelectedItem() + "";
		int month = Integer.parseInt(monthS.substring(6));
		
		String TopS = cbTop.getSelectedItem() + "";
		int Top = Integer.parseInt(TopS.substring(4));
		
		List<Object[]> list = DAOTicket.getInstance().DataByTop(month, Top);
		
		this.SetTable(list);
	}
	
	public void ChangeChart()
	{
		this.panelChart.removeAll();
		
		double NumTicket = Integer.parseInt(txtTotalTicket.getText());
		double NumFirst = Integer.parseInt(txtFirst.getText());
		double NumSecond = Integer.parseInt(txtMidle.getText());
		
		if(NumTicket == 0)
		{
			return;
		}
		
		double PerFirst =  NumFirst/NumTicket * 100;
		double PerSecond =  (NumSecond/NumTicket) * 100;
		double PerLast =  100 - PerFirst - PerSecond;
		
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Hạng Nhất", PerFirst);
		dataset.setValue("Hạng Trung", PerSecond);
		dataset.setValue("Hạng phổ thông", PerLast);
		
		JFreeChart chart = ChartFactory.createPieChart(cbMonth.getSelectedItem() + "", dataset, true, true, false);
		
		
		// Thiết lập font chữ cho biểu đồ
        StandardChartTheme chartTheme = (StandardChartTheme) StandardChartTheme.createJFreeTheme();
        chartTheme.setExtraLargeFont(new Font("Times New Roman", Font.BOLD, 18));
        chartTheme.setLargeFont(new Font("Times New Roman", Font.BOLD, 14));
        chartTheme.setRegularFont(new Font("Times New Roman", Font.PLAIN, 12));
        chartTheme.setSmallFont(new Font("Times New Roman", Font.PLAIN, 10));

        // Áp dụng theme đã thiết lập cho biểu đồ
        chartTheme.apply(chart);
		
		ChartPanel panel = new ChartPanel(chart);
		panel.setVisible(true);
		
		this.panelChart.add(panel);
	}
}
