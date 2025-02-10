/* 
Idea 1) 가장 안쪽(가운데)에 Yellow를 배치한 후 
        Brown으로 둘러싸면 Yellow의 Col과 Row 각각 +2가 된 Matrix가 Brown.
Idea 2) Yellow n x m 로 시작한다고 가정 n을 오름차순으로 반복. 
        만약 Yellow가 24 라면, 1x24, 2x12, 3x8, .. 하며 
        그것을 둘러싸는 brown의 개수가 맞는지 확인하면 된다.
Ex) Brown: 24, Yellow : 24
-> Case1: Y: 1x24, B: 2x26 -> 52 - 24 = 28, 28 != 24 (x)
-> Case2: Y: 2x12, B: 4x14 -> 56 - 24 = 32, 32 != 24 (x)
-> Case3: Y: 3x8,  B: 5x10 -> 50 - 24 = 26 (x)
-> Case4: Y: 4x6,  B: 6x8  -> 48 - 24 = 24 (o)
*/

class Solution {
    // Col(가로) >= Row(세로)
    public int[] solution(int brown, int yellow) {
        int yRow, yCol;
        int bRow, bCol;
        for(int i=1; i<=(int)Math.sqrt(yellow); i++){
            if(yellow%i==0) {
                yCol = yellow/i;
                yRow = i;
                
                bCol = yCol+2;
                bRow = yRow+2;
                if((bRow*bCol) - (yRow*yCol) == brown){
                    return new int[]{bCol, bRow};
                }
             }
        }return null;
    }
}