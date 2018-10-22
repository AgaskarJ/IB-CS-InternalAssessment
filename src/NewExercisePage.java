import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import com.mysql.jdbc.PreparedStatement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.awt.Color;
import java.util.Calendar;
import java.util.Date; 


public class NewExercisePage extends JFrame {

	private JPanel contentPane;
	private JTextField Burnedtxt;
	private JTextField TimeStarttxt;
	private JTextField TimeEndtxt;
	private JTextField Descriptiontxt;

	/**
	 * Launch the application.
	 */
	
	//function to open NewScreen2 from daily activity page 
	public static void NewScreen2() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//set new frame as NewExercisePage
					NewExercisePage frame = new NewExercisePage();
					frame.setVisible(true); //set visibility to true when pressed 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewExercisePage() {
		//set the closing operation of the window to dispose 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 502);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//design 
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 500, 40);
		contentPane.add(panel);
		
		JLabel headdingExercise = new JLabel("Exercise");
		headdingExercise.setFont(new Font("Champagne & Limousines", Font.PLAIN, 27));
		headdingExercise.setBounds(201, 6, 135, 32);
		panel.add(headdingExercise);
		
		JLabel lblCaloriesBurned = new JLabel("Calories burned");
		lblCaloriesBurned.setFont(new Font("Champagne & Limousines", Font.PLAIN, 24));
		lblCaloriesBurned.setBounds(10, 52, 202, 28);
		contentPane.add(lblCaloriesBurned);
		
		//text box for burned calories 
		Burnedtxt = new JTextField();
		Burnedtxt.setBounds(20, 93, 134, 28);
		contentPane.add(Burnedtxt);
		Burnedtxt.setColumns(10);
		
		JLabel lblTimeStart = new JLabel("Time Start");
		lblTimeStart.setFont(new Font("Champagne & Limousines", Font.PLAIN, 24));
		lblTimeStart.setBounds(10, 133, 126, 28);
		contentPane.add(lblTimeStart);
		
		JLabel lblTimeEnd = new JLabel("Time End");
		lblTimeEnd.setFont(new Font("Champagne & Limousines", Font.PLAIN, 24));
		lblTimeEnd.setBounds(199, 133, 98, 28);
		contentPane.add(lblTimeEnd);
		
		TimeStarttxt = new JFormattedTextField(); //text box for time start 
		TimeStarttxt.setColumns(10);
		TimeStarttxt.setBounds(20, 173, 134, 28);
		contentPane.add(TimeStarttxt);
		
		TimeEndtxt = new JTextField(); //text box for time end 
		TimeEndtxt.setColumns(10);
		TimeEndtxt.setBounds(209, 173, 134, 28);
		contentPane.add(TimeEndtxt);
		
		JLabel lblTypeOfExercise = new JLabel("Type of exercise");
		lblTypeOfExercise.setFont(new Font("Champagne & Limousines", Font.PLAIN, 24));
		lblTypeOfExercise.setBounds(10, 225, 239, 28);
		contentPane.add(lblTypeOfExercise);
		
		JLabel lblDescription = new JLabel("Description of exercise");
		lblDescription.setFont(new Font("Champagne & Limousines", Font.PLAIN, 24));
		lblDescription.setBounds(10, 313, 239, 21);
		contentPane.add(lblDescription);
		
		Descriptiontxt = new JTextField(); //text box for description 
		Descriptiontxt.setBounds(20, 346, 323, 40);
		contentPane.add(Descriptiontxt);
		Descriptiontxt.setColumns(10);
		
		//setting values for drop down box to select from 
		String [] messageStrings = {"Gym", "Running", "Swimming", "Basketball", "Football", "Tennis", "Rugby", "Badminton", "Golf", "Volleyball", "Baseball", "Hockey", "Rock Climbing"};
		final JComboBox Typetxt = new JComboBox(messageStrings); //combo box declaration 
		Typetxt.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		Typetxt.setBounds(20, 265, 192, 27);
		contentPane.add(Typetxt);
		
		//When jbutton savebtn is close, it will save data into the database
		JButton Savebtn = new JButton("Save");
		Savebtn.addActionListener(new ActionListener() { //action listener 
			public void actionPerformed(ActionEvent arg0) {
				
				//SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				
				//declaring int variables for each of the jtextfields
				int burned = Integer.parseInt(Burnedtxt.getText()); 
				String timestart = TimeStarttxt.getText();
				//sdf.format(timestart);
				String timeend = TimeEndtxt.getText();
				String type = Typetxt.getSelectedItem().toString();
				String description = Descriptiontxt.getText(); 
				
				Calendar calendar = Calendar.getInstance(); //get time that this was entered 
			    java.sql.Date startDateEx = new java.sql.Date(calendar.getTime().getTime());
				
				//set up database
				Connection myConn = null; 
				PreparedStatement myStmt= null; 
				PreparedStatement myStmt2= null; //secodn connection 
				
				
				//JOptionPane.showMessageDialog(null, "Saved! Please refresh to see updates.");
						
						try {
							//connection to database
							myConn = DriverManager.getConnection("jdbc:mysql://localhost:8889/DailyActivity", "root", "root");
							
							//create statements
							myStmt = (PreparedStatement) myConn.prepareStatement("insert into Exercise (Burned, Tstart, Tend, TypeEx, DescriptionEx, DateEx) values(?,?,?,?,?,?)");
							myStmt.setInt(1, burned);
							myStmt.setString(2, timestart);
							myStmt.setString(3, timeend);
							myStmt.setString(4, type);
							myStmt.setString(5, description);
							myStmt.setDate(6, startDateEx);
							
						
							
							//created new statement to save value of burned to the daily table in order to be used to calculate the remaining calories required in the DailyActivity class
							myStmt2 = (PreparedStatement) myConn.prepareStatement("insert into Daily (Exercise, Date) values(?, ?)");
							myStmt2.setInt(1, burned);
							myStmt2.setDate(2, startDateEx); //second statement 
							
							//execute function 
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
		Savebtn.setBounds(442, 434, 52, 40);
		contentPane.add(Savebtn);
	}
}

