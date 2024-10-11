import java.util.*;
public class Main {
	static class Node {
		int val;
        Node left;
        Node right;
	}

	static Scanner sc = new Scanner(System.in);
    public Node root;

    public Main() {
        root = createTree();
		bottomView(root);
    }
    private Node createTree() {
        int item = sc.nextInt();
        Node nn = new Node();
        nn.val = item;
        root = nn;

        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node rv = q.poll();
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();

            if (c1 != -1) {
                Node n = new Node();
                n.val = c1;
                rv.left = n;
                q.add(n);
            }
            if (c2 != -1) {
                Node n = new Node();
                n.val = c2;
                rv.right = n;
                q.add(n);
            }
        }

        return root;
    }
	static class Pair {
		Node node;
		int idx;
		public Pair(Node n, int i) {
			node = n;
			idx = i;
		}
	}
	private void bottomView(Node root) {
	    TreeMap<Integer, Integer> map = new TreeMap<>();
	    Queue<Pair> q = new ArrayDeque<>();
	    q.add(new Pair(root, 0));

	    while (!q.isEmpty()) {
		    Pair rv = q.poll();
		    Node nn = rv.node;
		    int idx = rv.idx;

			map.put(idx, nn.val);

			if (nn.left != null) 
				q.add(new Pair(nn.left, idx-1));
			if (nn.right != null)
				q.add(new Pair(nn.right, idx+1));
	    }

	    for (int key : map.keySet()) {
		   	System.out.print(map.get(key) + " " );
	    }
	} 
    public static void main(String args[]) {
		Main tt = new Main();

    }
}