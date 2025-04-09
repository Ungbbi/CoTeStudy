import java.util.*;
import java.io.*;

public class Main{
    // bfs?
    // 언제 종료를 해야하는가    
    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        // A<=B가 아니다. B < A 인 경우도 존재
        int A = Integer.parseInt(s[0]);
        int B = Integer.parseInt(s[1]);
        
        set = new HashSet<>(2*B+1);
        bfs(A,B);
    }
    static void bfs(int start, int end){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start,0});
        int max = 0;
        if (start > end){
            System.out.println(start-end);
            return;
        }
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int time = now[1];
            if(x<0) continue;
            if(set.contains(x)) continue;
            set.add(x);
            if(x==end){
                max = time;
                break;
            }
            if(x*2 <= end*2 && !set.contains(x*2)) q.add(new int[]{x*2,time});
            if(x>0 && !set.contains(x-1)) q.add(new int[]{x-1,time+1});
            if(x+1 <= end*2 && !set.contains(x+1)) q.add(new int[]{x+1,time+1});
        }
        System.out.println(max);
        return;
    }
}