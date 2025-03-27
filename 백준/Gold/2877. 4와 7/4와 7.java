import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String s = "";

        while (n > 0) {
            boolean isEven = (n % 2 == 0);
            n /= 2;

            if (isEven) {
                s = "7" + s;
                n--;
            } else {
                s = "4" + s;
            }
        }
        System.out.println(s);
    }
    
    /*
idx    1  2  3   4   5   6   7   8
val    4  7  44  47  74  77  444 447

짝수번째 값들의 일의 자릿값은 7
홀수 - 4
    */
}