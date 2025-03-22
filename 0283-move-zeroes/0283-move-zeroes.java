class Solution {
    public void moveZeroes(int[] nums) {
        // 1. 0을 뒤로 다 옮기고 나서 정렬 -> x 순서를 유지시켜야함 
        int l = 0;
        int r = 0;
        
        // Step 1. Move Zeors to the end.
        while(r<nums.length){
            if(l==r && nums[l] != 0){
                l++;
                r++;
                continue;
            }
            if(nums[r]==0){
                r++;
                continue;            
            }
            if(nums[l]==0){
                nums[l] = nums[r];
                nums[r] = 0;        
                l++;
            }

        }

        System.out.println(Arrays.toString(nums));
    }
}