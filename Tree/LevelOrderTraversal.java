import java.util.*;
import java.io.*;
import java.lang.*;

class LOTNode
{
    int key;
    LOTNode left;
    LOTNode right;
    LOTNode(int k){
        key=k;
        left=right=null;
    }
}


class LevelOrderTraversal {

    public static void main(String args[])
    {
        LOTNode root=new LOTNode(10);
        root.left=new LOTNode(20);
        root.right=new LOTNode(30);
        root.left.left=new LOTNode(40);
        root.left.right=new LOTNode(50);
        root.right.left=new LOTNode(60);
        root.right.right=new LOTNode(70);

        printLevel(root);
    }

    public static void printLevel(LOTNode root){
        if(root==null)return;
        Queue<LOTNode> q=new LinkedList<>();
        q.add(root);
        while(q.isEmpty()==false){
            LOTNode curr=q.poll();
            System.out.print(curr.key+" ");
            if(curr.left!=null)
                q.add(curr.left);
            if(curr.right!=null)
                q.add(curr.right);
        }
    }
} 