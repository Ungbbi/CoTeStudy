// bfs와 visited?
import java.util.*;
import java.io.*;

public class Main{
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static void bfs(int[][] map){
        int N = map.length;
        int[][] visited = new int[N][N];

        ArrayList<Integer> al = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        int groupNum = 0;
        int cnt=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                // 집이 없거나 방문했던 곳이라면 pass
                if(map[i][j]==0 || visited[i][j] == 1) continue;
                q.add(new int[]{i,j});
                groupNum ++;
                cnt = 0;
                while(!q.isEmpty()){
                    int[] now = q.poll();
                    int n = now[0];
                    int m = now[1];
                    if(visited[n][m]==1) continue;
                    visited[n][m] = 1;
                    cnt ++;

                    for(int k=0; k<4; k++){
                        int nx = m+dx[k];
                        int ny = n+dy[k];
                        if(nx<0 || nx>=N || ny<0 || ny>=N || visited[ny][nx] == 1) continue;
                        if(map[ny][nx]==1)  q.add(new int[]{ny,nx});
                    }
                }
                al.add(cnt);
            }
        }
        Collections.sort(al);
        StringBuilder sb = new StringBuilder();
        sb.append(groupNum).append("\n");

        for(int a : al){
            sb.append(a).append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for(int i=0; i<N; i++){
            String[] s = br.readLine().split("");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        bfs(map);
    }
}