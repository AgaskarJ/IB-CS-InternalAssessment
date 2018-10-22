import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class BMInewscreen1 extends JFrame {

	private JPanel contentPane;
	private JTextField Heightmeterstxt;
	private JTextField Weightkgtxt;

	/**
	 * Launch the application.
	 */
	public static void newScreenBMI1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMInewscreen1 frame = new BMInewscreen1();
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
	public BMInewscreen1() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//design 
		
				JPanel panel = new JPanel();
				panel.setLayout(null);
				panel.setBackground(SystemColor.textHighlight);
				panel.setBounds(0, 0, 501, 40);
				contentPane.add(panel);
				
				JLabel headdingFood = new JLabel("BMI");
				headdingFood.setFont(new Font("Champagne & Limousines", Font.PLAIN, 27));
				headdingFood.setBounds(229, 6, 164, 32);
				panel.add(headdingFood);
				
				JLabel metric = new JLabel("Metric");
				metric.setFont(new Font("Champagne & Limousines", Font.PLAIN, 27));
				metric.setBounds(10, 52, 230, 32);
				contentPane.add(metric);
				
				Heightmeterstxt = new JTextField();
				Heightmeterstxt.setColumns(10);
				Heightmeterstxt.setBounds(141, 96, 99, 26);
				contentPane.add(Heightmeterstxt);
				
				JLabel lblWeightkilograms = new JLabel("Weight (kilograms)");
				lblWeightkilograms.setBounds(20, 157, 125, 16);
				contentPane.add(lblWeightkilograms);
				
				Weightkgtxt = new JTextField();
				Weightkgtxt.setColumns(10);
				Weightkgtxt.setBounds(141, 152, 99, 26);
				contentPane.add(Weightkgtxt);
				
				JLabel lbl1 = new JLabel("Height (meters)");
				lbl1.setBounds(20, 101, 108, 16);
				contentPane.add(lbl1);
				
				
				final JLabel DISPLAY = new JLabel("");
				DISPLAY.setBounds(20, 221, 61, 16);
				contentPane.add(DISPLAY);
				
				
				JButton btnCalculate = new JButton("Calculate");
				btnCalculate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
	
						float heightmeters = (Float.parseFloat(Heightmeterstxt.getText()));
						float weightkg = (Float.parseFloat(Weightkgtxt.getText()));
		
						float textResultmetric = (weightkg/heightmeters); 
						float textResultmetricfinal = (textResultmetric/heightmeters); 
					
						String Mfinal = String.valueOf(textResultmetricfinal);	
						DISPLAY.setText(Mfinal);
						
						System.out.println(Mfinal);
						
					}
				});
				
				
				btnCalculate.setBounds(315, 117, 117, 40);
				contentPane.add(btnCalculate);
		
				
	}
}
