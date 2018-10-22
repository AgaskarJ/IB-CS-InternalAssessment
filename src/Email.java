import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Properties;

import javax.swing.JTextArea;
import javax.mail.*;
import javax.mail.internet.*; 
import javax.activation.*;

//package emailgmail;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email extends JFrame {

	private JPanel contentPane;
	private JTextField Totxt;
	private JTextField Subjecttxt;
	private JLabel lblRecipient;
	private JLabel lblSubject;
	private JTextArea Contenttxt;
	private JLabel lblContent;

	/**
	 * Launch the application.
	 */
	
	public static void newEmailScreen() { //new screen from the DailyActivity page 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Email frame = new Email();
					frame.setVisible(true); //setting value of frame to be true/showing when pressed
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public Email() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //set value of the frame to dispose when closing
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 500, 40);
		contentPane.add(panel);
		
		//label for sending email 
		JLabel headdingExercise = new JLabel("Send an Email");
		headdingExercise.setFont(new Font("Champagne & Limousines", Font.PLAIN, 27));
		headdingExercise.setBounds(150, 6, 222, 32);
		panel.add(headdingExercise);
		
		//text box for recipient 
		Totxt = new JTextField();
		Totxt.setBounds(6, 72, 130, 26);
		contentPane.add(Totxt);
		Totxt.setColumns(10);
		
		//text box for subject 
		Subjecttxt = new JTextField();
		Subjecttxt.setBounds(242, 72, 130, 26);
		contentPane.add(Subjecttxt);
		Subjecttxt.setColumns(10);
		
		//button for pressing send on email 
		JButton Send = new JButton("Send");
		Send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				        final String myEmail = "jayagaskar4747@gmail.com"; //declaring my email
				        final String password = "0891401009"; //declaring my password
				        String opponentEmail= Totxt.getText(); //declaring the email of the recipient
				        Properties pro=new Properties(); //new properties
				        pro.put("mail.smtp.host", "smtp.gmail.com"); //setting up port and simple mail transfer protocol
				        pro.put("mail.smtp.starttls.enable","true");
				        pro.put("mail.smtp.auth","true");
				        pro.put("mail.smtp.port","587"); //port
				        Session ss=Session.getInstance(pro, new javax.mail.Authenticator()
				                {
				                     @Override
				                    protected PasswordAuthentication getPasswordAuthentication() //password authentication for email 
				                    {	
				                        return new PasswordAuthentication(myEmail,password );
				                 }              
				  });
				        try
				        {
				            Message msg=new MimeMessage(ss); //new message with parameter of the session
				            msg.setFrom(new InternetAddress(myEmail));
				            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(opponentEmail));
				            msg.setSubject(Subjecttxt.getText()); //Subject of email
				            msg.setText(Contenttxt.getText()); //text of email
				            Transport trans = ss.getTransport("smtp");  //stmp server for gmail 
				            Transport.send(msg);
				            JOptionPane.showMessageDialog(null, "Your message has been successfully sent"); //dialogue when finished
				        }
				        catch(Exception e1)
				        {
				           System.out.println(e1.getMessage());
				           JOptionPane.showMessageDialog(null, "Your message did not send, please login to your account"); //default for not sending email 
				        }
				    }
	
			
		});
		Send.setBounds(333, 243, 117, 29);
		contentPane.add(Send);
		
		lblRecipient = new JLabel("Recipient: ");
		lblRecipient.setBounds(10, 56, 82, 16);
		contentPane.add(lblRecipient);
		
		lblSubject = new JLabel("Subject: ");
		lblSubject.setBounds(242, 52, 61, 16);
		contentPane.add(lblSubject);
		
		Contenttxt = new JTextArea();
		Contenttxt.setBounds(6, 160, 224, 63);
		contentPane.add(Contenttxt);
		
		lblContent = new JLabel("Content: ");
		lblContent.setBounds(6, 142, 61, 16);
		contentPane.add(lblContent);
	}


private JTextField getTotxt() { 
	if (Totxt == null) { //if the recuipient is null, take my school email as a default value 
		Totxt = new JTextField("jaag17@patana.ac.th"); //school email 
		Totxt.setEditable(false);
		Totxt.setBounds(133, 243, 117, 30);
	}
	return Totxt; 
}
}





