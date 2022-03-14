package chap01.recursion;

public class AllPathsInGrid {

    //recursive method to find total no.paths to travel from top left corner to bottom right corner in a n*m grid
    static int path(int n, int m) {
        if(n == 1 || m == 1) return 1;

        return path(n, m-1) + path(m, n-1);
    }

    public static void main(String[] args) {
        System.out.println(path(3, 3));
    }
}
