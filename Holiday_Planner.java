import java.util.*;


class Tour_Package{
	int price;
	String Package_name;
	String [] Destinations;
	int days, capacity;
	Tour_Package same;
	
}
class Category{ //node for BST
	//Category for tour packages having same feature(number of days or price)
	Tour_Package new_package;
	Category low , high; //left right links
	Category(Tour_Package tour){
		this.new_package = tour;
		this.new_package.same = null;
		low = high = null;
	}
}
class Travel_Company{   //Binary search Tree
	Category root; // root for BST based on price
	Category root1; //root for BST based on number of days
	Category ptr;
	void create_price() {
		
	}
	
	void searchByPrice(int searchPrice) {
		
	}
	void create_days(Tour_Package new_tour) {
		if (root1==null) {
			Category new_cat = new Category(new_tour);
			root1 = new_cat;
		}
		else {
			ptr=root1;
			while (ptr!=null) {
				if (ptr.new_package.days > new_tour.days) {
					if (ptr.low==null) {
						Category new_cat = new Category(new_tour);
						//System.out.println("Added "+new_tour.Package_name+" to the left of "+ptr.new_package.Package_name);
						ptr.low = new_cat;
						break;
					}
					else {
						ptr=ptr.low;
					}
				}
				else if (ptr.new_package.days==new_tour.days) { // if more than one tour packages have same number of days
					Tour_Package curr = ptr.new_package;
					while(curr.same!= null) {
						curr = curr.same;
					}
					curr.same = new_tour;
					//System.out.println("Added "+new_tour.Package_name+" to the same link of "+curr.Package_name);
					break;
				}
				else {
					if(ptr.high==null) {
						Category new_cat = new Category(new_tour);
						//System.out.println("Added "+new_tour.Package_name+" to the right of "+ptr.new_package.Package_name);
						ptr.high=new_cat;
						break;
					}
					else {
						ptr=ptr.high;
					}
				}
			}
		}
	}
	
	void searchByDays(int searchDays) { 
		Scanner sc = new Scanner(System.in);
		//To search based on number of day
		ptr = root1;
			if (ptr == null) {
				System.out.println("Package you are looking for is not available.......\nPlease try out other package!");
			}
			
			while (ptr != null) {
				if (ptr.new_package.days == 0) {
					System.out.println("Package Not Available For This Input........ ");
					
				} else if (searchDays<ptr.new_package.days ) {
					ptr = ptr.low;
				} 
				else if(searchDays == ptr.new_package.days) {
					display(ptr);
					break;
				}
				else
					ptr = ptr.high;

			}
				
			
		}
		
	 boolean is_destination(Tour_Package current,  String location) {
	   int i =0;
	   for (i=0;i<current.Destinations.length;i++) {
		   if (current.Destinations[i].equals(location))
			   return true;
			   
	   }
	   return false;
           } 
   
       
	void display() 
	{ // To display contents of one tourpackage
		 // To display contents of one tourpackage
		Tour_Package ptr = current.new_package;
		while (ptr!=null) 
		{
			System.out.println("Package : "+ptr.Package_name);
			System.out.println("Price: "+ptr.price);
			int i=0;
			for (i=0;i<ptr.Destinations.length;i++) {
				System.out.println(" "+ptr.Destinations[i]);
			}
			ptr = ptr.same;
		}	
	}
}
public class Holiday_Planner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner (System.in);
        Travel_Company Marvel = new Travel_Company();
        int choice,exit=0;
		do {
	    	 System.out.println("\n---MENU---\n1.Add Package \n2.Search\n3.Search By Place\n4.display\n5.Exit"); 
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
	    		 Tour_Package t = new Tour_Package(name,dest,mrp,days);
	    		 Marvel.create_days(t);
	    		 break;
	    	 case 2:
	    		 System.out.println("Enter days :"); 
	    	   	 int num = sc.nextInt();
	    		 Marvel.searchByDays(num);
	    		 break;
	    	 case 5:
	             exit=1;
	             break;
	    	 }
	     }while(exit==0);
	}

}
