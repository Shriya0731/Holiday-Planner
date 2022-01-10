package Holiday_Planner;

import java.util.*;

import java.util.Scanner;

public class Holiday_Planner {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner (System.in);
        int choice,ch,exit=0;
        Travel_Company Marvel = new Travel_Company();
        String destination1[] = {"Cherrapunjee","Guwahati","Kaziranga","Mawlynnong","Shillong"};
        Tour_Package T1 = new Tour_Package("Assam Meghalaya", destination1, 55000, 8, 40);
        Marvel.create_price(T1);
        Marvel.create_days(T1);
        
        String destination2[] = {"Shimla","Chandhigarh","Manali"};
        Tour_Package T2 = new Tour_Package("Shimla Manali", destination2, 30000, 6, 45);
        Marvel.create_price(T2);
        Marvel.create_days(T2);
        
        String destination3[] = {"Calangute"};
        Tour_Package T3 = new Tour_Package("Goa Kyriad Prestige Calangute", destination3, 19500, 4, 40);
        Marvel.create_price(T3);
        Marvel.create_days(T3);
        
        
        do{
            System.out.println("\t@@@@@@@@@@@@@@@@@@@@@@@ WELCOME TO MARVEL TOURS @@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println();
            System.out.println("\t                Building a legacy of redefining travel !       ");
            System.out.println();
            System.out.println("\t========================================================================");
            System.out.println("\t Please Select The Appropriate Choice");
            System.out.println("\t1)Company Employee\n\t2)Customer\n\t3)Exit");
            System.out.println("\t========================================================================");
           
                     ch=sc.nextInt();
            switch(ch){
                case 1:
                    do {
                        System.out.println("\t------------------------MENU---------------------------------\n\t1)Add new tour Package\n\t2)Display bookings" +
                                "\n\t3)Delete any tour package\n\t4)Exit");
                        System.out.print("\tEnter your choice:");
                        choice=sc.nextInt();
                        switch(choice) {
                            case 1:
                                System.out.print("\tName of Package: ");
                                sc.nextLine();
                                String name = sc.nextLine();
                                System.out.print("\tNumber of destinations covered: ");
                                int num_dest = sc.nextInt();
                                sc.nextLine();
                                String dest [] = new String[num_dest];
                                int i=0;
                                for (i=0;i<num_dest;i++) {
                                    System.out.print("\t● Destination "+(i+1) + ": ");
                                    dest[i] = sc.nextLine();
                                }
                                System.out.print("\tEnter Price: ");
                                int mrp = sc.nextInt();
                                System.out.print("\tEnter days: ");
                                int days = sc.nextInt();
                                System.out.print("\tCapacity : ");
                                int size = sc.nextInt();
                                Tour_Package t = new Tour_Package(name,dest,mrp,days,size);
                                Marvel.create_price(t);
                                Marvel.create_days(t);
                                break;
                            case 2:
                                System.out.print("\tEnter Name of Package:");
                                sc.nextLine();
                                String name1 = sc.nextLine();
                                Marvel.display_bookings(name1);

                                break;
                            case 3:
                                System.out.print("\tEnter Name of Package:");
                                sc.nextLine();
                                String nm = sc.nextLine();
                                System.out.print("\tEnter the number of days:  ");
                                int delete_days = sc.nextInt();
                                System.out.print("\tEnter the price:  ");
                                int delete_price = sc.nextInt();
                                Marvel.delete(Marvel.root1,nm,delete_days,delete_price);
                                Marvel.delete(Marvel.root,nm,delete_days,delete_price);
                                System.out.println("\tTour Package Deleted Successfully!!!  ");
                                break;
                        }
                    }while(choice!=4);
                    break;

                case 2:
                    int ch1;
                    do{
                        System.out.println("\t========================================================================");
                        System.out.println("\t-----------------------------MENU---------------------------------------\n\t1)Find the best travel package in your budget\n\t2)Find the suitable package according to number of days\n\t3)Book the Tour\n\t4)Exit");
                        System.out.println("\t========================================================================");
                        ch1=sc.nextInt();
                        switch (ch1){
                            case 1:
                                System.out.print("\tFind your package by entering price :");
                                int budget=sc.nextInt();
                        System.out.println("\t****************** Package Of Your Choice ***************************");
                                Marvel.searchByPrice(budget);
                                break;
                            case 2:
                                System.out.print("\tEnter number of days:");
                                int d=sc.nextInt();
                                Marvel.searchByDays(d);
                                break;
                            case 3:
                                sc.nextLine();
                                System.out.print("\tEnter the package name:");
                                String pkg=sc.nextLine();
                                Marvel.book_my_tour(pkg);

                                break;
                            default:
                                System.out.println("\t************************* Thank you ********************");
                                break;
                        }
                    }while (ch1!=4);

                    break;
            }

        }while(ch!=3);

    }
        }
