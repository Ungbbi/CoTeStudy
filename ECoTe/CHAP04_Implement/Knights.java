package ECoTe.CHAP04_Implement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


// 방법 1. 2차원 배열을 만들어서 인덱스가 있을 때, 이동 후 인덱스의 범위가 조건에 만족하면 Count
// 방법 2. 배열 생성하지 말고 인덱스 a-h를 아스키 코드로 하여 if 문 돌리면서 Count

public class Knights {
    // new int[] {상,하,좌,우}
    static int[] verticalFirst = new int[]{2,-2,-1,1};
    static int[] horizontalFirst = new int[]{1,-1,-2,2};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력은 a1 b2 이런식
        // a-h : 97 - 108
        String[] input = br.readLine().split("");
        int currentCol = input[0].charAt(0)-96;
        int currentRow = Integer.parseInt(input[1]);

        int nxVF,nxHF,nyVF,nyHF;

        int sol = 0;
        // 수직 이동 우선 수행 및 검사
        for(int i=0; i<2; i++){
            nyVF = currentRow + verticalFirst[i];
            nyHF = currentRow + horizontalFirst[i];
            if(nyVF>0 && nyVF<9){
                for(int j=2; j<4; j++){
                    nxVF = currentCol + verticalFirst[j];
                    if(nxVF>0 && nxVF<9) sol++;
                }
            }
            if(nyHF>0 && nyHF<9){
                for(int j=2; j<4; j++){
                    nxHF = currentCol + horizontalFirst[j];
                    if(nxHF>0 && nxHF<9) sol ++;
                }
            }
        }
        System.out.println("sol -> " + sol);

        // Sol 2
        int[][] steps = new int[][]{{-2,1},{-2,-1},{2,1},{2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
        int nx,ny;
        int sol2 = 0;
        for(int[] step : steps){
            nx = currentCol + step[0];
            ny = currentRow + step[1];

            if (nx>0 && nx<9 && ny>0 && ny<9) sol2 ++;
        }
        System.out.println("sol2 -> " + sol2);
    }
}
