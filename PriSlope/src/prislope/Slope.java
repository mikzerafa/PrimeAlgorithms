package prislope;

import java.util.ArrayList;

public class Slope 
{
    private int biggestStack;
    private ArrayList <Stack> slope;
    private int counter;
    
    
    Slope()
    {
        biggestStack = 0;
        counter = 0;
        slope = new ArrayList();
    }
    
    //WHEN PRIMES ARE ADDED TO THE SLOPE GIVE THEM THE EXTRA DEFIcIT. so if i enter a stack of maxCounter
    
    public void testPrime(int prime)
    {
        Boolean isPrime = true;
        
        for(int index = 2 ;index < prime/2; index++)
        {
            if(prime % index == 0)
            {
                isPrime = false;
            }
        }
        
        if(isPrime)
        {
            System.out.println("SUCCESS : " + prime);
        }
        
        else
        {
            System.out.println("Failure : " + prime);
        }
    }
  
    
    public void addToSlope(Prime prime)
    {
        
        int index = pickStack(prime);
        
        //System.out.print("Stack: " + index + " Stack counter ");
        
        

        if(index+1 > slope.size())
        {
            do
            {
                createNewStack();
            }while(index + 1 > slope.size());
            slope.get(index).stack.add(prime);
           
        }
        
        else
        {
            int deficit = slope.get(index).getMaxCounter() - slope.get(index).getCounter();
            prime.setCounter(prime.getCounter() + deficit);
            slope.get(index).stack.add(prime);
        }
        
        //System.out.println(slope.get(index).getCounter() + "/" + slope.get(index).getMaxCounter());
  
    }
    
    public Boolean[] LookForPrimes()
    {
        Boolean one = true;
        Boolean three = true;
        Boolean seven = true;
        Boolean nine = true;
        Sequence sequence = new Sequence();
        
        ArrayList<Prime> save = new ArrayList();
        
        if(!slope.isEmpty())
        {
            slope.get(0).UpdateStack();
            for(int index = 0 ; index < slope.get(0).getStack().size(); index++)
            {
                slope.get(0).getStack().get(index).counterLess(1);
                if(slope.get(0).getStack().get(index).getCounter() > 0) // or maybe 1
                {
                    
                    addToSlope(slope.get(0).getStack().get(index));
                    slope.get(0).getStack().remove(index);
                }
            }
        
        

            for(int index = 0 ; index < slope.get(0).getStack().size(); index++)
            {
                int seq = slope.get(0).getStack().get(index).getSequence();
                int state = slope.get(0).getStack().get(index).getSequenceState();

                slope.get(0).getStack().get(index).updateSequenceState();
                slope.get(0).getStack().get(index).resetCounter();


                int digit = sequence.getDigit(seq, state);
                
                slope.get(0).getStack().get(index).printNum();
                System.out.println("Sequence: " +seq);
                System.out.println("State: " +state);
                System.out.println("digit: " +digit);
                System.out.println("Multiple of Num: " + counter + "" + digit);
                
                

                switch(digit)
                {
                    case 1:
                        one = false;
                        break;

                    case 3:
                        three = false;
                        break;

                    case 7:
                        seven = false;
                        break;

                    case 9:
                        nine = false;
                        break;
                }
            }

            for(int index = 0; index < slope.get(0).getStack().size(); index++)
            {
                save.add(slope.get(0).getStack().get(index));
            }

            slope.get(0).getStack().clear();

            for(int index = 0; index < save.size(); index++)
            {
                //System.out.println("adding back to slope");
                //save.get(index).print();
                addToSlope(save.get(index));
            }

            save.clear();
        }

        
        Boolean[] answer = new Boolean[] {one, three, seven, nine};
        
        return answer;
  
    }
    
