import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st ;
//        int[][] dp = new int[N+1][3];
        int[][] rgb = new int[N+1][3];
        int[] dpMemorization = new int[3];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<3; j++){
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<3; i++) {
            dpMemorization[i] = rgb[1][i];
        }
//        int min = Math.min(Math.min(dp[N][0],dp[N][1]),dp[N][2]);

        for(int i=2; i<=N; i++){
            // R <- 이전에 G, B 중 choose min

            int r  = Math.min(dpMemorization[1],dpMemorization[2]) + rgb[i][0];
            int g = Math.min(dpMemorization[0],dpMemorization[2]) + rgb[i][1];
            int b = Math.min(dpMemorization[0],dpMemorization[1]) + rgb[i][2];
            dpMemorization[0] = r;
            dpMemorization[1] = g;
            dpMemorization[2] = b;
        }
        int min = Math.min(Math.min(dpMemorization[0],dpMemorization[1]),dpMemorization[2]);
        System.out.println(min);
    }
}