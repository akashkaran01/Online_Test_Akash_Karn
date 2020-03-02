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

import com.capgemini.project.dto.Test;
import com.capgemini.project.services.AdminServices;
import com.capgemini.project.dto.Questions;

public class AdminServices {
	
	//static LinkedHashMap<Integer, Test> alltests = new LinkedHashMap<Integer, Test>();

	public static void serialize1()
	{
		String filename = "C:\\Users\\akash\\Desktop\\Project\\Online_Test_Akash_Karn\\allTests.txt";
		LinkedHashMap<Integer, Test> alltests = new LinkedHashMap<Integer, Test>();

		try
        {    
            //Saving of object in a file 
            FileOutputStream files = new FileOutputStream(filename); 
            ObjectOutputStream outs = new ObjectOutputStream(files); 
              
            // Method for serialization of object  
            outs.writeObject(alltests);
            
            outs.close(); 
            files.close(); 
              
            //System.out.println("ALLTESTS have been Serialized"); 
  
        }
        catch(IOException ex) 
        { 
            System.out.println("ALLTESTS cant be SERIALIZED."); 
        } 
	}
	
	
	public static void serialize(LinkedHashMap<Integer, Test> alltests)
	{
		String filename = "C:\\Users\\akash\\Desktop\\Project\\Online_Test_Akash_Karn\\allTests.txt";

		try
        {    
            //Saving of object in a file 
            FileOutputStream files = new FileOutputStream(filename); 
            ObjectOutputStream outs = new ObjectOutputStream(files); 
              
            // Method for serialization of object  
            outs.writeObject(alltests);
            
            outs.close(); 
            files.close(); 
              
            //System.out.println("ALLTESTS have been Serialized"); 
  
        }
        catch(IOException ex) 
        { 
            System.out.println("ALLTESTS cant be SERIALIZED."); 
        } 
	}
	
	public static LinkedHashMap<Integer, Test> deserialize()
	{
		String filename = "C:\\Users\\akash\\Desktop\\Project\\Online_Test_Akash_Karn\\allTests.txt";
        LinkedHashMap<Integer, Test> alltests = new LinkedHashMap<Integer, Test>();

		
		 try
	        {    
	            //Saving of object in a file 
	            FileInputStream file = new FileInputStream(filename); 
	            ObjectInputStream out = new ObjectInputStream(file); 
	              
	            // Method for serialization of object 
	            alltests= (LinkedHashMap) out.readObject();
	            
	            file.close();
	            out.close();

	            
	            //System.out.println("ALLTESTS have been DeSerialized");    
	            
	        }catch(Exception ex) 
	        { 
	            System.out.println("ALLTESTS cant be SERIALIZED"); 
	        }		
		 return alltests;
	}
	
	public static void admintasks(Scanner sc)
	{
		
		System.out.println("Select the task you want to do -:");
		System.out.println("Press 1 - ADD TEST");
		System.out.println("Press 2 - DELETE TEST");
		System.out.println("Press 3 - ADD QUESTION");
		System.out.println("Press 4 - DELETE QUESTION");
		System.out.println("Press 5 - EXIT/LOGOUT");
		
		int admin_choice=sc.nextInt();
		sc.nextLine();
		
		switch(admin_choice)
		{
			case 1:AdminServices.addTest(sc);
					break;
			case 2:AdminServices.deleteTest(sc);
					break;
			case 3:AdminServices.addQuestion(sc);
					break;
			case 4:AdminServices.deleteQuestion(sc);
					break;
			case 5: System.exit(0);
					break;
			default : System.out.println("Invalid input. System Shutdown");
					System.exit(0);
					break;
		}
	}

	public static void login(Scanner sc)
	{
		
		System.out.println("Enter userid : ");
		String userid = sc.nextLine();
		userid = userid.trim();
		
		if(userid.equals("admin"))
		{
			System.out.println("Enter password : ");
			String password = sc.nextLine();
			password = password.trim();
			
			if(password.equals("admin"))
			{
				System.out.println("ADMIN LOGIN SUCCESSFULL !");
				AdminServices.admintasks(sc);
			}
			else
			{
				System.out.println("Oops.. Wrong password!!");
				System.out.println(" Press 1 - Try again");
				System.out.println(" Press 2 - Exit.");
				int again_entry = sc.nextInt();
				sc.nextLine();
				if(again_entry == 1)
				{
					AdminServices.login(sc);
				}else if(again_entry == 2)
				{
					System.exit(0);
				}else {
					System.out.println("Sorry.. Invalid entry. Exiting!");
					System.exit(0);
				}
			}
		}else {
			System.out.println("Invalid admin id .");
			System.out.println(" Press 1 - Try again");
			System.out.println(" Press 2 - Exit.");
			int again_entry = sc.nextInt();
			sc.nextLine();
			if(again_entry == 1)
			{
				AdminServices.login(sc);
			}else if(again_entry == 2)
			{
				System.exit(0);
			}else {
				System.out.println("Sorry.. Invalid entry. Exiting!");
				System.exit(0);
			}
		}
		
	}
	
