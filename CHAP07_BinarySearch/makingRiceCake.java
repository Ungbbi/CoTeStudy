package CHAP07_BinarySearch;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;

public class makingRiceCake {

    public static Integer binarySearch(int[] riceCakes, int target, int start, int end) {
        if (start >= end) return riceCakes[start - 1];
        int mid;
        int sum;
        int temp;
        while (start < end) {
            sum = 0;
            mid = (start + end) / 2;
            for (int i = 0; i < riceCakes.length; i++) {
                temp = riceCakes[i] - mid;
                if (temp>0){
                    sum+=temp;
                }
            }
            if (sum == target) {
                return mid;
            }
            // 기준이 요구치보다 값이 큼 -> 기준을 크게 ( 더 길게 잘라서 총 합을 줄여야함 )
            else if (sum > target) {
                start = mid + 1;
            }
            // 기준이 요구치보다 값이 작음 -> 기준을 작게 ( 더 짧게 잘라서 총 합을 늘려야함 )
            else {
                end = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        inputs = br.readLine().split(" ");
        int[] inputRiceCakes = new int[N];
        for(int i=0; i<N; i++){
            inputRiceCakes[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(inputRiceCakes);
        Integer sol = binarySearch(inputRiceCakes, M,inputRiceCakes[0],inputRiceCakes[inputRiceCakes.length-1]);
        System.out.println(sol);
    }
}
