import java.util.*;
import java.io.*;

public class Main{
    static int R,C;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static String[][] matrix;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        boolean[][] visited = new boolean[R][C];
        matrix = new String[R][C];
        for(int i=0; i<R; i++){
            s = br.readLine().split("");
            for(int j=0; j<C; j++){
                matrix[i][j] = s[j];
            }
        }

        HashSet<String> set = new HashSet<>();

        System.out.println(dfs(0,0, set, visited, 1));
    }

    static int dfs(int y, int x, HashSet<String> set, boolean[][] visited, int depth){
        ArrayList<Integer> al = new ArrayList<>();

        set.add(matrix[y][x]);
        visited[y][x] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || nx >= C || ny<0 || ny >= R || visited[ny][nx]) continue;
            if(set.contains(matrix[ny][nx])) continue;
            al.add(dfs(ny, nx, set, visited, depth + 1));
        }

        visited[y][x] = false;
        set.remove(matrix[y][x]);
        // 어디도 갈 곳이 없는 상태
        if(al.isEmpty()) return depth;
        // 앞에서 방문한 경로들 중 최댓값
        return Collections.max(al);
    }
}