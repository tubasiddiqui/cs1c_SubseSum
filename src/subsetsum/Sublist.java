/**
 * Tuba Siddiqui
 * CS1C
 * Sublist.java
 * This class takes an arraylist of double values and their indices to find the closest sum of sublists to the budget.
 * Outline provided by modules
 */


package subsetsum;

import java.util.ArrayList;

class Sublist implements Cloneable
{
    private double sum = 0;
    private ArrayList<Double> originalObjects;
    private ArrayList<Integer> indices;

    // constructor creates an empty Sublist (no indices)
    public Sublist(ArrayList<Double> orig)
    {
        sum = 0;
        originalObjects = orig;
        indices = new ArrayList<Integer>();
    }

    double getSum()
    { return sum; }

    // I have done the clone() for you, since you will need clone() inside addItem().
    public Object clone() throws CloneNotSupportedException
    {
        // shallow copy
        Sublist newObject = (Sublist)super.clone();
        // deep copy
        newObject.indices = (ArrayList<Integer>)indices.clone();

        return newObject;
    }

    Sublist addItem( int indexOfItemToAdd) throws CloneNotSupportedException {
        Sublist tempSublist = (Sublist) clone();

        tempSublist.indices.add(indexOfItemToAdd);
        tempSublist.sum += originalObjects.get(indexOfItemToAdd);

        return tempSublist;
    }

    void showSublist()
    {
        for (int k = 0 ; k < indices.size() ; k++)
            System.out.println("  array[" + indices.get(k) + "] = "
                    + originalObjects.get(indices.get(k)));
    }

    // returns SubSet to SubsetSum class
    public ArrayList<Double> getSubSet()
    {
        ArrayList<Double> tempSubSet = new ArrayList<Double>();
        for (int k = 0 ; k < indices.size() ; k++)
        {
            tempSubSet.add(originalObjects.get(indices.get(k)));
        }

        return tempSubSet;
    }

};
