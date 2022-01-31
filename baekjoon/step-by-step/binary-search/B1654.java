import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        Long[] arr = new Long[K];
        Long max = 0L;
        for(int i = 0 ; i < K ; i++) {
            arr[i] = Long.parseLong(br.readLine());
            if(arr[i] > max) max = arr[i];
        }
        // count가 value랑 일치하는 값보다 큰 값 첫번째 반환을 하므로 -1 해주어야 답이 된다.
        bw.write((solve(arr, max, N) - 1) + "");

        bw.flush();
        br.close();
        bw.close();
    }
    static Long solve(Long[] arr, Long max, int value) {
        //upperbound 응용
        // 1 ~ max 수 중 count가 value랑 일치하는 값보다 첫번째로 큰 값 반환
        Long low = 1L;
        Long high = max + 1; // high가 답인 경우가 있으므로 max + 1해주어야함
        while (low < high) {
            Long mid = (low + high) / 2;
            int count = 0;
            for(int i = 0 ; i < arr.length ; i++) {
                count += arr[i] / mid;
            }
            if(count >= value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}

