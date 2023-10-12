package ScdAssignment02;
import java.util.*;
public class NonRepeatingStreamMain 
{
    public static void main(String[]args)
    {
        First_NonRepeating_Stream s = new First_NonRepeating_Stream();
        s.add('a');
        s.add('b');
        s.add('a');
        System.out.println("Stream: ['a','b','a'] First non-repeating character in this stream is : "+s.getFirstNonRepeating());
        s.add('b');
        System.out.println("Stream: ['a','b','a','b'] First non-repeating character in this stream is : "+ s.getFirstNonRepeating());

    }
}
class First_NonRepeating_Stream
{
  private LinkedList <Character> cList;
  private HashMap<Character,Integer> check;
  public First_NonRepeating_Stream()
  {
    cList  =new LinkedList<>();
    check  = new HashMap<>();
  }  
  public void add(char c )
  {
    cList.addLast(c);
    check.put(c, check.getOrDefault(c, 0)+1);
  }
  public char getFirstNonRepeating()
  {
    while(!cList.isEmpty())
    {
        char firstnonrepeating=cList.getFirst();
        if(check.get(firstnonrepeating)==1)
        {
           return firstnonrepeating;
        }
        else
        {
            cList.removeFirst();
        }
    }
    return '-';
  }
}
