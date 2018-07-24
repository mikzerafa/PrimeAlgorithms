package mersennescout;

import java.util.ArrayList;

public class hypoth {
    
    ArrayList<Double> possibleMersenne;
    double posMerse;
    double b;
    double bsqr;
    double a;
    double asqr;
    double test; //2^n -1
    Boolean success;
    double n1;
    Evolve eve;
    
    hypoth()
    {
       possibleMersenne = new ArrayList();
       posMerse = 0.0;
       b = 0.0;
       a = 0.0;
       bsqr = 0.0;
       asqr = 0.0;
       test = 0.0;
       success = false;
       n1 = 0.0;
       eve = new Evolve();
    }
    
    public void start()
    {
        //posMerse =    b ^ 2 -  a ^ 2
        //2^n1 -1  =  (2^n2)^2 - (2^n2 - 1)^2
        
        for(double n2 = 1.0; n2 < 64; n2++)//64 cause of double
        {
            //System.out.println("execution");
            this.b = Math.pow(2.0, n2); // (2^n2)                              //    4          3  ... 4^2 - 3^2 = 4+3
            this.bsqr = this.b * this.b; // (2^n2)^2       // numerical example, b= (2^2), a=(2^2 - 1) // over here we're making the assumption that its 1 less and then checking if it still fits int he equation later
            this.a = b-1; //(2^n2 -1)
            this.asqr = this.a * this.a;//(2^n2 - 1)^2  
            
            this.posMerse = this.bsqr - this.asqr;
            System.out.println("");
            //System.out.println("a: " + this.a);
            //System.out.println("b: " + this.b + " (2^"+ n2+")");
            System.out.println("asqr: " + this.asqr);
            System.out.println("bsqr: " + this.bsqr);
            System.out.println("posMerse: " + this.posMerse);
            success = false;
            
            this.n1 = 0.0;
            
            test = 0.0;
            while(test <= this.posMerse)
            {
               // System.out.println("test: " + test);
                if(test == this.posMerse)
                {
                    
                    success = true;
                    
                    if(eve.isPrime(this.posMerse))
                    {
                        System.out.println(this.posMerse + " is a mersenne prime ");
                    }
                    test++; // exit loop;
                }
                
                else
                {
                    test = Math.pow(2.0, this.n1) - 1;
                    //System.out.println("newTestValue: " + test);
                    this.n1++;
                }
            }
        }
    }
}