    public void tick()
    {
        this.counter++;
        int test1 = 0;
        int test3 = 0;
        int test7 = 0;
        int test9 = 0;
        // We will check the first stack for Any primes
        System.out.println("before tick");
        printStacks();
        Boolean[] primes = LookForPrimes();
        System.out.println("1st row Moved");
        printStacks();
        
        if(slope.isEmpty())
        {
            System.out.println("firstStack");
            firstStack();
        }
        
        
        if(primes[0])
        {
            test1 = counter * 10 +1;
        }
        
        if(primes[1])
        {
            test3 = counter * 10 + 3;
        }
        
        if(primes[2])
        {
            test7 = counter *10 + 7;
        }
        
        if(primes[3])
        {
            test9 = counter * 10 + 9;
        }
        
        //We will Move the rest of the machine
        for(int index = 1; index < slope.size(); index++)  
        {
            System.out.print("Stack #" + index + "(" + slope.get(index).getStack().size()+ ") is at "  );
            slope.get(index).countDown();
            
            if(slope.get(index).getCounter() <= slope.get(index).getMaxCounter()/2)
            {
                System.out.println("Updating Stack #" + index);
                slope.get(index).UpdateStack();
                flushStack(index);
                slope.get(index).resetStack();
            }
        }
        
        //we will create the new primes and add them to the slope
        System.out.println("Moved the rest of the machine");
        printStacks();
        
  
        if(!multipleOfBase(test1) && test1 != 0)
        {
            testPrime(test1);
            Prime prime = new Prime(test1);
            addToSlope(prime);
        }
        if(!multipleOfBase(test3) && test3 != 0)
        {
            testPrime(test3);
            Prime prime = new Prime(test3);
            addToSlope(prime);
        }
        if(!multipleOfBase(test7) && test7 != 0)
        {
            testPrime(test7);
            Prime prime = new Prime(test7);
            addToSlope(prime);
        }
        if(!multipleOfBase(test9) && test9 != 0)
        {
            testPrime(test9);
            Prime prime = new Prime(test9);
            addToSlope(prime);
        }
        
        slope.get(0).resetStack();
        
        printStacks();
    }
    
    public void printStacks()
    {
        for(int index = 0; index < slope.size(); index++)
        {
            System.out.println("Stack #" + index + "(" + slope.get(index).stack.size() + ")" + "counter: " + slope.get(index).getCounter() + "/" + slope.get(index).getMaxCounter());
        }
    }
    
    public Boolean multipleOfBase(int num)
    {
        Boolean ans = false;
        
        if(num % 3 == 0 || num % 7 == 0 || num % 9 == 0)
        {
            ans = true;
        }
        
        return ans;
    }
    
    public void flushStack(int index1)
    {
        System.out.println("Flushing Stack #" + index1 + "(" + slope.get(index1).getStack().size() + ")");
        System.out.println("into Stack #" + (index1 - 1)+ "(" + slope.get(index1 - 1).getStack().size() + ")" );
        
        for(int index = 0; index < slope.get(index1).getStack().size(); index++)
        {
            slope.get(index1 - 1).getStack().add(slope.get(index1).getStack().get(index)); 
        }
        
        slope.get(index1).getStack().clear();
        
        System.out.println("Results : Stack #"+ index1 +"(" + slope.get(index1).getStack().size() + ")");
        System.out.println("Results : Stack #" + (index1 - 1)+ "(" + slope.get(index1 - 1).getStack().size() + ")" );
        
        
    }
    
    public int pickStack(Prime prime)
    {
        //This will return the index of the stack in the array slope based on the value of the prime number, ergo if we had 51, that has a max counter of 5, we want to place it in slope of max counter 4, so we find the square thats bigger -> 8 , devide it by 2, 4 and root it, 2 (this is the index of the array)
       // System.out.println("Picking a stack for prime:" + prime.getMaxCounter() + prime.getSequence());
       // System.out.println("Counter : " + prime.getCounter()+"/"+prime.getMaxCounter());;
        
        int squareNumber = 1;
        int result = 0;
        
        while(squareNumber < prime.getCounter())
        {
            squareNumber = squareNumber+squareNumber;
            result++;
        }
        
         
      //  System.out.println("Result: " + result);
        return result;
       
    }
    
    public void firstStack()
    {
        Stack stack = new Stack();
        stack.setCounter(1);
        stack.setMaxCounter(1);
        this.biggestStack = 1;
        slope.add(stack);
    }
    
    public void createNewStack()
    {
        System.out.println("creating a new stack " + (biggestStack + biggestStack));
        Stack stack = new Stack();
        stack.setCounter(biggestStack + biggestStack);
        
       // System.out.println("biggest Stack: " + biggestStack);
        stack.setMaxCounter(stack.getCounter());
        this.biggestStack = stack.getMaxCounter();
        slope.add(stack);
        
        System.out.println("NEW stack #"+ (slope.size()-1) + "(" +  stack.getCounter() + "/" + stack.getMaxCounter() + ")");
                
        
    }

    public int getBiggestStack() {
        return biggestStack;
    }

    public void setBiggestStack(int biggestStack) {
        this.biggestStack = biggestStack;
    }

    public ArrayList<Stack> getSlope() {
        return slope;
    }

    public void setSlope(ArrayList<Stack> slope) {
        this.slope = slope;
    }
    
    
}
