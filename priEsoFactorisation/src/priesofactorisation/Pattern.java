package priesofactorisation;

/*
    1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 0
    3 , 6 , 9 , 2 , 5 , 8 , 1 , 4 , 7 , 0
    7 , 4 , 1 , 8 , 5 , 2 , 9 , 6 , 3 , 0
    9 , 8 , 7 , 6 , 5 , 4 , 3 , 2 , 1 , 0
*/

//you get a number
// you do %10 to get the last digit
// you see what its corresponding factor ends with by following the sequence.
// you only check numbers of 1 of the corresponding factors
//if its not in that one you check in one of the remainding 2 corresponding factors (to each other, not to the one we checked before
//So we're only checking prime numbers
//this is the assumption, that we have a number that is a multiple of 2 numbers, which are prime
//this algorithm has to check if the number is a multiple of 2 and 5 seperately.
//because 2 and 5 are the only prime numbers that end in 2 and 5, we will almost assume that the number is not a multiple of these 2 numbers
//this gives us the advantage to limit the possible multiplication to 4 numbers -> 1, 3, 7 and 9
//Thus the sequence.
//the sequence tells us that if our number ends in 1 then the factors must end in either 1 and 1 or 3 and 7 or 7 and 3 or 9 and 9
//if our number ends in 


//So basicaly this could be accompplished by saving the last digit of
// 1 * 1, 1 * 3, 1 * 7 1 * 9, 3 * 3, 3* 7, 3 * 9, 7 * 7, 7 * 9, 9 * 9 ... but noooo

public class Pattern {
    private int[][]pattern = new int[4][10];
 
    
    Pattern()
    {
        initSequence();
    }
    
    //Search algorithms return the last digit of the other factor of x if the factor of x happened end with the search(digit) we're looking into
    public int search1(int digit)
    {
        return digit;
    }
    
    public int search3(int digit)
    {
        int index = 0;
        while(digit != this.pattern[1][index])
        {
            index++;
        }
        
        return index;
    }
    
    public int search7(int digit)
    {
        int index = 0;
        while(digit != this.pattern[2][index])
        {
            index++;
        }
        
        return index;
    }
    
    public int search9(int digit)
    {
        int index = 0;
        while(digit != this.pattern[3][index])
        {
            index++;
        }
        
        return index;
    }

    public int[][] getPattern() {
        return pattern;
    }

    public void setPattern(int[][] pattern) {
        this.pattern = pattern;
    }
    
    
    
    public void initSequence()
    {//the 1,3,7,9 last digit sequence.
        this.pattern[0][0] = 0;
        this.pattern[0][1] = 1;
        this.pattern[0][2] = 2;
        this.pattern[0][3] = 3;
        this.pattern[0][4] = 4;
        this.pattern[0][5] = 5;
        this.pattern[0][6] = 6;
        this.pattern[0][7] = 7;
        this.pattern[0][8] = 8;
        this.pattern[0][9] = 9;
        
        
        //Ending in 3 sequence;
        this.pattern[1][0] = 0;
        this.pattern[1][1] = 3;
        this.pattern[1][2] = 6;
        this.pattern[1][3] = 9;
        this.pattern[1][4] = 2;
        this.pattern[1][5] = 5;
        this.pattern[1][6] = 8;
        this.pattern[1][7] = 1;
        this.pattern[1][8] = 4;
        this.pattern[1][9] = 7;
       
        this.pattern[2][0] = 0;
        this.pattern[2][1] = 7;
        this.pattern[2][2] = 4;
        this.pattern[2][3] = 1;
        this.pattern[2][4] = 8;
        this.pattern[2][5] = 5;
        this.pattern[2][6] = 2;
        this.pattern[2][7] = 9;
        this.pattern[2][8] = 6;
        this.pattern[2][9] = 3;
        
        this.pattern[3][0] = 0;
        this.pattern[3][1] = 9;
        this.pattern[3][2] = 8;
        this.pattern[3][3] = 7;
        this.pattern[3][4] = 6;
        this.pattern[3][5] = 5;
        this.pattern[3][6] = 4;
        this.pattern[3][7] = 3;
        this.pattern[3][8] = 2;
        this.pattern[3][9] = 1;
        
    }
}
