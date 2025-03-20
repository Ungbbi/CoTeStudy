class Solution {
    // 생각해야될 것 : 언제 반복을 멈출 수 있을까? 전체 배열이 0인것을 도중에 어떻게 체크?
    public static int minZeroArray(int[] nums, int[][] queries) {

        int cnt = 0;
        int[] ary = new int[nums.length];
        int aryCnt = 0;

        for(int i=0; i<nums.length; i++){
            ary[i] = nums[i];
            if(ary[i]!=0){
                aryCnt += nums[i];
            }                    
        }

        for(int[] q : queries){
            if(aryCnt==0) break;
            for(int i = q[0]; i<=q[1]; i++){
                if(nums[i] == 0) continue;
                if(nums[i]<=q[2]){
                    aryCnt -= nums[i];
                    nums[i] = 0;
                }
                else {
                    nums[i] -= q[2];
                    aryCnt -= q[2];
                }                
            }
            // 하나의 쿼리로 연산이 끝났을 때 cnt++
            // nums = [0]이라면?
            cnt++;
            // 어느 특정 원소가 0이 됐을 때, -1?
        }
        if(aryCnt>0) return -1;
        return cnt;
    }
}