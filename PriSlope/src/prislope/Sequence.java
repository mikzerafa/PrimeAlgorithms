package prislope;

public class Sequence {
    
    //0 - Ends in 1
    //1 - Ends in 3
    //2 - Ends in 7
    //3 - Ends in 9
    private final String[] sequence = new String[]{ "1234567890", "3692581470", "7418529630", "9876543210"};
    
    Sequence()
    {
        
    }
    
    public int getDigit(int seq, int state)
    {
        int digit = 0;
        
        switch(seq)
        {
            case 1:
                digit = Integer.parseInt("" + sequence[0].charAt(state));
                break;
                
            case 3:
                digit = Integer.parseInt("" + sequence[1].charAt(state));
                break;
                
            case 7:
                digit = Integer.parseInt("" + sequence[2].charAt(state));
                break;
            
            case 9:
                digit = Integer.parseInt("" + sequence[3].charAt(state));
                break;
                      
        }
        
        return digit;
    }
    
}
