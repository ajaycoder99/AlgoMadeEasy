package sai;

//Implement your own stack, CharStack, using Linked list.
//You shall not use the default Linked List class from Java. 
//Element in CharStack is CharNode which contain a char.
// a
// b
// c

public class CharStack {
 protected CharNode top;
 
	public CharStack() {
     top = null;
 }
	
	// Initialize a new CharStack with a char. 
	// It means the stack will contain an element, a CharNode which carries the input char. 
	public CharStack(char c) {
        CharNode charNode = new CharNode(c);
        top = charNode;
    }

	// Initialize a new CharStack with a existing CharStack. It's copying the input CharStack and create a new one. 
	// Hint:
	// Do not modify the input CharStack
	public CharStack(CharStack cs) {
		// 2. Filling your code here
        CharStack tempStack = new CharStack();
        while (!cs.isEmpty())
        {
            tempStack.push(cs.pop());
        }
        System.out.println("Temp Stack :: " + tempStack.toString());
        CharStack newStack = new CharStack();
        while (!tempStack.isEmpty())
        {
            newStack.push(tempStack.pop());
        }
        this.top = newStack.top;
        // 2. End of code
    }
	
	// Create a CharStack. The stack shall contain all the charactors in input string.
	// Hint
	// The last char in string shall be at the top of the stack.
	public CharStack(String str) { // abcd
		// 3. Filling your code here
        char[] arr = str.toCharArray();
        CharStack stack = new CharStack(arr[0]);
        for(int i = 1; i< arr.length ; i++)
            stack.push(arr[i]);

        this.top = stack.top;
		// 3. End of code
 }
 // push a char to the top of the stack
 public void push(char x) {
     // 4. Filling your code here

     if(this.top == null){
         CharNode newNode = new CharNode(x);
         this.top = newNode;
     }
     else
     {
         CharNode newNode = new CharNode(x);
         newNode.setNext(top);
         this.top = newNode;
     }
		// 4. End of code
 }
 
	// pop the top char from the stack
	// Hint
	// For you convenience, you are not required to handle exception when poping a empty stack. 
	// It means when a stack is empty,  do nothing.
 public char pop() {
		// 5. Filling your code here
        if(top == null){
            System.out.println("Stack is Empty");
            return 0;
        }
        else
        {
            char c = top.getC();
            top = top.getNext();
            return c;
        }
		// 5. End of code
 }
	// return the char of the top element
 public char top() {
		// 6. Filling your code here
		return top.getC();
		// 6. End of code
 }
	// return true if the stack is empty, otherwise, return false;
 public boolean isEmpty() {
 	// 7. Filling your code here
		if(top == null)
		    return true;
		else
		    return false;
		// 7. End of code
 }
 // return the number of elements in the stack
	public int size(){
		// 8. Filling your code here
        int size = 0;
        CharNode temp = top;
		while(temp!=null)
        {
            size++;
            temp = temp.getNext();
        }
		return size;
		// 8. End of code
	}
	//  transfer the stack to a string and return it.
	// E.g. From bottom to the top, if the chars in stack are 'a', 'e', 'c', '!'. The return shall be "aec!" 
	public String toString() {
		// 9. Filling your code here
        System.out.print("Printing chars in String :: " );
        CharNode temp = top;
        StringBuffer sout = new StringBuffer(temp.getC());
        while (temp!=null){
            sout.append(temp.getC() + " ");
            temp = temp.getNext();
        }
        return sout.toString();
		// 9. End of code
	}

	public boolean checkIfValidParanthesis(String str)
    {
        char[] chars = str.toCharArray();
        CharStack stack = new CharStack();
        for(char c : chars)
        {
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            }
            else if(!stack.isEmpty() && ((c == '}' && stack.top() == '{') ||
                    (c == ')' && stack.top() == '(') ||
                    (c == ']' && stack.top() == '['))){
                stack.pop();
            }
            else {
                return false;
            }

        }

        if(stack.isEmpty())
            return true;
        else
            return false;

    }

    public static void main(String[] args) {
        CharStack stack = new CharStack();
        stack.push('a');
        stack.push('b');
        stack.push('c');
        stack.push('d');

        System.out.println("Size :: " + stack.size());

        System.out.println(stack.toString());
        System.out.println("Character Popped :: "+ stack.pop());

        CharStack stack1 = new CharStack(stack);
        System.out.println(stack1.toString());

        CharStack stack2 = new CharStack("abcd");
        System.out.println(stack2.toString());

        System.out.println("Top Element :: " + stack2.top());

        CharStack stack3 = new CharStack();
        System.out.println("Check if valid Para []{()}):: " + stack3.checkIfValidParanthesis("[([]{()})"));
    }
}



