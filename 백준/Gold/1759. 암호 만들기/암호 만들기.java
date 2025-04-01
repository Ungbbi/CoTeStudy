import java.util.*;
import java.io.*;

// a t c i s w
// a c i s t w

public class Main{
    static int L;
    static int C;
    static HashSet<String> vowel = new HashSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        L = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        String[] pw = new String[C];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb;
        for(int i=0; i<C; i++){
            pw[i] = st.nextToken();
        }
        Arrays.sort(pw);
        int depth = 0;
        sb = new StringBuilder();
        String[] vowels = {"a","e","i","o","u"};
        vowel.addAll(Arrays.asList(vowels));

        dfs(pw,-1,sb,depth, 0);

    }
    // v : 모음 갯수
    static void dfs (String[] pw, int start, StringBuilder sb, int depth, int v){
        if(depth==L){
            if(v==0) return;
            else if (L-v<2) return;

            System.out.println(sb);
            return;
        }
        for(int i=start+1; i<=C-(L-depth); i++){
            sb.append(pw[i]);
            if(vowel.contains(pw[i])) dfs(pw,i,sb,depth+1,v+1);
            else dfs(pw,i,sb,depth+1, v);
            sb.deleteCharAt(depth);
        }
    }
}