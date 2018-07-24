package normalprime;

public class NormalPrime {

    public static void main(String[] args) {
        int num = 3;
        Boolean isPrime = true;
        int limit = 0;
        
        while(true)
        {
            isPrime = true;
            limit = (int)Math.sqrt(num);
            
            for(int index = 3; index < limit; index+= 2)
            {
                if(num % index == 0)
                {
                    isPrime = false;
                }
            }
            
            if(isPrime)
            {
                System.out.println(num);
            }  
            
            num += 2;
        }
    }
}
