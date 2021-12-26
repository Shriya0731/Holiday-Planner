import java.util.Scanner;

public class Holiday_Planner {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner (System.in);
        int choice,ch,exit=0;
        Travel_Company Marvel = new Travel_Company();
        do{
            System.out.println("\t@@@@@@@ WELCOME @@@@@@@");
            System.out.println("\t\n=========================");
            System.out.println("\t1)Company Employee\n2)Customer\n3)Exit");
            System.out.println("\t=========================");
            System.out.println("\tWho are you?");
                     ch=sc.nextInt();
            switch(ch){
                case 1:
                    do {
                        System.out.println("\t\n---MENU---\n\t1)Add new tour Package\n\t2)Display bookings" +
                                "\n\t3)Delete any tour package\n\t4)Exit");
                        System.out.println("\tEnter your choice:");
                        choice=sc.nextInt();
                        switch(choice) {
                            case 1:
                                System.out.println("Name of Package:");
                                sc.nextLine();
                                String name = sc.nextLine();
                                System.out.println("Number of destinations covered: ");
                                int num_dest = sc.nextInt();
                                sc.nextLine();
                                String dest [] = new String[num_dest];
                                int i=0;
                                for (i=0;i<num_dest;i++) {
                                    System.out.println("● Destination:"+(i+1));
                                    dest[i] = sc.nextLine();
                                }
                                System.out.println("Enter Price: ");
                                int mrp = sc.nextInt();
                                System.out.println("Enter days: ");
                                int days = sc.nextInt();
                                System.out.println("Capacity : ");
                                int size = sc.nextInt();
                                Tour_Package t = new Tour_Package(name,dest,mrp,days,size);
                                Marvel.create_price(t);
                                Marvel.create_days(t);
                                break;
                            case 2:
                                System.out.println("Enter Name of Package:");
                                sc.nextLine();
                                String name1 = sc.nextLine();
                                Marvel.display_bookings(name1);

                                break;
                            case 3:
                                System.out.println("Enter Name of Package:");
                                sc.nextLine();
                                String nm = sc.nextLine();
                                System.out.println("DAYS:");
                                int delete_days = sc.nextInt();
                                System.out.println("price");
                                int delete_price = sc.nextInt();
                                Marvel.delete(Marvel.root1,nm,delete_days,delete_price);
                                Marvel.delete(Marvel.root,nm,delete_days,delete_price);
                                break;
                        }
                    }while(choice!=4);
                    break;

                case 2:
                    int ch1;
                    do{
                        System.out.println("\n==========================");
                        System.out.println("\n---MENU---\n1)Find the best travel package in your budget\n2)Find the suitable package according to number of days\n3)Book the Tour\n4)Exit");
                        System.out.println("\n==========================");
                        ch1=sc.nextInt();
                        switch (ch1){
                            case 1:
                                System.out.println("Enter your budget:");
                                int budget=sc.nextInt();
                                Marvel.searchByPrice(budget);
                                break;
                            case 2:
                                System.out.println("Enter number of days:");
                                int d=sc.nextInt();
                                Marvel.searchByDays(d);
                                break;
                            case 3:
                                sc.nextLine();
                                System.out.println("Enter the package name:");
                                String pkg=sc.nextLine();
                                Marvel.book_my_tour(pkg);

                                break;
                            default:
                                System.out.println("********** Thank you **********");
                                break;
                        }
                    }while (ch1!=4);

                    break;
            }

        }while(ch!=3);

    }
        }
