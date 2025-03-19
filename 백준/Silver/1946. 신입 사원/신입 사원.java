import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main{
    // 지원자 N명 들의 성적 인덱스 : 서류, 값 : 면접
    static int[] grades;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            grades = new int[N+1];

            for(int j=0;j<N; j++){
                st = new StringTokenizer(br.readLine()," ");
                int docsIndex = Integer.parseInt(st.nextToken());
                grades[docsIndex] = Integer.parseInt(st.nextToken());
            }


            int cnt = 1;
            int cri = grades[1];
            // 자기보다 서류등수가 위인 사람들의 면접 점수가 자신의 면접 점수보다 높은 사람이
            // 단 한 사람이라도 있으면 탈락이므로
            for(int j=2; j<=N; j++){
                if(grades[j] < cri){
                    cri = grades[j];
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}