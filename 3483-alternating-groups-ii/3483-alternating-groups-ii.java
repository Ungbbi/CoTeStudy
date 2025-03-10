import java.util.*;

class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int prevColor = colors[0];
        int groupCnt = 0;
        int tileCnt = 1;
        int right = 1 ;
        int left = 0;
        while(left<colors.length){
            if(colors[(right-1)%colors.length] != colors[right%colors.length]) 
            {                
                tileCnt++;
                if(tileCnt==k){
                    groupCnt++;
                    tileCnt--;
                    left++;
                }
            }
            else {
                left = right;
                tileCnt = 1;
            }
            right ++;
        }
        return groupCnt;
    }
}