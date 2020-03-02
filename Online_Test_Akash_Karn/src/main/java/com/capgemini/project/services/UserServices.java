package com.capgemini.project.services;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

import com.capgemini.project.dto.Questions;
import com.capgemini.project.dto.Test;
import com.capgemini.project.dto.User;

public class UserServices {

	public static void UserSerialize1()
	{
		String filename = "C:\\Users\\akash\\Desktop\\Project\\Online_Test_Akash_Karn\\allUser.txt";
		//List<User> alluser = new ArrayList<User>();
		LinkedHashMap<Integer, String> alluser= new LinkedHashMap<Integer, String>();
		
		try
        {    
            //Saving of object in a file 
            FileOutputStream files = new FileOutputStream(filename); 
            ObjectOutputStream outs = new ObjectOutputStream(files); 
            

            // Method for serialization of object  
            outs.writeObject(alluser);
            
            outs.close(); 
            files.close(); 
              
            //System.out.println("ALLUSERS have been Serialized"); 
  
        }
        catch(IOException ex) 
        { 
            System.out.println("ALLUSERS cant be SERIALIZED."); 
        } 
		
	}
	
	public static void UserSerialize(LinkedHashMap<Integer, String> alluser)
	{
		String filename = "C:\\Users\\akash\\Desktop\\Project\\Online_Test_Akash_Karn\\allUser.txt";

		
		try
        {    
            //Saving of object in a file 
            FileOutputStream files = new FileOutputStream(filename); 
            ObjectOutputStream outs = new ObjectOutputStream(files); 
              
            // Method for serialization of object  
            outs.writeObject(alluser);
            
            outs.close(); 
            files.close(); 
              
            //System.out.println("ALLUSERS have been Serialized"); 
  
        }
        catch(IOException ex) 
        { 
            System.out.println("ALLUSERS cant be SERIALIZED."); 
        } 
		
	}
	
	public static LinkedHashMap<Integer, String> Userdeserialize()
	{
		String filename = "C:\\Users\\akash\\Desktop\\Project\\Online_Test_Akash_Karn\\allUser.txt";
        LinkedHashMap<Integer, String> alluser = new LinkedHashMap<Integer, String>();

		
		 try
	        {    
	            //Saving of object in a file 
	            FileInputStream file = new FileInputStream(filename); 
	            ObjectInputStream out = new ObjectInputStream(file); 
	              
	            // Method for serialization of object 
	            alluser = (LinkedHashMap<Integer, String>) out.readObject();
	            //System.out.println("ALLUSERS have been DeSerialized");  
	            file.close();
	            out.close();
	            
	        }catch(Exception ex) 
	        { 
	            System.out.println("ALLUSERS cant be SERIALIZED"); 
	        }		
		 return alluser;
	}
	
	public static void login(Scanner sc)
	{
		System.out.println("For New Users(Press N) for Existing users (Press E)");
		String s = sc.nextLine();
		
        LinkedHashMap<Integer, String> alluser = new LinkedHashMap<Integer, String>();
		alluser = Userdeserialize();
		System.out.println(alluser);

		if(s.equalsIgnoreCase("N"))
		{			
			System.out.println("Enter userid : ");
			int userid = sc.nextInt();
			sc.nextLine();
			
			if(alluser.containsKey(userid))
			{
				System.out.println("User id already exists.");
				System.out.println("Do you want to login into this id");
				String duplicate_userid = sc.nextLine();
				
				if(duplicate_userid.equalsIgnoreCase("Yes"))
				{
					System.out.println("Enter password : ");
					String password = sc.nextLine();
					
					if(alluser.get(userid).equals(password))
					{
						System.out.println("Login Successfull."); 
						System.out.println("Do you want to give test?(Yes/No)");
						String str = sc.nextLine();
						str = str.trim();
						if(str.equalsIgnoreCase("Yes"))
						{
							UserServices.giveTest(sc);
						}else {
							System.out.println("Thankyou for visiting. System ShutDown");
							System.exit(0);
						}
					}else
					{
						System.out.println("Oops.. Wrong password!!");
						System.out.println(" Press 1 - Try again");
						System.out.println(" Press 2 - Exit.");
						int again_entry = sc.nextInt();
						sc.nextLine();
						if(again_entry == 1)
						{
							login(sc);
						}else if(again_entry == 2)
						{
							System.exit(0);
						}else {
							System.out.println("Sorry.. Invalid entry. Exiting!");
							System.exit(0);
						}
					}
				}else
				{
					System.out.println("Thankyou for visiting. System Shutdown.");
					System.exit(0);
				}
			}else
			{
				System.out.println("Create password");
				String password=sc.nextLine();
				password = password.trim();

				alluser.put(userid,password);
				System.out.println(alluser);
				UserServices.UserSerialize(alluser);

				System.out.println("Do you want to give test?(Yes/No)");
				String ss = sc.nextLine();
				ss = ss.trim();

				LinkedHashMap<Integer, Test> alltests = new LinkedHashMap<Integer, Test>();

				alltests = AdminServices.deserialize();
				System.out.println(alltests);

		        
				if(ss.equalsIgnoreCase("Yes"))
				{
					UserServices.giveTest(sc);
				}else {
					System.out.println("Thankyou for visiting. System ShutDown");
					System.exit(0);
				}
			}
				
		}
		else if(s.equalsIgnoreCase("E"))
		{
			UserServices.login1(sc);
		}else {
			System.out.println("Invalid option. System shutdown.");
			System.exit(0);
		}
	}
	
