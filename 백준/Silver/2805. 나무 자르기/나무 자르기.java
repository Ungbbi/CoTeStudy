import java.util.*;
import java.io.*;

// 몇몇 변수들은 long 타입인데 이는 문제에서 주어지는 데이터 범위를 만족시키기 위해서다.

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N,M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 길이 H보다 작으면 냅두고 크면 자르고 남은 나머지를 가져간다.
        st = new StringTokenizer(br.readLine()," ");
        int[] trees = new int[N];
        for(int i=0; i<N; i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        int lo = 0;
        int hi = trees[N-1];
        long result = 0;

        while(lo <= hi){
            int mid = (hi+lo)/2;
            long total = 0;

            for(int i=0; i<N; i++){
                long remain = trees[i] - mid;
                if(remain<=0) continue;
                total += remain;
            }

            // 가져가려는 길이보다 부족 -> 너무 크게 자름 -> 자르는 길이 축소
            if(total<M){
                hi = mid-1;
            }
            // 가져가려는 길이보다 많음 -> 너무 작게 자름 -> 자르는 길이 확장
            if(total>=M){
                lo = mid+1;
                result = mid;
            }
        }

        System.out.println(result);
    }
}
