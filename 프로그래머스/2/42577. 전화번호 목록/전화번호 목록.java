// matches를 활용한 정규표현식으로 풀면 효율성에서 탈락
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        
        for(String s : phone_book){
            set.add(s);
        }
        
        for(String s : phone_book){
            StringBuilder sb = new StringBuilder();
            
            for(int i=0; i<s.length() - 1; i++){
                sb.append(s.charAt(i));
                if(set.contains(sb.toString())) return false;
            }
        }
        return true;
    }
}