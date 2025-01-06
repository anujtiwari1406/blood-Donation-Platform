package GUI;
import Entity.*;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Request extends JFrame implements ActionListener
{
	
	    JPanel panel;
		JLabel pic, req, bgroup, condition, location, contact;
        //JComboBox bloodbox;
        JTextField bgroupfield, condifield, locationfield, contactfield;
        JButton submit, backbtn;
        Font font;
		ImageIcon img;
		Color mycolor,mycolor1;
	    Font myfont, myfont1, myfont2;
		private Account acc;
		
	public Request(Account acc)
	{
			
		super("Request frame no-6");
		this.setSize(1600,1000);
		
		this.acc=acc;
		
		mycolor=new Color(200,10,10);
		myfont=new Font ("Kristen ITC", Font.BOLD,20);
		myfont1=new Font ("Arial", Font.BOLD,35);
		myfont2=new Font ("Arial", Font.PLAIN,20);
		 
		panel=new JPanel();
		panel.setLayout(null);
		//panel.setBackground(mycolor);
		
		font=new Font("Arial",Font.BOLD,25);
		
        req=new JLabel("Please Fill out the Details");
        req.setBounds(60,70,500,50);
        req.setFont(myfont1);
        req.setBackground(Color.BLACK);
        panel.add(req);
		
		bgroup=new JLabel("Blood Group:");
        bgroup.setBounds(20,200,300,50);
        bgroup.setFont(myfont2);
        panel.add(bgroup);
  
		//String bloodgroup[]={"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
		bgroupfield=new JTextField();
		bgroupfield.setBounds(290,200,200,50);
		bgroupfield.setFont(myfont2);
		panel.add(bgroupfield);

        condition=new JLabel("Patient Conditions:");
        condition.setBounds(20,300,300,50);
        condition.setFont(myfont2);
        panel.add(condition);
		
		condifield=new JTextField();
        condifield.setBounds(290,300,200,50);
		condifield.setFont(myfont2);
        panel.add(condifield);

        location=new JLabel("Location Address/ Hospital:");
        location.setBounds(20,400,300,50);
        location.setFont(myfont2);
        panel.add(location);
		
		locationfield=new JTextField();
        locationfield.setBounds(290,400,200,50);
		locationfield.setFont(myfont2);
        panel.add(locationfield);

        contact=new JLabel("Contact Number:");
        contact.setBounds(20,500,300,50);
        contact.setFont(myfont2);
        panel.add(contact);

        contactfield=new JTextField();
        contactfield.setBounds(290,500,200,50);
		contactfield.setFont(myfont2);
        panel.add(contactfield);

        submit=new JButton("SUBMIT");
        submit.setBounds(120,700,100,50);
        submit.setBackground(Color.PINK);
        submit.setForeground(Color.BLACK);
		submit.addActionListener(this);
        panel.add(submit);

        backbtn=new JButton("BACK");
        backbtn.setBounds(320,700,100,50);
        backbtn.setBackground(Color.PINK);
        backbtn.setForeground(Color.BLACK);
		backbtn.addActionListener(this);
        panel.add(backbtn);

		img=new ImageIcon("image/blood-156063_1280.png");
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
		
		else if(ae.getSource()==submit)
		{   
	        
			String reqbloodgroup=bgroupfield.getText();
			String reqcondition=condifield.getText();
			String reqlocation=locationfield.getText();
			String reqnumber=contactfield.getText();
		
			if(reqbloodgroup.isEmpty()||reqlocation.isEmpty()||reqnumber.isEmpty())
			{
				JOptionPane.showMessageDialog(null,"You Have To Fill All");
			}
			else if(!reqbloodgroup.isEmpty() && reqcondition.isEmpty() && !reqlocation.isEmpty() && !reqnumber.isEmpty())
			{
				acc.makeRequest(reqbloodgroup,reqlocation, reqnumber);
				
				JOptionPane.showMessageDialog(null,"Created Sucessfully");
				
				bgroupfield.setText("");
				condifield.setText("");
				locationfield.setText("");
				contactfield.setText("");
				
			    DonorList DL1=new DonorList(acc);
	            DL1.setVisible(true);
			    this.setVisible(false);
			}
			else
			{   
				acc.makeRequest(reqbloodgroup, reqcondition, reqlocation, reqnumber);
				
				JOptionPane.showMessageDialog(null,"Created Sucessfully");
				
				bgroupfield.setText("");
				condifield.setText("");
				locationfield.setText("");
				contactfield.setText("");
				
			    DonorList DL1=new DonorList(acc);
	            DL1.setVisible(true);
			    this.setVisible(false);
			}
			 
		}
	}
	
}