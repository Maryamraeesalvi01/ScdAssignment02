package ScdAssignment02;
import java.util.*;
public class MergeIntervalMain 
{
    public static void main(String[]args)
    {
    List<int[]> listofintervals = new ArrayList<>();
    //adding intervals into the list 
    listofintervals.add(new int[] {1, 3});
    listofintervals.add(new int[] {2, 6});
    listofintervals.add(new int[] {8, 10});
    listofintervals.add(new int[] {15, 18});
    // merging 
    merge_intervals.merge_intervals(listofintervals);
    // i = interval
    for (int[] i : listofintervals) 
    {
        System.out.println("[" + i[0] + ", " + i[1] + "]");
    } 
    }
}
// class to merge intervals those are overlapping 
class merge_intervals
{
public static void  merge_intervals(List<int[]> intervals) 
{
    int sizeofinterval= intervals.size();
    // ind=index
    int ind = 0;
    if (intervals == null || intervals.isEmpty()) 
    {
        //if empty interval list
        return;
    }
    
    for (int i = 1; i <sizeofinterval; i++) 
    {
        // two pointers that iterates once to merge list
        int[] currentInterval = intervals.get(i);
        int[] previousInterval = intervals.get(ind);
        if (currentInterval[0] <= previousInterval[1]) 
        {
            previousInterval[1] = Math.max(previousInterval[1], currentInterval[1]);
        } 
        else 
        {
            ind++;
            intervals.set(ind, currentInterval);
        }
    }
    intervals.subList(ind + 1, sizeofinterval).clear();
    //return intervals;
}
}