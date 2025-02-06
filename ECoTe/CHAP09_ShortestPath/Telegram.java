package ECoTe.CHAP09_ShortestPath;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.List;
import java.util.ArrayList;

public class Telegram {
    static final int INF = (int) 1e9;
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int numberOfCity = Integer.parseInt(input[0]);
        int numberOfEdge = Integer.parseInt(input[1]);
        int origin = Integer.parseInt(input[2]);

        // 2차원 리스트 생성
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=numberOfCity;i++){
            graph.add(new ArrayList<>());
            for(int j=0; j<=numberOfCity; j++){
                graph.get(i).add(INF);
                if (i==j) graph.get(i).set(j, 0);
            }
        }

        // 입력받은 값들로 테이블 업데이트
        int start, end, cost;
        for(int i=0; i<numberOfEdge; i++){
            input = br.readLine().split(" ");
            start = Integer.parseInt(input[0]);
            end = Integer.parseInt(input[1]);
            cost = Integer.parseInt(input[2]);
            graph.get(start).set(end,cost);
        }
        // 플루이드 워셜 알고리즘 수행   ->  한 지점에서 다른 지점까지의 최소비용을 구하는 것이라 다익스트라 알고리즘을 사용하는 것이 낫다.
        for(int i=1; i<=numberOfCity; i++){
            for(int j=1; j<=numberOfCity; j++){
                for(int k=1; k<=numberOfCity; k++){
                    int min = Math.min(graph.get(i).get(k), graph.get(i).get(j) + graph.get(j).get(k));
                    graph.get(i).set(k,min);
                }
            }
        }


        // 결과값 구하는 과정
        int cnt = 0;
        int maxCost = 0;
        for(int i=1; i<=numberOfCity; i++){
            int x = graph.get(origin).get(i);
            if(x >= INF || x==0) continue;
            cnt++;
            maxCost = Math.max(maxCost, x);
        }
        System.out.println(cnt + " " + maxCost);
    }
}
