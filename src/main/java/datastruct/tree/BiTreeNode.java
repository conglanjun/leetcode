package datastruct.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BiTreeNode {

    public String data;
    public BiTreeNode lchild = null;
    public BiTreeNode rchild = null;

    public BiTreeNode(String data) {
        this.data = data;
    }

    public void preOrder(BiTreeNode root) {
        if (root != null) {
            System.out.print(root.data + ",");
            preOrder(root.lchild);
            preOrder(root.rchild);
        }
    }

    public void inOrder(BiTreeNode root) {
        if (root != null) {
            inOrder(root.lchild);
            System.out.print(root.data + ",");
            inOrder(root.rchild);
        }
    }

    public void postOrder(BiTreeNode root) {
        if (root != null) {
            postOrder(root.lchild);
            postOrder(root.rchild);
            System.out.print(root.data + ",");
        }
    }

    public void levelOrder(BiTreeNode root) {
        Queue<BiTreeNode> queue = new LinkedList<BiTreeNode>();
        queue.offer(root);
        while (queue.peek() != null) {
            BiTreeNode poll = queue.poll();
            System.out.print(poll.data + ",");
            if (poll.lchild != null) {
                queue.offer(poll.lchild);
            }
            if (poll.rchild != null) {
                queue.offer(poll.rchild);
            }
        }
    }

    public static void main(String[] args) {
        BiTreeNode a = new BiTreeNode("A");
        BiTreeNode b = new BiTreeNode("B");
        BiTreeNode c = new BiTreeNode("C");
        BiTreeNode d = new BiTreeNode("D");
        BiTreeNode e = new BiTreeNode("E");
        BiTreeNode f = new BiTreeNode("F");
        BiTreeNode g = new BiTreeNode("G");

        e.lchild = a;
        e.rchild = g;
        a.rchild = c;
        c.lchild = b;
        c.rchild = d;
        g.rchild = f;

        BiTreeNode root = e;
        System.out.println(root.lchild.rchild.data);

        root.preOrder(root);
        System.out.println();
        root.inOrder(root);
        System.out.println();
        root.postOrder(root);
        System.out.println();
        root.levelOrder(root);
    }
}
