package CHAP10_Graph;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

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
        int rootA = findVillage(a);
        int rootB = findVillage(b);
//         노드 (2, 3) 가 그룹 A 이고 노드 1이 그룹 B일 때 (1,2)가 서로 다른 그룹이므로 1과 2를 Union 한다면
//         그룹B(1,2) 그룹A(3)이 된다. 하지만 노드 3또한 노드1보다 값이 크므로 노드1의 그룹으로 Union 되어야 한다.
//         현재. 1 - 2 || 3 이다. 하지만 엣지는 1-2-3 으로 연결돼있다.
//         왜냐하면 후에 E(1,3)이 존재할 때, 노드 1과 노드3의 그룹이 다르므로 Union이 수행되고 이 경우 Cycle이 발생하기 때문이다.
//         따라서, 초기에 루트노드까지 그룹 변경을 시켜줘야 한다.
        if(rootA<rootB) {houses[b] = rootA;
            houses[rootB] = rootA;
        }
        else {
            houses[a] = rootB;
            houses[rootA] = rootB;

        }
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
            // 사이클 유무 검사
            if(findVillage(e.a) != findVillage(e.b)){
                unionVillage(e.a,e.b);
                totalCost += e.cost;
                maxCost = e.cost;
            }
        }

        System.out.println(totalCost - maxCost);
    }
}
