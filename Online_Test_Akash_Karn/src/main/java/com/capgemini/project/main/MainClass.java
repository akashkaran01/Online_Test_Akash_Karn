package com.capgemini.project.main;

import java.util.Scanner;


import com.capgemini.project.services.AdminServices;
import com.capgemini.project.services.UserServices;

public class MainClass {

	public static void main(String[] args) {
		
		//ONE TIME 
		/*
		 * AdminServices.serialize1();
		 *  UserServices.UserSerialize1();
		 */
		
		//UserServices.UserSerialize1();
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("For Login");
		System.out.println("Press 1 - Admin");
		System.out.println("Press 2 - User");
		System.out.println("Press 3 - Exit");
		int admin_or_user = sc.nextInt();
		sc.nextLine();
		
		if(admin_or_user == 1)
		{
			AdminServices.login(sc);
		}else if(admin_or_user == 2){
			UserServices.login(sc);
		}else if(admin_or_user == 3) {
			System.out.println("Thankyou for visiting. Visit us again.");
			System.exit(0);
		}else {
			System.out.println("Invalid Input. System Shutdown");
			System.exit(0);
		}

		 
		
	}
}
