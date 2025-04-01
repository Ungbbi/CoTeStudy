class Solution {
    // 1. 다른 문자 나올 경우 -> 지금까지 같은(?) 연속된 문자 개수 cnt
    // 1-1. 이후, 다른 문자들 모두를 하나의 변수로 cnt
    // 1-2. 기준 문자 나오면 기준문자 개수 cnt
    
    public int solution(String s) {
        int answer = 0;
        char baseChar = s.charAt(0);
        int numOfbaseChar = 1;
        int numOfElse = 0;
        int numOfSlicing = 1;
        int endIndex = s.length()-1;
        for(int i=1; i<s.length(); i++){
            if(baseChar != s.charAt(i)){
                numOfElse ++;
                if(numOfElse == numOfbaseChar){                    
                    if(i==endIndex){
                        break;
                    }
                    numOfSlicing ++;
                    baseChar = s.charAt(i+1);
                    i++;
                    numOfbaseChar = 1;
                    numOfElse = 0;
                }
            }
            else numOfbaseChar++;
        }      
        return numOfSlicing ;         // 자르면 두 덩이 나옴
    }
}