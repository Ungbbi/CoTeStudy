package ECoTe.CHAP08_DP;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;

import static java.lang.Math.min;

public class EfficientMonetary {
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String[] inputs = br.readLine().split(" ");
         int N = Integer.parseInt(inputs[0]);
         int M = Integer.parseInt(inputs[1]);
         int[] monetary = new int[N+1];
         for(int i=1;i<=N;i++){
             monetary[i] = Integer.parseInt(br.readLine());
         }
         Arrays.sort(monetary);

         // dp의 인덱스가 곧 숫자
         int[] dp = new int[M+1];
         int min = monetary[N];
         // 입력받은 화폐와 동일한 숫자값은 1번이면 되므로 미리 대입

         for(int m : monetary){
             if(m>M) break;
             dp[m] = 1;
         }
         // 최소값 이전은 전부 -1로 채운다.
         for(int i=0;i<monetary[1];i++){
             dp[i] = -1;
         }

         int tmp;
        // 가장 작은 수  이전은 전부 계산 불가이므로 최소값부터 시작
        int n=monetary[1];
         while(n<=M){
             // 화폐로 게산 불가능한 값이면 결국 min값은 안바뀌므로 후에 dp에 -1을 집어넣을 수 있다.
             min = M;
             if(dp[n]==1){
                 n++;
                 continue;
             }
             // 가장 큰 화폐를 빼자.
             for(int i=N;i>=1;i--){
                 tmp = n - monetary[i];
                 if(tmp<0 || dp[tmp] == -1){
                     continue;
                 }
                 if(min>dp[tmp]) min = dp[tmp];
             }
             if(min==M) dp[n] = -1;
             else{
                 dp[n] = min+1;
             }
             n++;
         }
        System.out.println(dp[M]);


    }
}
