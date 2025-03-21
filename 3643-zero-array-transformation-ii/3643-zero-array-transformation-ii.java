import java.util.Arrays;

class Solution {
	public int minZeroArray(int[] nums, int[][] queries) {

		int n = nums.length;

		int l = 0;
		int r = queries.length;
		int result = -1;

		while(l <= r){
			int mid = (l + r)/2 ;
			int[] arr = Arrays.copyOf(nums,n);
			boolean value = prefixSum(arr,queries,mid);
			// 0보다 큰거 있음
			if(!value){
				l = mid + 1;
			}else{
				r = mid - 1;
				result = mid;
			}
		}

		return result;
	}

	public boolean prefixSum(int[] nums, int[][] queries, int mid){
		int[] sum = new int[nums.length + 1];
		int[] prefixSum = new int[nums.length + 1];
		for(int i=0; i< mid; i++){
			int l = queries[i][0];
			int r = queries[i][1];
			int value = queries[i][2];
			sum[l] += value;
			sum[r + 1] -= value;
		}

		for(int i =1; i< prefixSum.length; i++){
			prefixSum[i] = sum[i-1] + prefixSum[i-1];
		}


		for(int i =0 ; i< nums.length; i++){
			nums[i] -= prefixSum[i + 1];
		}

		return allZero(nums);
	}

	public boolean allZero(int[] nums) {
		for (int num : nums) {
			if (num > 0) {
				return false;
			}
		}
		return true;
	}
}