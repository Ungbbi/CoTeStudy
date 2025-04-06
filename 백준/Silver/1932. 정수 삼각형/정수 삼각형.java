import java.util.*;
import java.io.*;


public class Main{
    static Integer[][] dp;
    static int[][] tree;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        tree = new int[N][N];
        dp = new Integer[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<=i; j++){
                tree[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            dp[N-1][i] = tree[N-1][i];
        }

        System.out.println(find(0, 0));

    }

    static int find(int depth, int idx) {

        if(depth == N - 1) return dp[depth][idx];

        // 입력에서 0 이상 9999 이하의 값이 주어진다고 했기에 dp를 Integer 배열로 선언.
        // int로 선언하면 초기화 안했을때 값이 0이므로 초기화 된건지 안된건지 모른다.
        if (dp[depth][idx] == null) {
            dp[depth][idx] = Math.max(find(depth + 1, idx), find(depth + 1, idx + 1)) + tree[depth][idx];
        }

        return dp[depth][idx];
    }
}