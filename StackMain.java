package ScdAssignment02;
import java.util.*;
class ExceptionalHandling
{
    public static void throwEmptyStackException()
    {
        throw new EmptyStackException();
    }
    public static void throwInvalidInputException(String m)
    {
        throw new IllegalArgumentException(m);
    }
}
class node<t>
{
    t data;
    node<t> next;
    public node(t data)
    {
        this.data=data;
        this.next=null;
    }
}
class genericStack<t>
{
    private node<t>top;
    private int size;
    public genericStack()
    {
        top=null;
        //size=0;
    }
    public void push(int size,t value)
    {
        node<t> newnode=new node<>(value);
        newnode.next=top;
        top=newnode;
        this.size=size;
    }
    public boolean isempty()
    {
        return top.next==null;
    }
    public int size()
    {
        
        return size;
    }
    public t pop()
    {
        if (isempty())
        {
            ExceptionalHandling.throwEmptyStackException();
        }
        t value=top.data;
        top=top.next;
        size--;
        return value;
    }
}
public class StackMain 
{
   public static void main(String[]args)
   {
    genericStack<String> stack1=new genericStack<>();
    Scanner scanner = new Scanner(System.in);
    int size ;
    System.out.println("Enter Stack size: ");
    size=scanner.nextInt();
    System.out.println("Enter Stack Vaalues: ");
    for(int i=0; i<=size; i++)
    {
        String s=scanner.nextLine();
        stack1.push(size,s);
        System.out.println("Value Pushed Into Stack!");
    }
    int choice;
    boolean Quit=false;
        while(!Quit)
        {
        System.out.println("----Stack Menu----");
        System.out.println("1->Pop");
        System.out.println("2->Size");
        System.out.println("3->isEmpty");
        System.out.println("4->Quit");
        System.out.println("Enter choice : ");
        choice=scanner.nextInt();
        switch(choice)
        {
        case 1:
        try
        {
            String popedValue;
            popedValue=stack1.pop();
            System.out.println("Value Poped From The Stack!");
        }catch(EmptyStackException E)
        {
            System.err.println("Error: EmptyStackExceptionc - cannot pop from empty Stack");
        }
        break;
        case 2:
        System.out.println("Size Of The Stack : "+ stack1.size());
        break;
        case 3:
        System.out.println("Stack is Empty : "+stack1.isempty());
        break;
        case 4:
        Quit=true;
        System.out.println("Quiting!");
        break;
        default:
        System.out.println("Invalid Choice!!");
        }
    }
    scanner.close();
  } 
}   
