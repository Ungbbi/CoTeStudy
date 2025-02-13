// 참가자  완주자
/* - 미완주자 출력 -
1. 참가자 - 완주자 
2. 중복이 있음
2-1. 참가자 중에서 완주자에 있는 동일한 원소가 있다면 둘다 하나씩 제거 (동명이인 고려)
2-2. 완주자의 모든 원소를 탐색하고 나서 남은 참가자가 곧 미완주자.

*/
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        // 참가자 목록을 맵에 저장 (이름별 등장 횟수 기록)
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        // 완주자를 맵에서 제거 (동명이인 고려)
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }
        
        // 값이 1 이상 남은 사람이 미완주자
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                return entry.getKey();
            }
        }
        
        return "";
    }
}
