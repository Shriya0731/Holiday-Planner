package assignment1;
import java.util.*;


class Tour_Package{
	int price;
	String [] Destinations;
	int days, capacity;
	Tour_Package low , high;
	
}
class Travel_Company{   //Binary search Tree
	Tour_Package root,ptr;
	
	int bydays,byprice;  // 
	void create_price() {
		
	}
	void create_days() {
		
	}
	void searchByPrice(int searchPrice) {
		
	}
	
	
	void searchByDays(int searchDays) { 
		Scanner sc = new Scanner(System.in);
		//To search based on number of days
			Tour_Package node = new Tour_Package();
			System.out.print("● ENTER NUMBER OF DAYS: ");
			node.days = sc.nextInt();
			if (ptr == null) {
				System.out.println("Package you are looking for is not available.......\nPlease try out other package!");
			}
			ptr = root;
			while (ptr != null) {
				if (ptr.days == 0) {
					System.out.println("Package Not Available For This Input........ ");
					
				} else if (searchDays<ptr.days ) {
					ptr = ptr.low;
				} else
					ptr = ptr.high;

			}
			display();
				
			
		}
		
	
	void display() { // To display contents of one tourpackage
		
	}
}
public class Holiday_Planner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Travel_Company Marvel = new Travel_Company();
        
	}

}
