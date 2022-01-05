import java.io.*;
import java.util.*;

//이진탐색
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        for(int i = 0 ; i < M ; i++) {
            if(Search.binarySearch(arr, Integer.parseInt(input[i]), 0, arr.length - 1)) bw.write("1\n");
            else bw.write("0\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
class Search {
    static boolean binarySearch(int[] arr, int target, int start, int end) {
        if(start > end) return false;

        int mid = (start + end) / 2;
        if(arr[mid] == target) return true;
        else if(arr[mid] > target) return binarySearch(arr, target, start, mid - 1);
        return binarySearch(arr, target, mid + 1, end);
    }
}
