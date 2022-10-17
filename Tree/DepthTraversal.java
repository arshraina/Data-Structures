package Tree;

class DTNode{
    int key;
    DTNode left;
    DTNode right;
    DTNode(int key){
        this.key = key;
    }
}
public class DepthTraversal {
    static void inorder(DTNode root) {
        if(root!=null) {
            inorder(root.left);
            System.out.print(root.key+" ");
            inorder(root.right);
        }
    }
    static void preorder(DTNode root) {
        if(root!=null) {
            System.out.print(root.key+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    static void postorder(DTNode root) {
        if(root!=null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key+" ");
        }
    }
    static int height(DTNode root){
        if(root==null){
            return 0 ;
        }
        else{
            return Math.max(height(root.left),height(root.right))+1;
        }
    }
    static void printKDist(DTNode root, int k){
        if(root == null){
            return;
        }
        if(k==0) {
            System.out.println(root.key+" ");
        }
        else{
            printKDist(root.left, k-1);
            printKDist(root.right, k-1);
        }
    }
    public static void main(String[] args) {
        DTNode root = new DTNode(10);
        root.left = new DTNode(20);
        root.right = new DTNode(30);
        root.right.left = new DTNode(40);
        root.right.right = new DTNode(50);
        System.out.println("Inorder: ");
        inorder(root);
        System.out.println("\nPreorder: ");
        preorder(root);
        System.out.println("\nPostorder: ");
        postorder(root);
        System.out.println("\nHeight: ");
        System.out.println(height(root));
        System.out.println("\nDTNodes at distance 2: ");
        printKDist(root,2);
    }
}
