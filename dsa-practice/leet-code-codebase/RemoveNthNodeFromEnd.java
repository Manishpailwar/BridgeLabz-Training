class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveNthNodeFromEnd{
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
    ListNode removeNthNodeFromEnd(int n){
        int size = 0 ;
        ListNode temp = head ;
        while(temp != null){
            temp = temp.next ;
            size++;
        }
        if(size-n == 0)
            return head.next ;
        temp = head ;
        for(int i=1;i<size-n;i++){
            temp = temp.next ;
        }
        temp.next = temp.next.next ;
        return head ;
    }
    

    public static void main(String[] args) {
        RemoveNthNodeFromEnd node = new RemoveNthNodeFromEnd();
        // List Inputs
        node.addNode(5);
        node.addNode(4);
        node.addNode(3);
        node.addNode(2);
        node.addNode(1);
        node.head = node.removeNthNodeFromEnd(2); // index from end to delete
        
    }
}