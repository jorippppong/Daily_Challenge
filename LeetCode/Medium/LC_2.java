package LeetCode.Medium;

/*
1. 아이디어 : 
LinkedList, 반복문
올림수 까지 더하고, 올림수를 다음 덧셈으로 넘긴다.

2. 시간복잡도 : 
O(n)

3. 자료구조/알고리즘 : 
LinkedList, 반복문
*/

public class LC_2 {
    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int leads = 0;
            ListNode dummyHead = new ListNode(0);
            ListNode curr = dummyHead;

            while(l1 != null && l2 != null){
                int num = l1.val + l2.val + leads;
                curr.next = new ListNode(num % 10);
                curr = curr.next;
                leads = num / 10;
                l1 = l1.next; l2 = l2.next;
            }
            while(l1 != null){
                int num = l1.val + leads;
                curr.next = new ListNode(num % 10);
                curr = curr.next;
                leads = num / 10;
                l1 = l1.next;
            }
            while(l2 != null){
                int num = l2.val + leads;
                curr.next = new ListNode(num % 10);
                curr = curr.next;
                leads = num / 10;
                l2 = l2.next;
            }
            if(leads != 0){
                curr.next = new ListNode(leads);
            }
            return dummyHead.next;
        }
    }
}
