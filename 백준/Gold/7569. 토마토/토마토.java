import java.util.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

// -1 : 토마토 없음, 0 : 안익음, 1 : 익어있음
public class Main{
    static int[][][] map;
    static int[][][] visited;
    static int N,M,H;
    // 높이(위), 높이(아래), 상 하 좌 우
    static int[] dx = {0,0,0,0,-1,1};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {-1,1,0,0,0,0};

    static int bfs(Queue<int[]> queue){
        int x,y,z,day;

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            z = now[0];
            y = now[1];
            x = now[2];
            day = now[3];
            //TODO 고려해야함. 처음에 넣었을 때 익은걸 큐에 넣으니 바로 pass 됨
            if(visited[z][y][x]>0 && map[z][y][x]!=1) continue;
            visited[z][y][x] = day;

            for(int i=0; i<6; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                int nz = z+dz[i];
                // 경계 밖
                if(nx<0 || nx>=N || ny<0 || ny>=M || nz<0 || nz>=H) continue;
                // 맨 처음에 주어진 익힌 토마토가 아니라 방문을 통해 익어진 토마토는 패스
                if(visited[nz][ny][nx]>=1 || visited[nz][ny][nx] == -1) continue;
                queue.add(new int[]{nz,ny,nx,day+1});
            }
        }

        int result = 0;
        for(int k=0; k<H; k++){
            for(int i=0; i<M; i++){
                for(int j=0; j<N; j++){
                    if(visited[k][i][j]==0) return -1;
                    result = Integer.max(result, visited[k][i][j]);
                }
            }
        }
        return result-1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        // N : 열, M : 행, H : 높이
        map = new int[H][M][N];

        // 큐가 empty 된 후, visited에 0이 남아있으면 -1으로 해야함
        visited = new int[H][M][N];

        Queue<int[]> queue = new LinkedList<>();

        // map 생성
        for(int k=0; k<H; k++){
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0; j<N; j++){
                    int a = Integer.parseInt(st.nextToken());
                    map[k][i][j] = a;
                    visited[k][i][j] = a;
                    if(a==1){
                        queue.add(new int[]{k,i,j,a});
                    }
                }
            }
        }
        System.out.println(bfs(queue));
    }
}