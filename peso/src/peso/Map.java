/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peso;

public class Map 
{
    private Boolean[] map;
     
    Map(int size)
    {
        map = new Boolean[size]; 
    }
    
    public void use(Boolean[] map2)
    {
        for(int index1 = 0; index1 < this.map.length - map2.length; index1 = index1 + map2.length)
        {
            for(int index = 0; index < map2.length; index++)
            {
                this.map[index+ index1]= map2[index];
            }
        }
        
        int remainder = this.map.length % map2.length;
        
        for(int index = 0; index < remainder; index++)
        {
            this.map[this.map.length - remainder + index] = map2[index];
        }
        
    }
    
    public void write(int index, Boolean yesNo)
    {
        this.map[index] = yesNo;
    }
    
    public Boolean readMap(int index)
    {
        return map[index];
    }
    
    public int length()
    {
        return this.map.length;
    }
    
    public void basePrimeFootprint(int prime)
    {
        int footprint = prime;
        this.map[footprint-1] = false;
        
        footprint = footprint * footprint;
        while(footprint - 1 < this.map.length)
        {
            this.map[footprint - 1] = false;
            footprint = footprint + prime + prime;
        }
    }
            
    
    public void primeFootprint(int prime)
    {
        //System.out.println("about to step for " + prime);
        int footprint = prime * prime;
        
        while(footprint - 1 < this.map.length)
        {
            this.map[footprint - 1] = false;
            footprint = footprint + prime + prime;
        }
    }
    
    public void initiateBaseMap() // made up of 2/3 pattern.
    {
        this.map[0] = true;//1 / 7
        this.map[1] = false;//2 /8
        this.map[2] = false;//3 / 9
        this.map[3] = false;//4 / 10
        this.map[4] = true;//5 / 11
        this.map[5] = false;//6 / 12
    }
    
    public void baseMap()
    {
     
        
    }
    
    public void print()
    {
        for(int index = 0; index < this.map.length; index++)
        {
            System.out.println(this.map[index]);
        }
    }

    public Boolean[] getMap() {
        return map;
    }

    public void setMap(Boolean[] map) {
        this.map = map;
    }
}

