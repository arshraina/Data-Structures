package LinkedList;

public class NthFromEnd {
    public static void printNthfromEnd(LinkedList.SLLNode head, int n){
        if (head==null){
            return;
        }
        LinkedList.SLLNode first = head;
        for (int i = 0; i < n; i++) {
            if (first == null){
                return;
            }
            first = first.next;
        }
        LinkedList.SLLNode second = head;
        while (first!=null){
            first = first.next;
            second = second.next;
        }
        System.out.println("Nth element from end: "+second.data);
    }
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
        head = insertEnd(head,50);

        printList(head);
        printNthfromEnd(head,2);

    }
}

