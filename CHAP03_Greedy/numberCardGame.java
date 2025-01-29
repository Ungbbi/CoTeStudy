package CHAP03_Greedy;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class numberCardGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int maxValue = 0;

        for(int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            int minInRow = Integer.MAX_VALUE;
            for(int j = 0; j < M; j++) {
                minInRow = Math.min(minInRow, Integer.parseInt(row[j]));
            }
            maxValue = Math.max(maxValue, minInRow);
        }

        System.out.println(maxValue);
        br.close();
    }
}
