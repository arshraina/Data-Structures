package LinkedList;

public class SortedInsertSLL {

    public static LinkedList.SLLNode insertEnd(LinkedList.SLLNode head, int data) {
        LinkedList.SLLNode temp = new LinkedList.SLLNode(data);
        if(head==null) {
            return temp;
        }
        LinkedList.SLLNode curr = head;
        while (curr.next!=null) {
            curr = curr.next;
        }
        curr.next = temp;
        return head;
    }
    public static LinkedList.SLLNode sortedInsert(LinkedList.SLLNode head, int data) {
        LinkedList.SLLNode temp = new LinkedList.SLLNode(data);
        if(head == null) {
            return temp;
        }
        if(data<head.data) {
            temp.next = head;
            return temp;
        }
        LinkedList.SLLNode curr = head;
        while(curr.next!=null && curr.next.data < data) {
            curr = curr.next;
        }
        temp.next = curr.next;
        curr.next = temp;
        return head;
    }
    public static void printList(LinkedList.SLLNode head) {
        LinkedList.SLLNode curr = head;
        while(curr!=null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
    public static void main(String[] args) {
        LinkedList.SLLNode head = null;
        head = insertEnd(head,10);
        head = insertEnd(head,20);
        head = insertEnd(head,30);
        head = insertEnd(head,40);
        head = sortedInsert(head, 25);
        printList(head);
    }
}
