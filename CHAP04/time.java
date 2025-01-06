package CHAP04;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class time {
    public static void main(String[] args) throws IOException{
        final int MAXMINUTE = 59;
        final int MAXSECOND = 59;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        if(N.length()==1) {
            N = "0" + N;
        }
        String[] numbers = N.split("");

        for(int i=0;i<=Integer.parseInt(N);i++){
            if(Arrays.stream(numbers).anyMatch("3"))
        }


    }
}
