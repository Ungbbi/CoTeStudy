
import java.util.*;
import java.io.*;

public class Main{
    static int N,M,K;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static int[] h_dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] h_dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    
    static int[][] map;
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);

        map = new int[N][M];
        visited = new boolean[N][M][K+1];
        StringTokenizer st;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
    }

    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,0,K});
        visited[0][0][K] = true;

        while(!q.isEmpty()){

            int[] now = q.poll();
            int n = now[0];
            int m = now[1];
            int move = now[2];
            int k = now[3];
            if(n == N-1 && m == M-1){
                System.out.println(move);
                return;
            }
            int nx,ny;
            if(k>0){
                for(int i=0; i<8; i++){
                    nx = m + h_dx[i];
                    ny = n + h_dy[i];
                    if(nx<0 || nx>=M || ny<0 || ny>=N || visited[ny][nx][k-1] || map[ny][nx] == 1) continue;
                    visited[ny][nx][k-1] = true;
                    q.add(new int[]{ny,nx,move+1, k-1});
                }
            }

            for(int i=0; i<4;i++){
                nx = m + dx[i];
                ny = n + dy[i];

                if(nx<0 || nx>=M || ny<0 || ny>=N || visited[ny][nx][k] || map[ny][nx]==1) continue;
                visited[ny][nx][k] = true;
                q.add(new int[]{ny,nx,move+1, k});
            }
        }
        System.out.println("-1");
        return;
    }
}