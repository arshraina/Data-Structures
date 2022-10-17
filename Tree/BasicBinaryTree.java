package Tree;

class BBTNode {
    int key;
    BBTNode left;
    BBTNode right;
    BBTNode(int key){
        this.key = key;
    }
}

class BasicBinaryTree{
    public static void main(String[] args) {
        BBTNode root = new BBTNode(10);
        root.left = new BBTNode(20);
        root.left.left = new BBTNode(40);
    }
}