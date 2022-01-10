package Holiday_Planner;

import java.util.Scanner;

class Tour_Package{
    int price;
    String Package_name;
    String [] Destinations;
    int days, capacity,booked_seats=0;
    Tour_Package same;
    Bookings bookthistour = new Bookings();
    Scanner sc=new Scanner(System.in);
    Tour_Package(String name, String dest[], int amt,int numdays,int cap){
        this.Destinations = dest;
        this.Package_name =name;
        this.price = amt;
        this.days = numdays;
        this.capacity = cap;
        same = null;
    }

 /* public void setDetails(){
      System.out.println("Name of the Package:");
      this.Package_name=sc.nextLine();
      System.out.println("Number of destinations covered: ");
      int num_dest = sc.nextInt();
      sc.nextLine();
      this.Destinations=new String[num_dest];
      int i=0;
      System.out.println("Enter destinations");
      for (i=0;i<num_dest;i++) {
          Destinations[i] = sc.nextLine();
      }
      System.out.println("Enter Price: ");
     this.price=sc.nextInt();
      System.out.println("Enter days: ");
      this.days=sc.nextInt();
      System.out.println("Enter number of travellers");
      this.capacity=sc.nextInt();

  }*/
        void book() {
            System.out.print("\tEnter your name:");
            String customer_name = sc.next();
            customer_name += sc.nextLine();
            System.out.print("\tEnter number of seats to book:");
            int seats=sc.nextInt();
            if (booked_seats + seats <= capacity) {
                System.out.print("\tTo confirm booking press 1");
                int yes = sc.nextInt();
                if (yes==1) {
                    bookthistour.insert(customer_name, seats);
                    this.booked_seats = booked_seats + seats;
                    System.out.println("\tThank you for choosing us as your travel partner!");
                }
            }
            else {
                System.out.println("\tSorry seats are full!");
            }

        }
        void displaybookings() {
            if (booked_seats != 0) {
                bookthistour.display();
            }
            else {
                System.out.println("\tNo bookings for this tour!");
            }
        }

    }



