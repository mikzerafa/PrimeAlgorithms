package prievolve;

import java.util.ArrayList;

public class Game {
    
    ArrayList<Double> prime = new ArrayList();
    ArrayList<decendant> decendants = new ArrayList();
    ArrayList<decendant> wait = new ArrayList();
    
    Boolean isprime = true;
    int num = 3;
    
    Game()
    {
        
    }
    
    public void start()
    {
        int Max = 10;

        while(true)
        {
            while(num < Max)
            {
                isprime = true;

                for(int index = 0; index < decendants.size(); index++)
                {
                    if(num == decendants.get(index).getNum())
                    {
                        isprime = false;
                        decendants.get(index).setNum(num + decendants.get(index).getPrime() + decendants.get(index).getPrime());
                    }
                }

                if(isprime)
                {
                    System.out.println(num);//+ " is prime"+ testPrime(num));

                    decendant dec = new decendant(num);
                    
                    if(num * num < Max)
                    {
                        decendants.add(dec);
                  
                    }

                    else
                    {
                        dec.setNum(num*num); //THE NEXT POINT THE NUMBER IS USEFUL IN DETERMINING THAT A NUMBER ISNT PRIME
                        wait.add(dec);
                    }
                }

                num += 2;
            }
            
            Max = Max * Max;
            
            for(int index = 0; index < wait.size(); index++)
            {
                //System.out.println("Size: " + wait.size());
                //OVER HERE I HAVE tO SEE IF I CAN UPDATE THE NUM of A DECENDANT BASED ON ITS PRIMES
                decendants.add(wait.get(index));
                
            }
            
        }
    }
    

    
    public Boolean testPrime(double primeNum)
    {
        Boolean output = true;
        
        for(double index = 2.0; index < primeNum/2 + 1; index++)
        {
            if(primeNum % index == 0)
            {
                output = false;
            }
        }
        
        return output;
    }

}
