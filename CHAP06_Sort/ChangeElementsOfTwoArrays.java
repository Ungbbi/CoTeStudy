package CHAP06_Sort;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;

public class ChangeElementsOfTwoArrays {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] A = new int[N];
        int[] B = new int[N];

        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            B[i] = Integer.parseInt(input[i]);
        }

        // A와 B 모두 정렬 후 인덱스를 반대로 하면 최대를 구할 수 있게된다.
        Arrays.sort(A); // 오름차순 정렬
        Arrays.sort(B);

        // 바꿔치기 수행
        for(int i = 0; i<K;i++){
            int temp = B[N-(i+1)];
            B[N-(i+1)] = A[i];
            A[i] = temp;
        }
        int sum=0;
        for(int i=0; i<N; i++){
            sum += A[i];
        }
        System.out.println(sum);
    }
}
