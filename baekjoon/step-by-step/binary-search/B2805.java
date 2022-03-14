import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int[] arr = new int[N];
        int max = 0;
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(input[i]);
            if(arr[i] > max) max = arr[i];
        }
        long val = solve(arr, max, M);
        long sum = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i] > val) sum += arr[i] - val;
        }
        if(sum < M) val--; // 부족하다면 하나 빼줘야함
        bw.write(val + "");
        bw.close();
        br.close();
    }
    //upper, lower바운드 응용
    static long solve(int[]arr, int max, int value) {
        long low = 0;
        long high = max;
        while (low < high) {
            long mid = low + (high - low)/2;
            // mid 높이 이상으로 나무를 잘라보자
            long sum = 0;
            for(int i = 0 ; i < arr.length ; i++) {
                if(arr[i] > mid) {
                    sum += arr[i] - mid; // mid 값보다 큰 나무를 자른다.
                }
            }
            if (value >= sum) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

