class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class RotateLinkedList {
    ListNode head ;
    void addNode(int data){
        ListNode newNode = new ListNode(data);
        if(head == null){
            head = newNode;
            return;
        }
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }
    ListNode rotateList(ListNode head,int k){
        if(k == 0 || head == null || head.next == null)
            return head ;
        int size = 0 ;
        ListNode temp = head ;
        while(temp != null){
            temp = temp.next ;
            size++;
        }
        if(k%size == 0)return head;
        temp = head ;
        int pointA = size - (k % size) ;
        for(int i=1 ;i<pointA;i++){
            temp = temp.next ;
        }
        ListNode temp2 = temp.next ;
        ListNode head2 = temp.next ;
        temp.next = null ;
        while(temp2.next != null){
            temp2 = temp2.next ;
        }
        temp2.next = head ;
        return head2 ;
    }
    public static void main(String[] args) {
        RotateLinkedList node = new RotateLinkedList();
        // List Inputs
        node.addNode(5);
        node.addNode(4);
        node.addNode(3);
        node.addNode(2);
        node.addNode(1);
        node.head = node.rotateList(node.head,2); // index from end to Rotate.
        
    }
}
