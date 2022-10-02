package LinkedList;

public class MiddleLL {
    public static void printMiddle(LinkedList.SLLNode  head){
            if(head==null){
                return;
            }
            LinkedList.SLLNode slow = head;
            LinkedList.SLLNode fast = head;
            while(fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            System.out.println("Middle element: "+slow.data);
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
            printMiddle(head);

        }
    }

