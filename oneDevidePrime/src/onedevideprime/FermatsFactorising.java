package onedevideprime;

import javax.swing.JOptionPane;

public class FermatsFactorising 
{
    public static void main(String[] args) {
        
        String strNum = JOptionPane.showInputDialog(null, "Insert number");
        int num = Integer.parseInt(strNum);
        
        //num + a^2 = b^2;
        
        int a = 1; //(a)
        int factor1 = 0;
        int factor2 = 0;
        
        while(true)
        {
            boolean loop = true;
            
            while(loop)
            {
                int bsquared = num + (a * a); // result = (b)
                double b = Math.sqrt(bsquared);
                
                System.out.println("num: " + num +"\ta: " + a + "\tb: " + b);
                if(Math.sqrt(b)%1 == 0)
                {
                    //found factors;
                    factor1 = a + (int)b;
                    factor2 = (int)b - a;
                    loop = false;
                }
                
                else
                {
                    a++;
                }
            }
        
            strNum = JOptionPane.showInputDialog(null, "Insert number (factors of " + num +" = " + factor1 + ", " + factor2);
            num = Integer.parseInt(strNum);
            factor1 = 0;
            factor2 = 0;
        }
        
    }
}
