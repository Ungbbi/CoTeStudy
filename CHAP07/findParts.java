package CHAP07;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;

public class findParts {
    public static Integer binarySearch(int[] ary, int target, int start, int end) {
        if (start >= end) return null;
        int mid = (start + end) / 2;
        if (ary[mid] == target) return mid;
        else if (ary[mid] > target) {
            return binarySearch(ary, target, start, mid - 1);
        } else if (ary[mid] < target) {
            return binarySearch(ary, target, mid + 1, end);
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] partsList = new int[N];
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            partsList[i] = Integer.parseInt(inputs[i]);
        }

        int M = Integer.parseInt(br.readLine());
        int[] orderPartsList = new int[M];
        inputs = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            orderPartsList[i] = Integer.parseInt(inputs[i]);
        }
        int[] indexOfSol = new int[M];
        String[] sol = new String[M];
        for (int i = 0; i < M; i++) {
            Integer s = binarySearch(partsList, orderPartsList[i], 0, partsList.length - 1);
            {
                if (s != null) {
                    indexOfSol[i] = s;
                    sol[i] = "yes";
                } else {
                    sol[i] = "no";
                }
            }
        }
        System.out.println(Arrays.toString(sol));
        System.out.println(Arrays.toString(indexOfSol));
    }
}
