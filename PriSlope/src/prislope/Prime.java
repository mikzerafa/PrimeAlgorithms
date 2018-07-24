package prislope;

public class Prime 
{
    //Storing the only data necessary to determine a number isnt prime (composite)
    private int counter;
    private int maxCounter;
    private int sequence;
    private int sequenceState;
    
    Prime(int num)
    {
        System.out.println(num);
        String strNum = num + "";
        String strMaxCounter = strNum.substring(0, strNum.length()-1); // eg 317 -> 31
        String strSequence = "" + strNum.charAt(strNum.length()-1);
        
        
        this.maxCounter = Integer.parseInt(strMaxCounter);
        this.counter = this.maxCounter;
        this.sequence = Integer.parseInt(strSequence);
        this.sequenceState = 1; // the next last digit in the sequence, 
    }
    
    public void printNum()
    {
        System.out.println("number: " + maxCounter + "" + sequence);
    }
    
    public void print()
    {
        
        System.out.println("\ncounter = " + this.counter);
        System.out.println("maxCounter = " + this.maxCounter);
        System.out.println("sequence = " + this.sequence);
        System.out.println("sequence State = " + this.sequenceState + "\n");
    }
    
    public void resetCounter()
    {
        this.counter = this.maxCounter;
    }
    
    public void updateSequenceState()
    {
        this.sequenceState++;
        if(this.sequenceState > 9)
        {
            this.sequenceState = 0;
        }
    }
    
    public void counterLess(int less)
    {
        this.counter = this.counter - less;
    }

    public int getCounter() {
        return counter;
    }

    public int getMaxCounter() {
        return maxCounter;
    }

    public int getSequence() {
        return sequence;
    }

    public int getSequenceState() {
        return sequenceState;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void setMaxCounter(int maxCounter) {
        this.maxCounter = maxCounter;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public void setSequenceState(int sequenceState) {
        this.sequenceState = sequenceState;
    }
    
    
}
