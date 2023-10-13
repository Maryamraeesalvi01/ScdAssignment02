package ScdAssignment02;
import java.util.*;
//  class to handle two types of excepption
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
// Node class 
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
// generic Stack Class with push pull isempty and getsize
class genericStack<t>
{
    Scanner scanner = new Scanner(System.in);
    private node<t>top;
    private int size;
    public genericStack()
    {
        top=null;
        //size=0;
    }
    public void push(int size,t s)
    {
        node<t> newnode=new node<>(s);
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
    /* public void addvalues()
    {
        for(int i=0; i<=size; i++)
    {
        if(scanner.hasNextInt())
        {
         
        int s=scanner.nextInt();
        push(size,s);
        System.out.println("Value Pushed Into Stack!");
        }
    }
    } */
}
// Main with integer type stack
public class StackMain 
{
   public static void main(String[]args)
   {
    genericStack<Integer> stack1=new genericStack<>();
    Scanner scanner = new Scanner(System.in);
    int size ;
    System.out.println("Enter Stack size: ");
    size=scanner.nextInt();
    System.out.println("Enter Stack Vaalues: ");
    // taking values in int form and giving illegalinputtype exception
    for(int i=0; i<=size; i++)
    {
        if(scanner.hasNextInt())
        {
        int s=scanner.nextInt();
        stack1.push(size,s);
        System.out.println("Value Pushed Into Stack!");
        }
        else
        {
            ExceptionalHandling.throwInvalidInputException("Error: Invalid Input - Please provide an integer value.");
            //scanner.nextLine();
            //i--;
        }
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
            int popedValue;
            popedValue=stack1.pop();
            System.out.println("Value Poped From The Stack!");
        }catch(EmptyStackException E)
        {
            System.err.println("Error: EmptyStackException - cannot pop from empty Stack");
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
