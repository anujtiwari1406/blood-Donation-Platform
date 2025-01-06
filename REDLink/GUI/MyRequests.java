package GUI;
import Entity.*;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyRequests extends JFrame implements MouseListener,ActionListener
{
	JPanel panel,backpanel;
	JLabel title,bg,location,condition,number;
	JButton logout,delete;
	Font myfont1;
	
	private Account acc;
	
	public MyRequests(Account acc)
	{
		super("signup frame no-2");
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
		
		panel=new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,300,1600,700);
		panel.setBackground(Color.RED);
		panel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		
		myfont1=new Font ("Arial", Font.BOLD,35);
		title=new JLabel("MY REQUESTS");
		title.setBounds(650,70,300,100);
		title.setFont(myfont1);
		panel.add(title);
		
		bg=new JLabel("BLOOD GROUP: "+acc.getreqbloodgroup());
		bg.setBounds(250,330,350,50);
		bg.setFont(myfont1);
		panel.add(bg);
		
		location=new JLabel("Location: "+acc.getreqlocation());
		location.setBounds(850,330,400,50);
		location.setFont(myfont1);
		panel.add(location);
		
		condition=new JLabel("Condition: "+acc.getreqcondition());
		condition.setBounds(250,400,350,50);
		condition.setFont(myfont1);
		panel.add(condition);
		
		number=new JLabel("Number: "+acc.getreqnumber());
		number.setBounds(850,400,400,50);
		number.setFont(myfont1);
		panel.add(number);
		
		logout=new JButton("Logout");
		logout.setBounds(1400,50,100,50);
		logout.setBackground(Color.RED);
		logout.setForeground(Color.WHITE);
		logout.addMouseListener(this);
		logout.addActionListener(this);
		logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backpanel.add(logout);
		
		delete=new JButton("DELETE REQUEST");
		delete.setBounds(1150,570,200,50);
		delete.setBackground(Color.WHITE);
		delete.setForeground(Color.RED);
		delete.addMouseListener(this);
		delete.addActionListener(this);
		delete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(delete);
		
		
		this.add(panel);
		this.add(backpanel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==logout)
		{
			 Initial I=new Initial();
		     I.setVisible(true);
			 this.setVisible(false);
		}
		
		else if(ae.getSource()==delete)
		{
			acc.deleteRequest();
			JOptionPane.showMessageDialog(null,"Request Deleted");
			UDashboard UD1=new UDashboard(acc);
			UD1.setVisible(true);
			this.setVisible(false);
		}
		
	}
	
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
}