import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int aSize = Integer.parseInt(input[0]);
        int bSize = Integer.parseInt(input[1]);
        int[] a = new int[aSize];
        int[] b = new int[bSize];

        input = br.readLine().split(" ");
        for(int i = 0 ; i < input.length ; i++) {
            a[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        for(int i = 0 ; i < input.length ; i++) {
            b[i] = Integer.parseInt(input[i]);
        }

        Solution s = new Solution();
        int[] arr = s.solve(a, b);
        for(int i = 0 ; i < arr.length ; i++) {
            bw.write(arr[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
class Solution {
    int[] solve(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int left = 0, right = 0, idx = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        while(left < a.length && right < b.length) {
            if(a[left] <= b[right]) {
                result[idx++] = a[left++];
            } else {
                result[idx++] = b[right++];
            }
        }
        while(left < a.length) {
            result[idx++] = a[left++];
        }
        while(right < b.length) {
            result[idx++] = b[right++];
        }
        return result;
    }
}

