import java.util.*;
import java.io.*;
import java.sql.*;
public class insert
{
      public static void main(String args[])
      {
            String check="y",check1="no",check2="n";
            int i=0,sub=0;
             int a[]=new int[10];
             details ar[]=new details[10];
             String z="y",aa="y",age="y",gen="y",pre="y";
            StringBuilder str=new StringBuilder(2);
            int max=2,max1=12;
            Scanner sc=new Scanner(System.in);
            try
            {
	String url="jdbc:odbc:Details1";
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection con=DriverManager.getConnection(url);
	Statement s=con.createStatement();
	System.out.println();
	System.out.println("\t\tTrain Ticket Booking");
	System.out.println("\t\t==============");
	System.out.println("\t1.Registration");
	System.out.println();
	System.out.println("\t2.Login");
	System.out.println();
	System.out.print("Enter Your Choice=");
	int ch=sc.nextInt();
	switch(ch)
	{
                        case 1:
	               System.out.println("\t\tRegistration");
	               System.out.println("\t\t============");
	               System.out.println();
                                 System.out.print("\tName         :");
	               String n=sc.next();
	               System.out.println();
	               System.out.print("\tPassword     :");
	               String p=sc.next();
	               System.out.println();
	               System.out.print("\tPhone No     :");
	               String ph=sc.next();
	               System.out.println();
	               System.out.print("\tE-Mail ID    :");
	               String em=sc.next();
                                System.out.println();	                   
                                 //insert into Table values('nn','23','123','we');
                                 String ss="insert into reg values('"+n+"','"+p+"','"+ph+"','"+em+"')";
	               s.execute(ss);
	               System.out.println("\t\t******Successfully Registered******");
	               System.out.println();
                         case 2:
                                  do
	               {
		System.out.println();
	                 System.out.println("\t\tLogin");
	                 System.out.println("\t\t=====");
		System.out.println();
	                 System.out.print("\tUsername  :");
	                 String user=sc.next();
		System.out.println();
	                 System.out.print("\tPassword  :");
	                 String pass=sc.next();
	                 s.execute("select * from reg where Username='"+user+"'");
	                 ResultSet rs=s.getResultSet();
	                 if(rs.next())
	                {
	                         String st=rs.getString("Password");
	                         if(st.equals(pass))
		        {
		                System.out.println();
		                System.out.println("\t*****Login Success*****");
			check="y";
			break;
		         }
	                         else
		        {
			System.out.println();
		                 System.out.println("\t*****Incorrect Username/Password*****");
			System.out.println();
			System.out.print("\tTo Login Again -->Click y=");
			check=sc.next();

		         }
                                    }
	                  else
		  {
			System.out.println();
			System.out.println("\t*****Login Failure*****");
			System.out.println();
			System.out.print("\tTo Login Again -->Click y=");
			check=sc.next();
		   }
	  }while(check.equals("y"));		
               }
                  if(check=="y")
	{
	 do
                    {
	System.out.println();
	System.out.println("\t\t1.Train Details ");
	System.out.println();
	System.out.println("\t\t2.Reservation");
	System.out.println();
	System.out.println("\t\t3.Exit");	
	System.out.println();
	System.out.print("Enter Your Choice=");
	int ch1=sc.nextInt();
	switch(ch1)
	{
                       case 1:
 	          System.out.println();       
		System.out.println("\t\tTrain Details");
		System.out.println("\t\t*************");
		System.out.println();
                           s.execute("select * from Train");
		         ResultSet rs=s.getResultSet();
	         for(i=0;i<113;i++)
                           {
                                    System.out.print("=");
                            }
	         System.out.println();
	         System.out.format("%5s %11s %15s %18s %17s %19s %17s","Date","Train No","Source","Destination","Type","Class","Seats");
	         System.out.println();
	          for(i=0;i<113;i++)
                           {
                                    System.out.print("=");
                            }
	          System.out.println();
	         while(rs.next())
	          {
		String dd=rs.getString("DD");
	                  String train=rs.getString("Train_No");
		String from=rs.getString("Source");
		String to=rs.getString("Destination");
		String type=rs.getString("Type");
		String cl=rs.getString("Class");
		String seat=rs.getString("Seats");
		System.out.println();
		System.out.format("%5s %8s %16s %18s %19s %21s %14s",dd,train,from,to,type,cl,seat);
		System.out.println();
		 for(i=0;i<113;i++)
                                     {
                                          System.out.print("-");
                                    }
	                 System.out.println();
	         }
	         break;
	     case 2:
	                   System.out.println();
		System.out.println("\t\tReservation");
		System.out.println("\t\t***********");
		System.out.println();
		System.out.print("\tSource=");
		String so=sc.next();	
		System.out.println();
		System.out.print("\tDestination=");
		String de=sc.next();
		System.out.println();
            	                   s.execute("select * from Train where Source='"+so+"'");
		s.execute("select * from Train where Destination='"+de+"'");
		ResultSet rs1=s.getResultSet();
		System.out.println();
		    for(i=0;i<129;i++)
                                        {
                                                  System.out.print("=");
                                        }
		   System.out.println();
		    System.out.format("%5s %11s %15s %18s %17s %19s %17s %14s","Date","Train No","Source","Destination","Type","Class","Seats","Rate");
	                      System.out.println();
		     for(i=0;i<129;i++)
                                        {
                                                  System.out.print("=");
                                        }
	                      System.out.println();
		  while(rs1.next())
	                  {
		    String date=rs1.getString("DD");
	                      String train=rs1.getString("Train_No");
		   String from=rs1.getString("Source");
		   String to=rs1.getString("Destination");
		   String type=rs1.getString("Type");
		   String cl=rs1.getString("Class");
		   int seat=rs1.getInt("Seats");
		   String rate=rs1.getString("Rate");
		   System.out.println();
		if(seat>0)
		{
	    	   System.out.format("%5s %8s %16s %18s %19s %21s %14s %14s",date,train,from,to,type,cl,seat,rate);
		   System.out.println();
	                                   for(i=0;i<129;i++)
                                        {
                                                  System.out.print("-");
                                        }	
		}
		  System.out.println();
		}
		                 System.out.println();
			System.out.print("Enter the Date=");	
			String dd=sc.next();
			System.out.println();
			System.out.print("Enter the Train Number=");
			String tr=sc.next();
			System.out.println();
			System.out.print("Enter the Number of Persons=");
			int per=sc.nextInt();
			for(int j=1;j<=per;j++)
			{
				System.out.println();
				System.out.print("\tEnter the  "+j+" Person Name=");
				 z=sc.next();
				System.out.println();	
				System.out.print("\tEnter the Aadhar Number(up to" + max1 + "Values)=");
				 aa=sc.next();
				System.out.println();
				System.out.print("\tEnter your Age(up to" + max + "Values)=");
				 age=sc.next();
				System.out.println();
				System.out.print("\tEnter your Gender=");
				 gen=sc.next();
				String limit=limitString(age,max);
				String limit1=limitString(aa,max1);
				System.out.println();
				System.out.print("\tEnter the Birth Preference(Lower/Upper/Middle/Side Lower/Side Upper)=");
				pre=sc.next();
				System.out.println();	
				s=con.createStatement();
			                  String ss="insert into Passenger values('"+dd+"','"+tr+"','"+z+"','"+limit1+"','"+limit+"','"+gen+"','"+pre+"')";
	               			s.execute(ss);
				ar[j]=new details();
			                     ar[j].read(z,limit,gen,pre);
			       }
				 s.execute("select * from Train where Train_No='"+tr+"'");
				ResultSet rs2=s.getResultSet();
				if(rs2.next())
				{
					int sea=rs2.getInt("Seats");
					int per1=per;
			                  		sub=sea-per1;
					String up="UPDATE Train SET Seats ="+sub+" WHERE Train_No='"+tr+"'";
					s.executeUpdate(up);
				}
			                                                   
		System.out.println();
		  for(i=0;i<50;i++)
                           {
                                    System.out.print("=");
                            }
		System.out.println();
		System.out.println("\tDate="+dd);
		System.out.println();
		System.out.println("\tTrain No="+tr);
		System.out.println();
		System.out.println("\tSource="+so);
		System.out.println();
		System.out.println("\tDestination="+de);
		System.out.println();
		System.out.println("\tPersons="+per);
		System.out.println();
		s.execute("select * from Train where Train_No='"+tr+"'");
		ResultSet rs3=s.getResultSet();
		while(rs3.next())
		{
		      String type=rs3.getString("Type");
		      int rate=rs3.getInt("Rate");
		      System.out.println("\tType="+type);
		      int pr=per*rate;
		     System.out.println();
		      System.out.println("\tFinal Amount="+pr);
		}
		System.out.println();
		System.out.println();
		for(int j=1;j<=per;j++)
		{
			ar[j].display();
		}
		
		  for(i=0;i<50;i++)
                                      {
                                         System.out.print("=");
                                     }
		System.out.println();
		System.out.println("\t\t\t*****Ticket is Successfully Booked*****");	
	  	check1="no";
		break;
	
	
	        case 3:
		check1="yes";
		break;
	}
	}while(!check1.equals("yes"));
	System.out.println();
                 }
	con.close();
         }
          catch(Exception e)
          {
	System .out.println(e);
           }
      }

     public static String limitString(String input,int n)
     {
	if(input.length()<=n)
	        return input;
	else
	      return input.substring(0,n);
    }   
}
class details
{
         String name,age,gen,pre,aa;
         public void read(String n,String o,String p,String q)
         {
	name=n;
	age=o;
	gen=p;	
	pre=q;
       }
        public void display()
       {
			System.out.format("%7s  %7s %8s %8s  ",name,age,gen,pre);
			System.out.println();
			
     }
}