import java.util.*;

class Solution {
    static String targetWord;
    static String[] wordSet;
    static int result = Integer.MAX_VALUE;
    static ArrayList<String> als = new ArrayList<>();
    
    public void dfs(String now, int depth, boolean[] visited){
        if(now.equals(targetWord)){
            result = Math.min(result, depth);
            return;
        }
        if(depth>visited.length) return;
        
        for(int i=0; i<visited.length; i++){
            if(visited[i]) continue;
            String[] nowSplit = now.split("");
            String[] s = als.get(i).split("");
            int notMatchCnt = 0; // 문자 하나만 달라야하므로 1이 되어야 함
            
//             for(String c : s){
//                 if(!now.contains(c)) notMatchCnt++;
//                 //!!!! 테스트케이스 실패 -> 같은문자가 여러개라면 실패한다.
//                 //인덱스를 가지고 한문자 한문자 비교하자.
//             }
            for(int j=0; j<s.length; j++){
                if(!nowSplit[j].equals(s[j])) notMatchCnt++;
            }
            
            if(notMatchCnt==1){
             visited[i] = true;
             dfs(wordSet[i], depth+1, visited);
             visited[i] = false;
            }
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        targetWord = target;
        wordSet = words;
        for(String s : words){
            als.add(s);
        }
        boolean[] visited = new boolean[words.length];
        dfs(begin, 0, visited);
        if(result == Integer.MAX_VALUE) return 0;
        else return result;
    }
}