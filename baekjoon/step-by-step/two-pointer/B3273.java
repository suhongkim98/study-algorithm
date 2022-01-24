import java.io.*;
import java.util.*;

//투포인터
//배열 정렬 후 시작
//끝에서부터 투포인터 합이랑 x와 비교
//대소 여부에 따라 start++ 혹은 end++하고 일치하면 카운트
//카운트 출력
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        //two-pointer
        int start = 0, end = arr.length - 1, count = 0;
        while(true) {
            if(start == end || start > end) break;

            int sum = arr[start] + arr[end];
            if(sum == x) {
                count++;
                start++;
            }
            else if(sum > x) {
                end--;
            } else {
                start++;
            }
        }
        bw.write(count + " ");

        bw.flush();
        br.close();
        bw.close();
    }
}
