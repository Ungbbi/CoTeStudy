//  "aya", "ye", "woo", "ma" 
class Solution {
    static String[] words = {"aya","ye","woo","ma"};
    static String[] dupWords = {"ayaaya","yeye","woowoo","mama"};
    public int solution(String[] babbling) {                
        int answer = 0;
        for(String b : babbling){
            if(isWord(b)) answer++;
        }
        return answer;
    }
    
    public static boolean isWord(String s){
        for(int i=0; i<4; i++){
            s = s.replace(dupWords[i],"X");
        }
        
        if(s.contains("X")) return false;
        
        
        for(int i=0; i< 4; i++){
            s = s.replace(words[i], "O");
        }
        
        for (int i=0; i<s.length(); i++){
            if(s.charAt(i) != 'O') return false;
        }
        
        return true;
    }
}