	public static void login1(Scanner sc)
	{
		System.out.println("Enter userid : ");
		int userid = sc.nextInt();
		sc.nextLine();

        LinkedHashMap<Integer, String> alluser = new LinkedHashMap<Integer, String>();
        alluser = Userdeserialize();
        
        System.out.println(alluser);
        
        if(alluser.containsKey(userid))
        {
        	  System.out.println("Enter your password");
			  String password=sc.nextLine();
			  //password = password.trim();
			  
			  if(alluser.get(userid).equals(password))
			  {
				  System.out.println("Login Successfull."); 
				  System.out.println("Do you want to give test?(Yes/No)");
				  String s = sc.nextLine();
				  s = s.trim();
				  if(s.equalsIgnoreCase("Yes"))
				  {
					  UserServices.giveTest(sc);
				  }else {
					  System.out.println("Thankyou for visiting. System ShutDown");
					  System.exit(0);
				  }
			  }else {
				  System.out.println("Oops.. Wrong password!!");
					System.out.println(" Press 1 - Try again");
					System.out.println(" Press 2 - Exit.");
					int again_entry = sc.nextInt();
					sc.nextLine();

					if(again_entry == 1)
					{
						login(sc);
					}else if(again_entry == 2)
					{
						System.exit(0);
					}else {
						System.out.println("Sorry.. Invalid entry. Exiting!");
						System.exit(0);
					}
			  }
        }else {
        	System.out.println("No such user id exists.");
        	System.out.println(" Press 1 - Try again");
			System.out.println(" Press 2 - Exit.");
			int again_entry = sc.nextInt();
			sc.nextLine();

			if(again_entry == 1)
			{
				login(sc);
			}else if(again_entry == 2)
			{
				System.exit(0);
			}else {
				System.out.println("Sorry.. Invalid entry. Exiting!");
				System.exit(0);
			}
        }
	}

	public static void giveTest(Scanner sc)
	{
		LinkedHashMap<Integer, Test> alltests = new LinkedHashMap<Integer, Test>();
		alltests = AdminServices.deserialize();

		System.out.println(alltests);
		System.out.println("Enter the test id which you want to give : ");
		int testid = sc.nextInt();
		sc.nextLine();

		int totalmarks = 0;
		
		Test obj;
		obj = alltests.get(testid);
		
		List<Questions> ques;
		ques = obj.getTestQuestions();
		
		int totalquestions = ques.size();
		
		for(int i=0; i<totalquestions; i++)
		{
			Questions q = ques.get(i);
			System.out.println(q.getQuestionid()+"->"+q.getQuestionTitle());
			System.out.println(q.getQuestionOptions());
			System.out.println("Enter answer(1/2/3/4)");
			int ans = sc.nextInt();
			sc.nextLine();

			q.setChosenAnswer(ans);
			
			if(q.getQuestionAnswer() == q.getChosenAnswer())
			{
				totalmarks++;
			}
			
		}
		
		System.out.println(" Marks obtained : "+totalmarks+" out of "+totalquestions);
	}
	
}
