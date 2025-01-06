package GUI;
import Entity.*;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Admin extends JFrame implements ActionListener
{
	    JPanel panel;
		JLabel intro,pic,text,name,number;
		JTextField usernamefield,numberfield;
		JButton deletebtn,logoutbtn;
		ImageIcon img;
		
	    Font myfont,myfont1;
		
		public Admin()
		{
			
		super("ADMIN");
		this.setSize(1600,1000);
		
		ImageIcon framelogo=new ImageIcon("image/framelogo.jpg"); 
		this.setIconImage(framelogo.getImage());
		
		myfont=new Font ("Kristen ITC", Font.BOLD,20);
		myfont1=new Font ("Arial", Font.BOLD,45);
		 
		panel=new JPanel();
		panel.setLayout(null);
		
		
		intro=new JLabel("ADMIN PANEL");
		intro.setForeground(Color.WHITE);
		intro.setBounds(700,50,700,50);
		intro.setFont(myfont1);
		panel.add(intro);
		
		text=new JLabel("Delete Account");
		text.setForeground(Color.WHITE);
		text.setFont(myfont);
		text.setBounds(750,150,300,50);
		panel.add(text);
		
		name=new JLabel("NAME");
		name.setBounds(700,300,200,50);
		name.setFont(myfont);
		name.setForeground(Color.WHITE);
		panel.add(name);
		
		number=new JLabel("NUMBER");
		number.setBounds(700,400,200,50);
		number.setFont(myfont);
		number.setForeground(Color.WHITE);
		panel.add(number);
		
		usernamefield=new JTextField();
		usernamefield.setBounds(900,300,200,50);
		panel.add(usernamefield);
		
		numberfield=new JTextField();
		numberfield.setBounds(900,400,200,50);
		panel.add(numberfield);
		
		deletebtn=new JButton("DELETE");
		deletebtn.setBounds(800,700,120,50);
        deletebtn.addActionListener(this);
		deletebtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(deletebtn);
		
		logoutbtn=new JButton("LOGOUT");
		logoutbtn.setBounds(1200,100,100,50);
		logoutbtn.addActionListener(this);
		logoutbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(logoutbtn);
		
		img=new ImageIcon("image/blood-group-2781421_1920.jpg");
		pic=new JLabel(img);
		pic.setBounds(0,0,1600,1000);
		panel.add(pic);
		pic.setOpaque(true);
		
		this.add(panel);
		}
		
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==logoutbtn)
			{
				Initial I=new Initial();
		        I.setVisible(true);
			    this.setVisible(false);
			}
			else if(ae.getSource()==deletebtn)
			{
				String username=usernamefield.getText();
			    String number=numberfield.getText();
				
				Account a=new Account();
				
				if(username.isEmpty()||number.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Please Fill up Details First!");
				}
				else
				{
					a.deleteAccount(username,number);
					JOptionPane.showMessageDialog(null,"Deleted Successfully!");
					usernamefield.setText("");
				    numberfield.setText("");
				}
			}
		
		
	}
}