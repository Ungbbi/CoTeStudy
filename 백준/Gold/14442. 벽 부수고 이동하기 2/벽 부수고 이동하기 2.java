import java.util.*;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;


public class Main{
    // 상하좌우
    static int N, M, K;
    static int[] dx = {-1,1,0,0};
    static int[] dy ={0,0,-1,1};
    static int[][] visited;

    public static int bfs(int[][] matrix, int[] start){
        visited[0][0] = 0;
        int nx, ny, destroy, dist;
        Queue<int[]>q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            dist = now[2];

            if (x==N-1 && y==M-1){
                return dist;
            }
            for(int i=0;i<4; i++){
                nx = x + dx[i];
                ny = y + dy[i];
                destroy = now[3];

                if(nx<0 || nx>=N || ny<0 || ny>=M) continue; // 범위 밖

                if(matrix[nx][ny]==1) destroy++;
                if(destroy>K) continue;

                /* 최적화
                 만약 방문지까지 도달하기까지의 벽뿌 횟수가 3인것 경로로 도착지에 가는 것이 성공하면 1도 성공할 것이다.
                 왜냐하면 방문지까지 3번뿌셨으며 앞으로 목적지를 가는 동안 한번도 벽을 뿌실 일이 없기 때문.
                 그러므로 벽뿌 횟수가 1인 것이 성공했다 하더라도 3인것이 성공할 보장은 없다.
                 */
                if(visited[nx][ny] > destroy) visited[nx][ny] = destroy;
                else continue;


                q.add(new int[]{nx, ny, dist+1, destroy});
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        visited = new int[N][M];
        for(int i=0; i< N; i++){
            // K는 최대 10 이므로
            Arrays.fill(visited[i], 11);
        }
        int[][] matrix = new int[N][M];
        // 맵 초기화
        for(int i=0; i<N; i++){
            String[] s = br.readLine().split("");
            for(int j=0; j<M; j++){
                matrix[i][j] = Integer.parseInt(s[j]);
            }
        }

        //dfs(matrix, 0,0,0,0);
        System.out.println(bfs(matrix,new int[]{0,0,1,0}));

    }
}


