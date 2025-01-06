package GUI;
import Entity.*;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminLogin extends JFrame implements MouseListener,ActionListener
{
	    JPanel panel;
		JLabel intro,pic,username,pass;
		JTextField usernamefield;
		JPasswordField passfield;
		JButton loginbtn,backbtn;
		ImageIcon img;
		
	    Font myfont1;
		
		public AdminLogin()
		{
			
		super("ADMIN");
		this.setSize(1600,1000);
		
		ImageIcon framelogo=new ImageIcon("image/framelogo.jpg"); 
		this.setIconImage(framelogo.getImage());
		
		myfont1=new Font ("Arial", Font.BOLD,45);
		 
		panel=new JPanel();
		panel.setLayout(null);
		
		
		intro=new JLabel("ADMIN LOGIN");
		intro.setForeground(Color.WHITE);
		intro.setBounds(700,50,700,50);
		intro.setFont(myfont1);
		panel.add(intro);
		
		username=new JLabel("USERNAME");
		username.setForeground(Color.WHITE);
		username.setBounds(650,150,200,50);
		panel.add(username);
		
		pass=new JLabel("PASSWORD");
		pass.setBounds(650,250,200,50);
		pass.setForeground(Color.WHITE);
		panel.add(pass);
		
		usernamefield=new JTextField();
		usernamefield.setBounds(800,150,200,50);
		panel.add(usernamefield);
		
		passfield=new JPasswordField();
		passfield.setBounds(800,250,200,50);
		panel.add(passfield);
		
		
		loginbtn=new JButton("LOGIN");
		loginbtn.setBounds(725,350,100,50);
		loginbtn.setBackground(Color.PINK);
		loginbtn.addActionListener(this);
		loginbtn.addMouseListener(this);
		loginbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(loginbtn);
		
		backbtn=new JButton("Back");
		backbtn.setBounds(1100,800,100,50);
		backbtn.setBackground(Color.PINK);
        backbtn.addActionListener(this);
		backbtn.addMouseListener(this);
		backbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
				Initial I=new Initial();
		        I.setVisible(true);
			    this.setVisible(false);
			}
			else if(ae.getSource()==loginbtn)
			{
				String name=usernamefield.getText();
			    String password=passfield.getText();
				
				if(name.equals("admin") && password.equals("0000"))
				{
					Admin AA1=new Admin();
					AA1.setVisible(true);
					this.setVisible(false);
					
					usernamefield.setText("");
				    passfield.setText("");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Wrong");
				}
			}
			
		 }
		 public void mouseClicked(MouseEvent me){}
	     public void mousePressed(MouseEvent me){}
	     public void mouseReleased(MouseEvent me){}
		 public void mouseEntered(MouseEvent me)
	{
		if(me.getSource()==loginbtn)
		{
			loginbtn.setBackground(Color.GREEN);
		}
		else if(me.getSource()==backbtn)
		{
			backbtn.setBackground(Color.RED);
		}
	}
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource()==loginbtn)
		{
			loginbtn.setBackground(Color.PINK);
		}
		else if(me.getSource()==backbtn)
		{
			backbtn.setBackground(Color.PINK);
		}
	}
}