// cycle이 발생할 수 있을 것 같은데??
// 1. Union-find
// 2. BFS

import java.util.*;

class Solution {
    static int[] root;
    
    public static int find_root(int a){
        if(root[a]!=a){
            root[a] = find_root(root[a]);
        }
        return root[a];
    }
    
    public static void union(int a, int b){
        a = find_root(a);
        b = find_root(b);
        if(a>b) root[a] = b;
        else root[b] = a;
    }
    
    public int solution(int n, int[][] computers) {
        root = new int[n];
        for(int i=0;i<n;i++){
            root[i] = i;
        }
        // 0 1 2 3 ... 9 
        // 인덱스가 컴퓨터 번호, i가 기준 컴퓨터 j는 그 외 컴퓨터
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j) continue;
                if(computers[i][j] == 1){
                    union(i,j);
                }
            }
        }
        // 루트 동기화
        for(int i=0; i<n; i++){
            find_root(i);
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i: root){
            set.add(i);
        }
        return set.size();
    
    }
}