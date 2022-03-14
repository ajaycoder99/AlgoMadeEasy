package chap03.stacks;

public class AdvanceStack extends IntegerStack{

    private IntegerStack stack = new IntegerStack();
    private IntegerStack minStack = new IntegerStack();

    public void push(int data)
    {
        if(stack.isEmpty())
        {
            stack.push(data);
            minStack.push(data);
        }
        else
        {
            stack.push(data);
            if(minStack.top() > data)
            {
                minStack.push(data);
            }
            else
            {
                minStack.push(minStack.top());
            }
        }
    }

    public int pop()
    {
        if(stack.isEmpty())
            return Integer.MIN_VALUE;
        else
        {
            minStack.pop();
            return stack.pop();
        }
    }

    public int getMin()
    {
        return minStack.pop();
    }

    public static void main(String[] args) {
        AdvanceStack advanceStack = new AdvanceStack();
        advanceStack.push(2);
        advanceStack.push(6);
        advanceStack.push(4);
        advanceStack.push(1);
        advanceStack.push(5);
        advanceStack.stack.printStack();
        advanceStack.minStack.printStack();

        System.out.println("  Min :: " + advanceStack.getMin());

        advanceStack.pop();advanceStack.pop();
        System.out.println("  Min :: " + advanceStack.getMin());

        advanceStack.pop();
        System.out.println("  Min :: " + advanceStack.getMin());
    }
}
