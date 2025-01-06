package GUI;
import Entity.*;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EditProfile extends JFrame implements ActionListener
{
	JPanel panel;
	JButton backbtn,confirmbtn;
	JLabel intro, name, pass, age, area, phn, pic, pic2;
	JTextField namefield, agefield, areafield, phnfield;
	JPasswordField passfield;
	ImageIcon img, img2;
	Color mycolor,mycolor1;
	Font myfont, myfont1, myfont2;
	
	private Account acc;
	
	public EditProfile(Account acc)
	{
		super("Edit Profile");
		this.setSize(1600,1000);
		
		this.acc=acc;
		
		ImageIcon framelogo=new ImageIcon("image/framelogo.jpg"); 
		this.setIconImage(framelogo.getImage());
		
		mycolor=new Color(240,60,70);
		myfont=new Font ("Kristen ITC", Font.BOLD,20);
		myfont1=new Font ("Arial", Font.BOLD,35);
		myfont2=new Font ("Arial", Font.BOLD,20);
		
		panel=new JPanel();
		panel.setLayout(null);
		panel.setBackground(mycolor);
		
		intro=new JLabel("EDIT YOUR PROFILE");
		intro.setBounds(200,50,500,50);
		intro.setFont(myfont1);
		intro.setForeground(Color.WHITE);
		panel.add(intro);
		
		name=new JLabel("New Name:");
		name.setBounds(150,150,200,50);
		name.setFont(myfont2);
		name.setForeground(Color.YELLOW);
		panel.add(name);
		
		namefield=new JTextField();
		namefield.setBounds(370,150,200,50);
		namefield.setFont(myfont2);
		panel.add(namefield);
		
		pass=new JLabel("New Password:");
		pass.setBounds(150,250,200,50);
		pass.setFont(myfont2);
		pass.setForeground(Color.YELLOW);
		panel.add(pass);
		
		passfield=new JPasswordField();
		passfield.setBounds(370,250,200,50);
		passfield.setFont(myfont2);
		passfield.setEchoChar('*');
		panel.add(passfield);
		
		age=new JLabel("Age:");
		age.setBounds(200,350,150,50);
		age.setFont(myfont2);
		age.setForeground(Color.YELLOW);
		panel.add(age);
		
		agefield=new JTextField();
		agefield.setBounds(370,350,200,50);
		agefield.setFont(myfont2);
		panel.add(agefield);
		
		area=new JLabel("Area:");
		area.setBounds(200,450,150,50);
		area.setFont(myfont2);
		area.setForeground(Color.YELLOW);
		panel.add(area);
		
		areafield=new JTextField();
	    areafield.setBounds(370,450,200,50);
		areafield.setFont(myfont2);
		panel.add(areafield);
		
		phn=new JLabel("Mobile:");
		phn.setBounds(200,550,150,50);
		phn.setFont(myfont2);
		phn.setForeground(Color.YELLOW);
		panel.add(phn);
		
		phnfield=new JTextField();
		phnfield.setBounds(370,550,200,50);
		phnfield.setFont(myfont2);
		panel.add(phnfield);
		
		backbtn=new JButton("Back");
		backbtn.setBounds(200,700,100,50);
		backbtn.setFont(myfont2);
        backbtn.addActionListener(this);
		panel.add(backbtn);
		
		confirmbtn=new JButton("Confirm");
		confirmbtn.setBounds(400,700,150,50);
		confirmbtn.setFont(myfont2);
		confirmbtn.addActionListener(this);
		panel.add(confirmbtn);
		
		img2=new ImageIcon("image/blood-group-2781421_1920.jpg");
		pic2=new JLabel(img2);
		pic2.setBounds(0,0,950,1000);
		panel.add(pic2);
		pic2.setOpaque(true);
		
		img=new ImageIcon("image/phone-frame-no-2.png");
		pic=new JLabel(img);
		pic.setBounds(950,0,650,1000);
		panel.add(pic);
		pic.setOpaque(true);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
	    if(ae.getSource()==confirmbtn)
		{
			String username=namefield.getText();
			String userpass=passfield.getText();
			String userage=agefield.getText();
			String userarea=areafield.getText();
			String userphn=phnfield.getText();
			
			String oldUsername=acc.getusername();
			String oldUserpass=acc.getuserpass();
			String oldUserphn=acc.getuserphn();
			
			if(username.isEmpty()||userpass.isEmpty()||userage.isEmpty()||userarea.isEmpty()||userphn.isEmpty())
			{
				JOptionPane.showMessageDialog(null,"You Have To Fill All");
			}
			else
			{
				
				acc.updateAccount(oldUsername,oldUserpass,oldUserphn,username,userpass,userage,userarea,userphn);
				JOptionPane.showMessageDialog(null,"Sucessfully Changed");
				
				namefield.setText("");
				passfield.setText("");
				agefield.setText("");
				areafield.setText("");
				phnfield.setText("");
				
			    UDashboard UD1=new UDashboard(acc);
			    UD1.setVisible(true);
			    this.setVisible(false);
			}
		}
		
		else if(ae.getSource()==backbtn)
		{
			 UDashboard UD1=new UDashboard(acc);
			 UD1.setVisible(true);
			 this.setVisible(false);
		}
	}
}