/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prievolution;
import java.util.BitSet;

   

//For now basic. optimize later. its easy, there are many places you can optimize this one.

public class Map 
{
    private boolean[] map;
    private BitSet map2;
     
    Map(int size)
    {
        //map = new boolean[size];
        map2 = new BitSet(size);
    }
    
    public boolean readMap(int index)
    {
       // return map[index];
        return map2.get(index);
    }
    
    public void primeFootprint(int prime)
    {
        int footprint = prime * prime;
        
        while(footprint - 1 < this.map2.size())
        {
            //this.map[footprint - 1] = false;
            this.map2.set(footprint-1, false);
            
            footprint = footprint + prime + prime;
        }
    }
    
    public void baseMap()
    {
       int index = 0;
        
        while(index < map.length - 5)
        {
            this.map[index] = true; //true = 0 false = 1 based on the written logic
            this.map[index+1] = false;
            this.map[index+2] = false;
            this.map[index+3] = false;
            this.map[index+4] = true;
            this.map[index+5] = false;
            
            index = index + 6;
        }
        
        int left = map.length - index;
        
        switch(left){
            case 1:
                this.map[index] = true;
            break;
            
            case 2:
                this.map[index] = true;
                this.map[index + 1] = false;
            break;
            
            case 3:
                this.map[index] = true;
                this.map[index + 1] = false;
                this.map[index + 2] = false;
            break;

            case 4:
                this.map[index] = true;
                this.map[index + 1] = false;
                this.map[index + 2] = false;
                this.map[index + 3] = false;
            break;
            
            case 5:
                this.map[index] = true;
                this.map[index + 1] = false;
                this.map[index + 2] = false;
                this.map[index + 3] = false;
                this.map[index + 4] = true;
            break;
          
        }
    }
    
    public void baseMap2()
    {
       int index = 0;
        
        while(index < this.map2.size() - 5)
        {
            this.map2.set(index);
            this.map2.set(index+1, false);
            this.map2.set(index+2, false);
            this.map2.set(index+3, false);
            this.map2.set(index+4);
            this.map2.set(index+5, false);
            
            index = index + 6;
        }
        
        int left = this.map2.size() - index;
        
        switch(left){
            case 1:
                //this.map[index] = true;
                this.map2.set(index);
            break;
            
            case 2:
                //this.map[index] = true;
                this.map2.set(index);
                //this.map[index + 1] = false;
                this.map2.set(index+1,false);
            break;
            
            case 3:
                //this.map[index] = true;
                this.map2.set(index);
                //this.map[index + 1] = false;
                this.map2.set(index+1 ,false);
                //this.map[index + 2] = false;
                this.map2.set(index+2,false);
            break;

            case 4:
                
                
                this.map2.set(index);
                this.map2.set(index+1, false);
                this.map2.set(index+2, false);
                this.map2.set(index+3, false);
            break;
            
            case 5:
                
                this.map2.set(index);
                this.map2.set(index+1, false);
                this.map2.set(index+2, false);
                this.map2.set(index+3, false);
                this.map2.set(index+4);
            break;
          
        }
    }
   
}
