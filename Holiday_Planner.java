package assignment1;
import java.util.*;


class Tour_Package{
	int price;
	String Package_name;
	String [] Destinations;
	int days, capacity;
	Tour_Package low , high;
	
}
class Travel_Company{   //Binary search Tree
	Tour_Package root,ptr,root1; //root1 for bst based on number of days and root for bst based on price
	int bydays,byprice;  // 
	
	void create_price(Tour_Package new_tour) {
        	if(root==null){
           	 root=new_tour;
       		}else{
            		Tour_Package ptr=root;
            		while(ptr!=null){
                	if (ptr.price>new_tour.price){
                    		if (ptr.low==null){
                        		ptr.low=new_tour;
                        		break;
                    		}
				else{
                       		 ptr=ptr.low;
                   	 	}
                	}
			else{
                    		if (ptr.high == null) {
                        		ptr.high = new_tour;
                        		break;
                   		} else {
                        		ptr = ptr.high;
                    			}
               		}
               		}
       		}

    }
	}
	void create_days(Tour_Package new_tour) {
		if (root1==null) {
			root1 = new_tour;
		}
		else {
			ptr=root1;
			while (ptr!=null) {
				if (ptr.days > new_tour.days) {
					if (ptr.low==null) {
						ptr.low = new_tour;
						break;
					}
					else {
						ptr=ptr.low;
					}
				}
				else {
					if(ptr.high==null) {
						ptr.high=new_tour;
						break;
					}
					else {
						ptr=ptr.high;
					}
				}
			}
		}
	}
	void searchByPrice(int searchPrice) {
		
	}
	
	
	void searchByDays(int searchDays) { 
		Scanner sc = new Scanner(System.in);
		//To search based on number of day
		ptr = root;	
		if (ptr == null) {
				System.out.println("Package you are looking for is not available.......\nPlease try out other package!");
			}
			
			while (ptr != null) {
				if (ptr.days == 0) {
					System.out.println("Package Not Available For This Input........ ");
					
				} else if (searchDays<ptr.days ) {
					ptr = ptr.low;
				}
				else if(searchDays == ptr.days) {
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
   
        void searchByplace(Tour_Package curr, String desire_loc) {
		if(curr.low!=null) {
			searchByplace(curr.low,desire_loc);
		}
		if (is_destination(curr,desire_loc )) {
			display(curr);
		}
		
		if(curr.high!=null) {
			searchByplace(curr.high,desire_loc);
		}
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
