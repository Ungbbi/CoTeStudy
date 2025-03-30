import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            map.put(br.readLine(), 1);
        }

        for(int i=0; i<M; i++){
            String s = br.readLine();
            if(map.containsKey(s)){
                map.put(s,2);
            }
        }
        ArrayList<String> al = new ArrayList<>();
        map.forEach((a,b) -> {if (b==2) al.add(a);});
        
        // 사전순으로  출력해야 한다.
        al.sort(Comparator.naturalOrder());
        
        System.out.println(al.size());               
        for(String s : al){
            System.out.println(s);
        }
    }
}