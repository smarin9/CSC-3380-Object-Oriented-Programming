/********************************************/
/*    Groovy Music End-of-Year Inventory    */
/*	     Sean Marino                    */
/* 	 CSC 3380_60 Section 1              */
/*            Assignment 1                  */
/*          Instructor: Douglas   	    */
/* Program due date:  February 2, 2016      */    
/********************************************/
/*
PROBLEM SPECIFICATION: Program displays the current inventory for Groovy Music, 
then displays the items that are to be deleted for the End of Year Inventory.
PROBLEM ANALYSIS: The program requires an input file which contains ID, Category Number,
Year, Quantity, Price, Artist, and Title. The program should then output the inserted inventory, items to be deleted,
and the final inventory after the items are deleted.
IMPLEMENTATION DIRECTIONS: Users will be required to type in the cut off year in order for the program to compile.
*/
package dvd;
public class DVD 
{    
    private static DVD[] dvds = new DVD[20];
    public int identification, categoryNumber, year, inventory;
    public double price, inventoryValue;
    public String artist, DVDTitle, category;
    
    /**
     * Compiles the data required for the inventory
     */
    public DVD()
    {
        identification = 0;
        categoryNumber = 0;
        year = 0;
        inventory = 0;
        price = 0.0;
        artist = "";
        DVDTitle = "";
        category = "";
    }
    /**
     * Constructor
     * @param identification
     * @param categoryNumber
     * @param year 
     */
    public DVD(int identification, int categoryNumber, int year)
    {
        this.categoryNumber = categoryNumber;
        categorize();
        this.identification = identification;
        this.year = year;
        inventory = 0;
        price = 0.0;
        artist = "";
        DVDTitle = "";
    }
    /**
     * Categorizes the four music genres which Groovy Music contains
     */
    private void categorize() 
    {
        switch(categoryNumber) 
        {
            case 1:
                category = "Blues";
                break;
            case 2: 
                category = "Classical";
                break;
            case 3:
                category = "Country";
                break;
            case 4:
                category = "Folk";
                break;
            default:
                System.out.println("error");
                break;
        }       
    }
    
    public void delete(Double price, int count)
    {
        this.price = price;
        this.inventory = count;
        inventoryValue = price * inventory;
    }
    
    @Override
    public String toString() 
    {
        return ("\nID:" + identification + "\n" + DVDTitle + " by "+ artist + "\n" + "Genre: " + category + "\n" + "Year: " + year +  "\n");
    }
}
