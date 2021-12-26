import java.util.Scanner;

public class Tour_Package {
		Scanner sc = new Scanner(System.in);
		int price;
		String Package_name;
		String [] Destinations;
		int days, capacity,booked_seats=0;
		Tour_Package same;
		Bookings bookthistour = new Bookings();
		Tour_Package(String name, String dest[], int amt,int numdays,int cap){
			this.Destinations = dest;
			this.Package_name =name;
			this.price = amt;
			this.days = numdays;
			this.capacity = cap;
			same = null;
		}
		void book() {
			System.out.println("Enter your name:");
			String customer_name = sc.next();
			customer_name += sc.nextLine();
			System.out.println("Enter number of seats to book:");
			int seats=sc.nextInt();
			if (booked_seats + seats <= capacity) {
				System.out.println("To confirm booking press 1");
				int yes = sc.nextInt();
				if (yes==1) {
					bookthistour.insert(customer_name, seats);
					this.booked_seats = booked_seats + seats;
					System.out.println("Thank you for choosing us as your travel partner!");
				}	
			}
			else {
				System.out.println("Sorry seats are full!");
			}
			
		}
		void displaybookings() {
			if (booked_seats != 0) {
				bookthistour.display();
			}
			else {
				System.out.println("No bookings for this tour!");
			}
		}
		
	}


