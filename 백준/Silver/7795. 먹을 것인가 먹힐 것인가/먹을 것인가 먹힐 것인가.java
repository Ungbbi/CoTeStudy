import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int[] a = new int[A];
            int[] b = new int[B];
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<A; j++){
                a[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0 ; j<B; j++){
                b[j] = Integer.parseInt(st.nextToken());
            }

            int sum = 0;
            Arrays.sort(b);

            for(int j=0; j<A; j++){
                // 인덱스를 반환ㄹ해줌
                int v = getCouples(a[j],b);
                if(v==-1) continue;
                sum += v;
            }
            System.out.println(sum);
        }
    }

    // 인덱스를 반환해줌
    static int getCouples(int a, int[] b){

        int lo = 0;
        int hi = b.length-1;
        int v = -1;
        while(lo <= hi){
            int mid = (lo+hi)/2;
            if(a > b[mid]){
                lo = mid+1;
                v = lo;
            }
            else if(a <= b[mid]){
                hi = mid-1;
            }
        }
        return v;

    }
}