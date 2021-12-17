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
		if (root==null) {
			root = new_tour;
			Category new_cat = new Category(new_tour);
			root = new_cat;
		}
		else {
			ptr=root;
			while (ptr!=null) {
				if (ptr.price > new_tour.price) {
				if (ptr.new_package.price > new_tour.price) {
					if (ptr.low==null) {
						ptr.low = new_tour;
						Category new_cat = new Category(new_tour);
						//System.out.println("Added "+new_tour.Package_name+" to the left of "+ptr.new_package.Package_name);
						ptr.low = new_cat;
						break;
					}
					else {
						ptr=ptr.low;
					}
				}
				else if (ptr.new_package.price==new_tour.price) { // if more than one tour packages have same number of days
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
						ptr.high=new_tour;
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
	
	
	void searchByPrice(int searchPrice) { 
		Scanner sc = new Scanner(System.in);
		//To search based on number of day
		
		ptr = root;
			if (ptr == null) {
				System.out.println("Package you are looking for is not available.......\nPlease try out other package!");
			}

			while (ptr != null) {
				if (ptr.new_package.price == 0) {
					System.out.println("Package Not Available For This Input........ ");
				} else if (searchPrice<ptr.new_package.price ) {
					display(ptr)
					ptr = ptr.low;
				} 
				else if(searchPrice == ptr.new_package.price) {
					display(ptr);
					break;
				}
				else
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
