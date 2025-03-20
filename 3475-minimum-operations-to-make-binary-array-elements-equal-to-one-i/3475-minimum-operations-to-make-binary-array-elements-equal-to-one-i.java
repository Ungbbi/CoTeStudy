class Solution {
    public static int minOperations(int[] nums) {
        // 최대한 앞에서 만들어 놓은 1은 안건드는게 좋지 않을까?
        // 현재 값이 0 일 때, 다음 값이 0일 때 ?

        int N = nums.length;
        
        int cnt = 0;
        for(int i=0; i<N-2; i++){
            if(nums[i]==0){
                cnt++;
                nums[i] = 1;
                nums[i+1] = (nums[i+1]==1)?0:1;
                nums[i+2] = (nums[i+2]==1)?0:1;
            }
        }
        if(nums[N-1]==0 || nums[N-2]==0) return -1;
        else return cnt;

    }
}