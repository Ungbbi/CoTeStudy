| 주로 모든 정점을 방문하는 즉, 완전탐색에서 DFS, BFS가 사용된다.</br> 그 중에서도 DFS-완전탐색, BFS-최단거리 로 쓰이는 경우가 많다.

보통 **DFS**는 **재귀**, **BFS**는 **큐**를 이용한다.
코드의 경우 그냥 재귀, 큐가 어떻게 사용되는지만 확인하자.
___

## DFS
**순열**&**조합**의 경우</br>
검색 대상 그래프가 큰 경우(정점과 간선의 개수가 많음)</br>
경로의 특징을 저장해둬야 하는 문제</br>
ex) 각 정점에 숫자가 적혀있고 a부터 b까지 가는 경로를 구하는 데 경로에 같은 숫자가 있으면 안된다는 문제</br>
BFS는 경로의 특징을 가지지 못함</br>

### Code
```JAVA
static void dfs(int nodeIndex) {
		// 방문 처리
		vistied[nodeIndex] = true;
		
		// 방문 노드 출력
		System.out.print(nodeIndex + " -> ");
		
		// 방문한 노드에 인접한 노드 찾기
		for (int node : graph[nodeIndex]) {
			// 인접한 노드가 방문한 적이 없다면 DFS 수행
			if(!vistied[node]) {
				dfs(node);
			}
		}
	}
```
___

## BFS

미로찾기 등 최단거리를 구해야 할 경우</br>
DFS는 처음으로 발견되는 해답이 최단거리 라는 것 보장 X</br>
반면 BFS는 현재 노드에서 가까운 곳부터 찾기 때문에 경로 탐색 시 첫번째로 찾아지는 해답이 곧 최단거리이다.</br>

### Code
```JAVA
import java.util.*;

public static void bfs(int start, int n){
        // visited는 경우에 따라 매개변수로 넘겨도 된다.
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        
        while(!q.isEmpty()){
            int v = q.poll();
            for(int i: graph[v]){
                if(!visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
```
