package chap01.recursion;

public class FastPow {

    static int fastPow(int a, int b)
    {
        if (b==0)
            return 1;

        if(b%2 == 0)
            return fastPow(a*a,b/2);
        else
            return a*fastPow(a,b-1);
    }

    public static void main(String[] args) {
        System.out.println(fastPow(4,3));
    }
}
