import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.List;


/*
공유기 설치
이분탐색 응용
1. 배열 정렬
2. mid를 구한다
3. 첫번째 집에 무조건 공유기 설치
4. 이전에 공유기 설치한 집부터 다음 집까지 비교하는데 거리가 mid보다 크면 해당집에 공유기 설치
5. 공유기 설치 개수가 지정된 개수랑 같다면 그 결과가 답
6. 공유기 설치 개수가 부족하면 end = mid - 1로 하고 다시 해본다.
7. 공유기 설치 개수가 더 많다면 start = mid + 1하고 다시 해본다.

 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 이분탐색을 위해 정렬
        Arrays.sort(arr);

        int start = 0, end = arr[arr.length - 1];
        int answer = -1;
        while (start <= end) {
            int mid = (start + end) / 2;

            // 공유기 설치 개수 // 첫번째 집에는 무조건 설치해야 함
            int count = 1;
            int before = arr[0];
            for(int i = 1 ; i < N ; i++) {
                if(arr[i] - before >= mid) {
                    count++;
                    before = arr[i]; // 설치
                }
            }
            if(count >= C) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        bw.write(answer + "");

        br.close();
        bw.close();
    }
}

