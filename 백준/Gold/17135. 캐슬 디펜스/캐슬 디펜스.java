import java.util.*;
import java.io.*;

public class Main {
    static int[] colOfArcher = new int[3];
    static int N, M, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int[][] originalMap = new int[N][M];
        int totalEnemies = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                originalMap[i][j] = Integer.parseInt(st.nextToken());
                if(originalMap[i][j] == 1) totalEnemies++;
            }
        }

        int maxKill = 0;

        // 궁수 3명의 위치 조합 시도
        for(int i = 0; i < M; i++) {
            for(int j = i+1; j < M; j++) {
                for(int k = j+1; k < M; k++) {
                    colOfArcher[0] = i;
                    colOfArcher[1] = j;
                    colOfArcher[2] = k;

                    int killed = simulate(originalMap);
                    maxKill = Math.max(maxKill, killed);

                    if(maxKill == totalEnemies) {
                        System.out.println(maxKill);
                        return;
                    }
                }
            }
        }

        System.out.println(maxKill);
    }

    // 시뮬레이션 함수
    static int simulate(int[][] originalMap) {
        // 맵 복사
        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = originalMap[i][j];
            }
        }

        int killed = 0;

        // 라운드 시작 (모든 적이 내려오는 대신 궁수 라인을 위로 올림)
        for(int archerRow = N; archerRow > 0; archerRow--) {
            // 이번 턴에 죽일 적의 위치를 저장
            Set<Integer> targets = new HashSet<>();

            // 각 궁수별로 공격할 적 선정
            for(int archerIdx = 0; archerIdx < 3; archerIdx++) {
                int archerCol = colOfArcher[archerIdx];
                int targetRow = -1;
                int targetCol = -1;
                int minDist = Integer.MAX_VALUE;

                // 가장 가까운 적 찾기 (거리가 같다면 가장 왼쪽)
                for(int d = 1; d <= D; d++) {  // 거리별로 순차 검색
                    boolean found = false;

                    // 왼쪽부터 오른쪽으로, 위쪽부터 아래쪽으로 검색하여 가장 왼쪽 우선
                    for(int col = 0; col < M; col++) {
                        for(int row = 0; row < archerRow; row++) {
                            int dist = Math.abs(archerRow - row) + Math.abs(archerCol - col);
                            if(dist <= D && dist == d && map[row][col] == 1) {
                                if(dist < minDist || (dist == minDist && col < targetCol)) {
                                    targetRow = row;
                                    targetCol = col;
                                    minDist = dist;
                                    found = true;
                                }
                            }
                        }
                    }

                    if(found) break;  // 적을 찾았으면 더 이상 탐색하지 않음
                }

                // 공격할 적이 있으면 목록에 추가
                if(targetRow != -1) {
                    targets.add(targetRow * M + targetCol);
                }
            }

            // 선택된 적 모두 제거
            for(int encodedPos : targets) {
                int row = encodedPos / M;
                int col = encodedPos % M;
                if(map[row][col] == 1) {
                    map[row][col] = 0;
                    killed++;
                }
            }
        }

        return killed;
    }
}