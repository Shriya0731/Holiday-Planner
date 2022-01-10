package Holiday_Planner;


public class Bookings{
    Customer head;
    void insert(String new_cust_name, int book_seats ) {
        Customer new_customer = new Customer(new_cust_name,book_seats);
        if (head==null) {
            head=new_customer;
        }
        else {
            Customer current = head;
            while(current.next!=null) {
                current =current.next;
            }
            current.next = new_customer;
        }

    }
    void display() {
        Customer current = head;
        if (head == null) {
            System.out.println("\tNo bookings.");
        }
        while(current!=null) {
            System.out.println("\n\t---Customer DETAILS---");
            System.out.println("\n\tName:"+current.name);
            System.out.println("\tSeats booked:"+current.seats);

            current =current.next;
        }
    }
}

