import java.util.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            // TreeMap 은 오름차순 정렬이 Default
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int M = Integer.parseInt(br.readLine());

            for(int j=0; j<M; j++){
                String[] input = br.readLine().split(" ");
                int key = Integer.parseInt(input[1]);

                if(input[0].equals("I")){
                    Integer x = map.get(key); // 키에 해당하는 값 없으면 Null 반환하므로 Integer
                    // 이미 값이 들어가있다면
                    if(x != null){
                        map.put(key,x+1);
                    }
                    else map.put(key,1);
                }

                else{
                    if(map.isEmpty()) continue;
                    // 값 가장 작은 것 poll
                    if(key == -1){
                        Integer a = map.firstEntry().getKey();
                        Integer b = map.firstEntry().getValue();
                        if(b > 1) map.put(a, b-1);
                        else map.pollFirstEntry();
                    }
                    else{
                        Integer a = map.lastEntry().getKey();
                        Integer b = map.lastEntry().getValue();
                        if(b > 1) map.put(a, b-1);
                        else map.pollLastEntry();
                    }
                }
            }
            if(map.isEmpty()) sb.append("EMPTY\n");
            else{
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}