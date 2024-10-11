import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());  // max-Heap
            PriorityQueue<Integer> right = new PriorityQueue<>();                           // min-Heap

            while (n-- > 0) {
                int item = sc.nextInt();                
                if (left.isEmpty())                     // adding the item
                    left.add(item);
                else if (item > left.peek()) 
                    right.add(item);
                else 
                    left.add(item);
                
                if (left.size() > right.size()+1)       // balancing the size of left and right heaps 
                    right.add(left.poll());
                else if (right.size() > left.size()) 
                    left.add(right.poll());

                System.out.print(medianFun(left, right) + " ");
            }
            System.out.println();
        }

    }
    public static int medianFun(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        if (left.size() == right.size())
            return (left.peek() + right.peek())/2;
        return left.peek();
    }
}