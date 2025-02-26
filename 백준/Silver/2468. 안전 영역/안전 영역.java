import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Main{
    // 상하좌우
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{-1,1,0,0};
    static int N;
    static int[][] matrix;
    static boolean[][][] visited;
    static int result = 0;

    // 안전영역 만들때 마다 arrayList 하나씩 만들기~
    public static void getSafetyZone(int max){

        for(int i=0; i<max; i++){
            int groupCnt = 0;

            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    if (visited[j][k][i]) continue;   // 이미 방문한 곳
                    if (matrix[j][k]<=i) continue;    // 침수된 곳

                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{j,k});
                    visited[j][k][i] = true;

                    while(!q.isEmpty()){
                        int[] now = q.poll();
                        int x = now[0];
                        int y = now[1];
                        if(matrix[x][y]<=i) continue;

                        for(int l=0; l<4; l++){
                            int nx = x + dx[l];
                            int ny = y + dy[l];

                            if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
                            if(visited[nx][ny][i]) continue;
                            if(matrix[nx][ny] <= i) continue;
                            visited[nx][ny][i] = true;
                            q.add(new int[]{nx,ny});
                        }
                    } groupCnt++;
                }
            }
            result = Integer.max(result,groupCnt);
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];

        int max = 0;

        for(int i=0; i<N; i++){
            String[] s = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                int tmp = Integer.parseInt(s[j]);
                max = Integer.max(max,tmp);
                matrix[i][j] = tmp;
            }
        }

        visited = new boolean[N][N][max+1];

        getSafetyZone(max);
        System.out.println(result);

    }
}