import java.util.*;

class Solution{
    static int[][] ary;

    public static int solution(int[][] triangle){
        ary = new int[triangle.length][];
        for(int i=0; i< triangle.length;i++){
            ary[i] = new int[triangle[i].length];
        }
        ary[0][0] = triangle[0][0];

        int depth = 1;
        int nodeIndex;

        while(depth<triangle.length){
            nodeIndex = 0;
            while(nodeIndex<=depth){
                if(nodeIndex==0){
                    ary[depth][nodeIndex] = triangle[depth][0] + ary[depth-1][0];
                }
                else if(nodeIndex==depth){
                    ary[depth][depth] = triangle[depth][depth] + ary[depth-1][depth-1];
                }
                else{
                    int a = triangle[depth][nodeIndex] + ary[depth-1][nodeIndex-1];
                    int b = triangle[depth][nodeIndex] + ary[depth-1][nodeIndex];
                    ary[depth][nodeIndex] = Integer.max(a,b);
                }
                nodeIndex++;
            }
            depth ++;
        }
        Arrays.sort(ary[ary.length-1]);
        
        int lastIndex = ary[ary.length-1].length-1;
        
        return ary[ary.length-1][lastIndex];
    }
}