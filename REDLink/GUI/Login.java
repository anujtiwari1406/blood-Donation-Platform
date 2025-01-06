package GUI;
import Entity.*;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener
{
	JPanel panel;
	JButton backbtn, logbtn,forgotpassbtn;
	JLabel intro, name, pass, phn, pic;
	JTextField namefield, phnfield;
	JPasswordField passfield;
	ImageIcon img;
	Color mycolor,mycolor1;
	Font myfont, myfont1, myfont2;
	private Account acc;
	public Login()
	{
		super("REDLink Login");
		this.setSize(1600,1000);
		
		ImageIcon framelogo=new ImageIcon("image/framelogo.jpg");  
		this.setIconImage(framelogo.getImage());
		
		mycolor=new Color(200,10,10);
		myfont=new Font ("Kristen ITC", Font.BOLD,20);
		myfont1=new Font ("Arial", Font.BOLD,35);
		myfont2=new Font ("Arial", Font.PLAIN,20);
		 
		panel=new JPanel();
		panel.setLayout(null);
		//panel.setBackground(mycolor);
		
		img=new ImageIcon("image/frame no-3.png");
		pic=new JLabel(img);
		pic.setBounds(0,150,1600,600);
		panel.add(pic);
		pic.setOpaque(true);
		
		
		name=new JLabel("Name:");
		name.setBounds(200,100,150,50);
		name.setFont(myfont2);
		panel.add(name);
		
		namefield=new JTextField();
		namefield.setBounds(270,100,150,50);
		namefield.setFont(myfont2);
		panel.add(namefield);
		
		pass=new JLabel("Password:");
		pass.setBounds(500,100,150,50);
		pass.setFont(myfont2);
		panel.add(pass);
		
		passfield=new JPasswordField();
		passfield.setBounds(620,100,150,50);
		passfield.setFont(myfont2);
		passfield.setEchoChar('*');
		panel.add(passfield);
		
		phn=new JLabel("Mobile:");
		phn.setBounds(850,100,150,50);
		phn.setFont(myfont2);
		panel.add(phn);
		
		phnfield=new JTextField();
		phnfield.setBounds(970,100,150,50);
		phnfield.setFont(myfont2);
		panel.add(phnfield);
		
		logbtn=new JButton("Enter");
		logbtn.setBounds(650,800,100,50);
		logbtn.setFont(myfont2);
		logbtn.setBackground(Color.PINK);
		logbtn.addActionListener(this);
		logbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(logbtn);
		
		backbtn=new JButton("Back");
		backbtn.setBounds(850,800,100,50);
		backbtn.setBackground(Color.PINK);
		backbtn.setFont(myfont2);
        backbtn.addActionListener(this);
		backbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(backbtn);
		
		forgotpassbtn=new JButton("Forgot Password?");
		forgotpassbtn.setBounds(1320,850,200,50);
		forgotpassbtn.addActionListener(this);
		forgotpassbtn.setFont(new Font("Arial", Font.PLAIN, 16));
		forgotpassbtn.setBackground(Color.RED);
        forgotpassbtn.setForeground(Color.WHITE);
		forgotpassbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(forgotpassbtn);
		
		this.add(panel);
		
		
		acc=new  Account();
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==backbtn)
		{
			 Initial I=new Initial();
		     I.setVisible(true);
			 this.setVisible(false);
		}
		else if(ae.getSource()==logbtn)
		{
			String name=namefield.getText();
			String pass=passfield.getText();
			String phn=phnfield.getText();
			
			acc.setusername(name);
			acc.setuserpass(pass);
			acc.setuserphn(phn);
			if(acc.getAccount(name,pass,phn)==true)
			{
			
			  String age=acc.getuserage();
			  String area=acc.getuserarea();
			  JOptionPane.showMessageDialog(null,"Valid Account");
			
			DonateRequest d1=new DonateRequest(acc);
		    d1.setVisible(true);
	        this.setVisible(false);
		    }
		   
		   else
		   {
			   JOptionPane.showMessageDialog(null,"Wrong");
		   }
			
		}
		else if(ae.getSource()==forgotpassbtn)
		{
			ForgotPassword FP1=new ForgotPassword();
			FP1.setVisible(true);
			this.setVisible(false);
		}
		
	}
}	