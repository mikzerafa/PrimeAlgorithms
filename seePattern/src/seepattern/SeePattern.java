package seepattern;

import java.util.ArrayList;

public class SeePattern {
    public static void main(String[] args) {
        
        ArrayList<Integer> squares = new ArrayList();
        
         for(int index = 1; index < 100; index++)
         {
             squares.add(index * index);
             newTest(squares);
         }
    }
    
    public static void newTest(ArrayList<Integer> squares)
    {
        int tester = squares.size()- 1;
        
        for(int index = 0; index < squares.size(); index++)
        {
            int result = squares.get(tester) - squares.get(index);
            
            if(factorise(result))
            {
                System.out.print("SquareA:\t" + squares.get(tester) + "(" +tester + "^2)\t");
                System.out.print("SquareB:\t" + squares.get(index) + "(" + index + "^2)\t");
                System.out.println("RESULT:\t " + result );
            }
            
        }
    }
    
    public static boolean factorise(int result) //lets ignore the whole 1 and itself ghax its like that for all of them hassle.
    {
        String factors  = ""; // to display data if we have 2. // maybe later ill display the data even without 2.
        int numOfFactors = 0;
        Boolean isWhatImLookingFor = false;
        
        for(int index = 2; index <= Math.sqrt(result); index++)
        {
            if(result % index == 0)
            {
                numOfFactors++;
                factors = factors + index + "\t";
            }
        }
        
        if(numOfFactors == 2)
        {
            System.out.print("FACTORS:\t" + factors + "\t");
            isWhatImLookingFor = true;
        }
        
        return isWhatImLookingFor;
    }
}
