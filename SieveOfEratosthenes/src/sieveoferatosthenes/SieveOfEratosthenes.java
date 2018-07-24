package sieveoferatosthenes;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int n = 99999999;

        // initially assume all integers are prime
        boolean[] isPrime = new boolean[n+1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        // mark non-primes <= n using Sieve of Eratosthenes
        //int limit = (int)Math.sqrt(n);
        for (int factor = 2; factor*factor <= n; factor++) {

            // if factor is prime, then mark multiples of factor as nonprime
            // suffices to consider mutiples factor, factor+1, ...,  n/factor
            if (isPrime[factor]) {
                for (int j = factor; factor*j <= n; j++) {
                    isPrime[factor*j] = false; // this already does that wow.
                }
            }
        }

        // count primes
        int primes = 0;
        for (int i = 3; i <= n; i+= 2) {
            if (isPrime[i]) System.out.println(i);
            
        }
    }
}
