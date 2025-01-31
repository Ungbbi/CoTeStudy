package CHAP10_Graph;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class formTeam {
    static int[] students;
    public static int findTeam(int a){
        if(students[a] != a){
            students[a] = findTeam(students[a]);
        }
        return students[a];
    }
    public static void unionTeam(int a, int b){
        int x = findTeam(a);
        int y = findTeam(b);
        if(x<y) students[b] = x;
        else students[a] = y;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        students = new int[N+1];
        // 자신의 번호로 팀 초기화
        for(int i=1;i<=N; i++){
            students[i] = i;
        }

        /* a b c 입력 형태
         a == 1 -> b&c 소속팀 확인
         a == 0 -> b&c 팀 합치기
         0~N 번까지의 학생 존재 (N+1명)
         처음엔 N+1 개의 팀이 존재하며 각각의 번호에 맞는 팀이 배정됨
         M개의 연산을 수행한다.
        */
        for(int i=0; i<M; i++){
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[1]);
            int b = Integer.parseInt(inputs[2]);
            if(inputs[0].equals("0")){
                unionTeam(a,b);
            }
            else {
                if(findTeam(a)==findTeam(b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }

    }
}
