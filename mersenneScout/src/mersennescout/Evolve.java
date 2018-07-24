package mersennescout;

public class Evolve {
    
    //Generator gen;
    int[] squarePattern;
    int[]possibleSquares;
    Boolean[] sqrMap;
    Boolean[] areSquares;
    double num;
    double factor1;
    double factor2;//both factors will be prime as this is for RSA
    double calcFactor1;
    double calcFactor2;
    double bsquared;
    double b;
    double a;
    int executions;
    
    Evolve()
    {
        //gen = new Generator();
        this.squarePattern = new int[10];
        initSqrMap();
        this.possibleSquares = new int[6];
        initPossibleSqrs();
        this.areSquares = new Boolean[possibleSquares.length];
        sqrMap = new Boolean[squarePattern.length]; // this is the optimization
        factor1 = 0;
        factor2 = 0;
        num = 0.0;


        calcFactor1 = 0;
        calcFactor2 = 0;
         bsquared = 0;
        b = 0.0;
        a = 0.0;
        executions = 0;
    }
    
    public void runTests()
    {
        while(true)
        {
            runTest();
        }
    }
    
    public String success()
    {
        String success = "Fail";
        if(this.factor1 == this.calcFactor1 && this.factor2 == this.calcFactor2)
        {
            success = "Success";
        }
        
        return success;
    }
    
    public void runTest()
    {
        //this.gen.go(999999989);
        //this.factor1 = gen.getRandom();
        //this.factor2 = gen.getRandom();
        this.factor1 = 8753196421.0; //prime from online
        this.factor2 = 19972667609.0; //prime from online
        if(this.factor1 < this.factor2)
        {
            double holder = this.factor2;
            this.factor2 = this.factor1;
            this.factor1 = holder;
        }
        this.num = factor1 * factor2;
        
        System.out.println(factor1 +" * " + factor2 +" = " + num);
        
        this.solveNormal();
        System.out.print("Fermat's :: Num:" + num + "\tFactors: " + calcFactor1 + ", " + calcFactor2);
        //System.out.println("\tExecutions " + executions +"\t" + success());
        
               
        FactoriseNum(num);
        
        //System.out.print("Evolve :: num = " + num + "\tFactors: " + this.calcFactor1 + ", " + this.calcFactor2);
        //System.out.println("\tExecutions: " + executions + "\t" + success());
        
        
        
        
    }
    
    public Boolean isPrime(double num)
    {
        Boolean ans = false;
        
        FactoriseNum(num);
        if(this.calcFactor2 == 1)
        {
            ans = true;
        }
        
        return ans;
    }
    
    public void FactoriseNum(double num)
    {
        //Based on this num + a^2 = b^2
        
        //which square endings for a + nums ending = an ending of a possible square .. i.e. 1, 4, 9, 6, 5 and 0 (but nat really) 100 y'know
        executions = 0;
        double lastDigit = num % 10;
        int[] CalculatedEndings = new int[possibleSquares.length];
        initMaps();
        
        for(int index = 0; index < possibleSquares.length; index++)
        {
            CalculatedEndings[index] = ((int)lastDigit + possibleSquares[index]) % 10; // now calculated endings contains the last digit of a^2 
        }
        
        for(int index = 0; index < CalculatedEndings.length; index++)
        {
            //if this ending is a possible square
            for(int index2 = 0; index2 < possibleSquares.length; index2++)
            {
                if(CalculatedEndings[index] == possibleSquares[index2]) // now we're checking if its still a possibleSquare
                {
                    areSquares[index] = true; //i assume the rest will be false;
                            
                }
            }
        }
        
        initMap();
        
        //AND NOW WE USE IT // this part i might be lost
        
        for(this.a = 1.0; a < num; a++) // i donno if it should be num
        {
            double selection = a % 10;
            if(sqrMap[(int)selection])
            {
                executions++; //this is the point we wanted to shorten;
                this.b = Math.sqrt(num + (a * a));
                if(b % 1 == 0)
                {
                    System.out.println(num + " + (a * a) = b^2");
                    System.out.println("a: " + a + "\tb: " + b + "\t(a * a): " + (a * a) + "\tb ^2: " + (b * b));
                    System.out.println("b^2 - a^2: " + ((b*b) - (a*a)));
                    this.calcFactor1 = a + b;
                    this.calcFactor2 = b - a;
                    
                    System.out.println("calcFactor1: " + this.calcFactor1);
                    System.out.println("calcFactor2: " + this.calcFactor2);
                    
                    if(this.calcFactor2 == 1.0)
                    {
                        System.out.println("MERSENNE PRIME");
                    }
                    
                    a = num; // EXIT LOOP
                }
                    
            }
        }
        
    }
    
    public void initMaps()
    {
        for(int index = 0; index < this.sqrMap.length; index++)
        {
            this.sqrMap[index] = false;
        }
        
        for(int index = 0 ; index < this.areSquares.length; index++)
        {
            this.areSquares[index] = false;
        }
    }

    
    
    public void initMap()
    {
      // repeat it and the last one of are squares is 0
      //the last one of sqrMap is 0
       sqrMap[0] = areSquares[5];//0
       sqrMap[1] = areSquares[0];//1
       sqrMap[2] = areSquares[1];//4
       sqrMap[3] = areSquares[2];//9
       sqrMap[4] = areSquares[3];//6
       sqrMap[5] = areSquares[4];//5
       sqrMap[6] = areSquares[3];//6
       sqrMap[7] = areSquares[2];//9
       sqrMap[8] = areSquares[1];//4
       sqrMap[9] = areSquares[0];//1

    }
    
    public void initPossibleSqrs()
    {
        
        this.possibleSquares[0] = 1;
        this.possibleSquares[1] = 4;
        this.possibleSquares[2] = 9;
        this.possibleSquares[3] = 6;
        this.possibleSquares[4] = 5;
        this.possibleSquares[5] = 0;
    }
    
    public void initSqrMap()
    {
        this.squarePattern[0] = 1;//1,4,9,6,5,6,9,4,1,0
        this.squarePattern[1] = 1;//1,4,9,6,5,6,9,4,1,0
        this.squarePattern[2] = 1;//1,4,9,6,5,6,9,4,1,0
        this.squarePattern[3] = 1;//1,4,9,6,5,6,9,4,1,0
        this.squarePattern[4] = 1;//1,4,9,6,5,6,9,4,1,0
        this.squarePattern[5] = 1;//1,4,9,6,5,6,9,4,1,0
        this.squarePattern[6] = 1;//1,4,9,6,5,6,9,4,1,0
        this.squarePattern[7] = 1;//1,4,9,6,5,6,9,4,1,0
        this.squarePattern[8] = 1;//1,4,9,6,5,6,9,4,1,0
        this.squarePattern[9] = 1;//1,4,9,6,5,6,9,4,1,0
    }
   

    //Start Factorising here.
    public void solveNormal()
    {
        executions = 0;
        a = 1.0;
        do
        {
            executions++;
            bsquared = num + (a * a);
            b = Math.sqrt(bsquared);
            //System.out.println(bsquared);
            //System.out.println(b);
            if(b % 1 == 0) //if b is integer
            {
                //System.out.println("it is and a and b are as follows " + a + " " + b);
                calcFactor1 = a + (int)b;
                calcFactor2 = (int)b - a;
            }

            else
            {
                a++; // here's where we optimise
            }
        }while(b%1 != 0);

        
    }
        

}
