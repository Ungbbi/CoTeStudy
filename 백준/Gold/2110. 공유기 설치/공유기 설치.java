import java.util.*;
import java.io.*;

//  좌표 정렬

public class Main{
    static int N,C;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];

        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        // 맨 첫번째 공유기와 마지막 공유기 간 거리의 중간값을 구한다. -> 이웃한 두 공유기 간 거리의 최댓값
        int lo = 0;
        int hi = nums[N-1]-nums[0];
        int mid;
        int result=0;

        while(lo <= hi){
            mid = (hi+lo)/2;
            int prevRouter = nums[0];
            int routerCnt = 1;

            for(int i=1; i<N; i++){
                // mid : 두 공유기 간 최소 거리
                //  앞서 설정한 mid에 따라 이웃한 두 공유기 간 거리가 최소거리보다는 커야한다.
                if(nums[i] - prevRouter >= mid){
                    routerCnt++;
                    // 현재 공유기 위치로 변환
                    prevRouter = nums[i];
                }
                // 만약 최소 거리보다 가까우면 공유기 설치하지 않는다. (무시)
            }


            // 공유기 수가 C보다 많음 -> 거리를 더 늘릴 수 있다.
            if (routerCnt>=C){
                result = mid;
                lo = mid+1;
            }

            // 공유기 수가 C보다 적음 -> 거리를 줄여야 함
            if(routerCnt<C){
                hi = mid-1;
            }

        }
        System.out.println(result);
    }
}