import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;
//import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import com.mysql.jdbc.PreparedStatement;

import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.StringTokenizer;


public class NewUserPage extends JFrame {

	private JPanel contentPane;
	private JTextField BMItxt;
	private JTextField Goaltxt;
	private JPasswordField Passwordtxtnew;
	private JTextField DOBtxt;
	private JTextField Heighttxt;
	private JTextField Weighttxt;
	
	/**
	 * Launch the application.
	 */
	public static void NewScreenUP() { //opens newscreen user page from the button when pressed 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUserPage frame = new NewUserPage(); //opens new page 
					frame.setVisible(true); //set visibility of this frame to true
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewUserPage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //dispose this page when closing 
		setBounds(100, 100, 501, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 501, 40);
		contentPane.add(panel);
		
		JLabel headdingFood = new JLabel("User details");
		headdingFood.setFont(new Font("Champagne & Limousines", Font.PLAIN, 27));
		headdingFood.setBounds(184, 6, 135, 32);
		panel.add(headdingFood);
		
		final JLabel Username = new JLabel("Username");
		Username.setFont(new Font("Champagne & Limousines", Font.PLAIN, 24));
		Username.setBounds(10, 40, 228, 33);
		contentPane.add(Username);
		
		final JLabel Password = new JLabel("Password");
		Password.setFont(new Font("Champagne & Limousines", Font.PLAIN, 24));
		Password.setBounds(273, 40, 228, 33);
		contentPane.add(Password);
		
		JLabel Name = new JLabel("Name");
		Name.setFont(new Font("Champagne & Limousines", Font.PLAIN, 24));
		Name.setBounds(10, 126, 228, 33);
		contentPane.add(Name);
		
		JLabel DOB = new JLabel("D.O.B.");
		DOB.setFont(new Font("Champagne & Limousines", Font.PLAIN, 24));
		DOB.setBounds(267, 126, 228, 33);
		contentPane.add(DOB);
		
		//username text box 
		final JTextField Usernametxt = new JTextField();
		Usernametxt.setBounds(20, 74, 180, 28);
		contentPane.add(Usernametxt);
		Usernametxt.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 114, 501, 10);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 199, 501, 10);
		contentPane.add(panel_2);
		
		//name text box
		final JTextField Nametxt = new JTextField();
		Nametxt.setBounds(20, 159, 180, 28);
		contentPane.add(Nametxt);
		Nametxt.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 286, 501, 10);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 373, 501, 10);
		contentPane.add(panel_4);
		
		JLabel Gender = new JLabel("Gender");
		Gender.setFont(new Font("Champagne & Limousines", Font.PLAIN, 24));
		Gender.setBounds(10, 213, 228, 33);
		contentPane.add(Gender);
		
		//email text box 
		final JTextField Emailtxt = new JTextField();
		Emailtxt.setBounds(283, 246, 180, 28);
		contentPane.add(Emailtxt);
		Emailtxt.setColumns(10);
		
		JLabel Email = new JLabel("Email");
		Email.setFont(new Font("Champagne & Limousines", Font.PLAIN, 24));
		Email.setBounds(267, 213, 228, 33);
		contentPane.add(Email);
		
		//password text box
		Passwordtxtnew = new JPasswordField();
		Passwordtxtnew.setBounds(283, 75, 180, 26);
		contentPane.add(Passwordtxtnew);
		
		//dob text box
		DOBtxt = new JTextField();
		DOBtxt.setBounds(283, 161, 180, 26);
		contentPane.add(DOBtxt);
		DOBtxt.setColumns(10);
		
		final JRadioButton Malebtn = new JRadioButton("Male");
		Malebtn.setBounds(20, 251, 69, 23);
		contentPane.add(Malebtn);
		
		final JRadioButton Femalebtn = new JRadioButton("Female");
		Femalebtn.setBounds(101, 251, 99, 23);
		contentPane.add(Femalebtn);
		
		JLabel Height = new JLabel("Height in meters");
		Height.setFont(new Font("Champagne & Limousines", Font.PLAIN, 24));
		Height.setBounds(10, 298, 228, 33);
		contentPane.add(Height);
		
		JLabel Weight = new JLabel("Weight in kg");
		Weight.setFont(new Font("Champagne & Limousines", Font.PLAIN, 24));
		Weight.setBounds(267, 298, 228, 33);
		contentPane.add(Weight);
		
		//height text box 
		Heighttxt = new JTextField();
		Heighttxt.setColumns(10);
		Heighttxt.setBounds(20, 333, 180, 28);
		contentPane.add(Heighttxt);
		
		//weight text box
		Weighttxt = new JTextField();
		Weighttxt.setColumns(10);
		Weighttxt.setBounds(283, 334, 180, 28);
		contentPane.add(Weighttxt);
		
		JLabel Goal = new JLabel("Goal");
		Goal.setFont(new Font("Champagne & Limousines", Font.PLAIN, 24));
		Goal.setBounds(10, 386, 228, 33);
		contentPane.add(Goal);
	
		//goal text box 
		Goaltxt = new JTextField();
		Goaltxt.setBounds(20, 421, 180, 28);
		contentPane.add(Goaltxt);
		Goaltxt.setColumns(10);
		
		
		JButton Savebtn = new JButton("Save"); //save button 
		Savebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//initializing each varialbe
				String username = Usernametxt.getText();
				String password = Passwordtxtnew.getText();
				String name = Nametxt.getText(); 
				//Date D =  Date.valueOf(DOBtxt.getText());
				String email = Emailtxt.getText(); 
				int goal = Integer.parseInt(Goaltxt.getText());
				
				if (!Emailtxt.getText().contains("@") || !Emailtxt.getText().contains(".")) { //to see if email contains @
					JOptionPane.showMessageDialog(null, "Your email is invalid"); //prompt 
					
				}
					
				
				/* String rGender = null;
		
				if (Malebtn.isSelected()) {
					 rGender = Malebtn.getText();
				} else if (Femalebtn.isSelected()) {
					 rGender = Femalebtn.getText();
				}
				*/ 
				Connection myConn = null; //connection 
				PreparedStatement myStmt= null; //statement 
			

				try {
					//connection to database
					myConn = DriverManager.getConnection("jdbc:mysql://localhost:8889/DailyActivity", "root", "root");
					
					//create statements
					myStmt = (PreparedStatement) myConn.prepareStatement("insert into Users (Username, Password, Name, Email, Goal) values(?,?,?,?,?)");
					myStmt.setString(1, username);
					myStmt.setString(2, password);
					myStmt.setString(3, name);
					myStmt.setString(4, email);
					myStmt.setInt(5, goal);
					
					
					//execute function 
					int i = myStmt.executeUpdate();
					if (i>0) {
						//statements to show up in a dialog box
						JOptionPane.showMessageDialog(null, "Account created!");
					} else {
						JOptionPane.showMessageDialog(null, "Error! Please try again."); //prompt for error
					}
				
				}
				catch (Exception exc) {
					JOptionPane.showMessageDialog(null, exc);
				}

			}
		});
		Savebtn.setBounds(449, 438, 52, 40);
		contentPane.add(Savebtn);
		
		JButton btnFindBmi = new JButton("Find BMI");
		btnFindBmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//initializing each varialbe for bmi as a double 
				double Height = Double.parseDouble(Heighttxt.getText()); //height in meters
				double Weight = Double.parseDouble(Weighttxt.getText()); //weight in kg
				double BMI = (double) Math.round(Weight /(Height * Height));
				
				//String Calcbmi = String.format("%.2f", BMI);
				//bmilbl.setText(Calcbmi);
				
				if (BMI <= 18.5) { //bmi declarations for each variable 
					JOptionPane.showMessageDialog(null, "Your BMI is: "+BMI+" you are underweight");
				} else if (BMI <= 24.9) {
					JOptionPane.showMessageDialog(null, "Your BMI is: "+BMI+" you are a little underweight");
				} else if (BMI <= 29.9) {
					JOptionPane.showMessageDialog(null, "Your BMI is: "+BMI+" you are normal weight");
				} else if (BMI <= 39.9) {
					JOptionPane.showMessageDialog(null, "Your BMI is: "+BMI+" you are a little overweight");
				} else if (BMI >= 40) {
					JOptionPane.showMessageDialog(null, "Your BMI is: "+BMI+" you are obese");
				}
			}
		});
		btnFindBmi.setBounds(232, 420, 117, 29);
		contentPane.add(btnFindBmi);
	
	}
}
