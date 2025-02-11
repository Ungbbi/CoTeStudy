// 피로도 : 1~5000
// 최소 >= 소모 
// Row : 던전, Col : 피로도
import java.util.*;


class Solution {
    static int needFatigue;
    static int usedFatigue;
    static int maxResult = 0;
    static int result;
    static boolean[] visited = new boolean[8];
    
    public static void dfs(int[][] dungeons,int fatigue,int v, int result){
        if(v>=dungeons.length) {
            maxResult = Math.max(maxResult, result);
            return;
        }

        for(int i=0; i<dungeons.length;i++){
            if(!visited[i]){
                visited[i] = true;
                needFatigue = dungeons[i][0];
                usedFatigue = dungeons[i][1];
                if(fatigue-needFatigue>=0){
                    dfs(dungeons, fatigue-usedFatigue, v+1, result+1);
                }
                else dfs(dungeons, fatigue, v+1, result);
                visited[i] = false;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];

        // 최소 필요 피로도 : 내림차순, 소모 피로도 : 오름차순
        Arrays.sort(dungeons, (a,b) ->{
            if(a[0] == b[0]) return Integer.compare(a[1],b[1]);
            return Integer.compare(b[0], a[0]);
        });
        dfs(dungeons, k, 0, 0);
        return maxResult;
    }
}