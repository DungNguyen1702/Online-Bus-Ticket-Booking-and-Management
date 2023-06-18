package view.admin;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.data.general.DefaultPieDataset;

import DAO.DAOTicket;
import DAO.DAOTrip;
import controller.admin.StatisticByYearListener;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;

public class PanelStatisticByYear extends JPanel {
	private JTextField txtPercent;
	private JTextField txtNumBill;
	private JTextField txtInCome;
	private JTextField txtNumTicket;
	private JTextField txtNumFirst;
	private JTextField txtNumMiddle;
	private JTextField txtNumNormal;
	private JPanel panelChart;
	public JComboBox<String> cbTop, cbMonth;
	public DefaultTableModel dtm = new DefaultTableModel() {
	    @Override
	    public boolean isCellEditable(int row, int column) {
	        return false;
	    }
	};
	public JTable table;
	
	/**
	 * Create the panel.
	 */
	
	private void GUI()
	{
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(188, 0, 614, 553);
		setLayout(null);
		
		JLabel lblThngKTheo = new JLabel("THỐNG KÊ THEO NĂM");
		lblThngKTheo.setForeground(Color.BLUE);
		lblThngKTheo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThngKTheo.setBounds(160, 10, 286, 39);
		add(lblThngKTheo);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 59, 594, 171);
		add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Năm");
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
		
		txtPercent = new JTextField();
		txtPercent.setText("0%");
		txtPercent.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtPercent.setEditable(false);
		txtPercent.setColumns(10);
		txtPercent.setBounds(134, 89, 168, 28);
		panel.add(txtPercent);
		
		txtNumBill = new JTextField();
		txtNumBill.setText("0");
		txtNumBill.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtNumBill.setEditable(false);
		txtNumBill.setColumns(10);
		txtNumBill.setBounds(134, 128, 168, 28);
		panel.add(txtNumBill);
		
		txtInCome = new JTextField();
		txtInCome.setText("0");
		txtInCome.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtInCome.setEditable(false);
		txtInCome.setColumns(10);
		txtInCome.setBounds(134, 50, 168, 28);
		panel.add(txtInCome);
		
		txtNumTicket = new JTextField();
		txtNumTicket.setText("0");
		txtNumTicket.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtNumTicket.setEditable(false);
		txtNumTicket.setColumns(10);
		txtNumTicket.setBounds(453, 11, 131, 28);
		panel.add(txtNumTicket);
		
		txtNumFirst = new JTextField();
		txtNumFirst.setText("0");
		txtNumFirst.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtNumFirst.setEditable(false);
		txtNumFirst.setColumns(10);
		txtNumFirst.setBounds(453, 50, 131, 28);
		panel.add(txtNumFirst);
		
		txtNumMiddle = new JTextField();
		txtNumMiddle.setText("0");
		txtNumMiddle.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtNumMiddle.setEditable(false);
		txtNumMiddle.setColumns(10);
		txtNumMiddle.setBounds(453, 89, 131, 28);
		panel.add(txtNumMiddle);
		
		txtNumNormal = new JTextField();
		txtNumNormal.setText("0");
		txtNumNormal.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtNumNormal.setEditable(false);
		txtNumNormal.setColumns(10);
		txtNumNormal.setBounds(453, 128, 131, 28);
		panel.add(txtNumNormal);
		
		cbMonth = new JComboBox<String>();
		cbMonth.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cbMonth.setBounds(134, 11, 168, 28);
		panel.add(cbMonth);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(10, 236, 296, 307);
		add(panel_2);
		
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
		
		cbTop = new JComboBox<String>();
		cbTop.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		cbTop.addItem("Top 1");
		cbTop.addItem("Top 2");
		cbTop.addItem("Top 3");
		cbTop.addItem("Top 4");
		cbTop.addItem("Top 5");
		cbTop.addItem("Top 6");
		cbTop.addItem("Top 7");
		cbTop.addItem("Top 8");
		cbTop.setBounds(58, 37, 228, 21);
		panel_2.add(cbTop);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(316, 236, 288, 307);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Biểu đồ loại vé");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(68, 10, 163, 21);
		panel_1.add(lblNewLabel_2);
		
		panelChart = new JPanel();
		panelChart.setLayout(new GridLayout(1,1));
		panelChart.setBounds(10, 34, 268, 263);
		panel_1.add(panelChart);
		
		cbMonth.addActionListener(new StatisticByYearListener(this));
		cbTop.addActionListener(new StatisticByYearListener(this));
	}
	
	public PanelStatisticByYear(){
		this.GUI();
		try {
			this.Init();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.cbMonth.setSelectedIndex(0);
		try {
			this.cbMonth_Pick();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Init() throws SQLException
	{
		cbMonth.removeAllItems();
		List<Integer> listYear = DAOTrip.getInstance().getListYear();
		
		for(Integer item : listYear)
		{
			cbMonth.addItem(item + "");
		}
	}
	
	public void cbMonth_Pick() throws ClassNotFoundException, SQLException
	{
		this.cbTop.setSelectedIndex(2);
		this.cbTop_Pick();
		
		int month = Integer.parseInt(cbMonth.getSelectedItem() + "");
		
		Object[] data = DAOTicket.getInstance().StatisticByYear(month);
		
		this.txtInCome.setText(data[0] + "");
		this.txtPercent.setText(data[1] + "%");
		this.txtNumBill.setText(data[2] + "");
		this.txtNumTicket.setText(data[3] + "");
		this.txtNumFirst.setText(data[4] + "");
		this.txtNumMiddle.setText(data[5] + "");
		this.txtNumNormal.setText(data[6] + "");
		
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
		int month = Integer.parseInt(cbMonth.getSelectedItem() + "");
		
		String TopS = cbTop.getSelectedItem() + "";
		int Top = Integer.parseInt(TopS.substring(4));
		
		List<Object[]> list = DAOTicket.getInstance().DataTopByYear(month, Top);
		
		this.SetTable(list);
	}
	
	public void ChangeChart()
	{
		this.panelChart.removeAll();
		
		double NumTicket = Integer.parseInt(txtNumTicket.getText());
		double NumFirst = Integer.parseInt(txtNumFirst.getText());
		double NumSecond = Integer.parseInt(txtNumMiddle.getText());
		
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
