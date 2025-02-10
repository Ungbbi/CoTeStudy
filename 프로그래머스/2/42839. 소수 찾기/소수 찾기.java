import java.util.Set;
import java.util.HashSet;

class Solution {
    static boolean[] visited = new boolean[7];
    static Set<Integer> set = new HashSet<>();
    
    public static boolean isPrime(int n){
        if (n<2){
            return false;
        }
        
        for(int i=2; i<= (int)Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        
        return true;
    }
    
    public static void dfs(String numbers, String combined, int depth){
        // 모든 숫자를 이용한 조합을 마무리했을 때
        if(depth > numbers.length()) return;
        
        for(int i=0; i<numbers.length();i++){
            if(!visited[i]){
                visited[i] = true;
                set.add(Integer.parseInt(combined + numbers.charAt(i)));
                dfs(numbers, combined + numbers.charAt(i), depth+1);
                visited[i] = false;
            }
        }
    }
    public int solution(String numbers) {
        
        int answer = 0;
        dfs(numbers, "", 0);
        
        for(Integer element: set){
            if(isPrime(element)) answer++;
        }
        return answer;
    }
}