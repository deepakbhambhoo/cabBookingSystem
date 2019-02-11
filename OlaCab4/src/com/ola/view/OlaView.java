package com.ola.view;

import com.ola.modal.Cab;
import com.ola.modal.User;
import com.ola.service.OlaService;

public class OlaView {

	public static void main(String[] args) throws InterruptedException {
		OlaService ola = new OlaService();
		User user =new User("Deepak","Deep@123",Long.parseLong("7015157647") ,"Gurgaon",Float.parseFloat ("100"));
		User user2 =new User("Deepak2","Deep@1234",Long.parseLong("7015157647") ,"Gurgaon",Float.parseFloat ("100"));
		Cab cab = new Cab("I 20" ,"HR 24 V 8650", "Hanuman", Long.parseLong("9782034812"), "Delhi", true);
		ola.registerCabDriver(cab);
		ola.registerUser(user);
		ola.registerUser(user2);
		Cab cabBooking = ola.cabBooking(user);
		Cab cabBooking2 = ola.cabBooking(user2);
		if(cabBooking!=null){
			System.out.println(cabBooking.getCabName());
			System.out.println(cabBooking.getCabNumber());
			System.out.println(cabBooking.getCity());
			System.out.println(cabBooking.getDriverName());
			System.out.println(cabBooking.getPhone());
		

		}else{System.out.println("No Cab Availble");}
		
		if(cabBooking2!=null){
			System.out.println(cabBooking2.getCabName());
			System.out.println(cabBooking2.getCabNumber());
			System.out.println(cabBooking2.getCity());
			System.out.println(cabBooking2.getDriverName());
			System.out.println(cabBooking2.getPhone());
		

		}else{System.out.println("No Cab Availble");}
		Thread.sleep(3000);
		 System.out.println(ola.cabCancel(cabBooking));
		  cabBooking2 = ola.cabBooking(user2);
		 if(cabBooking2!=null){
				System.out.println(cabBooking2.getCabName());
				System.out.println(cabBooking2.getCabNumber());
				System.out.println(cabBooking2.getCity());
				System.out.println(cabBooking2.getDriverName());
				System.out.println(cabBooking2.getPhone());
			

			}else{System.out.println("No Cab Availble");}
		 
	}

}
