package CHAP07;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;

public class makingRiceCake {
    public static Integer binarySearch(int[] riceCakes, int target, int start, int end){
        if(start>=end) return riceCakes[start-1];
        int mid = (start+end)/2;
        int sum = 0;
        for(int i=mid+1; i<=end;i++){
            sum += riceCakes[i] - riceCakes[mid];
        }
        if(sum==target) return riceCakes[mid];
        else if(sum>target){
            return binarySearch(riceCakes, target, mid+1, end);
        }
        else{
            return binarySearch(riceCakes, target, start, mid-1);
        }
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

        Arrays.sort(riceCakes);
        Integer sol = binarySearch(riceCakes, M,0,riceCakes.length-1);
        System.out.println(sol);
    }
}
