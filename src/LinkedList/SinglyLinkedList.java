package LinkedList;
import java.lang.*;

class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        next = null;
    }
}

public class SinglyLinkedList {
    public static Node insertBeg(Node head, int data) {
        Node temp = new Node(data);
        temp.next = head;
        return temp;
    }
    public static Node insertEnd(Node head, int data) {
        Node temp = new Node(data);
        if(head==null) {
            return temp;
        }
        Node curr = head;
        while (curr.next!=null) {
            curr = curr.next;
        }
        curr.next = temp;
        return head;
    }
    public static Node delHead(Node head) {
        if(head == null) {
            return null;
        }
        else {
            return head.next;
        }

    }
    public static Node delTail(Node head) {
        if(head==null) {
            return null;
        }
        if(head.next==null) {
            return null;
        }
        Node curr = head;
        while(curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }
    public static Node insertPos(Node head, int pos, int data){
        Node temp = new Node(data);
        if (pos==1) {
            temp.next = head;
            return temp;
        }
        Node curr = head;
        for (int i = 1; i < pos-1 && curr!=null; i++) {
            curr = curr.next;
        }
        if(curr==null){ //If pos is greater than linked list +1
            return head;
        }
        temp.next = curr.next;
        curr.next = temp;
        return head;
    }
    public static void main(String[] args) {
        Node head = null;

        head = insertBeg(head,10);
        head = insertBeg(head,20);
        head = insertBeg(head,30);
        head = insertEnd(head,10);
        head = insertEnd(head,20);
        head = insertEnd(head,30);
        head = delHead(head);
        head = delTail(head);
        head = insertPos(head, 2, 69);
        System.out.println(searchIterative(head,69));
        printList(head);
    }
    public static int searchIterative(Node head, int data) {
        int pos=1;
        Node curr = head;
        while(curr != null){
            if(curr.data == data){
                return pos;
            }
            else{
                pos++;
                curr = curr.next;
            }
        }
        return -1;
    }
    public static int searchRecursive(Node head, int data) {
        if(head==null) {
            return -1;
        }
        if(head.data==data) {
            return 1;
        }
        else {
            int res = searchRecursive(head.next, data);
            if(res==-1) {
                return -1;
            }
            else {
                return res+1;
            }
        }
    }
    public static void printList(Node head) {
        Node curr = head;
        while(curr!=null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}

