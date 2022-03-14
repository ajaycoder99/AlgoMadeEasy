package chap19.dp;

import java.util.HashMap;
import java.util.Map;

public class FreeCodeCamp {

    /*
    Fib using recursion takes O(2^n) time. So for large time it takes lot of time to calculate.
    using dynamic programming we can use the already calculated fib values.
    Space Complexity is height of tree which is n so space :- O(n)
     */
    static int fib(int n)
    {
        if(n <= 2)
            return 1;

        return fib(n-1) + fib(n - 2);
    }

    /*
    we will be using int[] fib to save the already executed fib values. This is memoization.
    Time complexity is reduced to O(n) with DP
    Space Complexity is height of tree which is n so space :- O(n)
     */
    static long fibDp(int n, long[] fib)
    {
        if(n <= 2)
            return 1;

        if(fib[n] != 0)
            return fib[n];

        fib[n] = fibDp(n-1,fib) + fibDp(n - 2,fib);
        return fib[n];
    }

    /*
    Grid Travel Problem :: Traveller can go right and down only.
    m and n are rows and columns in grid
    Time complexity is O(2^m*n)
    Space Complexity is height of tree which is n so space :- O(m*n)
     */
    static int gridTraveller(int m, int n){
        if(m == 0 || n == 0)
            return 0;
        if(m == 1 && n == 1)
            return 1;

        return gridTraveller(m-1,n) + gridTraveller(m,n-1);
    }

    /*
    Grid travel using DP : traveller had travelled some path already which is repeated in recusrion
    Time complexity is reduced to O(m*n)
    Space Complexity is height of tree which is n so space :- O(m*n)
     */
    static int gridTravellerDp(int m, int n, int[][] grid){
        if(m == 0 || n == 0)
            return 0;
        if(m == 1 && n == 1)
            return 1;

        if(grid[m][n] != 0)
            return grid[m][n];

        grid[m][n] = gridTravellerDp(m-1,n,grid) + gridTravellerDp(m,n-1,grid);
        return grid[m][n];
    }

    /*
    Array and target sum is given please return true / false if numbers from that array can be sum up to target or not.
    eg:- (7,[2,3,4]) :- true coz 3 + 4 = 7 and 3 + 2 + 2 = true
    Time complexity :- m :- target and n :- length of array then O(n^m)
     */
    static boolean canSum(int target, int[] array){
        if(target == 0)
            return true;

        if(target < 0)
            return false;

        for(int i=0; i<array.length; i++)
        {
            int remainder = target - array[i];
            if(canSum(remainder,array) == true)
                return true;
        }

        return false;
    }

    static boolean canSumDp(int target, int[] array, Map<Integer,Boolean> targetMap){

        if(target == 0)
            return true;

        if(target < 0)
            return false;

        if(targetMap.get(target) != null)
            return targetMap.get(target);

        for(int i=0; i<array.length; i++)
        {
            int remainder = target - array[i];
            if(canSumDp(remainder,array,targetMap) == true)
            {
                targetMap.put(target,true);
                return true;
            }
        }

        targetMap.put(target,false);
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Fib using recursion :: " + fib(8));

        long fib[] = new long[1000];
        System.out.println("Fib using DP :: " + fibDp(50,fib));

        System.out.println("Grid traveller using recursion :: " + gridTraveller(4,3));

        int[][] grid = new int[5][4];
        System.out.println("Grid traveller using DP :: " + gridTravellerDp(4,3,grid));

        System.out.println("Can Sum using recursion :: " + canSum(8,new int[]{4,3,2,5}));

        System.out.println("Can Sum using DP :: " + canSumDp(300,new int[]{7,14},new HashMap<>()));

    }
}
