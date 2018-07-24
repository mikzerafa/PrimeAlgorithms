package prii;
import java.util.*;

public class Prii
{
	public static void main (String args[])
	{
            ArrayList<Integer> primes = new ArrayList<>();
            ArrayList<Integer> decendants = new ArrayList<>();
            int num = 3;
            boolean prime = true;

            while (true)
            {
                    prime = true;
                    for(int index =0; index<decendants.size(); index++)
                    {
                        if(num == decendants.get(index))
                        {
                                prime = false;
                                decendants.set(index,( decendants.get(index) + primes.get(index) + primes.get(index) ));
                        }
                    }

                    if(prime==true)
                    {
                        primes.add(num);
                        decendants.add(num+num +num);                     
                        System.out.println("prii: " + num);
                    }
                        num = num + 2;
            }
	}
}