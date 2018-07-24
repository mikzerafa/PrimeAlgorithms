package fermatsevolve2;

public class FermatsEvolve2 {

    // where a < b and a >= 1
    //num = b^2 - a^2  
    //num + a^2 = b^2
    // num = m1 * m2
    // m1 = b + a
    // m2 = b - a
    
    // so you have to add a square to num and the result has to be a square
    // the last digit allows us to filter which possible squares will result in a square.
    public static void main(String[] args) {
        
        //its failing because of how double works on a computer
        Evolve eve = new Evolve();
        eve.runTest();
        
        
        
        //AGAIN LOSSES ON DOUBLE
        //2^n-1 * 1 tests
        
        /*
        for(double index = 1.0; index < 63.0; index++)
        {
            double num = Math.pow(2.0, index) - 1;
            System.out.println(num + " = 2^"+index+" -1");
            eve.FactoriseNum(num);
            System.out.println();
           
        }
        */
        
        
    }
}
