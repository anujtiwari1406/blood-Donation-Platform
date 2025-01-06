package GUI;
import Entity.*;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class UDashboard extends JFrame implements MouseListener,ActionListener
{
	JPanel backpanel,dboard;
	JLabel username;
	JButton request,donate,Eprofile,logout,mrequest;
	Font myfont1;
	private Account acc;
	
	public UDashboard(Account acc)
	{
		super("REDLink");
		this.setSize(1600,1000);
		
		this.acc=acc;
		
		ImageIcon framelogo=new ImageIcon("image/framelogo.jpg"); 
		this.setIconImage(framelogo.getImage());
		
		ImageIcon logo=new ImageIcon("image/Dashboard_background.png"); 
		JLabel imagelabel=new JLabel(logo);
		imagelabel.setBounds(0,0,1600,1000);
		
		backpanel=new JPanel();
		backpanel.setLayout(null);
		backpanel.setBounds(0,0,1600,50);
		backpanel.add(imagelabel);
		
		dboard=new JPanel();
		dboard.setLayout(null);
		dboard.setBounds(0,300,1600,700);
		dboard.setBackground(Color.RED);
		dboard.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		
		
        myfont1=new Font ("Arial", Font.BOLD,35);
		username=new JLabel(acc.getusername());
		username.setBounds(650,100,300,50);
		username.setFont(myfont1);
		dboard.add(username);
		
		request=new JButton("REQUEST BLOOD");
		request.setBounds(475,450,200,50);
		request.setBackground(Color.WHITE);
		request.addMouseListener(this);
		request.addActionListener(this);
		request.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dboard.add(request);
		
		donate=new JButton("DONATE BLOOD");
		donate.setBounds(775,450,200,50);
		donate.setBackground(Color.WHITE);
		donate.addMouseListener(this);
		donate.addActionListener(this);
		donate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dboard.add(donate);
		
		mrequest=new JButton("MY REQUESTS");
		mrequest.setBounds(625,300,200,50);
		mrequest.setBackground(Color.WHITE);
		mrequest.addMouseListener(this);
		mrequest.addActionListener(this);
		mrequest.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dboard.add(mrequest);
		
		Eprofile=new JButton("EDIT MY PROFILE");
		Eprofile.setBounds(625,550,200,50);
		Eprofile.setBackground(Color.WHITE);
		Eprofile.addMouseListener(this);
		Eprofile.addActionListener(this);
		Eprofile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dboard.add(Eprofile);
		
		logout=new JButton("Logout");
		logout.setBounds(1400,50,100,50);
		logout.setBackground(Color.RED);
		logout.setForeground(Color.WHITE);
		logout.addMouseListener(this);
		logout.addActionListener(this);
		logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backpanel.add(logout);
		
		
		this.add(dboard);
		this.add(backpanel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==request)
		{
			Request r1=new Request(acc);
		    r1.setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource()==logout)
		{
			Initial I=new Initial();
		    I.setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource()==mrequest)
		{
			if(acc.hasRequest()==true)
			{
				MyRequests mr1=new MyRequests(acc);
			    mr1.setVisible(true);
			    this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"You Currently Do Not Have Any Requests.");
			}	
		}
		
		else if(ae.getSource()==donate)
		{
			RequestList RL1=new RequestList(acc);
			RL1.setVisible(true);
			this.setVisible(false);
		}
		
		else if(ae.getSource()==Eprofile)
		{
			EditProfile EPr1=new EditProfile(acc);
			EPr1.setVisible(true);
			this.setVisible(false);
		}
			
		
	}
	
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}	
}