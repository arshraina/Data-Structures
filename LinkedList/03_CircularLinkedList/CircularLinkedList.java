package LinkedList;

class CLLNode {
    int data;
    CLLNode next;
    CLLNode(int data) {
        this.data = data;
        next = null;
    }
}

public class CircularLinkedList {
    public static CLLNode insertBegin(CLLNode head, int data) {
        CLLNode temp = new CLLNode(data);
        if (head==null) {
            temp.next = temp;
            return temp;
        }
        temp.next = head.next;
        head.next = temp;
        int t = head.data;
        head.data = temp.data;
        temp.data = t;
        return head;
    }
    public static CLLNode insertEnd(CLLNode head, int data) {
        CLLNode temp = new CLLNode(data);
        if (head==null) {
            temp.next = temp;
            return temp;
        }
        else{
            temp.next = head.next;
            head.next = temp;
            int t = head.data;
            head.data = temp.data;
            temp.data = t;
            return temp;//temp is now new head
        }
    }
    public static CLLNode delHead(CLLNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == head) {
            return null;
        }
        head.data = head.next.data;
        head.next = head.next.next;
        return head;
    }
    public static CLLNode delPos(CLLNode head, int k) {
        if(head == null) {
            return head;
        }
        if(k == 1){
            return delHead(head);
        }
        CLLNode curr = head;
        for(int i = 0; i < k-2; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }
    public static void printList(CLLNode head){
        if(head==null)return;
        CLLNode r=head;
        do{
            System.out.print(r.data+" ");
            r=r.next;
        }while(r!=head);
    }
    public static void main(String[] args) {
        CLLNode head = null;
        head = insertBegin(head, 10);
        head = insertBegin(head,20);
        head = insertEnd(head,10);
        head = insertEnd(head,20);
        head = delHead(head);
        printList(head);
    }
}
