package deleteDuplicates1;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}

class Solution{
    public ListNode deleteDuplicates(ListNode head){
        if(head == null)
            return head;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode cur = head;
        ListNode pre = newHead;
        while(cur != null){
            while(cur.next != null && cur.val == cur.next.val)
                cur = cur.next;
            if(pre.next == cur)
                pre = pre.next;
            else{
                pre.next = cur;
                pre = pre.next;
            }
            cur = cur.next;
        }
        return newHead.next;
    }
}

public class DeleteDuplicates {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println();
        head = new Solution().deleteDuplicates(head);
        temp = head;
        while(temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
    }
}
