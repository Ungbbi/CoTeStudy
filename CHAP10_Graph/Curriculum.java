package CHAP10_Graph;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Curriculum {
    static int[] time;
    static int[] indegree;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void topologySort(){
        int[] result = time.clone();
        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<time.length;i++){
            if (indegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()){
            int now = q.poll();
            for (int e : graph.get(now)){
                result[e] = Math.max(result[e], result[now] + time[e]);
                indegree[e] --;
                if(indegree[e] == 0) q.add(e);
            }
        }

        for (int i=1; i<time.length; i++){
            System.out.println(result[i]);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfLectures = Integer.parseInt(br.readLine());
        String[] StringInput;

        time = new int[numberOfLectures+1];
        indegree = new int[numberOfLectures+1];
        graph.add(new ArrayList<>());
        // 각 정보 입력
        for(int i=1; i<=numberOfLectures; i++){
            StringInput = br.readLine().split(" ");
            int[] input = Arrays.stream(StringInput)
                                .mapToInt(Integer::parseInt)
                                .toArray();

            time[i] = input[0];

            graph.add(new ArrayList<>());
            if(input.length>2){
                for(int j=1;j<input.length-1;j++){
                    graph.get(input[j]).add(i);
                    indegree[i] ++;
                }
            }

        }
        topologySort();
    }
}
