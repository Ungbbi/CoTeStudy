import java.util.*;

class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int prevColor = colors[0];
        int colorLength = colors.length;
        int groupCnt = 0;
        int tileCnt = 1;
        int right = 0 ;
        int left = 0;
        while(left<colors.length){
            if(prevColor != colors[right%colorLength]){
                prevColor = colors[right%colorLength];
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