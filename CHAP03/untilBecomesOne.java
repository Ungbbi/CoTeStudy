package CHAP03;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class untilBecomesOne {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int numberOfDivide = 0;
        int sol = N%K;
        while(true){
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
