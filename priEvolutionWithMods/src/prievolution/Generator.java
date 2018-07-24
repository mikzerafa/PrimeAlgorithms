package prievolution;

import java.util.ArrayList;

public class Generator 
{
    Map map;
    ArrayList<Integer> primes;
    
    Generator()
    {
        primes = new ArrayList();
    }
    
    public void start()
    {
        int size = 10;
        
        
        while(true)
        {
            System.out.print("Creating new Map size: " + size +"...");
            this.map = new Map(size);
            System.out.println("DONE");
            long startTime = System.currentTimeMillis();
            this.map.baseMap2();
            long endTime = System.currentTimeMillis();
            
            long time = endTime-startTime;
            
            System.out.println("Setting up map time: " + time);
            
            startTime = System.currentTimeMillis();
            for(int index = 0; index < this.primes.size(); index++)
            {
                this.map.primeFootprint(this.primes.get(index));
            }
            endTime = System.currentTimeMillis();
            
            time = endTime - startTime;
            
           // System.out.println("Adding prime Footprints time: " + time);

            
            startTime = System.currentTimeMillis();
            for(int index = (int)Math.sqrt(size); index < size; index++) // ignore position 0 because 1 is ignored in prime numbers
            {
                if(this.map.readMap(index)) //list starts from 1 not 0;
                {
                    primes.add(index + 1);
                   // System.out.println(index +1);
                }
            }
            
            endTime = System.currentTimeMillis();
            
            time = endTime - startTime;
            
            size = size * size;
            
            System.out.println("Adding primes Time: " + time);
        }
    } 
}
