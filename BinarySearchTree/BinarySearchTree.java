package BinarySearchTree;

import java.lang.*;

class BSTNode
{
    int key;
    BSTNode left;
    BSTNode right;
    BSTNode(int k){
        key=k;
        left=right=null;
    }
}


class BinarySearchTree {

    public static BSTNode insert(BSTNode root, int x){
        BSTNode temp=new BSTNode(x);
        BSTNode parent=null,curr=root;
        while(curr!=null){
            parent=curr;
            if(curr.key>x)
                curr=curr.left;
            else if(curr.key<x)
                curr=curr.right;
            else
                return root;
        }
        if(parent==null)
            return temp;
        if(parent.key>x)
            parent.left=temp;
        else
            parent.right=temp;
        return root;
    }

    public static boolean search(BSTNode root, int x){
        while(root!=null){//iterative approach is better as it doesn't require auxiliary space
            if(root.key==x)
                return true;
            else if(root.key<x)
                root=root.right;
            else
                root=root.left;
        }
        return false;
    }

    static int findMin(BSTNode root) {
        if (root == null)
            return Integer.MAX_VALUE;

        int res = root.key;
        int lres = findMin(root.left);
        int rres = findMin(root.right);

        if (lres < res)
            res = lres;
        if (rres < res)
            res = rres;
        return res;
    }

    static int findMax(BSTNode root)
    {
        if (root == null)
            return Integer.MIN_VALUE;

        int res = root.key;
        int lres = findMax(root.left);
        int rres = findMax(root.right);

        if (lres > res)
            res = lres;
        if (rres > res)
            res = rres;
        return res;
    }

    public static BSTNode getPredecessor(BSTNode curr){
        curr=curr.left;
        while(curr!=null && curr.right!=null)
            curr=curr.right;
        return curr;
    }

    public static BSTNode getSuccessor(BSTNode curr){
        curr=curr.right;
        while(curr!=null && curr.left!=null)
            curr=curr.left;
        return curr;
    }

    public static BSTNode delNode(BSTNode root, int x){
        if(root==null)
            return root;
        if(root.key>x)
            root.left= delNode(root.left,x);
        else if(root.key<x)
            root.right= delNode(root.right,x);
        else{
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            else{
                BSTNode succ=getSuccessor(root);
                root.key=succ.key;
                root.right= delNode(root.right,succ.key);
            }
        }
        return root;
    }
    public static void main(String args[])
    {
        BSTNode root=new BSTNode(15);
        root.left=new BSTNode(5);
        root.left.left=new BSTNode(3);
        root.right=new BSTNode(20);
        root.right.left=new BSTNode(18);
        root.right.left.left=new BSTNode(16);
        root.right.right=new BSTNode(80);
        System.out.println("BST: ");
        inorder(root);
        System.out.println();
        System.out.println("BST after insertion of 21: ");
        root=insert(root,21);
        inorder(root);
        System.out.println();
        System.out.println("Result of search for 16: ");
        if(search(root,16))
            System.out.println("Found");
        else
            System.out.println("Not Found");
        System.out.println("Minimum: ");
        System.out.println(findMin(root));
        System.out.println("Maximum: ");
        System.out.println(findMax(root));
        System.out.println("Predecessor of 18:");
        BSTNode pre = getPredecessor(root.right.left);
        System.out.println(pre.key);
        System.out.println("Successor of 20: ");
        BSTNode suc = getSuccessor(root.right);
        System.out.println(suc.key);
        System.out.println("BST after deletion of 18: ");
        root=delNode(root,18);
        inorder(root);
    }

    public static void inorder(BSTNode root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.key+" ");
            inorder(root.right);
        }
    }
}
