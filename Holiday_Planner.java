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
	void create_days() {
		
	}

	void searchByPrice(int searchPrice) {
        Scanner sc = new Scanner(System.in);
        //To search based on Price
        ptr = root;
        if (ptr == null) {
            System.out.println("Package you are looking for is not available.......\nPlease try out other package!");
        }

        while (ptr != null) {
            if (ptr.price == 0) {
                System.out.println("Package Not Available For This Input........ ");

            } else if (searchPrice < ptr.price) {
                ptr = ptr.low;
            } else if (searchPrice == ptr.price) {
                display(ptr);
                break;
            } else
                ptr = ptr.high;

        }
    }
	
	
	void searchByDays(int searchDays) { 
		Scanner sc = new Scanner(System.in);
		//To search based on number of day
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
				
			
		}
		
	
	 void display(Tour_Package temp) { // To display contents of one tourpackage
        	System.out.println("-----Package Details-----");
        	System.out.println("Package name:"+temp.Destinations);
        	System.out.println("price"+temp.price);
        	System.out.println("Number of days:"+temp.days);
        	System.out.println("--------------------------");
    }
}
public class Holiday_Planner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Travel_Company Marvel = new Travel_Company();
        
	}

}
