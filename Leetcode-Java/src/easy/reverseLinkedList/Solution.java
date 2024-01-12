package easy.reverseLinkedList;

import utils.ListNode.ListNode;

import java.util.Stack;

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        Stack<ListNode> nodes = new Stack<>();
        ListNode current = head;
        nodes.push(current);
        while(current.next != null){
            nodes.push(current.next);
            current = current.next;
        }

        current = nodes.pop();
        head = current;
        ListNode nextNode;
        while (!nodes.isEmpty()){
            nextNode = nodes.pop();
            nextNode.next = null;
            current.next = nextNode;
            current = nextNode;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode();
        a.val = 1;
        ListNode b = new ListNode();
        b.val = 2;
        ListNode c = new ListNode();
        c.val = 3;
        ListNode d = new ListNode();
        d.val = 4;
        ListNode e = new ListNode();
        e.val = 5;

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        new Solution().reverseList(a);

    }
}
