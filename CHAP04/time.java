package CHAP04;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class time {
    public static void main(String[] args) throws IOException{
        int sol = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        for(int i=0;i<=Integer.parseInt(N);i++){
            for(int j=0; j<60; j++){
                for(int k=0; k < 60; k++){
                    if((i%10)==3) sol ++;
                    else if ((j%10)==3 || ((j%100)>=30 && (j%100)<40)) sol ++;
                    else if ((k%10)==3 || ((k%100)>=30 && (k%100)<40)) sol ++;
                }
            }
        }
        System.out.println(sol);
    }
}
