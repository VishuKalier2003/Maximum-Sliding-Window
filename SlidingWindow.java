/* Maximum Window Substring problem... Given an array of Integers and a value k... Find the maximum out of the k integers of the given array in a sequential fashion...
 * Given string = [1, 2, 4, -1, 4, 5] and k = 3
 * Output:-
 * [1, 2, 4]   4
 * [2, 4, -1]  4
 * [4, -1, 4]  4
 * [-1, 4, 5]  5
*/
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
public class SlidingWindow
{
    public void MaximumWindow(int arr[], int k, Queue<Integer> q)
    {
        int l = arr.length;
        for(int i = 0; i < (l-k)+1; i++)
        {
            for(int j = 0; j < k; j++)
            {
                int x = arr[j+i];    // Combined Index positioning...
                if(!q.isEmpty())
                {
                    if(q.peek() < x)    // It works on FIFO preference (First In First Out)...
                    {
                        q.remove();     // Removing the head...
                        q.add(x);       // inserting new head...
                    }
                }
                else
                    q.add(x);    // If queue is empty...
            }
            System.out.println("Max of "+i+" term : "+q.peek());
            while(!q.isEmpty())     // Emptying the queue again...
                q.remove();
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();    // Queue created as Linked List Interface...
        int x, a, k;
        System.out.print("Enter the size of array : ");
        x = sc.nextInt();
        int array[] = new int[x];
        for(int i = 0; i < x; i++)
        {
            System.out.print("Enter "+(i+1)+" th value : ");
            a = sc.nextInt();
            array[i] = a;
        }
        System.out.print("Enter the size of the window : ");
        k = sc.nextInt();
        System.out.println("The Array formed is : ");
        for(int i = 0; i < x; i++)
            System.out.print(array[i]+", ");
        System.out.println();
        SlidingWindow window = new SlidingWindow();        // object creation...
        window.MaximumWindow(array, k, queue);
        sc.close();
    }
}