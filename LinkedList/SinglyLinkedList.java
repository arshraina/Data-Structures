package LinkedList;
import java.lang.*;

class SLLNode {
    int data;
    SLLNode next;
    SLLNode(int data) {
        this.data = data;
        next = null;
    }
}

public class SinglyLinkedList {
    public static SLLNode insertBeg(SLLNode head, int data) {
        SLLNode temp = new SLLNode(data);
        temp.next = head;
        return temp;
    }
    public static SLLNode insertEnd(SLLNode head, int data) {
        SLLNode temp = new SLLNode(data);
        if(head==null) {
            return temp;
        }
        SLLNode curr = head;
        while (curr.next!=null) {
            curr = curr.next;
        }
        curr.next = temp;
        return head;
    }
    public static SLLNode delHead(SLLNode head) {
        if(head == null) {
            return null;
        }
        else {
            return head.next;
        }

    }
    public static SLLNode delTail(SLLNode head) {
        if(head==null) {
            return null;
        }
        if(head.next==null) {
            return null;
        }
        SLLNode curr = head;
        while(curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }
    public static SLLNode insertPos(SLLNode head, int pos, int data){
        SLLNode temp = new SLLNode(data);
        if (pos==1) {
            temp.next = head;
            return temp;
        }
        SLLNode curr = head;
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
        SLLNode head = null;

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
    public static int searchIterative(SLLNode head, int data) {
        int pos=1;
        SLLNode curr = head;
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
    public static int searchRecursive(SLLNode head, int data) {
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
    public static void printList(SLLNode head) {
        SLLNode curr = head;
        while(curr!=null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}

