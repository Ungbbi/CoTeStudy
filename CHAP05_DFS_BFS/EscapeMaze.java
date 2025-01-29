package CHAP05_DFS_BFS;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Queue;

public class EscapeMaze {
    static int x = 1;
    static int y = 1;
    static int N;
    static int M;
    // 미로 정보 매트릭스
    static int[][] graph;
    // 상 하 좌 우
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};

    static class Node{
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void bfs(int[][] graph, int[][] visited){
        Queue<Node> queue = new LinkedList<>();
        int nx, ny;
        int dist = 1;
        int sol = 0;
        Integer[] ary = new Integer[]{0,0};
        queue.add(new Node(1,1,dist));

        while(!queue.isEmpty()){
            Node n = queue.poll();
            x = n.x;
            y = n.y;
            dist = n.dist;
            if(x==N && y==M){
                sol = dist;
             break;
            }
            for(int i=0; i<4; i++){
                nx = x + dx[i];
                ny = y + dy[i];
                // 상하좌우 노드가 범위 밖에 있을 시 Continue
                if(nx<1 || nx>N || ny<1 || ny>M) continue;
                // 0이 있는 부분은 괴물이 있는 곳이므로 Pass
                if(graph[nx][ny]==0) continue;
                // 1이 있는 곳을 지나가야 한다.
                if(graph[nx][ny]==1){
                    // 이미 방문한 곳인지 체크
                    if(visited[nx][ny]==0){
                        queue.add(new Node(nx,ny,dist+1));
                        visited[nx][ny] = 1;
                    }
                }
            }
        }
        System.out.println(sol);


    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        int[][] visited = new int[N+1][M+1];
        graph = new int[N+1][M+1];

        for(int i=1; i<=N; i++){
            String[] inputs = br.readLine().split("");
            for(int j=1; j<=M; j++){
                graph[i][j] = Integer.parseInt(inputs[j-1]);
            }
        }
        bfs(graph, visited);
    }
}
