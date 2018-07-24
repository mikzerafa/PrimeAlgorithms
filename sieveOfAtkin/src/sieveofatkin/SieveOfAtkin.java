/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sieveofatkin;




import java.util.*;//arrays copy
public class SieveOfAtkin 
{
    public static void main(String[]args)
    {
       int[] primes;
       int arraySize = 99999999;                 
       primes = AtkinSieve.findPrimes(arraySize);
       
        for(int prime : primes)
        {
            System.out.println(prime + " ");
        }
        
        System.out.println("DONE");
                  
    }
    static public class AtkinSieve
    {     
        public static int[] findPrimes(int arraySize)
        {
            boolean[] isPrime = new boolean[arraySize + 1];
            double sqrt = Math.sqrt(arraySize);
           
            for (int x = 1; x <= sqrt; x++)
            {
                for (int y = 1; y <= sqrt; y++) 
                {
                    int n = 4 * x * x + y * y;
                    if (n <= arraySize && (n % 12 == 1 || n % 12 == 5)) 
                    {
                        isPrime[n] = !isPrime[n];
                    }
 
                    n = 3 * x * x + y * y;
                    if (n <= arraySize && (n % 12 == 7))
                    {
                        isPrime[n] = !isPrime[n];
                    }
 
                    n = 3 * x * x - y * y;
                    if (x > y && (n <= arraySize) && (n % 12 == 11))
                    {
                        isPrime[n] = !isPrime[n];
                    }
                }
            }
            for (int n = 5; n <= sqrt; n++) 
            {
                if (isPrime[n])
                {
                    int s = n * n;
                    for (int k = s; k <= arraySize; k += s) 
                    {
                        isPrime[k] = false;
                    }
                }
            }
            int[] primes = new int[arraySize];
            int found = 0;
            if (arraySize > 2)
            {
                primes[found++] = 2;
            }
            if (arraySize > 3) 
            {
                primes[found++] = 3;
            }
            for (int n = 5; n <= arraySize; n += 2)
            { 
                if (isPrime[n]) 
             {
                    primes[found++] = n;
                }
             }
            return Arrays.copyOf(primes, found);
       }
    }
}
 
//END OF CODE