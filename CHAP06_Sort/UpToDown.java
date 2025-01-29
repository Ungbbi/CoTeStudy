package CHAP06_Sort;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;

/*
 !!!!! 주의 left<=end && ary[left] <= ary[pivot] 조건식의 순서가 중요하다.
 만약 ary[left] <= ary[pivot] && left<=end 같은 순서로 작성했다면 index 범위 초과 에러가 발생하게 된다.
 왜냐하면 조건식 또한 쓰여진 순서대로 실행된다.
 그렇다면 이미 letf>end로 인덱스가 outbound인데 "left<=end" 조건식이 뒤에 있어서 종료되지 않는다.
 ary[left] <= ary[pivot] 조건식이 먼저 실행될텐데 ary[left]의 left 는 이미 ary의 인덱스 범위를 넘어섰으므로
 index outbound error가 발생하게 된다.
 */
public class UpToDown {
    public static void quickSort(int[] ary, int start, int end){
        // 원소가 한개만 있는 경우 종료
        if (start >= end) return;

        int pivot = start;
        int left = start+1;
        int right = end;
        int temp;
        while(left<=right){
            while(left<=end && ary[left] <= ary[pivot]){
                left++;
            }
            while(right>start && ary[right] >= ary[pivot]){
                right --;
            }
            if(left>right){
                temp = ary[pivot];
                ary[pivot] = ary[right];
                ary[right] = temp;
            }
            else{
                temp = ary[left];
                ary[left] = ary[right];
                ary[right] = temp;
            }
        }
        quickSort(ary, start, right-1);
        quickSort(ary, right+1, end);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ary = new int[N];

        for (int i = 0; i < N; i++) {
            ary[i] = Integer.parseInt(br.readLine());
        }
        quickSort(ary, 0, ary.length-1);
        int[] sol = new int[N];
        for(int i=0;i<N;i++){
            sol[N-(i+1)] = ary[i];
        }
        System.out.println(Arrays.toString(sol));
    }
}