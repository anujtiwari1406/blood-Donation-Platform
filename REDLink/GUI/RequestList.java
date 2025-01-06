package GUI;
import Entity.*;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RequestList extends JFrame implements ActionListener{
	
	    JPanel panel;
		JLabel intro, pic;
		JButton backbtn;
		ImageIcon img;
		JTable table;
	
		Color mycolor,mycolor1;
	    Font myfont, myfont1, myfont2;
		
		private Account acc;
		
		public RequestList(Account acc)
		{
			
		super("RequestList frame");
		this.setSize(1600,1000);
		
		this.acc=acc;
		
		mycolor=new Color(200,10,10);
		myfont=new Font ("Kristen ITC", Font.BOLD,20);
		myfont1=new Font ("Arial", Font.BOLD,45);
		myfont2=new Font ("Arial", Font.PLAIN,20);
		 
		panel=new JPanel();
		panel.setLayout(null);
		
		intro=new JLabel("Request List");//"Donor List"
		intro.setForeground(Color.WHITE);
		intro.setBounds(700,50,700,50);
		intro.setFont(myfont1);
		panel.add(intro);
		
		String [][] data={                        //for table
			{"abdur","B+","01834288180"},
			{"rauf","A-","01834288180"},
			{"asif","AB+","01761525353"},
		    {acc.getusername(),acc.getreqbloodgroup(),acc.getreqnumber()}
		};
		String [] columnName={"Name","Adress","Mobile No"};
		
		JTable table=new JTable(data,columnName);
		table.setBounds(300,150,1000,500);
		table.setOpaque(true);
		panel.add(table);
		
		backbtn=new JButton("Back");
		backbtn.setBounds(700,700,120,50);
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
			 UDashboard UD1=new UDashboard(acc);
			 UD1.setVisible(true);
			 this.setVisible(false);
		}
		
		
	}
}