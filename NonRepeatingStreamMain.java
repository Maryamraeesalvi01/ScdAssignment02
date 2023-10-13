package ScdAssignment02;
import java.util.*;
// Main for Checking First Non Repeating Value 
public class NonRepeatingStreamMain 
{
    public static void main(String[]args)
    {
        First_NonRepeating_Stream s = new First_NonRepeating_Stream();
        // adding value in the stream
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
  // List of stream
  private LinkedList <Character> cList;
  // Hashmap to get count of every charachter 
  private HashMap<Character,Integer> check;
  public First_NonRepeating_Stream()
  {
    cList  =new LinkedList<>();
    check  = new HashMap<>();
  }  
  public void add(char c )
  {
    cList.addLast(c);
    // charachter as a key and value as count 
    check.put(c, check.getOrDefault(c, 0)+1);
  }
  // checking nonrepeating integer 
  public char getFirstNonRepeating()
  {
    while(!cList.isEmpty())
    {
      // takes first charachter in the list 
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
