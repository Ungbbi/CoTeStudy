import java.util.*;
import java.io.*;

/*
모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정한다.
모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액을 계산하여
그 이상인 예산요청에는 모두 상한액을 배정한다.
상한액 이하의 예산요청에 대해서는 요청한 금액을 그대로 배정한다

*/
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] budgets = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int totalSum = 0;
        for (int i=0; i<N; i++){
            budgets[i] = Integer.parseInt(st.nextToken());
            totalSum += budgets[i];
        }
        Arrays.sort(budgets);

        int M = Integer.parseInt(br.readLine());
        if(totalSum <= M) System.out.println(budgets[N-1]);
        else{
            int v = getMaxBudget(N, M, budgets);
            System.out.println(v);
        }
    }
    public static int getMaxBudget(int N, int M, int[] budgets){
        int[] arr = new int[N+1];

        int lo = 1;
        int hi = budgets[N-1];
        int mid;
        int result=0;
        while(lo <= hi){
            mid = (hi+lo)/2;
            int total = 0 ;
            for(int i=0; i<N; i++){
                int b = budgets[i];
                if(b <= mid){
                    total += b;
                }
                else total += mid;
            }
            // 예산보다 크므로 상한액을 감소시킨다.
            if (total > M){
                hi = mid-1;
            }
            // 주어진 예산에 여유가 생기므로 상한액을 증가시킨다.
            if (total < M){
                lo = mid+1;
                result = mid;
            }
            // M과 같다면 최대치이므로 더 이상 계산할 필요가 없다.
            if (total == M){
                result = mid;
                break;
            }
        }
        return result;
    }

}