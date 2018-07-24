package fermatsevolve;

public class FermatsEvolve {

    // where a < b and a >= 1
    //num = b^2 - a^2  
    //num + a^2 = b^2
    // num = m1 * m2
    // m1 = b + a
    // m2 = b - a
    
    // so you have to add a square to num and the result has to be a square
    // the last digit allows us to filter which possible squares will result in a square.
    public static void main(String[] args) {
        
        Evolve eve = new Evolve();
        eve.runTests();
        
    }
}
