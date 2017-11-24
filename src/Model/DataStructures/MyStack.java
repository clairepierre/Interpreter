package Model.DataStructures;



import java.util.Stack;

public class MyStack<T> implements MyIStack<T> {
    Stack<T> stack;

    public <T> MyStack(){stack=new Stack<>();}

    @Override
    public T pop(){return stack.pop();}

    @Override
    public void push(T el){stack.push(el);}

    @Override
    public boolean isEmpty(){return stack.isEmpty();}

    @Override
    public String toString()
    {
        String s="{";
        for (int i=stack.size()-1;i>=0;i--)
        {
            s+=stack.elementAt(i).toString()+"|";
        }
        if(s.length()==1)
            return"{}";
        return s.substring(0,s.length()-1)+"}";
    }

}
