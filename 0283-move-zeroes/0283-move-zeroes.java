class Solution {
    public void moveZeroes(int[] array) {        
        int size = array.length;
        int k = 0;

        for(int i = 0; i < size; i++) {
            if (array[i] != 0) {
                array[k] = array[i];
                k++;
            }
        }

        for(int i = k; i < size; i++) {
            array[i] = 0;
        }

    } 
}