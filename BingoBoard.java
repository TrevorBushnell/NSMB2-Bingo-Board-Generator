/*
* Insert fancy comment here
*/
import java.util.*;
import java.io.*;
import java.lang.Math;
import java.lang.reflect.Array;

public class BingoBoard
{
    //Declare private instance variables
    private int[] randomSeeds;
    private ArrayList<String> allGoals;
    private ArrayList<String> gameGoals;
    
    //Constructor
    public BingoBoard() throws FileNotFoundException
    {
        randomSeeds = new int[25];
        allGoals = new ArrayList<String>();
        gameGoals = new ArrayList<String>();


        randomSeeds = generateSeeds(randomSeeds);
        allGoals = readInGoals(allGoals);
    }


    //Getter functions

    public int[] getSeeds()
    {
        return randomSeeds;
    }

    public ArrayList<String> getGoals()
    {
        return gameGoals;
    }
    
    
    /*
    * PARAMETER: A boolean array representing whether a random number has been selected
    * 
    * POST: Returns an integer array containing the seeds for the goals to be used for the bingo
    */
    

    public void printSeeds(int[] seeds)
    {
        for (int i = 0; i < seeds.length; i++)
        {
            System.out.print(seeds[i] + " ");
        }
    }



    //A standard selection sort algorthim used to sort the randomly generated seeds in numerical order

    public static int[] selectionSort(int[] arr)
    {

        for (int j = 0; j < arr.length - 1; j++)
        {

            int index = j;

            for (int k = j + 1; k < arr.length; k++)
            {

                if (arr[k] < arr[index])
                {
                    index = k;
                }
            }


            int temp = arr[j];
            arr[j] = arr[index];
            arr[index] = temp;
        }

        return arr;
    }


    // A method that puts every single goal into an ArrayList of Strings
    public ArrayList<String> readInGoals(ArrayList<String> goals) throws FileNotFoundException
    {
        Scanner in = new Scanner(new File("nsmb2_goals.txt"));

        while (in.hasNextLine())
        {
            goals.add(in.nextLine());
        }
        
        return goals;
    }
    

    // A method that randomly generates 25 unique seeds, puts them into an array, and returns the array
    public int[] generateSeeds(int[] seeds)
    {

        boolean[] hasBeenUsed = new boolean[132];
        
        for (int i = 0; i < 25; i++)
        {
            int x = (int)(Math.random() * (94)) + 1;
            
            if (hasBeenUsed[x] == true)
            {
                i--;
            }

            else
            {
                seeds[i] = x;
                hasBeenUsed[x] = true;
            }
        }

        int[] to_return = selectionSort(seeds);
        return to_return;
    }


    // Method that takes in the random seeds in an array and creates/returns an ArrayList of goals
    public void addGoalsToStorage() throws FileNotFoundException
    {
        for (int i = 0; i < randomSeeds.length; i++)
        {
            gameGoals.add(allGoals.get(randomSeeds[i] - 1));
        }

        generateBingoCard(gameGoals);
    }



    /*
    * PARAMETER: An ArrayList of Strings containing all of the goals 
    *
    * POST: Generates a random bingo card for Any%. This means that the card that
    * is generated is a card with goals necesarry to complete before beating the
    * game.
    */
    public void generateBingoCard(ArrayList<String> goals) throws FileNotFoundException
    {
        PrintStream out = new PrintStream(new File("BINGOCARD.txt"));

        out.println("[");

        for (int i = 0; i < goals.size(); i++)
        {
            if (i == goals.size() - 1)
            {
                out.println("{\"name\": \"" + goals.get(i) + "\"}");
            }

            else
            {
                out.println("{\"name\": \"" + goals.get(i) + "\"},");
            }
        }

        out.println("]");
    }

}
