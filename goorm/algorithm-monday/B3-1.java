import java.awt.*;
import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");
        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);

        int start = 0, end = arr.length - 1;
        long result = 0;
        while (start <= end) {
            int sum = arr[start] + arr[end];
            if(sum != 0) {
                // 문제 있음
                if(Math.abs(arr[start]) < Math.abs(arr[end])) {
                    result += arr[end];
                    end--;
                } else {
                    result += arr[start];
                    start++;
                }
            } else {
                start++;
                end--;
            }
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}
/*
숫자를 정렬한다
투포인터 사용, 시작 끝지점

각 포인터의 합이 0이라면 통과
0이 아니라면 절대값이 큰놈이 문제, 걔를 더하고 포인터 이동
문제인 놈들을 합해서 출력

-5 1
*/