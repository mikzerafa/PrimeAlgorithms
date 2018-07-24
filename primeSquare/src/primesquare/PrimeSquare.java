/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primesquare;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class PrimeSquare {

    //prime * prime and what square - square is equal to it.
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int prime1 = 0;
        int prime2 = 0;
        int square1 = 0;
        int square2 = 0;
        
        
        
        ArrayList<Integer>primes = new ArrayList();
        ArrayList<Integer>decendants = new ArrayList();
        int num = 3;
        
        while(true)
        {
            Boolean isprime = true;
            
            for(int index = 0; index < decendants.size(); index++)
            {
                if(num == decendants.get(index))
                {
                    isprime = false;
                    decendants.set(index, decendants.get(index) + primes.get(index) + primes.get(index));
                }
            }
            
            if(isprime)
            {
                primes.add(num);
                System.out.println(num);
                decendants.add(num+num+num);
            }
            
            num = num + 2;
                
        }
    }
    
}
