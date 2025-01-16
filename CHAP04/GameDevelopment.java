package CHAP04;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GameDevelopment {
    /*
    0 : 북
    1 : 동
    2 : 남
    3 : 서
    */

    // 북, 남 변화
    final static int[] dx = new int[]{-1,0,1,0};
    // 동, 서 변화
    final static int[] dy = new int[]{0,1,0,-1};

    final static int GROUND = 0;
    final static int SEA = 1;

    // 왼쪽 방향으로 회전
    public static int turnleft(int d){
        int direction;
        if(d==3) direction = 0;
        else direction = d+1;

        return direction;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mapSize = br.readLine().split(" ");
        int rowValue = Integer.parseInt(mapSize[0]);
        int colValue = Integer.parseInt(mapSize[1]);
        int[][] map = new int[rowValue][colValue];

        String[] inputPosition = br.readLine().split(" ");
        // Map 생성
        for(int i=0; i<rowValue; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<colValue; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        // 방문 여부 체크 지도 (방문: 1, 미방문 : 0)
        int[][] visited = new int[rowValue][colValue];

        // 초기 위치 및 방향 설정
        int x = Integer.parseInt(inputPosition[0]);
        int y = Integer.parseInt(inputPosition[1]);
        int direction = Integer.parseInt(inputPosition[2]);
        // 초기 위치 방문 처리
        visited[x][y] = 1;
        int count = 1;
        int turnTime = 0;

        int nx,ny;

        while(true){
            direction = turnleft(direction);
            nx = x + dx[direction];
            ny = y + dy[direction];

            //방문한 적이 없고 육지일 경우
            if(visited[nx][ny]==0 && map[nx][ny]==0) {
                visited[nx][ny] = 1; // 방문 표시
                x = nx;
                y = ny;
                count++;
                turnTime = 0;
            }
            // 방문한 곳이거나 바다일 경우
            else turnTime++;
            // 네
            if(turnTime==4){
                if(map[nx][ny]==1) break;
                nx = x - dx[direction];
                ny = y - dy[direction];
                x = nx;
                y = ny;
            }
        }
        System.out.println(count);
    }
}