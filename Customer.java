package Holiday_Planner;

import java.util.Scanner;
class Customer{
    Scanner sc = new Scanner(System.in);
    String name;
    int seats;
    Customer next;
    Customer(String cust_name,int seat_booked){
        name = cust_name;
        seats = seat_booked;
        next=null;
    }

}

