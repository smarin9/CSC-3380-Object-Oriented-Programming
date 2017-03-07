/********************************************/
/*    Mon Cher Bourtique Coupon Discount    */
/*	     Sean Marino                    */
/* 	 CSC 3380_60 Section 1              */
/*            Assignment 2                  */
/*          Instructor: Douglas   	    */
/* Program due date:  February 18, 2016     */    
/********************************************/
/*
PROBLEM SPECIFICATION: The Mon Cher Boutique utilizes a coupon discount scheme as a business strategy.
Customers who spend between $200 and $500 receive a 25% discount. 
Customers who spend between $500 and $750 receive a 30% discount. 
Customers who spend between $750 and $1000 receive a 35% discount.
Customers who spend more than $1,000 or more receive a 40% discount.
The program is going to organize and report the customers based on their purchase amount and
grant them their discount.
PROBLEM ANALYSIS: The program will input a list which includes the name of the customer,
their address, their telephone number, whether or not they are on the mailing list, their email address,
and the amount of money spent. The program will then read the data in the input and automatically create a report
output file in the program folder. 
IMPLEMENTATION DIRECTIONS: The program will require an insert method which reads and scans the input file line by line.
A method will be included to determine whether or not the customer is on the mailing list. Another important method required 
is an efficient sorting method (Selection Sort used here) to sort the customer data. The final method required is a print method to print the data into an output.
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Assignment2 
{
    private static Assignment2 customers[] = new Assignment2[20];
    private String name; 
    private String address;
    private long phoneNumber;
    private boolean mailingList;
    private String email;
    private double moneySpent;
    
    /**
     * Constructor
     * @param name - The name of the customer
     * @param address - The address of the customer
     * @param phoneNumber - The phone number of the customer
     * @param mailingList - The mailing list determinant
     * @param email - The email address of the customer
     * @param moneySpent - The amount of money spent by the customer
     */
    public Assignment2(String name, String address, long phoneNumber, boolean mailingList, String email, double moneySpent)
    {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.mailingList = mailingList;
        this.email = email;
        this.moneySpent = moneySpent;
    }
    
     /**
     * This method determines whether the customer is on the mailing list or not.
     * @param trueOrFalse
     * @return 
     */
    public static boolean mailingListFlag(int trueOrFalse)
    {
        if (trueOrFalse == 1)
            return(true);
        return(false);
    }
    
    /**
     * This method will scan the input file line by line and collect the data.
     * @param in 
     * @throws FileNotFoundException Thrown when the input file is incorrect
     */
    public static void insert(String in) throws FileNotFoundException
    {
        try
        {  
        int i = 0;
        Scanner scan = new Scanner(new File(in));
        while(scan.hasNextLine())
        {
            String name = scan.nextLine();
            String address = scan.nextLine();
            long phoneNumber = scan.nextLong();
            int trueOrFalse = scan.nextInt();
            boolean mailingList = mailingListFlag(trueOrFalse);
            String email = scan.next();
            double moneySpent = scan.nextDouble();
            scan.nextLine();
            customers[i++] = new Assignment2(name, address, phoneNumber, mailingList, email, moneySpent);
        }
                } catch (FileNotFoundException ex){
                 Logger.getLogger(Assignment2.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
    /**
     * An efficient sorting method - Selection Sort
     */
    public static void selectionSort()
    {
        for (int i = 0; i < customers.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < customers.length; j++)
                if (customers[j] != null && customers[index] != null)
                    if (customers[j].moneySpent > customers[index].moneySpent)
                        index = j;
            
            Assignment2 temp = customers[index];
            customers[index] = customers[i];
            customers[i] = temp;
        }
    }
    
    /**
     * This method determines the discount by the amount purchased by the customer.
     * @param customer
     * @return 
     */
    public static int customerdiscount(Assignment2 customer)
    {
        if(customer.moneySpent < 200)
            return(0);
        if(customer.moneySpent < 500)
            return(25);
        if(customer.moneySpent < 750)
            return(30);
        if(customer.moneySpent < 1000)
            return(35);
        return(40);
    }
    
    /**
     * This method goes through the array and calls for a print statement for each piece of data
     * @param out 
     */
    public static void printCustomers(PrintWriter out)
    {
        out.println("Mon Cher Boutique\n");
        out.println("Discounted Customers\n");
        for (int i =0; i < customers.length; i++)
            if (customers[i] != null)
                printData(customers[i], out);
        out.close();
    }
    
    /**
     * This method prints the data.
     * @param customer
     * @param out 
     */
    public static void printData(Assignment2 customer, PrintWriter out)
    {
        out.println("Name: " + customer.name);
        out.println("Address: " + customer.address);
        out.println("Phone Number: " + customer.phoneNumber);
        out.println("Mailing List: " + customer.mailingList + "Email: " + customer.email);
        out.println("Money Spent: " + customer.moneySpent);
        out.println("Discount Receieved: " + customerdiscount(customer) + "%");
    }
    
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name of the input file: ");
        String file = scan.nextLine();
        System.out.println();
        try
        {
            PrintWriter out = new PrintWriter(new File("Report.out"));
            insert(file);
            selectionSort();
            printCustomers(out);
        }
        catch(FileNotFoundException ex)
        {
            Logger.getLogger(Assignment2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
