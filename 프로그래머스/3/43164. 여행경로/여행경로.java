// dfs 모두 이용
import java.util.*;

class Solution {
    static String base = "ICN";
    static String[] departures;
    static String[] destinations;
    static String[] answer;
    static ArrayList<String> aryListAL = new ArrayList<>();

    static void dfs(String destination, boolean[] visited, int depth, ArrayList<String> al){
        for(int i=0; i<visited.length; i++){
            
            // 매개변수로 받은 destination(목적지)에 해당하는 출발지가 존재하며 방문하지 않았다면
            if(departures[i].equals(destination) && !visited[i]){
                visited[i] = true;
                // 선택된 항공편의 목적지를 매개변수로 넘겨준다.
                al.add(departures[i]);
                dfs(destinations[i], visited, depth+1, al);
                visited[i] = false;
                // 출발지는 같으나 다른 목적지로 이동하는 경우도 고려해야 하므로
                // 이전에 dfs로 탐색했을때의 경로 기록 삭제
                al.remove(al.size()-1);
                // al.removeLast(); JDK 1부터 가능
            }
            // destination에 해당하는 출발지가 없으나 그것이 마지막 여행인 경우
            else if(depth==visited.length){
                al.add(destination);
                aryListAL.add(String.join("",al));
                al.remove(al.size()-1);
                // al.removeLast(); JDK 21부터 가능
                
                return;
            }
        }
    }

    public static String[] solution(String[][] tickets) {
        departures = new String[tickets.length];
        destinations = new String[tickets.length];
        for(int i=0; i<tickets.length; i++){
            departures[i] = tickets[i][0];
            destinations[i] = tickets[i][1];
        }
        
        boolean[] visited = new boolean [tickets.length];
        ArrayList<String> al = new ArrayList<>();

        dfs(base, visited, 0,al);
        
        // 문자열 정렬
        aryListAL.sort((a, b) -> a.compareTo(b));
        
        //문자 하나하나 쪼갠다.
        String[] temp = aryListAL.get(0).split("");
        String[] answer = new String[tickets.length+1];
        // 3글자 단위로 쪼개서 붙이고 하나의 원소로
        for(int i=0; i<temp.length; i=i+3){
            answer[i/3] = String.join("",temp[i], temp[i+1], temp[i+2]);
        }
        
        return answer;
    }

}