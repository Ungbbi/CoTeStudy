import java.util.Arrays;

class Solution {
    public static void quickSort(int[] ary, int start, int end){
        if (start>=end) return;
        int pivot = start;
        int left = start+1;
        int right = end;
        
        // 엇갈렸다면 반복문은 종료될 것이다.
        while(left <= right){
            while(left <= end && ary[left] <= ary[pivot]){
                left ++;
            }
            while(right > start && ary[right] >= ary[pivot]){
                right --;
            }
            // 엇갈렸다면 피벗 교체
            // 작은 값은 right가 된다. 
            // 왜냐하면 왼쪽에서는 pivot보다 큰 수를, 오른쪽에서는 pivot보다 작은 수를 위 코드에서 찾고있기 때문
            if (left > right){
                int tmp = ary[right];
                ary[right] = ary[pivot];
                ary[pivot] = tmp;
            }
            // 엇갈리지 않았다면 왼쪽(큰값)과 오른쪽(작은값)을 서로 교체한다.
            else{
                int tmp = ary[left];
                ary[left] = ary[right];
                ary[right] = tmp;
            }
        }
        quickSort(ary, start, right-1);
        quickSort(ary, right+1, end);
    }
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int i = 0;
        for(int[] command : commands){
            int[] sliced = Arrays.copyOfRange(array,command[0]-1,command[1]);
            quickSort(sliced, 0, sliced.length-1);
            answer[i] = sliced[command[2]-1];
            i++;
        }
        return answer;
    }
}