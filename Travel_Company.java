package Holiday_Planner;

import java.util.Scanner;
public class Travel_Company{
    Category root;
    Category root1;
    Category ptr,parent;
    int bydays,byprice,full =0,namefound=0;  //
    Category inorder[]= new Category[20];
    int i=0;
    int display = 1;
  void create_price(Tour_Package new_tour) {
        if (root==null) {
            Category new_cat = new Category(new_tour);
            root = new_cat;
        }
        else {
            ptr=root;
            while (ptr!=null) {
                if (ptr.new_package.price > new_tour.price) {
                    if (ptr.low==null) {
                        Category new_cat = new Category(new_tour);
                 //    System.out.println("Added "+new_tour.Package_name+" to the left of "+ptr.new_package.Package_name);
                        ptr.low = new_cat;
                        break;
                    }
                    else {
                        ptr=ptr.low;
                    }
                }
                else if (ptr.new_package.price==new_tour.price) {
                    Tour_Package curr = ptr.new_package;
                    while(curr.same!= null) {
                        curr = curr.same;
                    }
                    new_tour.same = null;
                    curr.same = new_tour;
               //    System.out.println("Added "+new_tour.Package_name+" to the same link of "+curr.Package_name);
                    break;
                }
                else {
                    if(ptr.high==null) {
                        Category new_cat = new Category(new_tour);
              //          System.out.println("Added "+new_tour.Package_name+" to the right of "+ptr.new_package.Package_name);
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
                 //      System.out.println("Added "+new_tour.Package_name+" to the left of "+ptr.new_package.Package_name);
                        ptr.low = new_cat;
                        break;
                    }
                    else {
                        ptr=ptr.low;
                    }
                }
                else if (ptr.new_package.days==new_tour.days) {
                    Tour_Package curr = ptr.new_package;
                    while(curr.same!= null) {
                        curr = curr.same;
                    }
                    new_tour.same = null;
                    curr.same = new_tour;
                  // System.out.println("Added "+new_tour.Package_name+" to the same link of "+ptr.new_package.Package_name);
                    break;
                }
                else {
                    if(ptr.high==null) {
                        Category new_cat = new Category(new_tour);
                     //   System.out.println("Added "+new_tour.Package_name+" to the right of "+ptr.new_package.Package_name);
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
    Category searchByDays(int searchDays) {
        Scanner sc = new Scanner(System.in);
        //To search based on number of day
        int flag=0;
        Category ptr = root1;
        if (ptr == null) {
            System.out.println("\tPackage you are looking for is not available.......\n\tPlease try out other package!");
        }

        while (ptr != null) {
            if (ptr.new_package.days == 0) {
                System.out.println("\tPackage Not Available For This Input........ ");

            } else if (searchDays<ptr.new_package.days ) {
                parent = ptr;
                ptr = ptr.low;
            }
            else if(searchDays == ptr.new_package.days) {
            	if(display == 1) {
            	 display(ptr);
            	}
               
                flag=1;
                return ptr;
            }
            else {
                parent = ptr;
                ptr = ptr.high;
            }


        }
        if(flag == 0) {
        	if(display == 1) {
      		  System.out.println("\tPackage you are looking for is not available........!");
                System.out.println("\tPlease explore our best tour packges");
      	}
        }
        return null;


    }
    Category searchByPrice(int searchPrice) {
        Scanner sc = new Scanner(System.in);
        int flag=0;
        //To search based on number of day
        Category ptr = root;
        if (ptr == null) {
            System.out.println("\tPackage you are looking for is not available.......\n\tPlease try out other package!");
        }

        while (ptr != null) {
            if (ptr.new_package.price == 0) {
                System.out.println("\tPackage Not Available For This Input........ ");

            } else if (searchPrice<ptr.new_package.price ) {
                parent = ptr;
                ptr = ptr.low;
            }
            else if(searchPrice == ptr.new_package.price) {
            	if(display == 1) { 
                     display(ptr);        
            	}
            	flag=1;
                  return ptr;
            }    
            else if(searchPrice > ptr.new_package.price){
                parent = ptr;
                ptr = ptr.high;
            }


        }
        if(flag == 0) {
        	if(display == 1) {
        		  System.out.println("\tPackage you are looking for is not available........!");
                  System.out.println("\tPlease explore our best tour packges");
        	}
        	
        }
        
        return null;


    }
    void display_bookings(String package_name_bookings) {
        Tour_Package existing_package = this.search_by_name( package_name_bookings);
        if (existing_package!=null) {
            existing_package.displaybookings();
        }
        else {
        	System.out.println("\tSorry! Couldn't Find the Package! ");
        }
    }
    void display(Category current) { // To display contents of one tourpackage
        Tour_Package ptr = current.new_package;
        while (ptr!=null) {
        	 System.out.println("\t-------------------- Tour Package Details -----------------------");
            System.out.println("\tPackage : "+ptr.Package_name);
            System.out.println("\tPrice : "+ptr.price);
            int i=0;
            System.out.println("\tDestinations Covered :    ");
            for (i=0;i<ptr.Destinations.length;i++) {
                System.out.println("\t "+ptr.Destinations[i]);
            }
            
            ptr = ptr.same;
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
    boolean is_tour(Tour_Package current,  String tour) {
        int i =0;
        if (current.Package_name.equals(tour)) {
            return true;
        }
        return false;
    }
    Tour_Package search_by_name(String pkgname) {
        inorder(root1);
        int j = 0;
        while(inorder[j]!=null && j< inorder.length) {
            Tour_Package ptr =inorder[j].new_package;
            while(ptr!= null) {
                //System.out.println("ptr name :"+ptr.Package_name);
                if (is_tour(ptr,pkgname )) {
                    namefound =1;
                    //System.out.println("found");
                    return ptr;

                }
                ptr = ptr.same;
            }
            j=j+1;
        }
        return null;
    }

    void book_my_tour( String name_package) {
        Tour_Package book_tour = search_by_name(name_package);
        if (book_tour!=null) {
            book_tour.book();
        }
        else {
            System.out.println("\n\tThe tour package you are looking for is not available!");
        }

    }
    boolean isleaf(Category ptr) {
        if ((ptr.low==null)&&(ptr.high==null)) {
            return true;
        }
        else {
            return false;
        }
    }
    boolean hasonlyleftchild(Category ptr){
        if ((ptr.low!=null)&&(ptr.high==null)) {
            return true;
        }
        else {
            return false;
        }
    }
    boolean hasonlyrightchild(Category ptr){
        if ((ptr.low==null)&&(ptr.high!=null)) {
            return true;
        }
        else {
            return false;
        }
    }
    Category inordersuccessor(Category ptr) {
        int j=0;
        for(j=0;j<=i;j++) {
            if (ptr==inorder[j]) {
                break;
            }
        }
        return inorder[j+1];
    }
    void inorder(Category current) {
        if((current!=null)&&(current.low!=null)) {
            inorder(current.low);
        }
        if(i < inorder.length) {
        	 inorder[i]=current;
             i=i+1;
        }

        if((current!=null)&&(current.high!=null)) {
            inorder(current.high);
        }
    }
    void delete(Category rt,String delete_pkg , int del_days,int del_price) {
        Category ptr1;
        Category found;
        if(rt==root1){
        	display = 0;
            found = searchByDays(del_days);
            display = 1;
        }else{
        	display = 0;
            found = searchByPrice(del_price);
            display = 1;
        }

        if (found != null) {
            if (!found.new_package.Package_name.equals(delete_pkg)) {
                Tour_Package temp = found.new_package;
                Tour_Package prev = null;
                while (temp!=null) {
                    if (is_tour(temp,delete_pkg)) {
                        break;
                    }
                    prev = temp;
                    temp = temp.same;
                }
                prev.same = temp.same;
             
            }
            // if full category is to be deleted
            else if ((found.new_package.Package_name.equals(delete_pkg))&&((full==1)||(found.new_package.same==null))){
                ptr1=found;
               
                if(isleaf(ptr1)) {
                    if (ptr1 == rt) {
                        rt = null;
                        System.out.println("\tNo packages available !");
                    }
                    else if(ptr1==parent.low) {
                        parent.low=null;
                      
                    }
                    else {
                        parent.high=null;
                     
                    }
                }
                else if(hasonlyleftchild(ptr1)) {
                	
                    if (ptr1 == rt) {
                    	if(rt == root1) {
                   		 root1 = ptr1.low;
                   	}
                    	else {
                    		root = ptr1.low;
                    	}
                       
                      
                        System.out.println(root1.new_package.Package_name);
                    }
                    else if(ptr1==parent.low) {
                        parent.low=ptr1.low;
                     
                    }
                    else {
                        parent.high=ptr1.low;
                   
                    }
                }
                else if(hasonlyrightchild(ptr1)) {
                    if (ptr1 == rt) {
                        rt = ptr1.high;
                    }
                    else if(ptr1==parent.low) {
                        parent.low=ptr.high;
                       
                    }
                    else {
                        parent.high=ptr1.high;
                    
                    }
                }
                else {
                    i=0;
                    
                    inorder(rt);
                   
                    Category successor = this.inordersuccessor(ptr1);
                    Category copy = successor;
                    String pkgname = successor.new_package.Package_name;
                    int succ_days = successor.new_package.days;
                    int succ_price=successor.new_package.price;
                    full = 1 ;
                    delete(rt,pkgname,succ_days,succ_price);
                    full = 0;
                    ptr1.new_package= copy.new_package;
              
                }
            }
            // if the first package in the found category is not desired package
            else if (found.new_package.Package_name.equals(delete_pkg)&&(found.new_package.same != null)){
                found.new_package = found.new_package.same;
             
            }

        }
        else {
            System.out.println("\tSorry, Tour Package Not Found!");
        }
    }
}
