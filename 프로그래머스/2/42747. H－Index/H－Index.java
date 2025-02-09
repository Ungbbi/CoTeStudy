import java.util.Arrays;

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

/*
정렬 후 최댓값을 가지고 반복문에 활용.
1. while(i > citations[x]) x++;
=> citations의 value값이 인용횟수이고, i는 인덱스이자 인용횟수이다.
반복문 진행 중 처음으로 x++로 인해 i <= citations[x]가 될 때, 
              그 이후는 모두 i보다 인용횟수가 많다는 것이다.
그 때 "논문이 h편 이상이고," 를 체크하는 것이  (i <= citations.length - x)
왜 citations.length - x 인가 ? 
-> x값 이전 인덱스들은 조건을 만족시키지 못한다. 하지만 x이상의 인덱스들이 조건들을 포함하므로
조건을 만족하는 논문 개수를 구하는 식.
i <= (citations.length -x) 는?
-> 문제에서 h번 이상 인용된 논문이 h편 이상이어야 하므로.
"h의 최댓값"을 구하는 것이 (i > result)
*/
