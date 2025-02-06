package ECoTe.CHAP08_DP;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class MakeOne {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /* x가
        1. 5로 나눠떨어지면, 5로 나눈다.
        2. 3으로 나눠떨어지면, 3으로 나눈다.
        3. 2로 나눠떨어지면 2로 나눈다.
        4. x에서 1을 뺀다.
         */
        int x = Integer.parseInt(br.readLine());
        // 5로 나눈 후 나머지 1~4 중 나머지가 4인 경우엔 최소 2번의 연산이 필요
        // 그 외 나머지가 1~3인경우는 1번의 연산이 필요
        int cnt = 0;
        int div = x;
        int mod=0;
        while(div>=5){
            mod = div%5;
            div = div/5;
            cnt ++;
        }
        if(mod==4){
            cnt +=2;
        }
        else if(mod>0) cnt++;

        System.out.println(cnt);
    }
}
