package CHAP03_Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

// 이코테 92p
public class LawOfLargeNumber {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int K = Integer.parseInt(str[2]);


        String input = br.readLine();

        int[] numbers = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 배열 오름차순 정렬
        int[] sortedNumbers = Arrays.stream(numbers).sorted().toArray();

        // 가장 큰 수와 그 다음 수가 담겨진 배열
        int[] topTwo = new int[2];
        topTwo[0] = sortedNumbers[sortedNumbers.length-1];
        topTwo[1] = sortedNumbers[sortedNumbers.length-2];
        // 가장 큰 수가 K번 더해졌을 때, 두번째로 큰 수를 더하게 하기 위함. 이후 다시 가장 큰 수를 더하게 됨
        boolean change = true;
        int sol = 0;
        for(int i=1; i<=M; i++){
            if(change){
                sol += topTwo[0];
                if(i%K==0) change = false;
            }
            else{
                sol += topTwo[1];
                change = true;
            }
        }
        System.out.println(sol);

        // Best Solution
        // 규칙을 구해서 가장 큰 수와 두번째로 큰 수가 각각 몇번 더해지는지 손쉽게 계산
        // N이 매우 큰 값으로 주어지게 될 경우 시간 및 메모리 초과될 상황이 발생 가능하므로 Best Sol이 필요
        int numberOfCalTopValues = ((M/(K+1))*K+(M%(K+1)));
        int numberOfCalSecondValues = (M/(K+1));

        int bestSol = topTwo[0] * numberOfCalTopValues + topTwo[1] * numberOfCalSecondValues;

        System.out.println("BestSol : " + bestSol);


        br.close();
    }
}
