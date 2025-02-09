/*
1. 정렬
2. 앞에 값부터 뽑고 인덱스를 통해 뽑은 원소 앞에 몇개가 있는지 확인 
*/
import java.util.Arrays;
import java.util.Collections;


class Solution {
    
    public int solution(int[] citations) {
        
        Arrays.sort(citations);
        int maxNum = citations[citations.length-1];
        int result = 0;
        for(int i=1;i<=maxNum;i++){
            int x=0;
            while(i>citations[x]){
                x++;
            }
            if(i <= citations.length - x && i>result) result = i;
        }
        return result;
    }
}