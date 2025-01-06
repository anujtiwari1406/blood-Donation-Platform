package GUI;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Entity.*;

public class Donate extends JFrame implements ActionListener{
	
	    JPanel panel;
		JLabel intro, hname, date, pic;
		JButton donatebtn, backbtn;
		JTextField hnamefield,donationfield;
		//JComboBox datebox;
		ImageIcon img;
		Color mycolor,mycolor1;
	    Font myfont, myfont1, myfont2;
		
		private Account acc;
		
		public Donate(Account acc)
		{
			
		super("Donate requar frame-4.1");
		this.setSize(1600,1000);
		
		this.acc=acc;
		
		ImageIcon framelogo=new ImageIcon("image/framelogo.jpg"); 
		this.setIconImage(framelogo.getImage());
		
		mycolor=new Color(200,10,10);
		myfont=new Font ("Kristen ITC", Font.BOLD,20);
		myfont1=new Font ("Arial", Font.BOLD,35);
		myfont2=new Font ("Arial", Font.PLAIN,20);
		 
		panel=new JPanel();
		panel.setLayout(null);
		//panel.setBackground(mycolor);
		
		intro=new JLabel("Before your donation we have to know some information, please fillup the box");
		intro.setForeground(Color.WHITE);
		intro.setBounds(100,150,1350,50);
		intro.setFont(myfont1);
		panel.add(intro);
		
		hname=new JLabel("Hospital name you donated last time:");
		hname.setForeground(Color.WHITE);
		hname.setBounds(200,250,350,50);
		hname.setFont(myfont2);
		panel.add(hname);
		
		hnamefield=new JTextField();
		hnamefield.setBounds(550,250,200,50);
		hnamefield.setFont(myfont2);
		panel.add(hnamefield);
		
		date=new JLabel("How many months ago did you last donate?:");
		date.setForeground(Color.WHITE);
		date.setBounds(200,350,400,50);
		date.setFont(myfont2);
		panel.add(date);
		
		//String dateb[]={"1", "2 ", "3", "3+"};
		//datebox=new JComboBox(dateb);
		//datebox.setBounds(550,350,200,50);
		//datebox.setFont(myfont2);
		//panel.add(datebox);
		donationfield=new JTextField();
		donationfield.setBounds(700,350,100,50);
		panel.add(donationfield);
		
		donatebtn=new JButton("Donate");
		donatebtn.setBounds(650,750,100,50);
		donatebtn.setFont(myfont2);
		//dontbtn.addMouseListener(this);
		donatebtn.addActionListener(this);
		panel.add(donatebtn);
		
		backbtn=new JButton("Back");
		backbtn.setBounds(850,750,100,50);
		backbtn.setFont(myfont2);
        backbtn.addActionListener(this);
		panel.add(backbtn);
		
		
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
			 DonateRequest d1=new DonateRequest(acc);
	         d1.setVisible(true);
			 this.setVisible(false);
		}
		else if(ae.getSource()==donatebtn)
		{
			String lastdonation=donationfield.getText();
			if(lastdonation.equals("1")||lastdonation.equals("2"))
			{
				JOptionPane.showMessageDialog(null,"Sorry, You cannot donate right now. Try again after few months!");
				
				donationfield.setText("");
			}
			else
			{
				RequestList RL1=new RequestList(acc);
				RL1.setVisible(true);
				this.setVisible(false);
			}
		}
		
		
	}
}