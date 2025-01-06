package GUI;
import Entity.*;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewPass extends JFrame implements MouseListener,ActionListener
{
	JPanel panel,imagepanel;
	JLabel newpass,repass;
	JPasswordField npfield,refield;
	JButton confirm;
	private Account acc;
	
	public NewPass(Account acc)
	{
		super("REDLink");
		this.setSize(1600,1000);
		
		this.acc=acc;
				
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
		
		newpass=new JLabel("NEW PASSWORD");
		newpass.setBounds(380,250,100,50);
		panel.add(newpass);
		
		repass=new JLabel("RE-ENTER PASSWORD");
		repass.setBounds(380,350,100,50);
		panel.add(repass);
		
		npfield=new JPasswordField();
		npfield.setBounds(500,250,100,50);
		panel.add(npfield);
		
		refield=new JPasswordField();
		refield.setBounds(500,350,100,50);
		panel.add(refield);
		
		confirm=new JButton("CONFIRM");
		confirm.setBounds(440,450,100,50);
		confirm.setBackground(Color.PINK);
		confirm.addMouseListener(this);
		confirm.addActionListener(this);
		confirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(confirm);
		
		this.add(panel);
		this.add(imagepanel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==confirm)
		{
			String newp=new String(npfield.getPassword());
			String rep=new String(refield.getPassword());
			if(newp.isEmpty()||rep.isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Please Fill up Details First!");
			}
			else
			{
				String oldUsername=acc.getusername();
				String oldUserpass=acc.getuserpass();
				String oldUserphn=acc.getuserphn();
				String newUsername=acc.getusername();
				String newUserpass=newp;
				String newUserage=acc.getuserage();
				String newUserarea=acc.getuserarea();
				String newUserphn=acc.getuserphn();
			
				acc.updateAccount(oldUsername,oldUserpass,oldUserphn,newUsername,newUserpass,newUserage,newUserarea,newUserphn);
				
				JOptionPane.showMessageDialog(null,"Password Successfully Changed");
				
				Login L1=new Login();
		        L1.setVisible(true);
			    this.setVisible(false);
				
			}
		}
	}
	
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource()==confirm)
		{
			confirm.setBackground(Color.GREEN);
		}
	}
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource()==confirm)
		{
			confirm.setBackground(Color.PINK);
		}
	}
}