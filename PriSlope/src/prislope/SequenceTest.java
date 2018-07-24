
package prislope;

import java.util.Random;

public class SequenceTest {
    Sequence sequence;
    
    SequenceTest()
    {
        this.sequence = new Sequence();
    }
    
    public void test()
    {
        Random random = new Random();
        int num = 0;
        int last = 0;
        
        for(int index = 0; index < 1000000; index++)
        {
            do{
                
                num = random.nextInt(1000000);
                System.out.println("num: " + num);
                last = lastDigit(num);
                System.out.println("last: " + last);
                
            }while( last %2 == 0 || last%5 == 0 );
            
            for(int index1 = 2; index1 < 1000; index1++)
            {
                System.out.println("Test no." + (index1-1));
                int test = num * index1;
                System.out.println(num + " * " + index1 + " = " + test);
                
                int lastTest = lastDigit(test);
                System.out.println("Last digit of Test: " + lastTest);
                
                int ans = this.sequence.getDigit(last, lastDigit(index1 -1));
                
                System.out.println("answer according to sequence: " + ans);
                
                if(lastTest == ans)
                {
                    System.out.println("success");
                }
                else
                {
                    System.out.println("Fail");
                }
            }
        }
    }
    
    public int lastDigit(int num)
    {
        String strNum = num + "";
        int ans = Integer.parseInt("" + strNum.charAt(strNum.length() - 1));
        
        return ans;
    }
    
}
