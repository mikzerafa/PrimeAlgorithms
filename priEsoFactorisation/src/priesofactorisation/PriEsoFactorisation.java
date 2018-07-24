package priesofactorisation;

public class PriEsoFactorisation {
    public static void main(String[] args) {
        
        Factoriser factor = new Factoriser();
        Generator generator = new Generator();
        
        //generator.randomPrime(10000, 50000); // random primenumber from 10,000 to 50,000.
        //generator.randomPrime(10000, 50000);
        factor.factorise();
    }
}
