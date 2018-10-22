import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;


public class DailyActivitySection extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void NewScreenDA() { //opens new screen dailyactivity from the login page 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					
					DailyActivitySection frame = new DailyActivitySection();
					frame.setVisible(true); //set frame visibility to true when opening 
			       

					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}

	/**
	 * Create the frame.
	 */
	public DailyActivitySection() {
		
		//close frame set to dispose
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  //set this frame to dispose on closing the window 
				setBounds(100, 100, 598, 495);
				contentPane = new JPanel();
				contentPane.setBackground(Color.WHITE);
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				//DESIGN 
				
				JPanel panel = new JPanel();
				panel.setBackground(SystemColor.textHighlight);
				panel.setBounds(0, 0, 700, 75);
				contentPane.add(panel);
				panel.setLayout(null);
				
				JLabel lblCalorieTracker = new JLabel("Calorie Tracker");
				lblCalorieTracker.setBounds(200, 6, 347, 38);
				lblCalorieTracker.setFont(new Font("Cool", Font.PLAIN, 32));
				panel.add(lblCalorieTracker);
				
				JLabel lblDailyActivity = new JLabel("Daily Activity");
				lblDailyActivity.setFont(new Font("Champagne & Limousines", Font.PLAIN, 27));
				lblDailyActivity.setBounds(234, 43, 173, 32);
				panel.add(lblDailyActivity);
				
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(0, 200, 700, 10);
				contentPane.add(panel_1);
				
				JLabel lblGoal = new JLabel("Goal");
				lblGoal.setFont(new Font("Champagne & Limousines", Font.PLAIN, 12));
				lblGoal.setBounds(46, 158, 61, 16);
				contentPane.add(lblGoal);
				
				JLabel lblFood = new JLabel("Food");
				lblFood.setFont(new Font("Champagne & Limousines", Font.PLAIN, 12));
				lblFood.setBounds(186, 158, 61, 16);
				contentPane.add(lblFood);
				
				JLabel lblExercise = new JLabel("Exercise");
				lblExercise.setFont(new Font("Champagne & Limousines", Font.PLAIN, 12));
				lblExercise.setBounds(323, 158, 61, 16);
				contentPane.add(lblExercise);
				
				JLabel lblRemainingGoal = new JLabel("Remaining goal");
				lblRemainingGoal.setFont(new Font("Champagne & Limousines", Font.PLAIN, 12));
				lblRemainingGoal.setBounds(469, 158, 123, 16);
				contentPane.add(lblRemainingGoal);
				
				JLabel label = new JLabel("-");
				label.setFont(new Font("Champagne & Limousines", Font.PLAIN, 18));
				label.setBounds(129, 112, 61, 16);
				contentPane.add(label);
				
				JLabel label_1 = new JLabel("+");
				label_1.setFont(new Font("Champagne & Limousines", Font.PLAIN, 18));
				label_1.setBounds(268, 112, 61, 16);
				contentPane.add(label_1);
				
				JLabel label_2 = new JLabel("=");
				label_2.setFont(new Font("Champagne & Limousines", Font.PLAIN, 18));
				label_2.setBounds(414, 112, 61, 16);
				contentPane.add(label_2);
				
				//setting the value of the foal label 
				final JLabel GOAL = new JLabel(" ");
				
				//set goal as value from table
				 try {
					//connection to database
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:8889/DailyActivity", "root", "root");
					
					//create statement 
					Statement myStmt = myConn.createStatement();
				      String query = "SELECT Goal FROM Users"; //select the goal column from users in the database 
				      ResultSet rs = myStmt.executeQuery(query);
				      while (rs.next()) 
				      {
				    	
				          String id = rs.getString("Goal");    //set text in jlabel to the goal 
				          GOAL.setText(id);
				      }	
				}
				catch (Exception exc) {
					JOptionPane.showMessageDialog(null, exc);
				} 
				
				GOAL.setForeground(Color.BLACK);
				GOAL.setBounds(40, 108, 77, 26); 
				contentPane.add(GOAL);
			
				
				
				final JLabel FOOD = new JLabel(" "); //set valu eof food label from the database
				
				try {
					//connection to database
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:8889/DailyActivity", "root", "root");
					
					//create statement 
					Statement myStmt = myConn.createStatement();
				      String query = "SELECT Food FROM Daily"; //select the food column form daily 
				      ResultSet rs = myStmt.executeQuery(query);
				      while (rs.next())
				      {
				    	  //set jlabel as food
				          String id = rs.getString("Food");
				          FOOD.setText(id);
				          
				      }	
				}
				catch (Exception exc) {
					exc.printStackTrace();
				}
				
				FOOD.setForeground(Color.BLACK);
				FOOD.setBounds(179, 108, 77, 26);
				contentPane.add(FOOD);
				
				
				final JLabel EXERCISE = new JLabel("  "); //label for exercise 
				
				try {
					//connection to database
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:8889/DailyActivity", "root", "root");
					
					//create statement 
					Statement myStmt = myConn.createStatement();
				      String query = "SELECT Burned FROM Exercise"; //select the burned column from exercise 
				      ResultSet rs = myStmt.executeQuery(query);
				      while (rs.next())
				      {
				    	  //set jlabel as exercise
				          String id = rs.getString("Burned");
				          EXERCISE.setText(id);
				          
				      }	
				}
				catch (Exception exc) {
					exc.printStackTrace();
				}

				EXERCISE.setForeground(Color.BLACK);
				EXERCISE.setBounds(325, 108, 77, 26);
				contentPane.add(EXERCISE);
				
				//setting the value of remaining as a label 
				JLabel REMAINING = new JLabel("  ");

				try {
					//connection to database
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:8889/DailyActivity", "root", "root");
					
					//create statement 
					Statement myStmt = myConn.createStatement();
				     /*  String query1 = "SELECT Goal FROM Users";
				      String query2 = "SELECT Food FROM Daily";*/
				      String query3 = "SELECT Goal FROM Users"; //select goal colummn from users
	
				      
				      ResultSet rs3 = myStmt.executeQuery(query3);
				      while (rs3.next()) {
				    	  int goal = Integer.parseInt(rs3.getString("Goal"));
				    	 
				    	  int food = Integer.parseInt(FOOD.getText()); //string to integer for food
				    	  int exercise = Integer.parseInt(EXERCISE.getText()); //string to integer for exercise
				    	  int result = (goal-food)+exercise; //calculation for result 
				          REMAINING.setText(String.valueOf(result)); //set value of remaining 
				        
				      }
     
				}
				catch (Exception exc) {
					exc.printStackTrace();
				}
				
				REMAINING.setForeground(Color.BLACK);
				REMAINING.setBounds(469, 108, 77, 26);
				contentPane.add(REMAINING);
				
				//Opens add food page in a new window 
				JButton btnAddFood = new JButton("Add Food");
				btnAddFood.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						NewerFoodPage nw = new NewerFoodPage();
						//open in the function NewScreen  
						nw.NewScreen();
					}
				});
				btnAddFood.setBounds(0, 222, 311, 93);
				contentPane.add(btnAddFood);
				
				//Opens add exercise page in a new window 
				JButton btnAddExercise = new JButton("Add Exercise");
				btnAddExercise.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						NewExercisePage nw = new NewExercisePage();
						//open in the function NewScreen2
						nw.NewScreen2();
					}
				});
				btnAddExercise.setBounds(323, 222, 269, 93);
				contentPane.add(btnAddExercise);
				
				JPanel panel_5 = new JPanel();
				panel_5.setBounds(-12, 432, 604, 38);
				contentPane.add(panel_5);
				panel_5.setLayout(null);
				
				//Opens edit profile page in a new window 
				JButton EditProfile = new JButton("Edit Profile");
				EditProfile.setBounds(16, 3, 155, 35);
				panel_5.add(EditProfile);
				
				JButton Refreshbtn = new JButton("Refresh");
				Refreshbtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						try {
							//connection to database
							Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:8889/DailyActivity", "root", "root");
							
							//create statement 
							Statement myStmt = myConn.createStatement();
						      String query = "SELECT Burned FROM Exercise"; //select the burned column from exercise 
						     // String query2 = "SELECT Food FROM Daily";
						     // String query3 = "SELECT Goal FROM Users";
						      
						      ResultSet rs = myStmt.executeQuery(query);
						      //ResultSet rs2 = myStmt.executeQuery(query2);
						      //ResultSet rs3 = myStmt.executeQuery(query3);
						      while (rs.next())
						      {
						    	  //set jlabel as exercise
						          String id = rs.getString("Burned");
						          EXERCISE.setText(id);
						          //String id2 = rs2.getString("Food");
						          //FOOD.setText(id2);
						          //String id3 = rs3.getString("Goal");    //set text in jlabel to the goal 
						          //GOAL.setText(id3);
						          
						      }	
						      
						      String query2 = "SELECT Food FROM Daily";
						      ResultSet rs2 = myStmt.executeQuery(query2);
						      
						      while (rs2.next())
						      {
						    	  //set jlabel as exercise
						          
						          String id2 = rs2.getString("Food");
						          FOOD.setText(id2);
     
						      }	
						      
						      String query3 = "SELECT Goal FROM Users";
						      ResultSet rs3 = myStmt.executeQuery(query3);
						      
						      while (rs3.next())
						      {
						    	  
						    	    String id3 = rs3.getString("Goal");    //set text in jlabel to the goal 
							          GOAL.setText(id3);
						      }	
						} 
						      
						      /* String query4 = "SELECT Goal FROM Users";
						      ResultSet rs4 = myStmt.executeQuery(query3);
						      
						      while (rs4.next())
						      {
						    	  
						    	    String id4 = rs4.getString("Goal");    //set text in jlabel to the goal 
							          REMAIN.setText(id4);
							          
							          int food = Integer.parseInt(FOOD.getText()); //string to integer for food
							    	  int exercise = Integer.parseInt(EXERCISE.getText()); //string to integer for exercise
							    	  int result = (goal-food)+exercise; //calculation for result 
							          REMAINING.setText(String.valueOf(result)); //set value of remaining 
						      }	
						}*/ 
						catch (Exception exc) {
							exc.printStackTrace();
						}
							
					}	
				});
				Refreshbtn.setBounds(481, 6, 117, 29);
				panel_5.add(Refreshbtn);
				EditProfile.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						NewUserPage nw = new NewUserPage();
						//open in the function NewUserPage 
						nw.NewScreenUP();
						
					}
					
				});

				//graph button 
				JButton btnGraphs = new JButton("Progress Graph"); 
				btnGraphs.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						Graph nw = new Graph();
						//open in the function NewUserPage 
						nw.newGraphScreen();

					}
				});
				btnGraphs.setBounds(0, 327, 311, 93);
				contentPane.add(btnGraphs);
				
				//email button 
				JButton Emailbtn = new JButton("Email");
				Emailbtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Email nw = new Email();
						//open in the function NewUserPage 
						nw.newEmailScreen();
						
					}
				});
				Emailbtn.setBounds(323, 327, 269, 93);
				contentPane.add(Emailbtn);
			
	}
}
