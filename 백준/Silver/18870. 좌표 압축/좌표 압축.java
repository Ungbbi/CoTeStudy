import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        int[] sort = new int[N];
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i=0; i<N; i++)
            numbers[i]=Integer.parseInt(st.nextToken());

        sort = numbers.clone();

        Arrays.sort(sort);

        int index=0;
        for(int i=0; i<N; i++) {
            if(!hashMap.containsKey(sort[i]))
                hashMap.put(sort[i], index++);
        }
        for(int i=0; i<N; i++)
            sb.append(hashMap.get(numbers[i])).append(" ");
        System.out.print(sb);
        br.close();

    }
}