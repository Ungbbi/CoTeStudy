package CHAP05;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

// 문제 풀이 dfs
/*
0. 맨 처음 방문한 노드를 시작으로 dfs를 수행한다. 수행을 마치면 노드와 인접한 모든 노드들이 방문처리된다.
1. 방문처리는 1로 한다. dfs함수 내에서 조건문으로 방문처리 됐거나 '1'이면 false를 반환
2. 결괏값 도출 부분에서 if문에 의해 뭉텅이(?) 별로 Count 할 수가 있게 된다.
2-1. 노드의 값이 0인 노드를 처음 방문하면 그것과 인접한 노드들은 모두 1로 처리되어 후에 dfs를 수행할 때 false값을 받아 count가 안된다.

 */

public class IcingDrink {
    static int N;
    static int M;
    static int[][] graph;

    public static boolean dfs(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M)
            return false;

        if (graph[x][y] == 0) {
            graph[x][y] = 1; // 방문 처리

            dfs(x-1, y);
            dfs(x + 1, y);
            dfs(x, y-1);
            dfs(x, y + 1);

            return true;
        }
        return false;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        // 방문처리 위한 Matrix
        int[][] visited = new int [N][M];

        // graph 생성
        graph = new int [N][M];
        for(int i=0; i<N; i++){
            String[] s = br.readLine().split("");
            for(int j=0; j<M; j++){
                graph[i][j] = Integer.parseInt(s[j]);
            }
        }

        int count = 0;

        // 결괏값 도출
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(dfs(i,j)){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
