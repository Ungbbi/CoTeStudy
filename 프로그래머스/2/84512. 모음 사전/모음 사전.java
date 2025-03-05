// A = 1번째, E = ?, I = 1563번째
// A와 I간의 차이 = 1562
// A와 E간의 차이 = 1562/2 = 781
// A와 E간의 차이 = 781, E = 782 번째
// E와 I간의 차이 = 781, I = 1563번째
// 뒷자리가 없을 때 'x'로 표시
/*
-- 뒷자리 --
네자리 'x' -> 6의 차이
AAAAx = 4
AAAEx = 10
AAAIx = 16
AAAOx = 22
AAAUx = 28
AAExx = 34

세자리  'x' -> 31의 차이
AAAxx = 3
AAExx = 34
AAIxx = 65
AAOxx = 96
AAUxx = 127
AExxx = 158

3번째 'x' ->  156의 차이
AAxxx = 2
AExxx = 158
AIxxx = 314
AOxxx = 470
AUxxx = 626

//4번째 'x' -> 781의 차이 : 맨 처음 계산한것과 일치.
Axxxx =1
Exxxx = 782

*/
public class Solution {
    static String[] words = {"A","E","I","O","U"};
    static int[] pattern = new int[]{781, 156, 31, 6, 1};
    
    public int solution(String word) {
        int result = 0;
        String[] inputs = new String[]{"x","x","x","x","x"};
        String[] s = word.split("");

        for(int i=0; i<s.length; i++){
            inputs[i] = s[i];
        }

        for(int i=0; i<5; i++){
            if(inputs[i].equals("A")){
                result++;
                continue;
            }
            for(int j=1; j<5; j++){
                if(inputs[i].equals(words[j])){
                    result += pattern[i] * j +1;
                    break;
                }

            }
        }
        return result;
    }
}