package chap03.stacks;

import java.util.Scanner;

public class ValidSymbolPattern {

    public static boolean checkIfValidPattern(String pattern)
    {
        StackUsingLinkedList<Character> stack = new StackUsingLinkedList<>();
        for(char a : pattern.toCharArray())
        {
            if(a=='(' || a=='[')
                stack.push(a);
            else
            {
                Character c = stack.pop();
                Character fromStack = c;
                if(!((a==')' && fromStack=='(') || (a==']' && fromStack=='[')))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static void infixToPostfix(String pattern)
    {
        StackUsingLinkedList<Character> stack = new StackUsingLinkedList<Character>();
        for(char s : pattern.toCharArray())
        {
            if      (s=='+') stack.push(s);
            else if (s=='*') stack.push(s);
            else if (s==')') System.out.print(stack.pop() + " ");
            else if (s=='(') System.out.print("");
            else if (s==' ') {}
            else System.out.print(s + " ");
        }
        System.out.println();
    }

    public static Integer evaluatePostFix(String pattern)
    {
        StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<Integer>();
        String[] strings = pattern.split(" ");
        for(String s : strings)
        {
            if      (s.equals("+")) stack.push(stack.popWithNoPrint() + stack.popWithNoPrint());
            else if (s.equals("*")) stack.push(stack.popWithNoPrint() * stack.popWithNoPrint());
            else stack.push(Integer.parseInt(s));
        }
        return stack.popWithNoPrint();
    }

    public static void main(String[] args) {

        //System.out.println("Enter the elements :: ");
        //   ()(()[()])
        //Scanner scanner = new Scanner(System.in);
        //String input = scanner.next();
        //System.out.println("Perfect Pattern :: " + checkIfValidPattern(input));

        //System.out.println("Enter the elements For InfixToPostfix:: "); //  (((5+(7*(1+1)))*3)+(2*(1+1)))
        //input = scanner.next();
        //infixToPostfix(input);

        System.out.println(evaluatePostFix("7 16 * 5 + 16 * 3 + 16 * 1 +"));
    }
}
