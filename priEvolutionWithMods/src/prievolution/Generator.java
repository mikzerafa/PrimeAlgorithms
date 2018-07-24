package prievolution;

import java.util.ArrayList;
import java.util.BitSet;

public class Generator 
{
    BitSet sieve;
    ArrayList<Integer> primes;

    Generator()
    {
        primes = new ArrayList(Short.MAX_VALUE-1);
    }
    
    public void start() {
        int size = 10;

        while (true) {
            System.out.print("Creating new Map size: " + size + "...");
            this.sieve = new BitSet(size);
            System.out.println("DONE");
            long startTime = System.currentTimeMillis();
            baseMap2();
            long endTime = System.currentTimeMillis();
            long time = endTime - startTime;

            System.out.println("Setting up map time: " + time);

            startTime = System.currentTimeMillis();
            for (int index = 0; index < this.primes.size(); index++) {
                primeFootprint(this.primes.get(index));
            }
            endTime = System.currentTimeMillis();

            time = endTime - startTime;

            // System.out.println("Adding prime Footprints time: " + time);


            startTime = System.currentTimeMillis();
            for (int index = (int) Math.sqrt(size); index < size; index++) // ignore position 0 because 1 is ignored in prime numbers
            {
                if (sieve.get(index)) //list starts from 1 not 0;
                {
                    primes.add(index + 1);
                }
            }

            endTime = System.currentTimeMillis();

            time = endTime - startTime;

            size = size * size;

            System.out.println("Adding primes Time: " + time);

//            for (int prime : primes) {
//                System.out.println(prime);
//            }
        }
    }

    public void primeFootprint(int prime)
    {
        int footprint = prime * prime;

        while(sieve.size() < footprint - 1 )
        {
            //this.map[footprint - 1] = false;
            sieve.set(footprint-1, false);

            footprint = footprint + prime + prime;
        }
    }

    public void baseMap2()
    {
        int index = 0;

        while(index < sieve.size() - 5)
        {
            sieve.set(index);
            sieve.set(index+1, false);
            sieve.set(index+2, false);
            sieve.set(index+3, false);
            sieve.set(index+4);
            sieve.set(index+5, false);

            index = index + 6;
        }

        int left = sieve.size() - index;

        switch(left){
            case 1:
                sieve.set(index);
                break;

            case 2:
                sieve.set(index);
                //this.map[index + 1] = false;
                sieve.set(index+1,false);
                break;

            case 3:
                //this.map[index] = true;
                sieve.set(index);
                //this.map[index + 1] = false;
                sieve.set(index+1 ,false);
                //this.map[index + 2] = false;
                sieve.set(index+2,false);
                break;

            case 4:
                sieve.set(index);
                sieve.set(index+1, false);
                sieve.set(index+2, false);
                sieve.set(index+3, false);
                break;

            case 5:

                sieve.set(index);
                sieve.set(index+1, false);
                sieve.set(index+2, false);
                sieve.set(index+3, false);
                sieve.set(index+4);
                break;
        }
    }
}
