package Entity;

import GUI.*;
import java.lang.*;
import java.util.*;
import java.io.*;

public class Account
{
	private String username;
	private String userpass;
	private String userage;
	private String userarea;
	private String userphn;
	
	public boolean hasRequest;
	private String reqbloodgroup;
    private String reqcondition;
    private String reqlocation;
    private String reqnumber;
	
	private File file;
	private FileWriter fwriter;
	private Scanner sc;
	
	public Account()
	{
		this.hasRequest=false;
	}
	
	public Account(String username,String userpass,String userage,String userarea,String userphn)
	{
		this.username=username;
		this.userpass=userpass;
		this.userage=userage;
		this.userarea=userarea;
		this.userphn=userphn;
	}
	
	public void setusername(String username)
	{
		this.username=username;
	}
	public void setuserpass(String userpass)
	{
		this.userpass=userpass;
	}
	public void setuserage(String userage)
	{
		this.userage=userage;
	}
	public void setuserarea(String userarea)
	{
		this.userarea=userarea;
	}
	public void setuserphn(String userphn)
	{
		this.userphn=userphn;
	}
	
	
	public String getusername()
	{
		return username;
	}
	public String getuserpass()
	{
		return userpass;
	}
	public String getuserage()
	{
		return userage;
	}
	public String getuserarea()
	{
		return userarea;
	}
	public String getuserphn()
	{
		return userphn;
	}
	
	public void addaccount()
	{
		try
		{
		file=new File("/Data/Data.txt");
		file.createNewFile();
		fwriter=new FileWriter(file,true);
		fwriter.write(getusername()+"\t");
		fwriter.write(getuserpass()+"\t");
		fwriter.write(getuserage()+"\t");
		fwriter.write(getuserarea()+"\t");
		fwriter.write(getuserphn()+"\n");
		fwriter.flush();
		fwriter.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
	public boolean getAccount(String username,String userpass,String userphn)
	{
		boolean flag=false;
		file=new File("/Data/Data.txt");
		
		try
		{
		  sc=new Scanner(file);
		  
		  while(sc.hasNextLine())
		  {
			  String line=sc.nextLine();
			  String[] value=line.split("\t");
			  if(value[0].equals(username)&&value[1].equals(userpass)&&value[4].equals(userphn))
			  {
				  flag=true;
			  }
		  }
		  sc.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		
		return flag;
		
	}
	
	public void deleteAccount(String username, String userphn) 
	{
        file = new File("/Data/Data.txt");
        File tempFile = new File("/Data/TempData.txt");

        try 
		{
            Scanner sc = new Scanner(file);
            FileWriter fw = new FileWriter(tempFile);

            while (sc.hasNextLine()) 
			{
                String line = sc.nextLine();
                String[] value = line.split("\t");
                if (!(value[0].equals(username) && value[4].equals(userphn))) 
				{
                    fw.write(line + "\n");
                }
            }

            sc.close();
            fw.flush();
            fw.close();

            file.delete();
            tempFile.renameTo(new File("/Data/Data.txt"));
        } 
		catch (IOException ioe) 
		{
            ioe.printStackTrace();
        }
    }

    public void updateAccount(String oldUsername, String oldUserpass, String oldUserphn,String newUsername,String newUserpass, String newUserage,String newUserarea, String newUserphn)
	{
        file = new File("/Data/Data.txt");
        File tempFile = new File("/Data/TempData.txt");

        try {
            Scanner sc = new Scanner(file);
            FileWriter fw = new FileWriter(tempFile);

            while (sc.hasNextLine()) 
			{
                String line = sc.nextLine();
                String[] value = line.split("\t");
                if (value[0].equals(oldUsername) && value[1].equals(oldUserpass) && value[4].equals(oldUserphn)) 
				{
                    fw.write(newUsername + "\t");
                    fw.write(newUserpass + "\t");
                    fw.write(newUserage + "\t");
                    fw.write(newUserarea + "\t");
                    fw.write(newUserphn + "\n");
                } 
				else 
				{
                    fw.write(line + "\n");
                }
            }

            sc.close();
            fw.flush();
            fw.close();

            file.delete();
            tempFile.renameTo(new File("/Data/Data.txt"));
        } 
		catch (IOException ioe) 
		{
            ioe.printStackTrace();
        }
    }
	
	public Account getAccount(String username,String userphn)
	{
		Account foundAccount=null;
		file=new File("/Data/Data.txt");
		
		try
		{
		  sc=new Scanner(file);
		  
		  while(sc.hasNextLine())
		  {
			  String line=sc.nextLine();
			  String[] value=line.split("\t");
			  if(value[0].equals(username)&&value[4].equals(userphn))
			  {
				  foundAccount=new Account(value[0],value[1],value[2],value[3],value[4]);
				  break;
			  }
		  }
		  sc.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		
		return foundAccount;
		
	}
	
	public boolean hasRequest()
	{
		return hasRequest;
	}
	
	public void makeRequest(String reqbloodgroup, String reqcondition, String reqlocation, String reqnumber) 
	{
        this.reqbloodgroup = reqbloodgroup;
        this.reqcondition = reqcondition;
        this.reqlocation = reqlocation;
        this.reqnumber = reqnumber;
        this.hasRequest = true;
    }
	
	public void makeRequest(String reqbloodgroup, String reqlocation, String reqnumber)
	{
		this.reqbloodgroup = reqbloodgroup;
        this.reqcondition ="";
        this.reqlocation = reqlocation;
        this.reqnumber = reqnumber;
        this.hasRequest = true;
	}
	
	 public void deleteRequest() 
	 {
        this.reqbloodgroup = "";
        this.reqcondition = "";
        this.reqlocation = "";
        this.reqnumber = "";
        this.hasRequest = false;
	
	}
	
	public String getreqbloodgroup()
	{
        return reqbloodgroup;
    }

    public String getreqcondition()
	{
        return reqcondition;
    }

    public String getreqlocation()
	{
        return reqlocation;
    }

    public String getreqnumber()
	{
        return reqnumber;
    }



}