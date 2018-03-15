package addTwoNumbers;

class ListNode{
    int data;
    ListNode next;

    public ListNode(int x){
        data = x;
    }
}

class Solution{
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode result = new ListNode(0);
        ListNode p = l1;
        ListNode q= l2;
        ListNode r = result;
        int flag = 0;
        while(p != null || q != null){
            int x = (p != null) ? p.data : 0;
            int y = (q != null) ? q.data : 0;
            int sum = x + y + flag;
            flag = sum / 10;
            r.next = new ListNode(sum%10);
            r = r.next;
            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }
        if(flag > 0)
            r.next = new ListNode(flag);

        return result.next;
    }

}

public class addTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);
        ListNode p = l1;
        ListNode q = l2;

        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(3);

        q.next = new ListNode(6);
        q = q.next;
        q.next = new ListNode(4);

        p = l1;
        q = l2;
        System.out.println("l1");
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }

        System.out.println("l2");
        while (q != null) {
            System.out.println(q.data);
            q = q.next;
        }

        System.out.println("result");
        ListNode result = Solution.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.data);
            result = result.next;
        }
    }
}
