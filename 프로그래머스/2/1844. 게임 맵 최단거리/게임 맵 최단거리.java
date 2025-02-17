import java.util.*;

class Solution {        // 상하좌우
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    // static boolean[][] visited;
    static int n,m;
    static int min = Integer.MAX_VALUE;
    // 방문처리를 취소해줘야한다.

        public static int bfs(int[][] maps, int n, int m) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        // 시작점 (0,0) 추가 & 방문 처리
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];

            // 목적지에 도달하면 거리 반환
            if (x == n - 1 && y == m - 1) {
                return count;
            }

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 내, 벽이 아니고, 방문하지 않은 경우만 큐에 추가
                if (nx >= 0 && nx < n && ny >= 0 && ny < m 
                    && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    // 만약 겹친다 했을때 먼저 도달한 경로가
                    //  더 짧은 경로이므로 (bfs이기에) false로 변경할 필요가 없다.
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, count + 1});
                }
            }
        }

        return -1; // 도달할 수 없는 경우
    }
    
    public static int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        // visited = new boolean[maps.length][maps[0].length];
        // visited[0][0] = true;
        // dfs(0,0,maps, 1);
        // return (min==Integer.MAX_VALUE)?-1:min;
        return bfs(maps, n, m);
        
    }
}

    
    // dfs 시간초과해서 bfs로 변경 
//     public static void dfs(int x, int y, int [][]maps, int count){
//         if(x==n-1 && y == m-1){
//             min = Math.min(min, count);
//             return;
//         }



//         for(int i=0; i<4; i++){
//             int nx = x + dx[i];
//             int ny = y + dy[i];
//             // 범위 밖 또는  방문한 곳 또는 벽이라면 패스
//             if(nx<0 || ny<0 || nx>=n || ny>=m || visited[nx][ny] || maps[nx][ny]==0)
//                 continue;
//             visited[nx][ny] = true;
//             dfs(nx,ny, maps, count+1);
//             visited[nx][ny] = false;
//         }
//     }