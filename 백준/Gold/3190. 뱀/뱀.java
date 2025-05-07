import java.util.*;
import java.io.*;

public class Main{
    static boolean[][] matrix;
    static boolean[][] snakeBody;
    static HashMap<Integer,String> map = new HashMap<>();

    public static void main(String[] args) throws IOException{
        int N,K,L;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        matrix = new boolean[N+1][N+1];
        snakeBody = new boolean[N+1][N+1];

        StringTokenizer st;
        // 사과
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            matrix[n][m] = true;
        }

        // 방향
        L = Integer.parseInt(br.readLine());
        for(int i=0; i<L; i++){
            st = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            map.put(n,c);
        }

        moving(N);

    }
    static void moving(int N){
        snakeBody[1][1] = true;
        int y = 1;
        int x = 1;

        int time = 0;
        int ds = 1;
        // 상 우 하 좌
        String[] direction = new String[]{"U","R","D","L"};
        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{-1,0,1,0};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1,1});

        while(true){
            int nx = x+dx[ds];
            int ny = y+dy[ds];
            int nt = time+1;
            // 조건
            if(nx<1 || ny<1 || nx>N || ny>N || snakeBody[ny][nx]){
                System.out.println(nt);
                return;
            }

            // 뱀 흔적 기록
            q.add(new int[]{ny,nx});
            snakeBody[ny][nx] = true;

            // 사과
            if(!matrix[ny][nx]){
                int[] tmp = q.poll();
                snakeBody[tmp[0]][tmp[1]] = false; // 꼬리자리 비우기
            }
            else matrix[ny][nx] = false; // 사과 먹기

            x = nx;
            y = ny;
            // 방향전환
            if(map.containsKey(nt)){
                if(map.get(nt).equals("L")){
                    if(ds==0) ds = 3;
                    else ds--;
                }
                else ds = (ds+1) % 4;
            }
            time = nt;
        }
    }
}