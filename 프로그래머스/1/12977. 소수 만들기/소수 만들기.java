class Solution {        
    
    public int solution(int[] nums) {
        int answer = 0;
        int tmp = 0;
        for(int i=0; i<nums.length-2; i++){
            tmp += dfs(nums, nums[i], 2, i);
        }
        answer = tmp;
        return answer;
    }
    static int dfs(int[] nums, int prefixSum, int depth, int idx){
        // level 3
        if(depth==3){
            int ans=0;
            for(int i=idx+1; i<nums.length; i++){
                if(getPrime(prefixSum+nums[i])) ans++;
            }
            return ans;
        }
                
        // level 2
        int r=0;        
        for(int i=idx+1; i<nums.length; i++){                
            r += dfs(nums, prefixSum+nums[i], depth+1, i);
        }
        return r;
    }
    
    static boolean getPrime(int n){
        for(int i=2; i<=(int)Math.sqrt(n); i++){
            if (n%i==0) return false;            
        }
        return true;
    }
}