import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AccountInfo implements ActionListener
{
	String AccountItems[]={"New","Close","Exit"};
	String TranscationItems[]={"Deposit","Withdraw"};
	JFrame f;
	JDesktopPane jdp;
	JInternalFrame f1,f2,f3,f4;
	JMenuBar mb;
	JMenu account,transcation;
	JPanel p1,p2,p3,p4;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
	int a,c,x,y,g,e,t;
	String temp,temp1,temp4;
	mydatabase md=new mydatabase();
	public AccountInfo()
	{
		f=new JFrame("MY Bank");
		f.setSize(1000,1000);
		jdp=new JDesktopPane();
		mb=new JMenuBar();
		account=new JMenu("Account");
		transcation=new JMenu("Transcation");
		for(int i=0;i<AccountItems.length;i++)
		{
			JMenuItem item=new JMenuItem(AccountItems[i]);
			item.addActionListener(this);
			account.add(item);
		}
		for(int i=0;i<TranscationItems.length;i++)
		{
			JMenuItem item=new JMenuItem(TranscationItems[i]);
			item.addActionListener(this);
			transcation.add(item);
		}
		account.insertSeparator(2);
		mb.add(account);
		mb.add(transcation);
		f.setJMenuBar(mb);
		f.add(jdp);
		f.setVisible(true);
		newaccount();
		closeaccount();
		depositmoney();
		withdrawmoney();
	}
	public void actionPerformed(ActionEvent e1)
	{
		String str=e1.getActionCommand();
		if(str.equals("New"))
		{
			System.out.println("new was clicked");
			newaccount();
		}
		
		if(str.equals("Close"))
		{
			System.out.println("close account was clicked");
			closeaccount();
		}
		if(str.equals("Exit"))
		{
			System.out.println("exit was clicked");
			System.exit(1);
		}
		if(str.equals("Deposit"))
		{
			System.out.println("Deposit was clicked");
			depositmoney();
		}
		if(str.equals("Withdraw"))
		{
			System.out.println("Withdarw was clicked");
			withdrawmoney();
		}
		
		if(e1.getSource()==b2)
		{
			t2.setText("");
			t3.setText("");
		}
		if(e1.getSource()==b5)
		{
			t4.setText("");
			t5.setText("");
			t6.setText("");
		}
		if(e1.getSource()==b8)
		{
			t7.setText("");
			t8.setText("");
			t9.setText("");
			t10.setText("");
		}
		if(e1.getSource()==b11)
		{
			t11.setText("");
			t12.setText("");
			t13.setText("");
			t14.setText("");
		}
		if(e1.getSource()==b3)
		{
			System.out.print("not");
			f1.setVisible(false);
		}
		if(e1.getSource()==b6)
		{
			System.out.print("not");
			f2.setVisible(false);
		}
		if(e1.getSource()==b9)
		{
			System.out.print("not");
			f3.setVisible(false);
		}
		if(e1.getSource()==b12)
		{
			System.out.print("not");
			f4.setVisible(false);
		}
		if(e1.getSource()==t7)
		{
			if(!(t7.getText().equals("")))
			{
			System.out.println("text");
			x=Integer.parseInt(t7.getText());
			ResultSet rs;
			try{
				rs=md.singlerow("accounts",x);
				if(rs.next())
				{
						t8.setText(rs.getString("Name"));
						t9.setText(rs.getString("Balance"));
				}
				else
				{
					JOptionPane.showMessageDialog(f3,"This Account No does not exit.plz enter a valid  account no","Respond",JOptionPane.PLAIN_MESSAGE);
					return;
				}
					
			}
			catch(Exception e)
			{
				System.out.print("error");
			}}
		}
		if(e1.getSource()==t4)
		{
			if(!(t4.getText().equals("")))
			{
			System.out.println("text");
			x=Integer.parseInt(t4.getText());
			ResultSet rs;
			System.out.println("shubham");
			try{
				System.out.println("hello");
				System.out.println("shubham");
				rs=md.singlerow("accounts",x);
				System.out.println("shubham1");
				System.out.println("hello");
				if(rs.next())
				{
					t5.setText(rs.getString("Name"));
					t6.setText(rs.getString("Balance"));
				}
				else
				{
					JOptionPane.showMessageDialog(f2,"This Account No does not exit.plz enter a valid  account no","Respond",JOptionPane.PLAIN_MESSAGE);
					return;
				}
					
			}
			catch(Exception e)
			{
				System.out.print("error");
			}
		}}
		if(e1.getSource()==t11)
		{
			if(!(t11.getText().equals("")))
			{
			System.out.println("text");
			x=Integer.parseInt(t11.getText());
			ResultSet rs;
			try{
				rs=md.singlerow("accounts",x);
				if(rs.next())
				{
						t12.setText(rs.getString("Name"));
						t13.setText(rs.getString("Balance"));
					}
					else
					{
						JOptionPane.showMessageDialog(f4,"This Account No does not exit.plz enter a valid  account no","Respond",JOptionPane.PLAIN_MESSAGE);
					return;
					}
					
			}
			catch(Exception e)
			{
				System.out.print("error");
			}
		}}
		
		if(str.equals("Save"))
		{
			if(e1.getSource()==b1)
			{
			System.out.print("save was pressed");
			String str1,str2;
			str1=t2.getText(); str2=t3.getText();
			if(str1.equals(""))
			{
				JOptionPane.showMessageDialog(f1,"plz Enter name","Respond",JOptionPane.PLAIN_MESSAGE);
				return;
			}
			char arr1[];
						arr1=str1.toCharArray();
						int j=0;
						while(j<arr1.length)
						{
							char ch1=arr1[j];
							if(Character.isAlphabetic(ch1))
							{j++;
								continue;}
							else{
								JOptionPane.showMessageDialog(f1,"plz Enter a valid Name","Respond",JOptionPane.PLAIN_MESSAGE);
								return;
							}
						}
			if(str2.equals(""))
			{
				JOptionPane.showMessageDialog(f1,"plz Enter Amount","Respond",JOptionPane.PLAIN_MESSAGE);
				return;
			}
			t=Integer.parseInt(str2);
			if(t<0)
			{
				JOptionPane.showMessageDialog(f1,"plz Enter valid amount","Respond",JOptionPane.PLAIN_MESSAGE);
				return;
			}
			char arr[];
						arr=str2.toCharArray();
						for(int i=0;i<arr.length;i++)
						{
							char ch=arr[i];
							if(ch>='0' && ch<='9')
								continue;
							else{
								JOptionPane.showMessageDialog(f1,"plz Enter a valid Amount","Respond",JOptionPane.PLAIN_MESSAGE);
								break;
								
							}
						}
			try
			{
				System.out.println("Hello");
						int y=Integer.parseInt(t1.getText());
						md.insert("accounts",y,str1,str2);
						System.out.println("Hello1");
						JOptionPane.showMessageDialog(f1,"Account Succesfully Created","Respond",JOptionPane.PLAIN_MESSAGE);
						ResultSet rs;
						rs=md.select("accounts");
			if(rs.next())
			{
				rs.last();
				int x=rs.getInt("AccountNo");
				x=x+1;
				t1.setText(""+x);
				t2.setText("");
				t3.setText("");
			}
			else{
				t1.setText("1");
			}
			}
			catch(Exception e)
			{
				System.out.print("error");
			}
		}}
		
		if(str.equals("Delete"))
		{
			if(e1.getSource()==b4)
			{
			System.out.println("delete was pressed");
			if(t4.getText().equals(""))
			{
				JOptionPane.showMessageDialog(f2,"plz Enter Account No","Respond",JOptionPane.PLAIN_MESSAGE);
				return;
			}
			char arr[];
						arr=t4.getText().toCharArray();
						for(int i=0;i<arr.length;i++)
						{
							char ch=arr[i];
							if(ch>='0' && ch<='9')
								continue;
							else{
								JOptionPane.showMessageDialog(f2,"plz Enter a valid Account No","Respond",JOptionPane.PLAIN_MESSAGE);
								break;
								
							}
						}
			try{
			int y=Integer.parseInt(t4.getText());
						md.delete("accounts",y);
						JOptionPane.showMessageDialog(f2,"Account Succesfully Deletd","Respond",JOptionPane.PLAIN_MESSAGE);
						t4.setText("");
						t5.setText("");
						t6.setText("");
						if(!(t7.getText().equals("")))
						{
						g=Integer.parseInt(t7.getText());
					if(y==g)
					{
							t7.setText("");
							t8.setText("");
							t9.setText("");
						}}
					if(!(t11.getText().equals("")))
					{
					e=Integer.parseInt(t11.getText());
					if(y==e)
					{
						t11.setText("");
						t12.setText("");
						t13.setText("");
					}}
			}
			
			catch(Exception e)
			{
				System.out.print("error");
			}}}
			
			
			if(str.equals("deposit"))
			{
				if(e1.getSource()==b7)
			{
				System.out.println("deposit was pressed");
				if(t7.getText().equals(""))
			{
				JOptionPane.showMessageDialog(f3,"plz Enter Account No","Respond",JOptionPane.PLAIN_MESSAGE);
				return;
			}
			char arr1[];
						arr1=t7.getText().toCharArray();
						int j=0;
						while(j<arr1.length)
						{
							char ch1=arr1[j];
							if(ch1>='0' && ch1<='9')
							{j++;
								continue;}
							else{
								JOptionPane.showMessageDialog(f3,"plz Enter a valid Account No","Respond",JOptionPane.PLAIN_MESSAGE);
								return;
								
							}
						}
			if(t10.getText().equals(""))
			{
				JOptionPane.showMessageDialog(f3,"plz Enter Amount","Respond",JOptionPane.PLAIN_MESSAGE);
				return;
			}
				String str3=t10.getText();
					char arr[];
						arr=str3.toCharArray();
						int i=0;
						while(i<arr.length)
						{
							char ch=arr[i];
							if(ch>='0' && ch<='9')
							{i++;
							continue;}
							else{
								JOptionPane.showMessageDialog(f3,"plz Enter a valid Amount","Respond",JOptionPane.PLAIN_MESSAGE);
								break;
							}
						}
				try{
					a=Integer.parseInt(t7.getText());
					y=Integer.parseInt(t10.getText());
					ResultSet rs;
					rs=md.singlerow("accounts",a);
					if(rs.next())
					{
						temp=rs.getString("Balance");
						x=Integer.parseInt(temp);
						c=x+y;
						md.update("accounts",a,""+c);
						JOptionPane.showMessageDialog(f3,"Amount Succesfully deposited","Respond",JOptionPane.PLAIN_MESSAGE);
						t10.setText("");
						t9.setText(""+c);
						if(!(t4.getText().equals("")))
						{
						g=Integer.parseInt(t4.getText());
						if(a==g)
					{
							t6.setText(""+c);
							t9.setText(""+c);
						}
					}
					if(!(t11.getText().equals("")))
					{
					e=Integer.parseInt(t11.getText());
					if(a==e)
					{
						t9.setText(""+c);
						t13.setText(""+c);
					}
					}
					}
					else
					{
						JOptionPane.showMessageDialog(f3,"This Account No does not exit.plz enter a valid  account no","Respond",JOptionPane.PLAIN_MESSAGE);
					return;
					}
				}
				catch(Exception e)
				{
					System.out.println("error");
				}
			}}
			
			if(str.equals("withDraw"))
			{
				if(e1.getSource()==b10)
				{
					System.out.println("withdaw was pressed");
					if(t11.getText().equals(""))
			{
				JOptionPane.showMessageDialog(f4,"plz Enter Account No","Respond",JOptionPane.PLAIN_MESSAGE);
				return;
			}
						char arr1[];
						arr1=t11.getText().toCharArray();
						int j=0;
						while(j<arr1.length)
						{
							char ch1=arr1[j];
							if(ch1>='0' && ch1<='9')
							{
								j++;
								continue;}
							else{
								JOptionPane.showMessageDialog(f4,"plz Enter a valid Account No","Respond",JOptionPane.PLAIN_MESSAGE);
								break;
							}
						}
			
			if(t14.getText().equals(""))
			{
				JOptionPane.showMessageDialog(f4,"plz Enter Amount","Respond",JOptionPane.PLAIN_MESSAGE);
				return;
			}
					String str3=t14.getText();
					char arr[];
						arr=str3.toCharArray();
						int i=0;
						while(i<arr.length)
						{
							char ch=arr[i];
							if(ch>='0' && ch<='9')
							{
								i++;
									continue;}
							else{
								JOptionPane.showMessageDialog(f4,"plz Enter a valid Amount","Respond",JOptionPane.PLAIN_MESSAGE);
								break;
							}
						}
					try
					{
						a=Integer.parseInt(t11.getText());
						ResultSet rs;
					rs=md.singlerow("accounts",a);
					if(rs.next())
					{
					temp=rs.getString("Balance");
					x=Integer.parseInt(temp);
					y=Integer.parseInt(t14.getText());
					c=x-y;
					if(c>=0)
					{
						temp1=""+c;
						md.update("accounts",a,temp1);
						JOptionPane.showMessageDialog(f4,"Amount Succesfully withdraw","Respond",JOptionPane.PLAIN_MESSAGE);
						t14.setText("");
						t13.setText(temp1);
						if(!(t4.getText().equals("")))
					{
						g=Integer.parseInt(t4.getText());
						if(a==g)
						{
							t6.setText(temp1);
							t13.setText(temp1);
						}
					}
					if(!(t7.getText().equals("")))
					{
						e=Integer.parseInt(t7.getText());
						if(a==e)
						{
							t9.setText(temp1);
							t13.setText(temp1);
						}
					}
					}
					else
					{
						JOptionPane.showMessageDialog(f4,"Amount insufficent.plzz enter valid amount","Respond",JOptionPane.PLAIN_MESSAGE);
					}
					}
					else
					{
						JOptionPane.showMessageDialog(f4,"This Account No does not exit.plz enter a valid  account no","Respond",JOptionPane.PLAIN_MESSAGE);
					return;
					}}
					catch(Exception e)
					{
						System.out.println("error");
					}	
			}}
	}
	public void newaccount()
	{
	f1=new JInternalFrame("New Account",true,true,true,true);
		f1.setSize(300,300);
		p1=new JPanel(new GridBagLayout());
		l1=new JLabel("Account No");
		GridBagConstraints gbc=new GridBagConstraints();
     gbc.gridx=0; gbc.gridy=0;
     gbc.gridwidth=1;  gbc.gridheight=1;
     Insets i=new Insets(2,2,2,10);
     gbc.insets=i;
     p1.add(l1,gbc);
     t1=new JTextField(15);
     t1.setEditable(false);
     gbc.gridx=1; gbc.gridwidth=1;
     Insets j=new Insets(2,2,10,2);
     gbc.insets=j;
     p1.add(t1,gbc);
     l2=new JLabel("Name");
     gbc.gridy=1; gbc.gridx=0;
     Insets k=new Insets(2,2,2,10);
     gbc.insets=k;
     p1.add(l2,gbc);
     t2=new JTextField(15);
     gbc.gridx=1; gbc.gridy=1;
     Insets a2=new Insets(2,2,10,2);
     gbc.insets=a2;
     p1.add(t2,gbc);
     l3=new JLabel("Balance");
     gbc.gridx=0; gbc.gridy=2;
     Insets s=new Insets(2,2,2,10);
     gbc.insets=s;
     p1.add(l3,gbc);
     t3=new JTextField(15);
     gbc.gridx=1; gbc.gridy=2;
     Insets b=new Insets(2,2,2,10);
     gbc.insets=b;
     p1.add(t3,gbc);
     f1.add(p1,"Center");
		b1=new JButton("Save");
		b2=new JButton("Cancel");
		b3=new JButton("close");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		p2=new JPanel();
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		f1.add(p2,"South");
		f1.setLocation(50,50);
		jdp.add(f1);
		f1.setVisible(true);
		ResultSet rs;
		try{
			rs=md.select("accounts");
			if(rs.next())
			{
				rs.last();
				int x=rs.getInt("AccountNo");
				x=x+1;
				t1.setText(""+x);
				t2.setText("");
				t3.setText("");
			}
			else{
				t1.setText("1");
			}
		}
		catch(Exception e)
		{
			
		}
		
	}
	// to close a account
	public void closeaccount()
	{
		f2=new JInternalFrame("Close Account",true,true,true,true);
		f2.setSize(300,300);
		p1=new JPanel(new GridBagLayout());
		l1=new JLabel("Account no");
		GridBagConstraints gbc=new GridBagConstraints();
     gbc.gridx=0; gbc.gridy=0;
     gbc.gridwidth=1;  gbc.gridheight=1;
     Insets i=new Insets(2,2,2,10);
     gbc.insets=i;
     p1.add(l1,gbc);
     t4=new JTextField(15);
     t4.addActionListener(this);
     gbc.gridx=1; gbc.gridwidth=1;
     Insets j=new Insets(2,2,10,2);
     gbc.insets=j;
     p1.add(t4,gbc);
     l2=new JLabel("Name");
     gbc.gridy=1; gbc.gridx=0;
     Insets k=new Insets(2,2,2,10);
     gbc.insets=k;
     p1.add(l2,gbc);
     t5=new JTextField(15);
     t5.setEditable(false);
     gbc.gridx=1; gbc.gridy=1;
     Insets a=new Insets(2,2,10,2);
     gbc.insets=a;
     p1.add(t5,gbc);
     l3=new JLabel("Balance");
     gbc.gridx=0; gbc.gridy=2;
     Insets s=new Insets(2,2,2,10);
     gbc.insets=s;
     p1.add(l3,gbc);
     t6=new JTextField(15);
     t6.setEditable(false);
     gbc.gridx=1; gbc.gridy=2;
     Insets b=new Insets(2,2,2,10);
     gbc.insets=b;
     p1.add(t6,gbc);
     f2.add(p1,"Center");
		b4=new JButton("Delete");
		b5=new JButton("Cancel");
		b6=new JButton("close");
		p2=new JPanel();
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		p2.add(b4);
		p2.add(b5);
		p2.add(b6);
		f2.add(p2,"South");
		f2.setLocation(50,350);
		jdp.add(f2);
		f2.setVisible(true);
	}
	// to deposit in a account
	public void depositmoney()
	{
		f3=new JInternalFrame("Deposit",true,true,true,true);
		f3.setSize(300,300);
		f3.setLocation(400,50);
		p3=new JPanel(new GridBagLayout());
		l4=new JLabel("Account no");
		GridBagConstraints gbc1=new GridBagConstraints();
     gbc1.gridx=0; gbc1.gridy=0;
     gbc1.gridwidth=1;  gbc1.gridheight=1;
     Insets i=new Insets(2,2,2,10);
     gbc1.insets=i;
     p3.add(l4,gbc1);
     t7=new JTextField(15);
     t7.addActionListener(this);
     gbc1.gridx=1; gbc1.gridwidth=1;
     Insets j=new Insets(2,2,10,2);
     gbc1.insets=j;
     p3.add(t7,gbc1);
     l5=new JLabel("Name");
     gbc1.gridy=1; gbc1.gridx=0;
     Insets k=new Insets(2,2,2,10);
     gbc1.insets=k;
     p3.add(l5,gbc1);
     t8=new JTextField(15);
     t8.setEditable(false);
     gbc1.gridx=1; gbc1.gridy=1;
     Insets a=new Insets(2,2,10,2);
     gbc1.insets=a;
     p3.add(t8,gbc1);
     l6=new JLabel("Balance");
     gbc1.gridx=0; gbc1.gridy=2;
     Insets s=new Insets(2,2,2,10);
     gbc1.insets=s;
     p3.add(l6,gbc1);
     t9=new JTextField(15);
     t9.setEditable(false);
     gbc1.gridx=1; gbc1.gridy=2;
     Insets b=new Insets(2,2,2,10);
     gbc1.insets=b;
     p3.add(t9,gbc1);
     l7=new JLabel("Amount");
     gbc1.gridx=0; gbc1.gridy=3;
     Insets s1=new Insets(2,2,2,10);
     gbc1.insets=s1;
     p3.add(l7,gbc1);
     t10=new JTextField(15);
     gbc1.gridx=1; gbc1.gridy=3;
     Insets z=new Insets(2,2,2,10);
     gbc1.insets=z;
     p3.add(t10,gbc1);
     f3.add(p3,"Center");
		b7=new JButton("deposit");
		b8=new JButton("Cancel");
		b9=new JButton("close");
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		p4=new JPanel();
		p4.add(b7);
		p4.add(b8);
		p4.add(b9);
		f3.add(p4,"South");
		jdp.add(f3);
		f3.setVisible(true);
		
	}	
		// to withdraw money
	public void withdrawmoney()
	{
		f4=new JInternalFrame("Withdraw",true,true,true,true);
		f4.setSize(300,300);
		f4.setLocation(400,350);
		p3=new JPanel(new GridBagLayout());
		l4=new JLabel("Account no");
		GridBagConstraints gbc1=new GridBagConstraints();
     gbc1.gridx=0; gbc1.gridy=0;
     gbc1.gridwidth=1;  gbc1.gridheight=1;
     Insets i1=new Insets(2,2,2,10);
     gbc1.insets=i1;
     p3.add(l4,gbc1);
     t11=new JTextField(15);
     t11.addActionListener(this);
     gbc1.gridx=1; gbc1.gridwidth=1;
     Insets j1=new Insets(2,2,10,2);
     gbc1.insets=j1;
     p3.add(t11,gbc1);
     l5=new JLabel("Name");
     gbc1.gridy=1; gbc1.gridx=0;
     Insets k1=new Insets(2,2,2,10);
     gbc1.insets=k1;
     p3.add(l5,gbc1);
     t12=new JTextField(15);
     t12.setEditable(false);
     gbc1.gridx=1; gbc1.gridy=1;
     Insets a1=new Insets(2,2,10,2);
     gbc1.insets=a1;
     p3.add(t12,gbc1);
     l6=new JLabel("Balance");
     gbc1.gridx=0; gbc1.gridy=2;
     Insets s1=new Insets(2,2,2,10);
     gbc1.insets=s1;
     p3.add(l6,gbc1);
     t13=new JTextField(15);
     t13.setEditable(false);
     gbc1.gridx=1; gbc1.gridy=2;
     Insets b1=new Insets(2,2,2,10);
     gbc1.insets=b1;
     p3.add(t13,gbc1);
     l7=new JLabel("Amount");
     gbc1.gridx=0; gbc1.gridy=3;
     Insets s2=new Insets(2,2,2,10);
     gbc1.insets=s2;
     p3.add(l7,gbc1);
     t14=new JTextField(15);
     gbc1.gridx=1; gbc1.gridy=3;
     Insets b2=new Insets(2,2,2,10);
     gbc1.insets=b2;
     p3.add(t14,gbc1);
     f4.add(p3,"Center");
		b10=new JButton("withDraw");
		b11=new JButton("Cancel");
		b12=new JButton("close");
		b10.addActionListener(this);
		b11.addActionListener(this);
		b12.addActionListener(this);
		p4=new JPanel();
		p4.add(b10);
		p4.add(b11);
		p4.add(b12);
		f4.add(p4,"South");
		jdp.add(f4);
		f4.setVisible(true);
		
}
public static void main(String args[])
	{
		AccountInfo ai=new AccountInfo();// Main class object
	}
}