package prievolve;


public class decendant {
    private int num;
    private int prime;
    
    decendant(int num)
    {
        this.num = num + num + num; //we're skipping evens so eg(input = 3; the next useful p
        this.prime = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPrime() {
        return prime;
    }

    public void setPrime(int prime) {
        this.prime = prime;
    }
    
    
}

