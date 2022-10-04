import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.List;

class Main {

    /*
    upperbound 활용
    첫번째 인덱스부터 넣어보며 개수구하기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);
        int maxCount = 0;
        long result = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            long target = arr[i];
            int nextIdx = upperBound(arr, target);

            int size = nextIdx - i;
            if(maxCount < size) {
                maxCount = size;
                result = target;
            }
            i = nextIdx - 1;
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
    static int upperBound(long[] array, long value) {
        int start = 0;
        int end = array.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (value >= array[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}