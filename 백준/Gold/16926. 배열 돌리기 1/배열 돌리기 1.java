import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N, M, R;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int[][] matrix = new int [N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<M; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        arrRotation(matrix,new int[]{0,0}, new int[]{N-1,M-1}, R);
        StringBuilder sb = new StringBuilder();
        for(int[] i : matrix){
            for(int j : i){
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void arrRotation(int[][] matrix, int[] start, int[] end, int rotation){
        int sn = start[0];
        int sm = start[1];
        int en = end[0];
        int em = end[1];

        int[] tmp = new int[2];
        for(int k=0; k<rotation;k++){

            int snsm = matrix[sn][sm];
            for(int i=em-1; i>=sm; i--){
                //문제 : 이전에 이미 업데이트 된거를 계속 앞에 넣음
                tmp[i%2] = matrix[sn][i];
                if(i==em-1){
                    matrix[sn][i] = matrix[sn][em];
                    continue;
                }
                if(i%2==0) matrix[sn][i] = tmp[1];
                else matrix[sn][i] = tmp[0];
            }

            int ensm = matrix[en][sm];
            for(int i=sn+1; i<=en; i++){
                tmp[i%2] = matrix[i][sm];
                if(i==sn+1){
                    matrix[i][sm] = snsm;
                    continue;
                }
                if (i%2==0) matrix[i][sm] = tmp[1];
                else matrix[i][sm] = tmp[0];
            }

            int enem = matrix[en][em];
            for(int i=sm+1; i<=em; i++){
                tmp[i%2] = matrix[en][i];
                if(i==sm+1){
                    matrix[en][i] = ensm;
                    continue;
                }
                if(i%2==0) matrix[en][i] = tmp[1];
                else matrix[en][i] = tmp[0];
            }

            int snem = matrix[sn][em];
            for(int i=en-1; i>=sn; i--){
                tmp[i%2] = matrix[i][em];
                if(i==en-1){
                    matrix[i][em] = enem;
                    continue;
                }
                if(i%2==0) matrix[i][em] = tmp[1];
                else matrix[i][em] = tmp[0];
            }
        }
        start[0] = sn+1;
        start[1] = sm+1;
        end[0] = en-1;
        end[1] = em-1;

        if(start[0]>end[0] || start[1]>end[1]) return;
        else arrRotation(matrix, start, end, rotation);
    }
}

/*            [sn][em-i]
          {sn,sm} ----- {sn,em}
[sn+i][sm]   |            |    [en-i][em]
             |            |
          {en,sm} ------{en,em}
                [en][sm+i]

*/