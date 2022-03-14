package InterviewsGiven;

import java.util.Scanner;

public class RahIndiaTest {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number 1:: ");
        Integer number1 = scanner.nextInt();
        System.out.println("Enter Number 2:: ");
        Integer number2  = scanner.nextInt();
        scanner.close();

        //System.out.println(isPalindrome(number));
        //System.out.println(isArmstrong(number));
        System.out.println(HCF(number1,number2));
    }

    public static boolean isPalindrome(Integer number)
    {
        String num = number.toString();
        char[] charArray = num.toCharArray();

        if(charArray.length == 1)
            return true;

        if(charArray.length == 2)
        {
            if(charArray[0] == charArray[1])
                return true;
            else
                return false;
        }

        for(int i = 0; i < charArray.length / 2 ; i++)
        {
            if(!(charArray[i] == charArray[charArray.length - 1 - i]))
            {
                return false;
            }
        }
        return true;
    }

    public static boolean isArmstrong(Integer number){

        Integer a,b,c=0;
        b = number;

        while(number > 0){
            a = number % 10;
            number = number / 10;
            c = c + (a * a * a);
        }

        if(b.compareTo(c) == 0)
            return true;
        else
            return false;

    }

    public static Integer HCF(Integer num1, Integer num2){
        if(num2 == 0)
            return num1;
        return HCF(num2,num1%num2);
    }
}



