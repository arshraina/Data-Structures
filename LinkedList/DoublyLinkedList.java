package LinkedList;

class Node {
    int data;
    Node prev;
    Node next;
    Node(int data) {
        this.data = data;
        prev = next = null;
    }
}

public class DoublyLinkedList {
    public static Node insertBegin(Node head, int data) {
        Node temp = new Node(data);
        temp.next = head;
        if (head != null){
            head.prev = temp;
        }
        return temp;
    }
    public static Node reverseList(Node head) {
        Node curr = head;
        Node temp = null;
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
    public static Node deleteHead(Node head) {
        if(head == null || head.next==null) {
            return null;
        }
//        head.next.prev = null; (not imp due to automatic memory deallocation)
        head = head.next;
        head.prev = null;
        return head;
    }
    public static Node deleteTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node curr = head;
        while(curr.next!=null){
            curr = curr.next;
        }
        curr.prev.next = null;
        curr.prev = null;
        return head;
    }
    public static void printList(Node head){
        Node curr = head;
        while(curr!=null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
    public static void main(String[] args) {
        Node head=new Node(10);
        Node temp1=new Node(20);
        Node temp2=new Node(30);
        head.next=temp1;
        temp1.prev=head;
        temp1.next=temp2;
        temp2.prev=temp1;
        head = insertBegin(head, 13);
        head = reverseList(head);
        head = deleteHead(head);
        head = deleteTail(head);
        printList(head);
    }
}
