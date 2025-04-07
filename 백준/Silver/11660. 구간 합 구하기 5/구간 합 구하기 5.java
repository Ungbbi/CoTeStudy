import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[][] map = new int[N+1][N+1];
//        int[][] dpRow = new int[N+1][N+1];
        int[][] dpCol = new int[N+1][N+1];

        StringTokenizer st;
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Col Sum
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                dpCol[i][j] = map[i][j] + dpCol[i][j-1];
            }
        }
        // Row Sum
//        for(int i=1; i<=N; i++){
//            for(int j=1; j<=N; j++){
//                dpRow[i][j] = map[i][j] + dpRow[i-1][j];
//            }
//        }

        int[][] input = new int[M][4];
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine()," ");
            int sum = 0;
            for(int j=0; j<4; j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
            
                for(int k = input[i][0]; k<=input[i][2]; k++){
                    sum += dpCol[k][input[i][3]] - dpCol[k][input[i][1]-1];
                }
//            else{
//                for(int k = input[i][1]; k<= input[i][3]; k++){
//                    sum += dpRow[input[i][2]][k] - dpRow[input[i][0]-1][k];
//                }
//            }
            sb.append(sum).append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}