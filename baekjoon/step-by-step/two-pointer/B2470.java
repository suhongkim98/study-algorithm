import java.io.*;
import java.util.*;

//투포인터
//입력받아 정렬하고
//시작++ 끝--해가며 절대값이 0이랑 가장 가까운값 갱신
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;
        int result = Integer.MAX_VALUE;
        int resultStart = start;
        int resultEnd = end;
        while(start < end) {
            int sum = arr[start] + arr[end];
            if(Math.abs(sum) < result) {
                result = Math.abs(sum);
                resultStart = start;
                resultEnd = end;
            }
            if(sum < result) {
                start++;
            } else {
                end--;
            }
        }
        bw.write(arr[resultStart] + " " + arr[resultEnd]);

        bw.flush();
        br.close();
        bw.close();
    }
}
