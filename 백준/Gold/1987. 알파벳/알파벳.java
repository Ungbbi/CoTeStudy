import java.util.*;
import java.io.*;
public class Main{
    static int R, C;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static char[][] matrix;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        
        matrix = new char[R][C];
        for(int i = 0; i < R; i++){
            String line = br.readLine();
            for(int j = 0; j < C; j++){
                matrix[i][j] = line.charAt(j);
            }
        }
        
        // 알파벳 방문 여부를 비트마스킹으로 표현
        int maxDepth = dfs(0, 0, 1, 1 << (matrix[0][0] - 'A'));
        System.out.println(maxDepth);
    }
    
    static int dfs(int y, int x, int depth, int visited){
        int maxPath = depth;
        
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= C || ny < 0 || ny >= R) continue;
            
            char nextChar = matrix[ny][nx];
            int bit = 1 << (nextChar - 'A');
            
            // 이미 방문한 문자면 스킵
            if((visited & bit) != 0) continue;
            
            // 비트마스킹으로 방문 표시를 업데이트하고 재귀 호출
            maxPath = Math.max(maxPath, dfs(ny, nx, depth + 1, visited | bit));
        }
        
        return maxPath;
    }
}