package prieso;

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
            this.map.baseMap(); // this bit creates a map that allows the sieve to be set up with multiples of 2 and 3
            //technically im sure it would be easy to remove atleast half of these
            //but i have to test out the actual speed of my code, so i can properly evaluate on whether this has a useful application
            

            for(int index = 0; index < this.primes.size(); index++)
            {
                this.map.primeFootprint(this.primes.get(index));
            }

            for(int index = (int)Math.sqrt(size); index < size; index++) //continue reading the map from the last pos.
            {
                if(this.map.readMap(index))
                {
                    primes.add(index + 1);
                    System.out.println(index+1);
                }
            }
            size = size * size;
        }
    } 
}

