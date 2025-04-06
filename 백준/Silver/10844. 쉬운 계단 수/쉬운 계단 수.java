import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[10];
        long[] tmp = new long[10];
        // N<=1

        for(int i=1; i<=9; i++){
            dp[i] = 1;
        }

        for(int i=1; i<N;i++){
            for(int j=0; j<10; j++){
                if(j==0){
                    tmp[0] = dp[1]% 1000000000;
                    continue;
                }
                if(j==9){
                    tmp[9] = dp[8]% 1000000000;
                    continue;
                }
                tmp[j] = (dp[j-1]+ dp[j+1])% 1000000000;
            }

            for(int j=0; j<10; j++){
                dp[j] = tmp[j];
            }
        }

        long sum = 0;

        for(int i=0; i<10; i++){
            sum += dp[i];
        }
        System.out.println(sum % 1000000000);
    }
}