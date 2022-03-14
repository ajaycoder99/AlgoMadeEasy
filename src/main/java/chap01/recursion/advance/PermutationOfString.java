package chap01.recursion.advance;

import java.util.HashSet;
import java.util.Set;

public class PermutationOfString<T> {

    static Set<String> set = new HashSet<>();

    static void permutations(String s, int l, int r) {
        if(l == r) {
            if(set.contains(s)) return;
            set.add(s);
            System.out.println(s);
            return;
        }

        for(int i = l; i<=r; i++) {
            s = interchangeChar(s, l, i);
            permutations(s, l+1, r);
            s = interchangeChar(s, l, i);
        }
    }

    static String interchangeChar(String s, int a, int b) {
        char array[] = s.toCharArray();
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
        return String.valueOf(array);
    }

    public void printAllRecursive(int n, T[] elements) {

        if(n == 1) {
            printArray(elements);
        } else {
            for(int i = 0; i < n-1; i++) {
                printAllRecursive(n - 1, elements);
                if(n % 2 == 0) {
                    swap(elements, i, n-1);
                } else {
                    swap(elements, 0, n-1);
                }
            }
            printAllRecursive(n - 1, elements);
        }
    }

    private void printArray(T[] input) {
        System.out.print('\n');
        for(int i = 0; i < input.length; i++) {
            System.out.print(input[i]);
        }
    }

    private void swap(T[] input, int a, int b) {
        T tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    public static void main(String[] args) {

        PermutationOfString<Character> object = new PermutationOfString<>();
        Character[] abc = new Character[4];
        abc[0]='a';abc[1]='b';abc[2]='c';abc[3]='d';
        object.printAllRecursive(3, abc);
        System.out.println("\n\n\n");
        permutations("abcc", 0, 3);
    }
}
