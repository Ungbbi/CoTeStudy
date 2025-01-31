package CHAP03_Greedy;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UntilBecomesOne {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        // N을 K로 나눈 횟수
        int numberOfDivide = 0;
        // 나눠지지 않아서 1을 뺀 횟수 = N을 K로 나눈 나머지
        int sol = N%K;

        // 나눠지는 수의 횟수
        while(true){
            // 1이 될 때 까지 나눈 후, 나눈 횟수 + 1을 뺀 횟수 더함
            if(N==1){
                sol += numberOfDivide;
                break;
            }
            N = N/K;
            numberOfDivide++;
        }
        System.out.println(sol);
    }
}
