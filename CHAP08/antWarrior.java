package CHAP08;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class antWarrior {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] storages = new int[N];
        int[] dp = new int[N];
        for(int i=0; i<N; i++){
            storages[i] = Integer.parseInt(input[i]);
        }

        dp[0] = storages[0];
        dp[1] = storages[1];
        dp[2] = dp[0]+storages[2];

        for(int i=3;i<N;i++){

            if(dp[i-3]<dp[i-2]){
                dp[i] = dp[i-2] + storages[i];
            }
            else{
                dp[i] = dp[i-3] + storages[i];
            }
        }
        int sol;
        if (dp[N-2]>dp[N-1]) sol = dp[N-2];
        else sol = dp[N-1];

        System.out.println(sol);
    }
}
