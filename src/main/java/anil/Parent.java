package anil;

import java.util.Arrays;
import java.util.List;

/**
 * The question is: if I write forList(Array.asList(0,1,2,3,4,5,6)).elemAt(3).shouldBe(equalsTo(3)); in main, it should execute and return true
 */
public class Parent {

    public static boolean toList(List abc)
    {
        return true;
    }
}

class Child extends Parent{

    public static void main(String[] args) {
        //forList(Array.asList(0,1,2,3,4,5,6)).elemAt(3).shouldBe(equalsTo(3));
        toList(Arrays.asList(1,2,3,4,5,6));
    }
}

class A  extends Parent{

    public static void elementAt(int a)
    {

    }
}