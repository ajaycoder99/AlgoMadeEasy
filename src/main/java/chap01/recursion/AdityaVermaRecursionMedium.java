package chap01.recursion;

/*
N :: y-axis K :: x-axis
1 - 0
2 - 0 1
3 - 0 1 1 0
4 - 0 1 1 0 1 0 0 1
 */

// Medium Problems
public class AdityaVermaRecursionMedium {

    /** Very Important Trick **/
    public static int KthSymbolGrammar(int N, int K)
    {
        if(N==1 && K==1){
            return 0;
        }
        int length=(int) Math.pow(2,N-1);
        int mid=length/2;

        if(K<=mid){
            return KthSymbolGrammar(N-1,K);
        }
        else{
            return (KthSymbolGrammar(N-1,K-mid)==0 ? 1:0);
        }
    }

    static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod)
    {
        if (n == 1)
        {
            System.out.println("Move disk 1 from rod " +  from_rod + " to rod " + to_rod);
            return;
        }
        towerOfHanoi(n-1, from_rod, aux_rod, to_rod);
        System.out.println("Move disk " + n + " from rod " +  from_rod + " to rod " + to_rod);
        towerOfHanoi(n-1, aux_rod, to_rod, from_rod);
    }

    // Print Subset / PowerSet / subsequence Set
    // All Subsequence of abc :: ab bc ac
    // Power Set :: "" a b ab
    // Sub Set :: same as subsequence coz we don't want to print all combinations like ab and ba both ab is enough
    public static void printSubsetsPowerSet(String input, String output)
    {
        if(input.length()==0){
            System.out.print(output + "  ");
            return;
        }
        String out1 = output;
        String out2 = output;
        out2 += input.charAt(0);
        input = input.substring(1);

        printSubsetsPowerSet(input,out1);
        printSubsetsPowerSet(input,out2);
    }

    public static void printPermutationWithSpaces(String input, String output)
    {
        if(input.length() == 0){
            System.out.print(output + "  ");
            return;
        }

        String output1 = output;
        String output2 = output;

        output1 = output1 + "_" + input.charAt(0);
        output2 = output2 + input.charAt(0);

        printPermutationWithSpaces(input.substring(1), output1);
        printPermutationWithSpaces(input.substring(1), output2);
        return;
    }

    public static void printPermutationWithUpperCase(String input,String output)
    {
        if(input.length() == 0){
            System.out.print(output + "  ");
            return;
        }

        String output1 = output;
        String output2 = output;

        output1 = output1 + input.charAt(0);
        output2 = output2 + (input.charAt(0)+"").toUpperCase();

        printPermutationWithUpperCase(input.substring(1),output1);
        printPermutationWithUpperCase(input.substring(1),output2);
    }

    public static void printPermutationLetterCase(String input,String output)
    {
        if(input.length() == 0){
            //input = output;
            System.out.print(output + "  ");
            return;
        }

        String output1 = output;
        String output2 = output;

        if(Character.isLetter(input.charAt(0)))
        {
            output1 = output1 + (input.charAt(0)+"").toLowerCase();
            output2 = output2 + (input.charAt(0)+"").toUpperCase();

            printPermutationLetterCase(input.substring(1),output1);
            printPermutationLetterCase(input.substring(1),output2);
        }
        else
        {
            output1 = output1 + (input.charAt(0)+"");
            printPermutationLetterCase(input.substring(1),output1);
        }
    }

    // Function that print all combinations of
    // balanced parentheses
    // open store the count of opening parenthesis
    // close store the count of closing parenthesis
    static void _printParenthesis(char str[], int pos, int n, int open, int close)
    {
        if(close == n)
        {
            // print the possible combinations
            for(int i=0;i<str.length;i++)
                System.out.print(str[i]);
            System.out.println();
            return;
        }
        else
        {
            if(open > close) {
                str[pos] = '}';
                _printParenthesis(str, pos+1, n, open, close+1);
            }
            if(open < n) {
                str[pos] = '{';
                _printParenthesis(str, pos+1, n, open+1, close);
            }
        }
    }

    // Print N-bit binary numbers having more 1’s than 0’s for any prefix
    public static void printBinary(int one, int zero, int n, String output){
        if(n==0){
            System.out.println(output + " ");
            return;
        }

        String output1 = output + "1";
        printBinary(one+1,zero,n-1,output1);

        if(one > zero)
        {
            String output2 = output;
            output2 = output2 + "0";
            printBinary(one,zero+1,n-1,output2);
        }
    }

    public static void main(String[] args) {
        System.out.println("Kth Symbol Grammar :: " + KthSymbolGrammar(4,5));
        System.out.print( "\n" );

        System.out.println("Tower of Hanoi :: ");
        towerOfHanoi(3,'a','b','c');
        System.out.print( "\n" );

        System.out.println("Print SubSet / PowerSet :: ");
        printSubsetsPowerSet("abc","");
        System.out.println();

        System.out.println("Permutation with spaces :: ");
        printPermutationWithSpaces("bc","a");
        System.out.println();

        System.out.println("Permutation with upper case :: ");
        printPermutationWithUpperCase("ab","");
        System.out.println();

        System.out.println("Permutation with Letter Case :: ");
        printPermutationLetterCase("a1B2","");
        System.out.println();

        int n = 3;
        char[] str = new char[2 * n];
        System.out.println("Balanced Parenthesis :: ");
        _printParenthesis(str,0,3,0,0);

        System.out.println("Print Binary :: ");
        printBinary(0,0,3,"");
    }
}
