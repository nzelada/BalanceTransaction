package NickZelada;

import java.util.*;
import java.io.*;

/**
 * This class opens and reads the file of the user and asking for the starting
 * balance and seeing if it matches with the expected amount.
 *
 * @author Nick Zelada
 * @version 02/28/19 I affirm that this program is entirely my own work and
 * other person's work is involved.
 */
public class BalanceTransactions {
/**
 * getFileName will ask for the file name and return it.
 * @return the file name
 */
    public static String getFileName() {
        String name; // the name of the file
        Scanner input = new Scanner(System.in); // new scanner

        System.out.print("Enter the name of the text file: "); // print line
        name = input.nextLine(); // whatever the user types goes to name

        return name; // the name is return
    }
/**
 * processFile will open and process the file to get the information and make
 * calculation for the right transaction and see if the balance equals to the
 * end balance.
 * @param fileName the file name from getFileName()
 * @throws FileNotFoundException 
 */
    public static void processFile(String fileName) throws FileNotFoundException 
    {
        Scanner file = new Scanner(new File(fileName)); //  new scanner for file
        double startBalance; // beginning balance
        double endBalance; // ending balance
        double cashAmount; // the amount of cash
        double balance; // overall balance
        String transactionType; // the type of transaction
        String invoiceNum; // invoice number

        Scanner input = new Scanner(System.in); // new scanner
        System.out.print("Enter the starting balance: \n"); // print line
        startBalance = input.nextDouble(); // input for starting balance

        System.out.print("Enter the ending balance: \n"); // print line
        endBalance = input.nextDouble(); // input for ending balance

        balance = startBalance; // start balance is the balance

        while (file.hasNext()) { // while loop for the file
            invoiceNum = file.next(); // reads the invoice from file
            cashAmount = file.nextDouble(); // reads the cash amount from file
            transactionType = file.next(); // reads the transaction type

            if (transactionType.equalsIgnoreCase("P")) { // if it is P
                balance = balance - cashAmount; //minus cash amount from balance
            } else if (transactionType.equalsIgnoreCase("R")) { // if its R
                balance = balance + cashAmount; //add balance with cash amount
            }
        }

        System.out.println("Ledger Balance: " + balance); // print the balance

        file.close(); // closes file

        if (balance == endBalance) { // if balance is equal to the end balance
            System.out.println("The amount equals to the expected amount.");
            // print line
        } else { // if not equal
            System.out.println("The amount doesn't equal, sorry\n");
            // print line
        }

    }
/**
 * This the main in which it would do a try and catch. If the file can't be 
 * read, it will ask again.
 * @param args
 * @throws FileNotFoundException 
 */
    public static void main(String[] args) throws FileNotFoundException {
        String name; // file name
        try { // try and catch for for the file

            name = getFileName();// calls the file name method
            processFile(name); //calls the process file method with a parameter
        } catch (Exception ex) { // if the file is read wrong, it ask again
            name = getFileName();// calls the file name method
            processFile(name);//calls the process file method with a parameter
        }
    }
}
