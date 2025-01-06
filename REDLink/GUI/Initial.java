package GUI;
import Entity.*;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Initial extends JFrame implements MouseListener,ActionListener
{
	JPanel panel;
	JButton logbtn,regbtn,adminbtn;
	JLabel pic;
	ImageIcon img;
	
	public Initial()
	{
		super("REDLink");
		this.setSize(1600,1000);
		
		ImageIcon framelogo=new ImageIcon("image/framelogo.jpg");  
		this.setIconImage(framelogo.getImage());
		
		
		panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(0,0,1600,1000);
		
		logbtn=new JButton("Login");
		logbtn.setBounds(680,50,100,50);
		logbtn.setBackground(Color.PINK);
		logbtn.addMouseListener(this);
		logbtn.addActionListener(this);
		logbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(logbtn);
		
		regbtn=new JButton("Register");
		regbtn.setBounds(820,50,100,50);
		regbtn.setBackground(Color.PINK);
		regbtn.addMouseListener(this);
		regbtn.addActionListener(this);
		regbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(regbtn);
		
		adminbtn=new JButton("Admin Login");
		adminbtn.setBounds(1400,850,150,50);
		adminbtn.setBackground(Color.RED);
		adminbtn.addMouseListener(this);
		adminbtn.addActionListener(this);
		adminbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(adminbtn);
		
		img=new ImageIcon("image/logoResized.jpg");  
		pic=new JLabel(img);
		pic.setBounds(0,0,1600,1000);
		pic.setOpaque(true);
		panel.add(pic);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==regbtn)
		{
			SignUp s1=new SignUp ();
		    s1.setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource()==logbtn)
		{
			Login L1=new Login();
		    L1.setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource()==adminbtn)
		{
			AdminLogin AL1=new AdminLogin();
			AL1.setVisible(true);
			this.setVisible(false);
		}
	}
	
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource()==logbtn)
		{
			logbtn.setBackground(Color.GREEN);
		}
		else if(me.getSource()==regbtn)
		{
			regbtn.setBackground(Color.GREEN);
		}
		else if(me.getSource()==adminbtn)
		{
			adminbtn.setBackground(Color.WHITE);
		}
	}
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource()==logbtn)
		{
			logbtn.setBackground(Color.PINK);
		}
		else if(me.getSource()==regbtn)
		{
			regbtn.setBackground(Color.PINK);
		}
		else if(me.getSource()==adminbtn)
		{
			adminbtn.setBackground(Color.RED);
		}
	}
}