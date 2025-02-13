// 최대 2의 20승이므로 완전탐색 해도 된다.
// DFS로 끝까지 구한 결과값과 Target과 비교하여 Count

import java.util.*;

class Solution {
    static int answer = 0;
    static int targetNum;
    static int[] nums;
    
    static void dfs(int num, int cnt){
        if(nums.length-1 == cnt && num == targetNum){
            answer++;
            return;
        }
        else if(nums.length-1<=cnt) return;
        cnt++;
        dfs(num-nums[cnt], cnt);
        dfs(num+nums[cnt], cnt);
        
    }
    public int solution(int[] numbers, int target) {
        // 내림차순으로 정렬
        nums = numbers;
        targetNum = target;
        dfs(nums[0], 0);
        dfs(-nums[0], 0);
        
        return answer;
    }
}