package CHAP04;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class UpDownLeftRight {
    public static int checkBoundaryAndCal(int position, int direction, int N){
        int boundary = position + direction;
        int output ;
        if (boundary > 0  && boundary <= N){
            output = boundary;
            return output;
        }
        return position;
    }

    public static void main (String[] args) throws IOException{
        int[] dx = new int[] {0,0,-1,1};
        int[] dy = new int[] {-1,1,0,0};
        int[] currentPosition = new int[] {1,1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        // Sol 1
        for(String direction : inputs){
            switch(direction){
                case "U":
                    currentPosition[1] = checkBoundaryAndCal(currentPosition[1], dy[0],N);
                    break;
                case "D":
                    currentPosition[1] = checkBoundaryAndCal(currentPosition[1], dy[1], N);
                    break;
                case "L":
                    currentPosition[0] = checkBoundaryAndCal(currentPosition[0], dx[2], N);
                    break;
                case "R":
                    currentPosition[0] = checkBoundaryAndCal(currentPosition[0], dx[3], N);
                    break;
                default:
                    break;
            }
        }
        System.out.println(Arrays.toString(currentPosition));

        // Sol 2
        String[] moveTypes = new String[] {"U","D","L","R"};
        int x = 1;
        int y = 1;
        for (String direction: inputs) {
            int nx=0;
            int ny=0;
            for (int i = 0; i < 4; i++) {
                if (Objects.equals(direction, moveTypes[i])) {
                    nx = x + dx[i];
                    ny = y + dy[i];
                }
            }
            if (nx < 1 || ny < 1 || nx > N || ny > N){
                continue;
            }
            x = nx;
            y = ny;
        }
        System.out.printf("%d, %d", x, y);
    }
}
