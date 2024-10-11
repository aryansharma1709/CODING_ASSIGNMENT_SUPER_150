import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] arr=br.readLine().split(" ");
        BinaryTree bt=new BinaryTree(arr);
        
        bt.topview();
        
    }
}

class BinaryTree
{
    private class Node
    {
        int data;
        Node left,right;
        Node(int data)
        {
            this.data=data;
        }
    }

    Node root;

    BinaryTree(String[] arr)
    {
        Queue<Node> queue=new LinkedList<Node>();
        construct(arr,0,queue);
    }

    public void topview()
    {
        verticalTraversalTop(this.root);
    }
	class Pair {
		Node node;
		int idx;
		public Pair(Node n, int i) {
			node = n;
			idx = i;
		}
	}

   private void verticalTraversalTop(Node root) {
	   TreeMap<Integer, Integer> map = new TreeMap<>();
	   Queue<Pair> q = new ArrayDeque<>();
	   q.add(new Pair(root, 0));

	   while (!q.isEmpty()) {
		   Pair rv = q.poll();
		   Node nn = rv.node;
		   int idx = rv.idx;

		   if (!map.containsKey(idx))
			  map.put(idx, nn.data);

			if (nn.left != null) 
				q.add(new Pair(nn.left, idx-1));
			if (nn.right != null)
				q.add(new Pair(nn.right, idx+1));
	   }

	   for (int key : map.keySet()) {
		   if (map.get(key) != -1)
		   	   System.out.print(map.get(key) + " ");
	   }
   }


    private void construct(String[] arr,int ind,Queue<Node> queue)
    {
        if(ind>=arr.length)
        return;
        if(queue.size()==0)
        {
            Node nn=new Node(Integer.parseInt(arr[ind]));
            this.root=nn;
            queue.add(nn);
        }
        else
        {
            Node parent=queue.peek();
                if(parent.data!=-1){
                if(parent.left==null)
                {
                    parent.left=new Node(Integer.parseInt(arr[ind]));
                    queue.add(parent.left);
                }
                else
                {
                    if(parent.right==null)
                    {
                    parent.right=new Node(Integer.parseInt(arr[ind]));
                    queue.add(parent.right);
                    queue.poll();
                    }
               }
               }
               else
               {
                   queue.poll();
                   ind--;
               }
        }
        construct(arr,ind+1,queue);
    }

    public void display()
    {
        display_tree(this.root);
    }

    private void display_tree(Node root)
    {
        if(root==null)
        return;
        String str=root.data+"";
        if(root.left!=null)
        {
            str=root.left.data+" <= "+str;
        }
        else
        {
            str="END <= "+str;
        }

        if(root.right!=null)
        {
            str=str+" => "+root.right.data;
        }
        else
        {
            str=str+" => END";
        }
        System.out.println(str);
        display_tree(root.left);
        display_tree(root.right);

    }


}