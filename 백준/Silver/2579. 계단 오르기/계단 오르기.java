import java.util.*;
import java.io.*;

public class Main{
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1];

        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = arr[1];
        if(N>1) dp[2] = arr[1]+arr[2];
        System.out.println(topDown(N));

    }
    static int topDown(int n){
        if(n<=0) return 0;
        if(dp[n] > 0) return dp[n]; // 계단의 점수는 자연수 -> dp는 0보다 커짐
        dp[n] = Math.max(topDown(n-2), topDown(n-3) + arr[n-1]) + arr[n];
        return dp[n];
    }
}