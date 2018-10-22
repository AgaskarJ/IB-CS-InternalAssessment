import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;


public class Graph extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void newGraphScreen() { //open this page from the dailyactivity section 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Graph frame = new Graph(); //set frame value to true when opening 
					frame.setVisible(true); //visibility to true when button is pressed 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Graph() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  //dispose this frame when closing panel 
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 500, 46);
		contentPane.add(panel);
		
		JLabel headdingExercise = new JLabel("Progress graph");
		headdingExercise.setFont(new Font("Champagne & Limousines", Font.PLAIN, 27));
		headdingExercise.setBounds(116, 6, 246, 32);
		panel.add(headdingExercise);
		
		//show pie chart button declaration 
		JButton ShowPieChartbtn = new JButton("Show Pie Chart");
		ShowPieChartbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultPieDataset pieDataset = new DefaultPieDataset(); //default dataset from jfreechart
				pieDataset.setValue("Breakfast", new Integer(100)); //value of breakfast
				pieDataset.setValue("Exercise", new Integer(200)); //value of exercise
				pieDataset.setValue("Snacks", new Integer(50)); //value of snacks 
				JFreeChart chart= ChartFactory.createPieChart("Pie Chart: ", pieDataset, true, true, true); //chart factory function 
				PiePlot P=(PiePlot)chart.getPlot(); //amount of plot allocated 
				//P.setForegroundAlpha(TOP_ALIGNMENT);
				ChartFrame frame = new ChartFrame("Pie Chart", chart);
				frame.setVisible(true); //set frame as visible when pressed 
				frame.setSize(500, 500);
			}
		});
		ShowPieChartbtn.setBounds(0, 160, 120, 46);
		contentPane.add(ShowPieChartbtn);
		
		//show bar chart button declaration 
		JButton ShowBarChartbtn = new JButton("Show Bar Chart");
		ShowBarChartbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultCategoryDataset barDataset = new DefaultCategoryDataset(); //default dataset from jfreechart
				barDataset.setValue(100, "Calories", "Breakfast"); //breakfast value
				barDataset.setValue(200, "Calories", "Exercise"); //exercise value 
				barDataset.setValue(50, "Calories", "Snacks"); //snacks value
				//axis data
				JFreeChart chart= ChartFactory.createBarChart("Bar chart: ", "Types of consumption", "Calories consumed/burned", barDataset, PlotOrientation.VERTICAL, false, true, false);
				CategoryPlot p=chart.getCategoryPlot(); //amount of plot allocated
				p.setRangeGridlinePaint(Color.black); //grid pattern 
				ChartFrame frame=new ChartFrame("Bar Chart: ", chart); 
				frame.setVisible(true); //set frame as visible when pressed 
				frame.setSize(500,500);
			}
		});
		ShowBarChartbtn.setBounds(138, 160, 120, 46);
		contentPane.add(ShowBarChartbtn);

		
		JLabel lblTheFollowingAre = new JLabel("The following are different options of charts that display ");
		lblTheFollowingAre.setBounds(10, 58, 384, 25);
		contentPane.add(lblTheFollowingAre);
		
		JLabel lblThatDisplayYour = new JLabel("your calorie consumption daily");
		lblThatDisplayYour.setBounds(10, 78, 384, 25);
		contentPane.add(lblThatDisplayYour);
		
		//print pie chart  button declaration 
		JButton btnPrintPieChart = new JButton("Print Pie Chart");
		btnPrintPieChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultPieDataset pieDataset = new DefaultPieDataset(); //dataset from jfreechart 
				pieDataset.setValue("Breakfast", new Integer(100)); //breakfasst value
				pieDataset.setValue("Exercise", new Integer(200)); //exercise value 
				pieDataset.setValue("Snacks", new Integer(50)); //snacks value 
				JFreeChart chart= ChartFactory.createPieChart("Pie Chart: ", pieDataset, true, true, true); //chart factory function 
				//PiePlot P=(PiePlot)chart.getPlot();
				//P.setForegroundAlpha(TOP_ALIGNMENT);
				//ChartFrame frame = new ChartFrame("Pie Chart", chart);
				//frame.setVisible(true); 
				//frame.setSize(500, 500);
				
				try {
					final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection()); //render chart
					final File file1=new File("PieChart.jpeg"); //save as jpeg file 
					ChartUtilities.saveChartAsJPEG(file1, chart, 500, 500, info);
					
					//prompt 
					JOptionPane.showMessageDialog(null, "Your graph has been saved in your workspace folder");
					
					
				} catch (Exception e1) {
					
				}
				
			
			}
		});
		btnPrintPieChart.setBounds(274, 278, 120, 46);
		contentPane.add(btnPrintPieChart);
		
		//button to print bar chart declaration 
		JButton btnPrintBarChart = new JButton("Print Bar Chart");
		btnPrintPieChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				DefaultCategoryDataset barDataset = new DefaultCategoryDataset(); //defualt dataset from jfreechart
				barDataset.setValue(100, "Calories", "Breakfast"); //breakfast value
				barDataset.setValue(200, "Calories", "Exercise"); //exercise value
				barDataset.setValue(50, "Calories", "Snacks"); //snacks value 
				JFreeChart chart= ChartFactory.createBarChart("Bar chart: ", "Types of consumption", "Calories consumed/burned", barDataset, PlotOrientation.VERTICAL, false, true, false);
				//CategoryPlot p=chart.getCategoryPlot();
				//p.setRangeGridlinePaint(Color.black);
				//ChartFrame frame=new ChartFrame("Bar Chart: ", chart); 
				//frame.setVisible(true);
				//frame.setSize(500,500);
				
				try {
					final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection()); //renders chart
					final File file1=new File("BarChart.jpeg"); //save as jpeg file 
					ChartUtilities.saveChartAsJPEG(file1, chart, 500, 500, info);
					
					//prompt 
					JOptionPane.showMessageDialog(null, "Your graph has been saved in your workspace folder");
					
					
				} catch (Exception e1) {
					
				}
				
			
			}
		});
		btnPrintBarChart.setBounds(138, 278, 120, 46);
		contentPane.add(btnPrintBarChart);

		
		JLabel lblGraphTypes = new JLabel("Graph types:");
		lblGraphTypes.setBounds(16, 139, 95, 16);
		contentPane.add(lblGraphTypes);
		
		JLabel lblPrintOptions = new JLabel("Print options: ");
		lblPrintOptions.setBounds(299, 256, 95, 16);
		contentPane.add(lblPrintOptions);
	
	}
}
























