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
            this.map.baseMap();

            for(int index = 0; index < this.primes.size(); index++)
            {
                this.map.primeFootprint(this.primes.get(index));
            }

            for(int index = (int)Math.sqrt(size); index < size; index++) // ignore position 0 because 1 is ignored in prime numbers
            {
                if(this.map.readMap(index)) //list starts from 1 not 0;
                {
                    primes.add(index + 1);
                    System.out.println(index +1);
                }
            }
            
            size = size * size;
        }
    } 
}
