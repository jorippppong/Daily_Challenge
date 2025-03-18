package LeetCode.Hard;

/*
1. 아이디어 : 
merge sort 

2. 시간복잡도 : 
(n : 모든 리스트의 node 갯수)
(k : 리스트의 length)
O(nlogk)

3. 자료구조/알고리즘 : 
divide and conquer, two pointer
*/

public class LC_23 {
    
    //Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists == null || lists.length == 0) return null;
            return mergeSort(lists, 0, lists.length -1);
        }

        public ListNode mergeSort(ListNode[] lists, int left, int right){
            if(left == right) return lists[left];
            int mid = (left+right)/2;
            ListNode n1 = mergeSort(lists, left, mid);
            ListNode n2 = mergeSort(lists, mid+1, right);
            return merge(n1, n2);
        }

        // 가장 앞에 있는 Node 반환
        public ListNode merge(ListNode n1, ListNode n2){
            ListNode dummyHead = new ListNode(0);
            ListNode curr = dummyHead;
            
            while(n1 != null && n2 != null){
                if(n1.val < n2.val){
                    curr.next = n1;
                    n1 = n1.next;
                }
                else{
                    curr.next = n2;
                    n2 = n2.next;
                }
                curr = curr.next;
            }
            curr.next = (n1 != null) ? n1 : n2;
            return dummyHead.next;
        }
    }
}
