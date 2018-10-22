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
import com.mysql.jdbc.Statement;

import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.StringTokenizer;


public class Ulogin extends JFrame {

	private JPanel contentPane;
	private JTextField Usernametxt;
	private final JPasswordField Passwordtxt = new JPasswordField();

	/**
	 * Launch the application.
	 */
	public static void main(String [] args){ //open this page as main 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ulogin frame = new Ulogin();
					frame.setVisible(true); //make frame visible 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ulogin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //dispose this frame when closing 
		setBounds(50, 50, 450, 345);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 501, 51);
		contentPane.add(panel);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblLogin.setBounds(196, 0, 200, 50);
		panel.add(lblLogin);
		
		
		JButton btnCreateAnAccount = new JButton("Create An Account"); //button declaration for creating an account 
		btnCreateAnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewUserPage nw2 = new NewUserPage(); //open newuserpage when button is pressed 
				//open in the function NewScreen  
				nw2.NewScreenUP();
				
			}
		});
		btnCreateAnAccount.setBounds(10, 73, 167, 70);
		contentPane.add(btnCreateAnAccount);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(222, 63, 200, 50);
		contentPane.add(lblUsername);

		
		Usernametxt = new JTextField(); //username text box declaratiom
		Usernametxt.setBounds(222, 105, 200, 28);
		contentPane.add(Usernametxt);
		Usernametxt.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(222, 152, 200, 50);
		contentPane.add(lblPassword);
		
		JButton btnSubmit = new JButton("Submit"); //submit button declaration 
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				  try {
					  int flag = 1;
					  //connect to mysql database 
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:8889/DailyActivity", "root", "root");
					Statement st = (Statement) myConn.createStatement();  //statement connection 
					ResultSet rs = st.executeQuery("select * from Users"); //select the columns from users 
					while(rs.next()) {
						if(rs.getString(2).equals(Usernametxt.getText()) && rs.getString(3).equals(Passwordtxt.getText())) { //adding each value from the correct text box
							flag = 0; 
							break;
						}
					}
					
					if (flag == 0) {
						JOptionPane.showMessageDialog(null, "Login successful"); //if the flag with a current value is 0 then there is successful login 
						DailyActivitySection nw = new DailyActivitySection(); //open dailyactivity page 
						//open in the function NewScreen  
						nw.NewScreenDA();
						
					}	else {
						JOptionPane.showMessageDialog(null, "Invalid username or password"); //else promput an incorrect user or pass when flag is no 0
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

	 }
		});
		btnSubmit.setBounds(305, 271, 117, 29);
		contentPane.add(btnSubmit);
		Passwordtxt.setBounds(222, 194, 190, 28);
		contentPane.add(Passwordtxt);
	
	}
}