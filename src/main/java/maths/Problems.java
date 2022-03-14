package maths;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Problems {

    // https://www.geeksforgeeks.org/sieve-of-eratosthenes/
    public static boolean[] sieveOfEratosthenes(int n){

        boolean[] array = new boolean[n+1];
        Arrays.fill(array,true);

        for (int i = 2 ; i * i <= n ; i++)
            for (int j = 2*i ; j <= n ; j = i + j)
            {
                //System.out.println(i + " -- " + j);
                array[j] = false;
            }
        return array;
    }

    public static int gcd(int a, int b){
        if(b==0)
            return a;

        // return a%b == 0 ? b : gcd(b,a%b);
        return gcd(b,a%b);
    }

    public static int fastPower(int a, int b){
        int res = 1;

        while ( b > 0 ){
            if((b&1) != 0){ // b%2 != 0
                res = res * a;
            }
            a = a * a;
            b = b >> 1; // b divide by 2
        }
        return res;
    }

    static long fastPowerUsingArithmetic(long a, long b, int n) {

        long res = 1;

        while ( b > 0) {

            if ( (b&1) != 0) {
                res = (res * a % n) % n; // res % a will always return res as res is small compared to n
            }

            a = (a % n * a % n) % n;
            b =  b >> 1;
        }

        return res;

    }

    public static void main(String[] args) {
        boolean[] array = sieveOfEratosthenes(20);
        System.out.printf("Prime Numbers :: ");
        for (int i = 0 ; i < array.length ; i++)
        {
            if(array[i] == true)
            System.out.printf(" " + i);
        }

        System.out.println("\nGCD :: " + gcd(20,144));
        System.out.println("Power :: " + fastPower(3,5));
        System.out.println("Power Using Modulo Arithmetic :: " + fastPowerUsingArithmetic(3978432, 5, 1000000007)); // 383984356
    }
}
