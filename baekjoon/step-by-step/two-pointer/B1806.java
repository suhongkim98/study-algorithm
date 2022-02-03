import java.io.*;
import java.util.*;

//two pointer
//left right
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        int left = 0;
        int right = 0;
        int sum = arr[left]; // 초기는 첫번째만 가리킴
        int result = Integer.MAX_VALUE;
        while (left < N) {
            if(sum >= M) {
                if(left == right) {
                    result = 1;
                    break; // 1보다 작은건 없으므로 탈출
                }
                int length = right - left + 1;
                if(result > length) result = length;
            }
            // 합이 타켓값보다 크면 left++ 작으면 right++
            if(sum < M && right + 1 < N) {
                sum += arr[++right];
            } else {
                sum -= arr[left++];
            }

        }
        if(result == Integer.MAX_VALUE) result = 0;
        bw.write(result+"");

        bw.flush();
        br.close();
        bw.close();
    }
}

