// Set으로 중복 제거하고 N/2 개수 
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        
        int N = nums.length;
        int answer;
        ArrayList<Integer> al = new ArrayList<>(set);
        if(al.size()<=(N/2)) answer = al.size();
        else answer = N/2;
        
        return answer;
    }
}