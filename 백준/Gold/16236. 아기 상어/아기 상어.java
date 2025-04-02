import java.util.*;
import java.io.*;

class Fish implements Comparable<Fish>{
    int n;
    int m;
    int dist;

    Fish(int n, int m, int dist){
        this.n = n;
        this.m = m;
        this.dist = dist;
    }
    @Override
    public int compareTo(Fish target){
        if(this.dist > target.dist) return 1;
        else if(this.dist < target.dist ) return -1;

        if(this.n > target.n) return 1;
        else if (this.n < target.n) return -1;

        if(this.m > target.m) return 1;
        else return -1;
    }
}
// ****************************************************************************
public class Main{
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static PriorityQueue<Fish> pq = new PriorityQueue<>();
    static int[][] map;
    static int N;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[N][N];

        int sharkSize = 2;
        int exp = 0;

        // 상어 좌표(x,y), 크기, 경험치(?), 경과시간
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==9){
                    q.add(new int[]{i,j,0});
                    map[i][j] = 0;
                }

            }
        }

        int total = 0;
        bfs(q,sharkSize);
        // pq에서 하나 뽑고 그거로 bfs 돌리고 나온 최종 위치에서 pq 하나 뽑고 bfs 탐색 (탐색 전 pq 초기화)
        while(!pq.isEmpty()){
            Fish shark = pq.poll();
            exp ++;
            map[shark.n][shark.m] = 0;
            if(sharkSize == exp){
                sharkSize++;
                exp = 0;
            }
            total += shark.dist;
            pq.clear();
            q.add(new int[]{shark.n, shark.m, 0});
            bfs(q, sharkSize);
        }
        System.out.println(total);
    }

    static void bfs(Queue<int[]> q, int size){
        // q : y, x, 거리
        boolean[][] visited = new boolean[N][N];

        while(!q.isEmpty()){
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];
            int dist = now[2];

            visited[y][x] = true;
            if(map[y][x]>0 && map[y][x] < size){
                pq.add(new Fish(y,x,dist));
            }
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx>=N || ny<0 || ny>=N || visited[ny][nx]) continue;
                if(map[ny][nx]>size) continue;
                visited[ny][nx] = true;
                q.add(new int[]{ny,nx,dist+1});
            }
        }
    }
}