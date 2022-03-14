package sai;

import java.io.IOException;

public class NodeStacking {
    // use this weight for calculating
    public static int weight = 128;

    /**
     * Implement a recursive method that takes row index and column index of a node.
     * calculate the weight it supports.
     */
    static double sum = 0;
    public static double weightSupporting(int row, int col) {

        if (row < 0 || col < 0 || col > row)
            return 0;

        sum = weightSupporting(row - 1, col - 1) + weightSupporting(row - 1, col);
        System.out.println("row :: " + row + " col :: " + col);
        sum = sum + 64;
        System.out.println("sum :: " + sum);
        return sum;
    }

    public static void main(String[] args) throws IOException {

        System.out.println(weightSupporting(1, 1));
    }
}
