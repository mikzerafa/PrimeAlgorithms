package mersennescout;

public class MersenneScout 
{
    public static void main(String[] args) {
        
        //So from what i can tell
        // a mersenne prime is a prime that can be expressed as 2^n - 1.
        // now using N = b^2 - a^2
        // we found that b = a + 1
        //           and b = 2^n - 1 ( this time n has a different value to the mersenne prime's ^n
        
        //Therefore
        //           2^n1 -1  =  (2^n2)^2 - (2^n2 - 1)^2
        
        hypoth mersenne = new hypoth();
        mersenne.start();
    }  
}
