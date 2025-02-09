import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] inputs = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            inputs[i] = String.valueOf(numbers[i]);
        }
        // 퀵 솔트로 진행되는데, 피벗을 가지고 문자열 합친 값을 비교하여 정렬을 수행한다
        /* {"3", "30", "34", "5","9"} 일 때,
        1. pivot = 9
        3 vs 9  -> 39, 93   : 9가 앞
        30 vs 9 -> 309, 930 : 9가 앞
        34 vs 9 -> 349, 934 : 9가 앞
        5 vs 9  -> 59, 95   : 9가 앞
        9가 맨 앞으로 간다. -> {"9", "3", "30", "34", "5"}
        
        2. pivot = 5
        위 1과 마찬가지로 수행...
        
        최종적으로 {"9","5","34","3","30"} 으로 정렬 된다.
        */ 
        Arrays.sort(inputs, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if (inputs[0].equals("0")) return "0";
        
        return String.join("", inputs);
    }
}