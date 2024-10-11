import java.util.*;
public class Main {

    static class Node 
	{
        int d;
        Node l;
        Node r;

        Node(int x) 
		{
            d = x;
            l = null;
            r = null;
        }
    };

    static Scanner sc = new Scanner(System.in);

    static Node buildTree() {
        int x = sc.nextInt();
        Node root = new Node(x);

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty())
		 {

            Node n = q.poll();
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();

            if (c1 != -1) 
			{
                n.l = new Node(c1);
                q.add(n.l);
            }
            if (c2 != -1) 
			{
                n.r = new Node(c2);
                q.add(n.r);
            }
        }
        return root;
    }

    static void verticalPrint(Node root, Map<Integer, ArrayList<Integer>> m, int x) {
        if (root == null) 
            return;
        
        if (!m.containsKey(x)) 
          m.put(x, new ArrayList<>());
        m.get(x).add(root.d);

        verticalPrint(root.l, m, x - 1);
        verticalPrint(root.r, m, x + 1);
    }

    public static void main(String[] args) 
	{
        int n = sc.nextInt();
        Node root = buildTree();
        Map<Integer, ArrayList<Integer>> m = new TreeMap<>();
        verticalPrint(root, m, 0);
        for (int idx : m.keySet()) 
		{
			for (int v : m.get(idx))
			 {
				System.out.print(v + " ");
			}
		}
    }
}
