package datastruct.tree;

import java.util.Arrays;
import java.util.List;

class BTreeNode {
    public String data;
    public BTreeNode lchild;
    public BTreeNode rchild;
    public BTreeNode parent;

    public BTreeNode(String data) {
        this.data = data;
    }
}

public class BST {

    public BTreeNode root;

    public BST(List<String> li) {
        this.root = null;
        if (li != null) {
            for (int i = 0; i < li.size(); ++i) {
                insertNoRec(li.get(i));
            }
        }
    }

    public BTreeNode insert(BTreeNode node, String val) {
        if (node == null) {
            node = new BTreeNode(val);
        } else if (val.compareTo(node.data) < 0) {
            node.lchild = insert(node.lchild, val);
            node.lchild.parent = node;
        } else if (val.compareTo(node.data) > 0) {
            node.rchild = insert(node.rchild, val);
            node.rchild.parent = node;
        }
        return node;
    }

    public void insertNoRec(String val) {
        BTreeNode p = this.root;
        if (p == null) {
            this.root = new BTreeNode(val);
            return;
        }
        while (true) {
            if (val.compareTo(p.data) < 0) {
                if (p.lchild == null) {
                    p.lchild = new BTreeNode(val);
                    p.lchild.parent = p;
                    return;
                }
                p = p.lchild;
            } else if (val.compareTo(p.data) > 0){
                if (p.rchild == null) {
                    p.rchild = new BTreeNode(val);
                    p.rchild.parent = p;
                    return;
                }
                p = p.rchild;
            } else {
                return;
            }
        }
    }

    public BTreeNode query(BTreeNode node, String val) {
        if (node == null) {
            return null;
        }
        if (node.data.compareTo(val) < 0) {
            return query(node.rchild, val);
        } else if (node.data.compareTo(val) > 0) {
            return query(node.lchild, val);
        } else {
            return node;
        }
    }

    public BTreeNode queryNoRec(String val) {
        BTreeNode p = this.root;
        while (p != null) {
            if (p.data.compareTo(val) < 0) {
                p = p.rchild;
            } else if (p.data.compareTo(val) > 0) {
                p = p.lchild;
            } else {
                return p;
            }
        }
        return null;
    }

    private void removeLeave(BTreeNode node) {
        if (node.parent == null) { // root
            this.root = null;
        } else if (node == node.parent.lchild) { //  lchild
            node.parent.lchild = null;
        } else {
            node.parent.rchild = null;
        }
    }

    /**
     * node only has lchild
     */
    private  void removeMid1(BTreeNode node) {
        if (node.parent == null) {
            this.root = node.lchild;
            node.lchild.parent = null;
        } else if (node.parent.lchild == node) {
            node.parent.lchild = node.lchild;
            node.lchild.parent = node.parent;
        } else {
            node.parent.rchild = node.lchild;
            node.lchild.parent = node.parent;
        }
    }

    /**
     * node only has rchild
     */
    private void removeMid2(BTreeNode node) {
        if (node.parent == null) {
            this.root = node.rchild;
            node.rchild.parent = null;
        } else if (node.parent.lchild == node) {
            node.parent.lchild = node.rchild;
            node.rchild.parent = node.parent;
        } else{
            node.parent.rchild = node.rchild;
            node.rchild.parent = node.parent;
        }
    }

    public void delete(String val) {
        if (this.root == null) {
            return;
        }
        BTreeNode node = queryNoRec(val);
        if (node == null) { // not exist!
            return;
        }
        if (node.lchild == null && node.rchild == null) { // node is leave!
            removeLeave(node);
        } else if (node.rchild == null) { // node only has lchild
            removeMid1(node);
        } else if (node.lchild == null) { // node only has rchild
            removeMid2(node);
        } else { // node have rchild and lchild
            BTreeNode minNode = node.rchild;
            while (minNode.lchild != null) {
                minNode = minNode.lchild;
            }
            node.data = minNode.data;
            if (minNode.rchild != null) {
                removeMid2(minNode);
            } else {
                removeLeave(minNode);
            }
        }
    }

    public void preOrder(BTreeNode root) {
        if (root != null) {
            System.out.print(root.data + ",");
            preOrder(root.lchild);
            preOrder(root.rchild);
        }
    }

    public void inOrder(BTreeNode root) {
        if (root != null) {
            inOrder(root.lchild);
            System.out.print(root.data + ",");
            inOrder(root.rchild);
        }
    }

    public void postOrder(BTreeNode root) {
        if (root != null) {
            postOrder(root.lchild);
            postOrder(root.rchild);
            System.out.print(root.data + ",");
        }
    }

    public static void main(String[] args) {
        String[] strs = {"4", "6", "7", "9", "2", "1", "3", "5", "8"};
        List<String> li = Arrays.asList(strs);
        BST bst = new BST(li);
        bst.preOrder(bst.root);
        System.out.println();
        bst.inOrder(bst.root);
        System.out.println();
        bst.postOrder(bst.root);

        System.out.println();
        System.out.println(bst.queryNoRec("11"));
        System.out.println(bst.query(bst.root, "4").data);

        String[] strs1 = {"1", "4", "2", "5", "3", "8", "6", "9", "7"};
        List<String> li1 = Arrays.asList(strs1);
        BST bst1 = new BST(li1);
        System.out.println();
        bst1.inOrder(bst1.root);
        System.out.println();
        bst1.delete("4");
        bst1.delete("1");
        bst1.inOrder(bst1.root);
    }
}
