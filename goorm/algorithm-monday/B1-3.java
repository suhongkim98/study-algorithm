import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.List;

class Main {

    /*
맨헤튼 거리 구하기
그리디

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        Integer[] arr = new Integer[input.length];
        for(int i = 0 ; i < input.length ; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int result = Math.abs(arr[0] - arr[2]) + Math.abs(arr[1] - arr[3]);
        bw.write(result + "");

        br.close();
        bw.close();
    }
}