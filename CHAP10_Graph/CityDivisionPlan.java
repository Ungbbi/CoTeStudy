package CHAP10_Graph;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge>{
    int a;
    int b;
    int cost;

    Edge(int a, int b, int cost){
        this.a = a;
        this.b = b;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge e){
        int tmp = Integer.compare(this.cost, e.cost);
        if(tmp==0) {
            int tmp2 = Integer.compare(this.a, e.a);
            if(tmp2==0){
                return Integer.compare(this.b, e.b);
            }
            return tmp2;
        }
        else return tmp;
    }

}
public class CityDivisionPlan {
    static int[] houses;
    static int[] cost;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static int findVillage(int a){
        if(houses[a] != a){
            houses[a] = findVillage(houses[a]);
        }
        return houses[a];
    }
    public static void unionVillage(int a, int b){
        int x = findVillage(a);
        int y = findVillage(b);
        if(x<y) houses[b] = x;
        else houses[a] = y;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int numberOfHouse = Integer.parseInt(inputs[0]);
        int numberOfEdge = Integer.parseInt(inputs[1]);

        cost = new int[numberOfHouse+1];
        houses = new int[numberOfHouse+1];
        for(int i=1;i<=numberOfHouse;i++){
            houses[i] = i;
        }

        // A번과 B번 집 간 엣지 비용 C
        // Edge들을 우선순위 큐에 삽입
        for(int i=0; i<numberOfEdge; i++) {
            inputs = br.readLine().split(" ");
            int A = Integer.parseInt(inputs[0]);
            int B = Integer.parseInt(inputs[1]);
            int cost = Integer.parseInt(inputs[2]);
            pq.offer(new Edge(A,B,cost));
        }

        // 우선 되도록 모든 것을 연결하고 그중 엣지cost가 가장 높은것을 끊으면 되지 않을까
        int maxCost=0 ;
        int totalCost=0;
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            // 사이클이 없다면 (서로 다른 집합이라면)
            if(findVillage(e.a) != findVillage(e.b)){
                unionVillage(e.a,e.b);
                totalCost += e.cost;
                maxCost = e.cost;
            }
        }

        System.out.println(totalCost - maxCost);
    }
}
