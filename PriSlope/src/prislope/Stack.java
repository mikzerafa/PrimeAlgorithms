package prislope;

import java.util.ArrayList;

public class Stack 
{
    ArrayList<Prime> stack;
    private int maxCounter;
    private int counter;
    
    Stack()
    {
        stack = new ArrayList();
        maxCounter = 0;
        counter = 0;
    }
    
    public void resetStack()
    {
        this.counter = this.maxCounter;
    }
    
    public void UpdateStack()
    {
        System.out.println("Decreasing all counters by " + maxCounter/2);
        for(int index = 0; index < stack.size(); index++)
        {
            stack.get(index).counterLess(maxCounter/2);
        }
    }
    
    public void countDown()
    {
        this.counter--;
        System.out.println(counter + "/"+  maxCounter);
    }

    public ArrayList<Prime> getStack() {
        return stack;
    }

    public int getMaxCounter() {
        return maxCounter;
    }

    public int getCounter() {
        return counter;
    }

    public void setStack(ArrayList<Prime> stack) {
        this.stack = stack;
    }

    public void setMaxCounter(int maxCounter) {
        this.maxCounter = maxCounter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
    
    
}
