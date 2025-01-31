package CHAP09_ShortestPath;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int index;
    int cost;

    Node(int index, int cost){
        this.index = index;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node n){
        return Integer.compare(this.cost, n.cost);
    }
}

public class telegram_dijkstra {
    static final int INF = (int) 1e9;
    static ArrayList<Node>[] nodeGraph;

    public static void dijkstra(int n, int start){
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));

        while(!pq.isEmpty()){
            int nowVertex = pq.poll().index;
            if(visited[nowVertex]) continue;
            visited[nowVertex] = true;

            for(Node next: nodeGraph[nowVertex]){
                if(dist[next.index] > dist[nowVertex] + next.cost){
                    dist[next.index] = dist[nowVertex] + next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int numberOfCity = Integer.parseInt(input[0]);
        int numberOfEdge = Integer.parseInt(input[1]);
        int origin = Integer.parseInt(input[2]);

        nodeGraph = new ArrayList[numberOfCity+1];
        for(int i=0; i<=numberOfCity; i++) {
            nodeGraph[i] = new ArrayList<>();
        }

        // 입력받은 값들로 테이블 업데이트
        int start, end, cost;
        for(int i=0; i<numberOfEdge; i++){
            input = br.readLine().split(" ");
            start = Integer.parseInt(input[0]);
            end = Integer.parseInt(input[1]);
            cost = Integer.parseInt(input[2]);
            nodeGraph[start].add(new Node(end,cost));
        }
        // 도시 C에서 각 도시로의 최단거리를 구하고 그 중 가장 값이 큰 최단거리를 구하자.
        dijkstra(numberOfCity, origin);
        int cnt = 0;
        int max_cost = 0;
        for(Node n : nodeGraph[origin]){
            if(n.cost>=INF) continue;
            cnt++;
            max_cost = Integer.max(max_cost, n.cost);
        }
        System.out.println(cnt + " " + max_cost);


    }
}
