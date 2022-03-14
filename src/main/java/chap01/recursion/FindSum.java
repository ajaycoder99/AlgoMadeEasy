package chap01.recursion;

public class FindSum {

    static int sum(int n) // Sum of Natural Numbers
    {
        if(n == 1)
            return 1;

        return n + sum(n-1);
    }

    public static void main(String[] args) {
        System.out.println(sum(5));
    }
}
