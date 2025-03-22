class Solution {
    public boolean isSubsequence(String s, String t) {        
        String[] ns = s.split("");
        String[] nt = t.split("");
        int k=0, nsCnt = s.length();

        for(int i=0; i<t.length(); i++){
            if(nt[i].equals(ns[k])){
                nsCnt--;
                k++;
            }
            if(nsCnt==0) return true;
        }
        if(nsCnt==0) return true;
        return false;
    }
}