	public static void addTest(Scanner sc) 
	{
		System.out.println("Enter test id : ");
		int test_id = sc.nextInt();
		sc.nextLine();
		LinkedHashMap<Integer, Test> alltests = new LinkedHashMap<Integer, Test>();
		
		alltests = deserialize();
		
		if(alltests.containsKey(test_id))
		{
			System.out.println("Test with "+test_id+" is already present. Test can't be added.");
		}else {
			Test test = new Test(test_id);
			alltests.put(test_id, test);
			System.out.println("Test with "+test_id+" added successfully.");
			serialize(alltests);
		}
		
		System.out.println("Do you want to add Questions");
		String s = sc.nextLine();
		  s = s.trim();
		
		  if(s.equalsIgnoreCase("Yes"))
		  {		
			  AdminServices.addQuestioninTest(sc, test_id);
		  }else {
			  System.out.println("Thankyou for visiting. System ShutDown");
			  System.exit(0);
		  }
		  
		  admintasks(sc);
		
	}
	
	public static void addQuestioninTest(Scanner sc, int testid)
	{
		System.out.println("How many question do you wanna add?");
		int x = sc.nextInt();
		sc.nextLine();
		
		LinkedHashMap<Integer, Test> alltests = new LinkedHashMap<Integer, Test>();
		alltests = deserialize();
		
		
		List<Questions> queslist = new ArrayList<Questions>();
		
		for(int i=0; i<x; i++)
		{
			System.out.println("Enter question id : ");
			int quesid = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter question : ");
			String ques = sc.nextLine();
			
			List<String> qOptions = new ArrayList<String>();
			System.out.println("Enter options : ");
			for(int j=0; j<4; j++)
			{
				qOptions.add(sc.nextLine());
			}
			
			System.out.println("Enter its answer : ");
			int ans = sc.nextInt();
			sc.nextLine();
			
			Questions q = new Questions(quesid, ques, qOptions, ans);
			queslist.add(q);
			System.out.println("Question is added successfully.");
		}			
		
		alltests.get(testid).setTestQuestions(queslist);
		serialize(alltests);
		
		admintasks(sc);
		
	}
	
	public static void deleteTest(Scanner sc) 
	{
		System.out.println("Enter test id : ");
		int test_id = sc.nextInt();
		sc.nextLine();
		LinkedHashMap<Integer, Test> alltests = new LinkedHashMap<Integer, Test>();
		
		alltests = deserialize();
		
		if(alltests.containsKey(test_id))
		{
			alltests.remove(test_id);
			System.out.println("Test with "+test_id+" is deleted successfully.");
			serialize(alltests);
		}else {
			System.out.println("No Test with "+test_id+" found. Test can't be deleted.");
		}
		
		admintasks(sc);
	}
	
	
	
	public static void addQuestion(Scanner sc)
	{
		System.out.println("Enter testid where you want to add this question : ");
		int testid = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter question id : ");
		int quesid = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter question : ");
		String ques = sc.nextLine();
		
		List<String> qOptions = new ArrayList<String>();
		System.out.println("Enter options : ");
		for(int i=0; i<4; i++)
		{
			qOptions.add(sc.nextLine());
		}
		
		System.out.println("Enter its answer : ");
		int ans = sc.nextInt();
		sc.nextLine();
		
		Questions q = new Questions(quesid, ques, qOptions, ans);
		List<Questions> queslist = new ArrayList<Questions>();
		queslist.add(q);
		
		
		LinkedHashMap<Integer, Test> alltests = new LinkedHashMap<Integer, Test>();
		alltests = deserialize();
		
		Test obj;
		obj = alltests.get(testid);
		obj.setTestQuestions(queslist);
		
		serialize(alltests);
		
		System.out.println("Question is added successfully.");
		
		admintasks(sc);
		
	}
	
	public static void deleteQuestion(Scanner sc)
	{
		LinkedHashMap<Integer, Test> alltests = new LinkedHashMap<Integer, Test>();
		alltests = deserialize();
		System.out.println("List of tests are given below : ");
		System.out.println(alltests.keySet());
		
		System.out.println("Enter test id : ");
		int testid = sc.nextInt();
		sc.nextLine();
		
		
		System.out.println("Enter question id you want to delete : ");
		int quesid = sc.nextInt();
		sc.nextLine();
		
		//Testing TEST has question or not
		/*
		 * List<Questions> qq; qq = alltests.get(101).getTestQuestions(); for(Questions
		 * q : qq) { System.out.println(q.getQuestionTitle()); }
		 */
		
		int flag = 0;
		
		
		List<Questions> objj;
		objj = alltests.get(testid).getTestQuestions();
		//System.out.println(objj);
		for(int j=0; j<objj.size(); j++)
		{
			Questions q;
			q = objj.get(j);
			//System.out.println(q);

			if(q.getQuestionid() == quesid)
			{
				objj.remove(j);
				//alltests.get(testid).setTestQuestions(objj);
				flag = 1;
				System.out.println("Question removed successfully.");
				break;
			}
		}		
		if(flag == 0)
		{
			System.out.println("Question not found");
		}
		serialize(alltests);
		
		admintasks(sc);
		
	}
}
