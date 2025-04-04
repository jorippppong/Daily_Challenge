package leetcode.medium;

/*
1. 아이디어 : 
binary search
오름차순으로 정렬되어 있는 block 내부에 target 값이 있는지 먼저 확인한다.

2. 시간복잡도 : 
O(logn)

3. 자료구조/알고리즘 : 
binary search
*/

public class LC33 {
    class Solution {
        public int search(int[] nums, int target) {
            int rotateIdx = findRotateIdx(nums);
            System.out.println(rotateIdx);
            if(rotateIdx == 0){
                return findTargetIdx(nums, target, 0, nums.length-1);
            }
            else{
                int a = findTargetIdx(nums, target, 0, rotateIdx-1);
                int b = findTargetIdx(nums, target, rotateIdx, nums.length-1);
                return (a != -1) ? a : (b != -1) ? b : -1;
            }
        }
    
        public int findRotateIdx(int[] nums){
            int start = 0, end = nums.length-1;
            while(start <= end){
                if(start == end){
                    return 0;
                }
                if(end - start == 1){
                    if(nums[start] > nums[end]) return end;
                    else return 0;
                }
    
                int mid = (start + end) / 2;
                if(nums[start] < nums[mid]){ // 앞 블럭이 오름차순
                    start = mid;
                }
                else{ // 뒷 블럭이 오름차순
                    end = mid;
                }
            }
            return 0;
        }
    
        public int findTargetIdx(int[] nums, int target, int start, int end){
            while(start <= end){
                if(start == end){
                    if(target == nums[start]) return start;
                    else return -1;
                }
    
                int mid = (start + end) / 2;
                if(target <= nums[mid]){
                    end = mid;
                }
                else{
                    start = mid +1;
                }
            }
            return -1;
        }
    }
}