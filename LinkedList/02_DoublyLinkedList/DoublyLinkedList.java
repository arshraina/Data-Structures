package LinkedList;

class DLLNode {
    int data;
    DLLNode prev;
    DLLNode next;
    DLLNode(int data) {
        this.data = data;
        prev = next = null;
    }
}

class DoublyLinkedList {
    public static DLLNode insertBegin(DLLNode head, int data) {
        DLLNode temp = new DLLNode(data);
        temp.next = head;
        if (head != null){
            head.prev = temp;
        }
        return temp;
    }
    public static DLLNode insertEnd(DLLNode head, int data) {
        DLLNode temp = new DLLNode(data);
        DLLNode curr = head;
        while(curr.next!=null) {
            curr = curr.next;
        }
        curr.next = temp;
        temp.prev = curr;
        return head;
    }
    public static DLLNode reverseList(DLLNode head) {
        DLLNode curr = head;
        DLLNode temp = null;
        if(head == null || head.next==null){
            return head;
        }
        while(curr!=null){
            temp =  curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }
        return temp.prev;
    }
    public static DLLNode deleteHead(DLLNode head) {
        if(head == null || head.next==null) {
            return null;
        }
//        head.next.prev = null; (not imp due to automatic memory deallocation)
        head = head.next;
        head.prev = null;
        return head;
    }
    public static DLLNode deleteTail(DLLNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        DLLNode curr = head;
        while(curr.next!=null){
            curr = curr.next;
        }
        curr.prev.next = null;
        curr.prev = null;
        return head;
    }
    public static void printList(DLLNode head){
        DLLNode curr = head;
        while(curr!=null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
    public static void main(String[] args) {
        DLLNode head=new DLLNode(10);
        DLLNode temp1=new DLLNode(20);
        DLLNode temp2=new DLLNode(30);
        head.next=temp1;
        temp1.prev=head;
        temp1.next=temp2;
        temp2.prev=temp1;
        head = insertBegin(head, 13);
        head = insertEnd(head, 43);
        head = reverseList(head);
        head = deleteHead(head);
        head = deleteTail(head);
        printList(head);
    }
}
