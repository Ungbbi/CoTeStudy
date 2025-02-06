package ECoTe.CHAP08_DP;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class FloorConstruction {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;
        for(int i=4; i<=N; i++){
            dp[i] = dp[i-1] + dp[i-2]*2;
        }
        System.out.println(dp[N]);
    }
}
