class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        
        int result = 0;

        int[] copy = new int[colors.length - 1 + k];

        for(int i= 0 ; i< colors.length; i++){
            copy[i] = colors[i];
        }

        for(int i = colors.length; i < copy.length; i++){
            copy[i] = colors[i - colors.length];
        }
        
        int l = 0;
        int r = 0;

        while(r + 1< copy.length ){
            if(copy[r] != copy[r + 1]){
                r++;
            }else{
                r = r + 1;
                l = r;
            }

            if(r - l + 1== k) {
                result++;
                l++;
            }

        }
        
        return result;
    }
}