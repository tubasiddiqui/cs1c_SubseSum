/**
 *Tuba Siddiqui
 * CS1C
 * This file reads a CSV and adds the numeric values to an array list
 */

package subsetsum;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class GroceriesFileReader {

    //declare readFile method to read CSV file
    public ArrayList<Double> readFile(String filePath) {

        //declare arraylist for each of the prices
        ArrayList<Double> priceArray = new ArrayList<Double>();

        //try/catch block with initialized Scanner
        try {
            Scanner inputStream = new Scanner(new File(filePath));
            //gets data while there is still values
            while (inputStream.hasNext()) {
                //gets entire line
                String data = inputStream.next();
                //split string into an array of string
                String[] values = data.split(",");
                //convert String to a double, only get values at index 1
                double price = Double.parseDouble(values[1]);
                priceArray.add(price); // add price to the arraylist
            }

            //close Scanner
            inputStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("No grocery list has been detected.");
        }

        return priceArray;
    }
}

