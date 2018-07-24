package fermatsevolve2;

public class Map 
{
    private Boolean[] map;
     
    Map(int size)
    {
        map = new Boolean[size];
    }
    
    public Boolean readMap(int index)
    {
        return map[index];
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
