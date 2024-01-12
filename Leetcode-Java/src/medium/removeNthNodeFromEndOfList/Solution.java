package medium.removeNthNodeFromEndOfList;

import utils.ListNode.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;
        int nodesCount = 1;
        ListNode nodePointer = head;
        while (nodePointer.next != null){
            nodePointer = nodePointer.next;
            nodesCount++;
        }

        int removeNodeIndex = nodesCount - n;
        if(removeNodeIndex == 0) return head.next;
        nodePointer = head;
        while(removeNodeIndex > 1){
            nodePointer = nodePointer.next;
            removeNodeIndex--;
        }

        nodePointer.next = nodePointer.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1),
                b = new ListNode(2),
                c = new ListNode(3),
                d = new ListNode(4),
                e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        a = new Solution().removeNthFromEnd(a, 2);
        a = new Solution().removeNthFromEnd(a, 1);

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        one.next = two;
        one = new Solution().removeNthFromEnd(one,2);
        System.out.println(one);
    }
}
