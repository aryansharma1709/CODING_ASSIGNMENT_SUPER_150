import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        BT bt = new BT(a);
        
        bt.topView();
    }


	
}

class BT {
    private class Node {
        int v;
        Node l, r;
        Node(int v) {
            this.v = v;
        }
    }

    Node root;

    BT(String[] a) {
        Queue<Node> q = new LinkedList<>();
        build(a, 0, q);
    }

    public void topView() {
        verticalTop(this.root);
    }

	class P {
		Node n;
		int i;
		public P(Node n, int i) {
			this.n = n;
			this.i = i;
		}
	}

    private void verticalTop(Node root) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        Queue<P> q = new ArrayDeque<>();
        q.add(new P(root, 0));

        while (!q.isEmpty()) {
            P p = q.poll();
            Node nn = p.n;
            int idx = p.i;

            if (!m.containsKey(idx)) 
                m.put(idx, nn.v);

            if (nn.l != null) 
                q.add(new P(nn.l, idx - 1));
            if (nn.r != null) 
                q.add(new P(nn.r, idx + 1));
        }

        for (int k : m.keySet()) 
		{
            if (m.get(k) != -1)
                System.out.print(m.get(k) + " ");
        }
    }

    private void build(String[] a, int idx, Queue<Node> q) {
        if (idx >= a.length)
            return;
        if (q.size() == 0) {
            Node nn = new Node(Integer.parseInt(a[idx]));
            this.root = nn;
            q.add(nn);
        }
		 else 
		 {
            Node p = q.peek();
            if (p.v != -1)
			 {
                if (p.l == null)
				 {
                    p.l = new Node(Integer.parseInt(a[idx]));
                    q.add(p.l);
                } 
				else 
				{
                    if (p.r == null)
					 {
                        p.r = new Node(Integer.parseInt(a[idx]));
                        q.add(p.r);
                        q.poll();
                    }
                }
            } 
			else {
                q.poll();
                idx--;
            }
        }
        build(a, idx + 1, q);
    }

    public void show() {
        displayTree(this.root);
    }

    private void displayTree(Node root)
	 {
        if (root == null)
            return;
        String s = root.v + "";
        if (root.l != null) 
		{
            s = root.l.v + " <= " + s;
        }
		 else 
		{
            s = "END <= " + s;
        }

        if (root.r != null) 
		{
            s = s + " => " + root.r.v;
        }
		 else {
            s = s + " => END";
        }
        System.out.println(s);
        displayTree(root.l);
        displayTree(root.r);
    }
}
