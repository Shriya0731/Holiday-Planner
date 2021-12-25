import java.util.*;
	
public class Holiday_Planner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
        Travel_Company Marvel = new Travel_Company();
        int choice,exit=0;
		do {
	    	 System.out.println("\n---MENU---\n1.Add Package \n2.Search\n3.Book a tour\n4.display\n5.Delete\n6.Exit"); 
	    	 choice=sc.nextInt();
	    	 switch(choice) {
	    	 case 1:
	    		 System.out.println("Name of Package:");
	    		 sc.nextLine();
	    		 String name = sc.nextLine();
	    		 System.out.println("Number of destinations covered: ");
	    		 int num_dest = sc.nextInt();
	    		 sc.nextLine();
	    		 String dest [] = new String[num_dest];
	    		 int i=0;
	    		 for (i=0;i<num_dest;i++) {
	    			 dest[i] = sc.nextLine();
	    		 }
	    		 System.out.println("Enter Price: ");
	    		 int mrp = sc.nextInt();
	    		 System.out.println("Enter days: ");
	    		 int days = sc.nextInt();
	    		 System.out.println("Capacity : ");
	    		 int size = sc.nextInt();
	    		 Tour_Package t = new Tour_Package(name,dest,mrp,days,size);
	    		 Marvel.create_days(t);
	    		 break;
	    	 case 2:
	    		 System.out.println("Enter days :"); 
	    	   	 int num = sc.nextInt();
	    		 Marvel.searchByDays(num);
	    		 break;
	    	 
	    	 case 3:
	    		 System.out.println("Enter tour package name to book :");
	    		 sc.nextLine();
	    		 String place = sc.nextLine();
	    		 Marvel.book_my_tour(place);
	    		 break;
	    	 case 4:
	    		 System.out.println("Enter tour package name to see bookings :");
	    		 sc.nextLine();
	    		 String see_bookings = sc.nextLine();
	    		 Marvel.display_bookings(see_bookings);
	    		 break;
	    	 case 5:
	    		 System.out.println("Enter Name of Package:");
	    		 sc.nextLine();
	    		 String name1 = sc.nextLine();
	    		 System.out.println("DAYS:");
	    		 int delete_days = sc.nextInt();
	    		  Marvel.delete(name1,delete_days);
	    		  break;
	    	 case 6:	
	    		 
	             exit=1;
	             break;
	             
	    		 
	    	 }
	     }while(exit==0);
        
	}

}
