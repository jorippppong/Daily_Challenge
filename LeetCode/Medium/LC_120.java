package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
1. 아이디어 : 
DP (top-down)
윗 row에서 선택할 수 있는 값 중 더 작은 값을 선택해서 더한다.

2. 시간복잡도 : 
(n : row의 갯수)
O(n^2)

3. 자료구조/알고리즘 : 
리스트 / DP (반복문)
*/

public class LC_120 {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            List<Integer> prevTri = triangle.get(0);
            List<Integer> currTri = new ArrayList<>();
            for(int i=1; i<triangle.size(); i++){
                currTri = triangle.get(i);
                for(int j=0; j<currTri.size(); j++){
                    if(j==0){
                        currTri.set(j, currTri.get(j) + prevTri.get(0));
                    }
                    else if(j==currTri.size()-1){
                        currTri.set(j, currTri.get(j) + prevTri.get(prevTri.size()-1));
                    }
                    else{
                        currTri.set(j, currTri.get(j) + Math.min(prevTri.get(j-1), prevTri.get(j)));
                    }
                }
                prevTri = currTri;
            }
            return Collections.min(triangle.get(triangle.size()-1));
        }
    }   
}
