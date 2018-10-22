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

import com.mysql.jdbc.PreparedStatement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class NewerFoodPage extends JFrame {

	private JPanel contentPane;
	private JTextField Breakfasttxt;
	private JTextField Lunchtxt;
	private JTextField Dinnertxt;
	private JTextField Snackstxt;
	private JTextField Drinkstxt;

	/**
	 * Launch the application.
	 */
	
	//function to open NewScreen 
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//set new frame as NewerFoodPAge
					NewerFoodPage frame = new NewerFoodPage();
					frame.setVisible(true); //set page visibility to true 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public NewerFoodPage() {
		//set the closing operation of the window to dispose 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //set the page to dispose when closing 
		setBounds(100, 100, 501, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//DESIGN
		
		JLabel Breakfast = new JLabel("Breakfast");
		Breakfast.setFont(new Font("Champagne & Limousines", Font.PLAIN, 24));
		Breakfast.setBounds(10, 40, 228, 33);
		contentPane.add(Breakfast);
		
		JLabel Lunch = new JLabel("Lunch");
		Lunch.setFont(new Font("Champagne & Limousines", Font.PLAIN, 24));
		Lunch.setBounds(10, 125, 228, 33);
		contentPane.add(Lunch);
		
		JLabel Dinner = new JLabel("Dinner");
		Dinner.setFont(new Font("Champagne & Limousines", Font.PLAIN, 24));
		Dinner.setBounds(10, 211, 228, 33);
		contentPane.add(Dinner);
		
		JLabel Snacks = new JLabel("Snacks");
		Snacks.setFont(new Font("Champagne & Limousines", Font.PLAIN, 24));
		Snacks.setBounds(10, 297, 228, 33);
		contentPane.add(Snacks);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 501, 40);
		contentPane.add(panel);
		
		JLabel headdingFood = new JLabel("Food");
		headdingFood.setFont(new Font("Champagne & Limousines", Font.PLAIN, 27));
		headdingFood.setBounds(221, 6, 135, 32);
		panel.add(headdingFood);
		
		//breakfast text box declaration 
		Breakfasttxt = new JTextField();
		Breakfasttxt.setBounds(20, 74, 134, 28);
		contentPane.add(Breakfasttxt);
		Breakfasttxt.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 114, 501, 10);
		contentPane.add(panel_1);
		
		//lunch text box declaration 
		Lunchtxt = new JTextField();
		Lunchtxt.setColumns(10);
		Lunchtxt.setBounds(20, 159, 134, 28);
		contentPane.add(Lunchtxt);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 199, 501, 10);
		contentPane.add(panel_2);
		
		//dinner text box declaration 
		Dinnertxt = new JTextField();
		Dinnertxt.setColumns(10);
		Dinnertxt.setBounds(20, 245, 134, 28);
		contentPane.add(Dinnertxt);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 286, 501, 10);
		contentPane.add(panel_3);
		
		//snacks declaration 
		Snackstxt = new JTextField();
		Snackstxt.setColumns(10);
		Snackstxt.setBounds(20, 332, 134, 28);
		contentPane.add(Snackstxt);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 373, 501, 10);
		contentPane.add(panel_4);
		
		JLabel Drinks = new JLabel("Drinks");
		Drinks.setFont(new Font("Champagne & Limousines", Font.PLAIN, 24));
		Drinks.setBounds(10, 384, 228, 33);
		contentPane.add(Drinks);
		
		//drinks declaration 
		Drinkstxt = new JTextField();
		Drinkstxt.setColumns(10);
		Drinkstxt.setBounds(20, 420, 134, 28);
		contentPane.add(Drinkstxt);
		
		JLabel lblCalories = new JLabel("Calories");
		lblCalories.setBounds(159, 80, 61, 16);
		contentPane.add(lblCalories);
		
		JLabel label = new JLabel("Calories");
		label.setBounds(159, 170, 61, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Calories");
		label_1.setBounds(159, 256, 61, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Calories");
		label_2.setBounds(159, 342, 61, 16);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Calories");
		label_3.setBounds(159, 432, 61, 16);
		contentPane.add(label_3);
		

		//When jbutton savebtn is pressed, it will save data into the database
		JButton Savebtn = new JButton("Save");
		Savebtn.addActionListener(new ActionListener() { //action listener
			public void actionPerformed(ActionEvent e) {     	
				
				//initializing each variable as an integer 
				int breakfast = Integer.parseInt(Breakfasttxt.getText()); 
				int lunch = Integer.parseInt(Lunchtxt.getText()); 
				int dinner = Integer.parseInt(Dinnertxt.getText()); 
				int snacks = Integer.parseInt(Snackstxt.getText()); 
				int drinks = Integer.parseInt(Drinkstxt.getText()); 
				int calfood = breakfast+lunch+dinner+snacks+drinks;
				
				//JOptionPane.showMessageDialog(null, "Saved! Please refresh to see updates.");
				
				
				Calendar calendar = Calendar.getInstance();//get date and time this was entered 
			   java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
				
				Connection myConn = null; //connection 
				PreparedStatement myStmt= null; 
				PreparedStatement myStmt2= null; //statements 
						
						try {
							//connection to database
							myConn = DriverManager.getConnection("jdbc:mysql://localhost:8889/DailyActivity", "root", "root");

			      // create the mysql insert preparedstatement
			      myStmt = (PreparedStatement) myConn.prepareStatement("insert into Food (Breakfast, Lunch, Dinner, Snacks, Drinks, Date) values(?, ?, ?, ?, ?, ?)");
			      myStmt.setInt (1, breakfast);
			      myStmt.setInt (2, lunch);
			      myStmt.setInt (3, dinner);
			      myStmt.setInt (4, snacks);
			      myStmt.setInt (5, drinks);
			     myStmt.setDate (6, startDate);

			      //execute secodn statement for insert data into daily table to calculate total value 
			      myStmt2 = (PreparedStatement) myConn.prepareStatement("insert into Daily (Food, Date) values(?, ?)");
			      myStmt2.setInt(1, calfood);
			     myStmt2.setDate(2, startDate);
					
			      int j = myStmt2.executeUpdate();
			      int i = myStmt.executeUpdate();
					if (i>0 && j>0) {
						//statements to show up in a dialog box
						JOptionPane.showMessageDialog(null, "Saved! Please refresh to see updates.");
					} else {
						JOptionPane.showMessageDialog(null, "Error! Please try again."); //error dialogue 
					}
			    }
			    catch (Exception exc) {
			    	JOptionPane.showMessageDialog(null, exc);
			    }
			  }
			
	
		});
		Savebtn.setBounds(445, 432, 56, 40);
		contentPane.add(Savebtn);
	
	}
}



