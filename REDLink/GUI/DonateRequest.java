package GUI;
import Entity.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DonateRequest extends JFrame implements ActionListener{
	
	    JPanel panel;
		JLabel intro, pic;
		JButton dontbtn, reqbtn, backbtn, dashbtn;
		ImageIcon img;
		Color mycolor,mycolor1;
	    Font myfont, myfont1, myfont2;
		
		private Account acc;
		
		public DonateRequest(Account acc)
		{
			
		super("DonateRequest frame-4");
		this.setSize(1600,1000);
		
		this.acc=acc;
		
		ImageIcon framelogo=new ImageIcon("image/framelogo.jpg"); 
		this.setIconImage(framelogo.getImage());
		
		mycolor=new Color(200,10,10);
		myfont=new Font ("Kristen ITC", Font.BOLD,20);
		myfont1=new Font ("Arial", Font.BOLD,45);
		myfont2=new Font ("Arial", Font.PLAIN,20);
		 
		panel=new JPanel();
		panel.setLayout(null);
		
		intro=new JLabel("DONATE BLOOD, SAVE LIFE");
		intro.setForeground(Color.WHITE);
		intro.setBounds(450,200,700,50);
		intro.setFont(myfont1);
		panel.add(intro);
		
		dontbtn=new JButton("Donate");
		dontbtn.setBounds(550,700,100,50);
		dontbtn.setFont(myfont2);
		//dontbtn.addMouseListener(this);
		dontbtn.addActionListener(this);
		dontbtn.setBackground(Color.PINK);
		panel.add(dontbtn);
		
		reqbtn=new JButton("Request");
		reqbtn.setBounds(700,700,120,50);
		reqbtn.setFont(myfont2);
		reqbtn.setBackground(Color.PINK);
		//reqbtn.addMouseListener(this);
		reqbtn.addActionListener(this);
		panel.add(reqbtn);
		
		backbtn=new JButton("Back");
		backbtn.setBounds(880,700,100,50);
		backbtn.setFont(myfont2);
		backbtn.setBackground(Color.PINK);
        backbtn.addActionListener(this);
		panel.add(backbtn);
		
		dashbtn=new JButton("DASHBOARD");
		dashbtn.setBounds(630,500,250,50);
		dashbtn.setBackground(Color.PINK);
		dashbtn.setFont(myfont2);
        dashbtn.addActionListener(this);
		panel.add(dashbtn);
		
		
		img=new ImageIcon("image/blood-group-2781421_1920.jpg");
		pic=new JLabel(img);
		pic.setBounds(0,0,1600,1000);
		panel.add(pic);
		pic.setOpaque(true);
		
		this.add(panel);
		}
		
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==backbtn)
		{
			 Login L1=new Login();
		     L1.setVisible(true);
			 this.setVisible(false);
		}
		else if(ae.getSource()==dontbtn)
		{
			 Donate d1=new Donate(acc);
		     d1.setVisible(true);
			 this.setVisible(false);
		}
		else if(ae.getSource()==reqbtn)
		{
			 Request r1=new Request(acc);
		     r1.setVisible(true);
			 this.setVisible(false);
		}
		else if(ae.getSource()==dashbtn)
		{	
			UDashboard UD1=new UDashboard(acc);
			UD1.setVisible(true);
			this.setVisible(false);
		}
		
	}
}