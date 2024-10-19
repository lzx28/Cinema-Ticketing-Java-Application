import javax.swing.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.*;
import java.awt.*;

public class Welcome extends JFrame implements KeyListener, ActionListener 
{
	public JTextField jtfUserName, jtfPassword;
	private JButton jbRegister, jbGuest;
	public JButton jbLogin;
	public String userName = "", mobileNumber = "", birthDate = "", email = "", password = "", reEnterPassword = "";
	
	public Welcome()
	{
		Container canvas = getContentPane();
		canvas.setLayout(new BorderLayout());
		
		JPanel p1 = new JPanel();
		JLabel title = new JLabel("Welcome to GSL Cinema");
		p1.setLayout(new FlowLayout());
		p1.add(title);
		title.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		JLabel name = new JLabel("Username:");
		p2.add(name);
		p2.add(jtfUserName = new JTextField(10));
		name.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout());
		JLabel password = new JLabel("Password:");
		p3.add(password);
		p3.add(jtfPassword = new JTextField(10));
		password.setFont(new Font("Tahoma", Font.PLAIN, 20));
	
		JPanel p4 = new JPanel();
		p4.setLayout(new FlowLayout());
		jbLogin = new JButton("Login");
		jbRegister = new JButton("Register");
		p4.add(jbLogin);
		jbLogin.setEnabled(false);
		p4.add(jbRegister);
		jbLogin.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jbRegister.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JPanel p5 = new JPanel();
		p5.setLayout(new FlowLayout());
		jbGuest = new JButton("Continue As A Guest");
		p5.add(jbGuest);
		jbGuest.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JPanel p1p2p3 = new JPanel();
		p1p2p3.setLayout(new BorderLayout());
		p1p2p3.add(p1, BorderLayout.NORTH);
		p1p2p3.add(p2, BorderLayout.CENTER);
		p1p2p3.add(p3, BorderLayout.SOUTH);
		
		canvas.add(p1p2p3, BorderLayout.NORTH);
		canvas.add(p4, BorderLayout.CENTER);
		canvas.add(p5, BorderLayout.SOUTH);
		
		jtfUserName.addKeyListener(this);
		jtfPassword.addKeyListener(this);
		jbRegister.addActionListener(this);
		jbLogin.addActionListener(this);
		jbGuest.addActionListener(this);
	}
	
	public void keyPressed(KeyEvent e)
	{
		//
	}
	
	public void keyReleased(KeyEvent e)
	{
		//
	}
	
	public void keyTyped(KeyEvent e)
	{
		if(jtfUserName.getText().length()>0 && jtfPassword.getText().length()>0)
		{
			jbLogin.setEnabled(true);
		}
	}
	
	public void actionPerformed(ActionEvent e) 
	{

		boolean bool = true;

		if(e.getSource() == jbRegister) 
		{
			Register gui = new Register();
						
			gui.setVisible(true);
			gui.setSize(500,325);
			gui.setLocationRelativeTo(null);
					
			this.dispose();
		}
					
		if(e.getSource() == jbLogin)
		{
			try 
			{
				if(!jtfUserName.getText().equals(this.userName) || (!jtfPassword.getText().equals(this.password)))
				{
					bool = false;
					throw new Exception("User Does Not Exist");
				}
			}
				catch(Exception ex) 
				{
					showMessageDialog(null, ex.getMessage());
				}

			if (bool == true)
			{
				CustomerData gui = new CustomerData(this.userName,this.mobileNumber,this.birthDate,this.email,this.password,this.reEnterPassword);
				gui.WelcomeToMovieList();
				this.dispose();
			}
		}
		
		if(e.getSource() == jbGuest)
		{
			CustomerData gui = new CustomerData(this.userName,this.mobileNumber,this.birthDate,this.email,this.password,this.reEnterPassword);
			gui.WelcomeToMovieList();
			this.dispose();
		}
	}
	
//end
}


				

			
			
	

