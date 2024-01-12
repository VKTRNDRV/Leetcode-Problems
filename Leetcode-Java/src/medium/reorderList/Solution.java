package medium.reorderList;

import utils.ListNode.ListNode;

import java.util.ArrayDeque;

class Solution {
    public void reorderList(ListNode head) {
        if(head == null) return;
        ArrayDeque<ListNode> nodes = new ArrayDeque<>();
        ListNode current = head;
        nodes.addLast(current);
        while(current.next != null){
            current = current.next;
            nodes.addLast(current);
        }

        current = nodes.getLast();
        head.next = current;

        int counter = 0;
        while(!nodes.isEmpty()){
            if(counter % 2 == 0){
                current.next = nodes.removeFirst();
            }else{
                current.next = nodes.removeLast();
            }

            current = current.next;
            counter++;
        }

        current.next = null;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode x = new ListNode(4);
        ListNode y = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = x;
        x.next = y;

        new Solution().reorderList(a);
        System.out.println(a);
    }
}
