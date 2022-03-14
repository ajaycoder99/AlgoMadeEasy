package sai;

public class CharNode
{
	// Instead of implement a single function as before, You are required to design and implement the whole class. 
	// Design and implement your CharNode. It's a link node which contains a char
	// You can define any attributes or methods on your own
	// You will use your CharNode class in CharStack.
	// Filling your code here
	
	// End of your code

    private char c;
    private CharNode next;

    public CharNode(char c) {
        this.c = c;
        next = null;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public CharNode getNext() {
        return next;
    }

    public void setNext(CharNode next) {
        this.next = next;
    }
}
