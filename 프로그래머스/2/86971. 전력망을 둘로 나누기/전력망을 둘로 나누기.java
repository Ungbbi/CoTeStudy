import java.util.*;

class Solution{
    static int answer = Integer.MAX_VALUE;
    static ArrayList<Integer>[] graph;
    
    public static void bfs(int start, int n){
        boolean[] visited = new boolean[n+1];
        int cnt = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        
        while(!q.isEmpty()){
            int v = q.poll();
            for(int i: graph[v]){
                if(!visited[i]){
                    q.add(i);
                    cnt ++;
                    visited[i] = true;
                }
            }
        }
        // (n-cnt) - cnt = n-2cnt
        answer = Integer.min(answer, Math.abs(n-2*cnt));
    }
    public int solution(int n, int[][] wires){
        graph = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] wire: wires){
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }
        for(int[] wire: wires){
            graph[wire[0]].remove(Integer.valueOf(wire[1]));
            graph[wire[1]].remove(Integer.valueOf(wire[0]));
            bfs(1, n);
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }
        return answer;
    }
}
/* 
-- Union-Find로 풀어보려 했으나 시간초과 때문인지 어떤 이유에서 탈락하는지 알 수 없음
-- 테스트케이스 6~9를 제외하고는 전부 실패
import java.util.*;

class Solution {
    public static int find_root(int[] parent, int x){
        if(parent[x] != x){
            parent[x] = find_root(parent, parent[x]);
        }
        return parent[x];
    }

    public static void union(int[] parent, int a, int b){
        a = find_root(parent, a);
        b = find_root(parent, b);
        if(a<b) parent[b] = a;
        else parent[a] = b;
    }

    public static int solution(int n, int[][] wires) {
        int groupA;
        int groupB;
        int result = n;
        int[] parents = new int[n+1];

        for(int[] wire : wires){
            groupA = 0;
            groupB = 0;
            for(int i=1; i<=n;i++){
                parents[i] = i;
            }
            //{{3, 5}, {1, 2}, {1, 3}, {1, 4}, {3, 6}, {3, 7}};
            for(int j=0; j<wires.length; j++){
                if (Arrays.equals(wire, wires[j])) continue;
                union(parents, wires[j][0], wires[j][1]);
            }
            int firstNode = parents[1];
            for(int k=1; k<parents.length; k++){
                if(parents[k]==firstNode) groupA++;
                else groupB++;
            }
            result = Integer.min(result, Math.abs(groupA-groupB));
        }
        System.out.println(result);
        return result;
    }
}
*/