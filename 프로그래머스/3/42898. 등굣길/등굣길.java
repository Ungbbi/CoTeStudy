import java.util.*;

// bfs로 풀면 효율성에서 불합격됨.
// 오른쪽, 아래쪽에 Focus
// 해당 타일에서 왼쪽과 윗쪽 타일의 값들을 더하면 될듯
// 침수나 인덱스 범위 밖으로 인해 하나밖에 못더하면 그냥 그대로 값을 이어받게 됨.
// 처음에 1행과 1열에 해당하는 모든 타일은 1로 채운다.
// 

class Solution {
    // 오른쪽과 아래로만 이동하므로 visited는 필요 없다.

    // puddles : 물에 잠긴 지역 (0~10)
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1];
        
        for(int[] p : puddles){
                dp[p[1]][p[0]] = -1;            
        }
        dp[1][1] = 1;
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(dp[i][j]==-1){
                    dp[i][j] = 0;
                    continue;
                }
                if(i==1 && j==1) continue;
                else if(i==1 && j>1) dp[1][j] = dp[1][j-1];
                else if (j==1 && i>1) dp[i][1] = dp[i-1][j];
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        

        int ans = dp[n][m] % 1000000007;
        return ans;
    }
}



//  static int bfs(int n, int m){
//         int cnt = 0;
//         Queue<int[]> q = new LinkedList<>();
        
//         q.add(new int[]{1,1});
        
//         while(!q.isEmpty()){
//             int[] now = q.poll();
//             int x = now[0];
//             int y = now[1];
            
//             for(int i=0; i<2; i++){
//                 int nx = x+dx[i];
//                 int ny = y+dy[i];
                
//                 if(nx<1 || nx>n || ny<1 || ny>m) continue;
//                 if(map[nx][ny] == 1) continue;
//                 if(nx==n && ny==m){
//                     cnt ++;
//                     continue;
//                 }
//                 q.add(new int[]{nx, ny});
//             }
//         }
//         return cnt;
//     }