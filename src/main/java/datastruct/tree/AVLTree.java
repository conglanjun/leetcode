package datastruct.tree;

import java.util.Arrays;
import java.util.List;

class AVLNode extends BTreeNode{

    public int bf;
    public AVLNode(String data) {
        super(data);
        this.bf = 0;
    }
}

public class AVLTree extends BST {

    public AVLTree(List<String> li) {
        super(li);
    }

    @Override
    public void insertNoRec(String val) {
        AVLNode p = (AVLNode) this.root;
        if (p == null) {
            this.root = new AVLNode(val);
            return;
        }
        AVLNode node = null;
        while (true) {
            if (p.data.compareTo(val) > 0) {
                if (p.lchild == null) {
                    p.lchild = new AVLNode(val);
                    p.lchild.parent = p;
                    node = (AVLNode) p.lchild;
                    break;
                }
                p = (AVLNode) p.lchild;
            } else if (p.data.compareTo(val) < 0) {
                if (p.rchild == null) {
                    p.rchild = new AVLNode(val);
                    p.rchild.parent = p;
                    node = (AVLNode) p.rchild;
                    break;
                }
                p = (AVLNode) p.rchild;
            } else {
                return;
            }
        }
        while (node.parent != null) {
            AVLNode g = (AVLNode) node.parent.parent;
            AVLNode x = (AVLNode) node.parent;
            AVLNode rotatedNode = null;
            if (node.parent.lchild == node) { // inserted node from lchild
                if (((AVLNode)node.parent).bf < 0) { // node's parent left > right, change -1 to -2, you need to rotate tree.
                    if (node.bf > 0) {
                        rotatedNode = rotateLeftRight((AVLNode) node.parent, node);
                    } else {
                        rotatedNode = rotateRight((AVLNode)node.parent, node);
                    }
                } else if (((AVLNode)node.parent).bf > 0) { // from 1 to 0
                    ((AVLNode) node.parent).bf = 0;
                    break;
                } else { // from 0 to -1
                    ((AVLNode) node.parent).bf = -1;
                    node = (AVLNode) node.parent;
                    continue;
                }
            } else { // right add node. so bf need to be add 1
                if (((AVLNode)node.parent).bf > 0) { // from 1 to 2, need to rotate
                    if (node.bf < 0) {
                        rotatedNode = rotateRightLeft((AVLNode)node.parent, node);
                    } else {
                        rotatedNode = rotateLeft((AVLNode)node.parent, node);
                    }
                } else if (((AVLNode)node.parent).bf < 0) {// from -1 to 0
                    ((AVLNode) node.parent).bf = 0;
                    break;
                } else { // from 0 to 1
                    ((AVLNode) node.parent).bf = 1;
                    node = (AVLNode) node.parent;
                    continue;
                }
            }
            if (rotatedNode != null) {
                rotatedNode.parent = g;
                if (g != null) {
                    if (g.lchild == x) {
                        g.lchild = rotatedNode;
                    } else {
                        g.rchild = rotatedNode;
                    }
                } else {
                    this.root = rotatedNode;
                }
                break;
            }
        }
    }

    public AVLNode rotateLeft(AVLNode p, AVLNode c) {
        AVLNode s2 = (AVLNode) c.lchild;
        p.rchild = s2;
        if (s2 != null) {
            s2.parent = p;
        }
        c.lchild = p;
        p.parent = c;

        p.bf = 0;
        c.bf = 0;
        return c;
    }

    public AVLNode rotateRight(AVLNode p, AVLNode c) {
        AVLNode s2 = (AVLNode) c.rchild;
        p.lchild = s2;
        if (s2 != null) {
            s2.parent = p;
        }
        c.rchild = p;
        p.parent = c;

        c.bf = 0;
        p.bf = 0;
        return c;
    }

    public AVLNode rotateRightLeft(AVLNode p, AVLNode c) {
        AVLNode g = (AVLNode) c.lchild;
        AVLNode s3 = (AVLNode) g.rchild;

        c.lchild = s3;
        if (s3 != null) {
            s3.parent = c;
        }

        g.rchild = c;
        c.parent = g;

        AVLNode s2 = (AVLNode) g.lchild;

        p.rchild = s2;
        if (s2 != null) {
            s2.parent = p;
        }

        g.lchild = p;
        p.parent = g;

        if (g.bf > 0) {
            c.bf = 0;
            p.bf = -1;
        } else if (g.bf < 0) {
            c.bf = 1;
            p.bf = 0;
        } else {
            c.bf = 0;
            p.bf = 0;
        }
        g.bf = 0;
        return g;
    }

    public AVLNode rotateLeftRight(AVLNode p, AVLNode c) {
        AVLNode g = (AVLNode) c.rchild;
        AVLNode s2 = (AVLNode) g.lchild;
        c.rchild = s2;
        if (s2 != null) {
            s2.parent = c;
        }
        g.lchild = c;
        c.parent = g;

        AVLNode s3 = (AVLNode) g.rchild;
        p.lchild = s3;
        if (s3 != null) {
            s3.parent = p;
        }
        g.rchild = p;
        p.parent = g;

        if (g.bf > 0) {
            p.bf = 0;
            c.bf = -1;
        } else if (g.bf < 0) {
            p.bf = 1;
            c.bf = 0;
        }
        g.bf = 0;
        return g;
    }

    public static void main(String[] args) {
        String[] strs = {"9", "8", "7", "6", "5", "4", "3", "2", "1"};
        List<String> li = Arrays.asList(strs);
        AVLTree tree = new AVLTree(li);
        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
    }
}












