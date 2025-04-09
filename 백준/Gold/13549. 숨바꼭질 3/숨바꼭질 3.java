import java.util.*;
import java.io.*;

public class Main{
    // bfs?
    // 언제 종료를 해야하는가
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int A = Integer.parseInt(s[0]);
        int B = Integer.parseInt(s[1]);

        if(A>B){
            System.out.println(A-B);
            return;
        }
        visited = new boolean[B*2 + 1];
        bfs(A,B);
    }
    static void bfs(int start, int end){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start,0});
        int max = 0;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int time = now[1];
            
            if(x>end*2) continue;
            if(visited[x]) continue;
            visited[x] = true;
            if(x==end){
                max = time;
                break;
            }
            if(x*2 <= end*2 && !visited[x*2]) q.add(new int[]{x*2,time});
            // x = 0일 때 인덱스 문제 발생
            if(x!=0 && !visited[x-1]) q.add(new int[]{x-1,time+1});
            if(x+1 <= end*2 && !visited[x+1]) q.add(new int[]{x+1,time+1});
        }
        System.out.println(max);
        return;
    }
}