import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split("");
        int strlen = inputs.length;
        String[] duckSpell= "quack".split("");

        boolean[] visited = new boolean[inputs.length];

        int num = strlen;
        int duck = 0;

        while(num>0){
            int idx = 0, total = 0;
            for(int i=0; i<strlen; i++){
                if(!visited[i] && inputs[i].equals(duckSpell[idx])){
                    visited[i] = true;
                    idx = (idx +1) % 5;
                    total ++;
                }
            }
            num -= total;
            if(total != 0 && total%5==0) duck++;
            else{
                System.out.println("-1");
                return;
            }
        }
        System.out.println(duck);
    }
}