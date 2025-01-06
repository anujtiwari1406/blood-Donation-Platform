package GUI;
import Entity.*;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ForgotPassword extends JFrame implements MouseListener,ActionListener
{
	JPanel panel,imagepanel;
	JLabel name,phnnmb,text;
	JTextField namefield,phnnmbfield;
	JButton enter,back;
	Font font;
	
	Color color1=new Color(184,255,90);
	Color color2=new Color(255,93,37);
	private Account acc;
	
	public ForgotPassword()
	{
		super("REDLink");
		this.setSize(1600,1000);
		
		ImageIcon framelogo=new ImageIcon("image/framelogo.jpg");  
		this.setIconImage(framelogo.getImage());
		
		ImageIcon logo=new ImageIcon("image/Request_form_background.png");   
        JLabel imagelabel=new JLabel(logo);
        imagelabel.setBounds(0,0,1600,1000);
		
		imagepanel=new JPanel();
        imagepanel.setLayout(null);
        imagepanel.setBounds(0,0,600,1000);
        imagepanel.add(imagelabel);
		

		panel=new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,1100,1000);
		panel.setBackground(Color.RED);
		panel.setOpaque(true);
		
		name=new JLabel("Name");
		name.setBounds(380,250,100,50);
		panel.add(name);
		
		namefield=new JTextField();
		namefield.setBounds(550,250,150,50);
		panel.add(namefield);
		
		phnnmb=new JLabel("PHONE NUMBER");
		phnnmb.setBounds(380,350,100,50);
		panel.add(phnnmb);
		
		phnnmbfield=new JTextField();
		phnnmbfield.setBounds(550,350,150,50);
		panel.add(phnnmbfield);
		
		font=new Font("Arial",Font.BOLD,25);
		text=new JLabel("ENTER YOUR DETAILS TO RECOVER PASSWORD");
		text.setBounds(250,50,650,100);
		text.setFont(font);
		panel.add(text);
		
		enter=new JButton("Enter");
		enter.setBounds(440,450,100,50); 
		enter.setBackground(Color.PINK);
		enter.addMouseListener(this);
		enter.addActionListener(this);
		enter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(enter);
		
		back=new JButton("BACK");
		back.setBounds(900,800,100,50);
		back.setBackground(Color.PINK);
		back.addMouseListener(this);
		back.addActionListener(this);
		back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(back);
		
		
		this.add(panel);
		this.add(imagepanel);
		
		
		acc=new Account();
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==enter)
		{
			String name=namefield.getText();
			String phnnmb=phnnmbfield.getText();
			if(name.isEmpty()||phnnmb.isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Please Fill up Details First!");
			}
			else
			{
				
				Account retrievedAccount=acc.getAccount(name,phnnmb);
				
				if(retrievedAccount !=null)
				{ 
			        acc=retrievedAccount;
					NewPass NP1=new NewPass(acc);
			        NP1.setVisible(true);
			        this.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"No Account found from the Given Details");
				}
			}
		}
		else if(ae.getSource()==back)
		{
			Login L1=new Login();
			L1.setVisible(true);
			this.setVisible(false);
		}
	}
	
	public void mouseClicked(MouseEvent me)
	{
		if(me.getSource()==enter)
		{
			enter.setBackground(color1);
		}
		else if(me.getSource()==back)
		{
			back.setBackground(color2);
		}
	}
	public void mousePressed(MouseEvent me)
	{
		if(me.getSource()==enter)
		{
			enter.setBackground(Color.GREEN);
		}
		else if(me.getSource()==back)
		{
			back.setBackground(Color.RED);
		}
	}
	public void mouseReleased(MouseEvent me)
	{
		if(me.getSource()==enter)
		{
			enter.setBackground(Color.PINK);
		}
		else if(me.getSource()==back)
		{
			back.setBackground(Color.PINK);
		}
	}
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource()==enter)
		{
			enter.setBackground(Color.GREEN);
		}
		else if(me.getSource()==back)
		{
			back.setBackground(Color.RED);
		}
	}
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource()==enter)
		{
			enter.setBackground(Color.PINK);
		}
		else if(me.getSource()==back)
		{
			back.setBackground(Color.PINK);
		}
	}

}