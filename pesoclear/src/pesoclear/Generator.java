package pesoclear;

import java.util.ArrayList;

public class Generator 
{
    Map map;
    Map baseMap;
    ArrayList<Integer> primes;
    
    Generator()
    {
        primes = new ArrayList();
    }
    
    public void start()
    {
        int size = 10; //2 up to 24 ( 5^2 - 1)
        this.baseMap = new Map(6); //011101
        this.baseMap.initiateBaseMap();

        while(size <= 100000000)
        {
            System.out.print("Creating new Map size: " + size +"...");
            this.map = new Map(size);
            //System.out.println("DONE");
            
            if(primes.size() > 0)
            {
                updateBaseMap();
            }
            
            this.map.use(this.baseMap.getMap());

            for(int index = 0; index < this.primes.size(); index++)
            {
                //System.out.println("adding footprint of : " + primes.get(index));
                this.map.primeFootprint(this.primes.get(index));
            }

            for(int index = (int)Math.sqrt(size); index < size; index = index++) //continue reading the map from the last pos.
            {
                //System.out.println("Reading map at index: " + index + " representing number :" + (index+1) + " result: " + this.map.readMap(index));
                if(this.map.readMap(index))
                {
                    primes.add(index + 1);
                    //System.out.println(index+1);
                    //System.out.println(testPrime(index+1));
                }
            }
            //System.out.println(primes.get(primes.size()-1));
            size = size * size;
        }
    }
    
    public Boolean testPrime(int prime)
    {
        Boolean isprime = true;
        for(int index = 2; index < Math.sqrt(prime); index++)
        {
            if(prime % index == 0)
            {
             isprime = false;   
            }
        }
        
        return isprime;
    }
    
    public void updateBaseMap()
    {
        int size = this.baseMap.length();
        int index = 0;
        while(size * primes.get(index)< Math.sqrt(this.map.length()))
        {
            size = size * primes.get(index);
            //System.out.println("prime: " +primes.get(index));
            //System.out.println("Size: " + size);
            index++;   
        }
        
        //save the old map.
        Boolean[] baseMap2 = new Boolean[this.baseMap.length()];
        
        for(int index1 = 0 ; index1 < this.baseMap.length(); index1++)
        {
            baseMap2[index1] = this.baseMap.readMap(index1);
        }
        
        //System.out.println("Creating new base map size: " + size);
        this.baseMap = new Map(size); // creating a new base map
        
        //write the old basemap on the new basemap.
        for(int index1 = 0; index1 < this.baseMap.length(); index1 = index1 + baseMap2.length)
        {
            for(int index2 = 0; index2 < baseMap2.length; index2++)
            {
                this.baseMap.write(index1+index2, baseMap2[index2]);
            }
        }
        
        int primesAdded = 0;
        for(primesAdded = 0; primesAdded < index; primesAdded++)
        {
            //System.out.println("Adding prime footprint to base map: " + primes.get(primesAdded));
            this.baseMap.basePrimeFootprint(primes.get(primesAdded));
        }
        
        while(primesAdded > 0) //THE BLIND MAP
        {
            primesAdded--;
            this.primes.remove(primesAdded);  
        }
        
        //this.baseMap.print();
        
    }
}

