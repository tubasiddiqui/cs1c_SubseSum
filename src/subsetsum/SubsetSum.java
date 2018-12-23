/**
 * Tuba Siddiqui
 * CS1C
 * This file shows the algorithm implemented in main() that will find the sublist with the largest
 * sum according to the user defined budget
 * The abstraction for this file was provided in the modules
 */

package subsetsum;
import java.util.*;

public class SubsetSum {
    private static ArrayList<Sublist> Col = new ArrayList<Sublist>();
    private static ArrayList<Double> subset;

    //find subarray with maximum sum that is <= budget
    public static ArrayList<Double>
    findSubset(ArrayList<Double> shoppingList, double budget)
    {
        //Initialize collection
        Sublist newSublist = new Sublist(shoppingList);
        Col.add(newSublist);

        //Loop over all elements x in S
        for(int i = 0; i < shoppingList.size(); i++)
        {
            //Loop over all subsets that are already members of Col
            for (int j = 0; j < Col.size() - j; j++)
            {
                newSublist = Col.get(j);
                double k = newSublist.getSum() + shoppingList.get(i);
                if(k <= budget)    //if sublist is <= budget, add the sublist to Col
                {
                    try
                    {
                        Col.add(newSublist.addItem(i));   //add sublist to Col

                    } catch (CloneNotSupportedException e)
                    {
                        e.printStackTrace();
                    }
                }
                //if sublist == target budget, then break from both loops
                else if(newSublist.getSum() + shoppingList.get(i) == budget)
                    break; //break from loops
            }
        }

        //find sublist with the largest sum()
        double largestSum = Col.get(0).getSum();
        int largestIndex = 0;

        for (int i = 0; i < Col.size(); i++ )
        {
            double currentValue = Col.get(i).getSum();
            if (currentValue > largestSum)
            {
                largestSum = currentValue;
                largestIndex = i;
            }
        }

        subset = Col.get(largestIndex).getSubSet();

        return subset;   //return subset that shows the highest value within the budget
    }

}