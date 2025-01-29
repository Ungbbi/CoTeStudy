package CHAP09_ShortestPath;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;


public class futureCity {
    // 무한의 값
    static final int INF = (int) 1e9;

    public static void main(String[] args)throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String[] input = br.readLine().split(" ");
         int numberOfCompany = Integer.parseInt(input[0]);
         int numberOfEdge = Integer.parseInt(input[1]);

        // 2차원 리스트 생성 및 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=numberOfCompany;i++){
            graph.add(new ArrayList<>());
            for(int j=0; j<=numberOfCompany; j++){
                graph.get(i).add(INF);
                if(i==j) graph.get(i).set(i,0);
            }
        }

        // 연결된 두 회사의 번호를 입력받아서 테이블 갱신 ( dist는 모두 1)
        // 이번 문제에서는 단방향이 아닌 양방향이므로 둘 다 설정해준다.
        int first,second;
         for(int i=0; i<numberOfEdge; i++){
             input = br.readLine().split(" ");
             first = Integer.parseInt(input[0]);
             second = Integer.parseInt(input[1]);
             graph.get(first).set(second,1);
             graph.get(second).set(first,1);
         }

        // 1 -> K -> X
        input = br.readLine().split(" ");
        int destination = Integer.parseInt(input[0]); // X
        int stopOver = Integer.parseInt(input[1]); // K


        // 플루이드 워셜 알고리즘 수행
        for(int i=1; i<=numberOfCompany; i++){
            for(int j=1; j<=numberOfCompany; j++){
                for(int k=1; k<=numberOfCompany; k++){
                    int min = Math.min(graph.get(i).get(j), graph.get(i).get(k) + graph.get(k).get(j));
                    graph.get(i).set(j,min);
                }
            }
        }
        // 반드시 stopOver를 거치고 (중간지점을 거치고 목적지로 향해야함)
        int sol = graph.get(1).get(stopOver) + graph.get(stopOver).get(destination);
        if(sol>=INF) System.out.println("-1");
        else System.out.println(sol);
    }
}
