package GUI;
import Entity.*;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePage extends JFrame implements MouseListener,ActionListener
{

	    JPanel panel;
		JLabel intro, pic;
		JButton logbtn, signupbtn;
		ImageIcon img;
		Color mycolor,mycolor1;
	    Font myfont, myfont1, myfont2;
		
	public HomePage()
	{
		super("Home page no-1");
		this.setSize(1600,1000);
		
		mycolor=new Color(200,10,10);
		myfont=new Font ("Kristen ITC", Font.BOLD,20);
		myfont1=new Font ("Arial", Font.BOLD,35);
		myfont2=new Font ("Arial", Font.PLAIN,20);
		 
		panel=new JPanel();
		panel.setLayout(null);
		
		intro=new JLabel("DONATE BLOOD SAVE LIFE");
		intro.setBounds(50,50,500,50);
		intro.setFont(myfont1);
		panel.add(intro);
		
		logbtn=new JButton("Login");//login button er jonno
		logbtn.setBounds(150,200,100,50);
		logbtn.setFont(myfont2);
		logbtn.addMouseListener(this);
		logbtn.addActionListener(this);
		panel.add(logbtn);
		
		signupbtn=new JButton("SignUp");//signin buttoner jonno 
		signupbtn.setBounds(300,200,100,50);
		signupbtn.setFont(myfont2);
		signupbtn.addMouseListener(this);
		signupbtn.addActionListener(this);
		panel.add(signupbtn);
		
		img=new ImageIcon("image/blood-donation-2783902_11920.png");
		pic=new JLabel(img);
		pic.setBounds(0,0,1600,1000);
		panel.add(pic);
		pic.setOpaque(true);
		

		
		this.add(panel);
	}
	
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource()==logbtn)
		{
			logbtn.setBackground(Color.BLUE);
			logbtn.setForeground(Color.WHITE);
		}
		else if(me.getSource()==signupbtn)
		{
			signupbtn.setBackground(Color.BLUE);
			signupbtn.setForeground(Color.WHITE);
		}
	}
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource()==logbtn)
		{
			logbtn.setBackground(Color.WHITE);
			logbtn.setForeground(Color.BLACK);
		}
		
		else if(me.getSource()==signupbtn)
		{
			signupbtn.setBackground(Color.WHITE);
			signupbtn.setForeground(Color.BLACK);
		}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==signupbtn)
		{
			SignUp s1=new SignUp ();
		    s1.setVisible(true);
			this.setVisible(false);
		}
		else if (ae.getSource()==logbtn)
		{
			Login L1=new Login();
		    L1.setVisible(true);
			this.setVisible(false);
		}
		
	}
	
}