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
import java.util.Scanner;
import java.util.LinkedList;
import java.io.*;
public class DVDADT 
{
    private static DVD[] dvds = new DVD[20];
    private static final LinkedList<DVD> list = new LinkedList<>();
    private static int cutoffDate = 0;
    
    /**
     * This method creates the required inventory from the text file.
     */

    private static void addDVD(Scanner in)
    {
        while (in.hasNextLine())
        {
            int count = 0;
            DVD dvd = new DVD();
            while (count < 4)
            {
                String line = in.nextLine();
                String info[] = line.split("\\s+");
                if (count == 0)
                {
                    dvd = new DVD(Integer.parseInt(info[0]), Integer.parseInt(info[1]), Integer.parseInt(info[2]));
                }
                else if (count == 1)
                {
                    dvd.delete(Double.parseDouble(info[0]), Integer.parseInt(info[1]));
                }
                else if (count == 2)
                {
                    dvd.artist = line;
                }
                else if (count == 3)
                {
                    dvd.DVDTitle = line;
                }
                count++;
            }
            if (list.size() == 0)
            {
                list.add(dvd);
            }
            else
            {
                boolean added = false;
                for (int i = 0; i < list.size(); i++)
                {
                    if (list.get(i).identification > dvd.identification)
                    {
                        list.add(i, dvd);
                        added = true;
                        break;
                    }
                }
                if (added == false)
                {
                    list.addLast(dvd);
                }
            }
        }
    }
    
    /**
     * This method deletes the music files which come on or before the cutoff date.
     * @return deleted music inventory
     */
    private static LinkedList<DVD> deleteDVDs()
    {
        LinkedList<DVD> deleted = new LinkedList<>();
        list.stream().filter((cd) -> (cd.year < cutoffDate)).forEach((cd) -> {
            deleted.add(cd);
        });
        deleted.stream().forEach((cd) -> {
            list.remove(cd);
        });
        return deleted;
    }
    /**
     * Main Method - Displays the required output
     * @param args
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("                        GROOVY MUSIC INC                            ");
        System.out.println("This program will delete all albums up to the specified cutoff year ");
        System.out.println();
        System.out.println("Please enter the cutoff year: ");
        cutoffDate = scan.nextInt();
        File input = new File("input.txt");
        Scanner scan2 = new Scanner(input);
        addDVD(scan2);
        System.out.println();
        System.out.println("GROOVY MUSIC CURRENT INVENTORY: ");
        list.stream().forEach((dvd) -> 
        {
            System.out.printf("%s", dvd.toString());
        });
        LinkedList<DVD> deleted = deleteDVDs();
        System.out.println();
        System.out.println("INVENTORY ITEMS BEING DELETED: ");
        deleted.stream().forEach((cd) ->
        {
            System.out.printf("%s", cd.toString());
        });
        System.out.println();
        System.out.println("GROOVY MUSIC INVENTORY AFTER DELETION: ");
        list.stream().forEach((cd) -> 
        {
            System.out.printf("%s", cd.toString());
        });
    }
}
