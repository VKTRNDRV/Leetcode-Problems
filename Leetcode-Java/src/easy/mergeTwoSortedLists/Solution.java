package easy.mergeTwoSortedLists;

import utils.ListNode.ListNode;

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode outputHead, outputCurrent;
        if(list1.val <= list2.val){
            outputHead = list1;
            list1 = list1.next;
        }else{
            outputHead = list2;
            list2 = list2.next;
        }
        outputCurrent = outputHead;

        while (list1 != null || list2 != null){
            if(list1 == null){
                outputCurrent.next = list2;
                list2 = list2.next;

            }else if(list2 == null){
                outputCurrent.next = list1;
                list1 = list1.next;

            }else if(list1.val <= list2.val){
                outputCurrent.next = list1;
                list1 = list1.next;

            }else{
                outputCurrent.next = list2;
                list2 = list2.next;
            }

            outputCurrent = outputCurrent.next;
        }

        return outputHead;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(5);
        a.next = b;
        b.next = c;

        ListNode x = new ListNode(2);
        ListNode y = new ListNode(4);
        ListNode z = new ListNode(6);
        x.next = y;
        y.next = z;

        new Solution().mergeTwoLists(a, x);
    }
}
