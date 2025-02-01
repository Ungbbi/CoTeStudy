package CHAP10_Graph;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.List;
import java.util.ArrayList;

class Lecture{
    int time;
    int prev;

    Lecture(int time){
        this.time = time;
    }
    Lecture(int time, int prev){
        this.time = time;
        this.prev = prev;
    }
}

public class Curriculum {
    static List<List<Integer>> lectureList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<=N;i++){
            lectureList.add(new ArrayList<>());
        }
        // 각 과목별 수업 및 선수과목을 모두 수행했을 때의 시간
        int[] totalTimeOfLecture = new int[N+1];
        for(int i=1; i<=N;i++){
            String[] inputs = br.readLine().split(" ");
            // 입력받고 리스트에 저장
            for (String input : inputs) {
                if(input.equals("-1")) break;
                lectureList.get(i).add(Integer.parseInt(input));
            }
            // 선수과목 없이 시간만 입력받았다면 시간만 출력
            if(inputs.length==2){
                System.out.println(lectureList.get(i).getFirst());
                totalTimeOfLecture[i] = lectureList.get(i).getFirst();
                continue;
            }
            else{
                for(int l : lectureList.get(i)){
                    if(l == lectureList.get(i).getFirst()){
                        totalTimeOfLecture[i] += l;
                        continue;
                    }
                    totalTimeOfLecture[i] += totalTimeOfLecture[l];
                }
            }
            System.out.println(totalTimeOfLecture[i]);
        }
    }
}
