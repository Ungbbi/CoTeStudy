import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int[][] result;

    static void bfs(int origin, int N){
        Queue<Integer> q  = new LinkedList<>();
        boolean[] visited = new boolean[N];

        q.add(origin);
        while(!q.isEmpty()){
            int n = q.poll();
            for(int i=0; i<N; i++){
                if(map[n][i]==1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    result[origin][i] = 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        result = new int[N][N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

        for(int i=0; i<N; i++){
            bfs(i, N);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}