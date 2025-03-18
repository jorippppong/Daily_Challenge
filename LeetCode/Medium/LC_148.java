package LeetCode.Medium;

/*
1. 아이디어 : 
merge sort

2. 시간복잡도 : 
O(nlogn)
분할 할 때는 연산이 없다. 
병합 할 때, 정렬을 위한 n번의 탐색이 depth인 logn 만큼 발생해서 O(nlogn) 만큼 소요된다.

3. 자료구조/알고리즘 : 
divide and conquer, two pointer
*/

public class LC_148 {
    
    // Definition for singly-linked list.
    class ListNode {
        int val;   
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    class Solution {
        // merge sort (divide and conquer, two pointer)
        public ListNode sortList(ListNode head) {
            if(head == null || head.next == null) return head;

            // 1. mid 찾기
            ListNode slow = head; 
            ListNode fast = head.next;

            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode mid = slow.next;
            slow.next = null; // 연결 끊기

            // 2. divide & conquer
            return merge(sortList(head), sortList(mid));
        }


        // two pointer (head를 반환)
        public ListNode merge(ListNode n1, ListNode n2){
            ListNode dummyHead = new ListNode(0);
            ListNode node = dummyHead;

            while(n1 != null && n2 != null){
                if(n1.val < n2.val){
                    ListNode newN1 = n1.next;
                    n1.next = null;
                    node.next = n1;
                    n1 = newN1;
                }
                else{
                    ListNode newN2 = n2.next;
                    n2.next = null;
                    node.next = n2;
                    n2 = newN2;
                }
                node = node.next;
            }

            if(n1 != null){
                node.next = n1;
            }
            else if(n2 != null){
                node.next = n2;
            }
            
            return dummyHead.next;
        }
    }
}