class Solution {
    public int solution(int[][] lines) {
        int[] line = new int[401];
        
        for (int i = 0; i < 3; i++) {
            lines[i][0] = (lines[i][0] + 100) * 2;
            lines[i][1] = (lines[i][1] + 100) * 2;
        }
        
       
        for (int i = 0; i < 3; i++) {
            for (int j = lines[i][0]; j < lines[i][1]; j++) { 
                line[j]++;
            }
        }
        
        boolean isLine = false;
        int start = -1;
        int sum = 0;
        int prevPoint = -1;
        
        for (int i = 0; i < line.length; i++) {                
            if (!isLine && line[i] >= 2) {
                isLine = true;
                start = i;
                prevPoint = i; 
                continue;
            }            
            if (isLine && line[i] < 2) {
                isLine = false;
                sum += (i - start) / 2; 
                
                // 접점 처리
                if (prevPoint != -1 && prevPoint + 1 < i) {
                    sum += 1; // 접점 길이 추가
                }
            }
            if (isLine && line[i] >= 2) {
                prevPoint = i; // 접점 업데이트
            }
        }
        return sum;
    }
}
