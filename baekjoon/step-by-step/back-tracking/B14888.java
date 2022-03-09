import java.io.*;
import java.util.*;

class Main {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] operationCount = new int[4];
        String[] input = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        for(int i = 0 ; i < 4 ; i++) {
            operationCount[i] = Integer.parseInt(input[i]);
        }
        solve(arr, operationCount, 1, arr[0]); // 첫번째는 계산하고 들어간다

        bw.write(max + "\n" + min);
        bw.close();
        br.close();
    }
    static void solve(int[] numArr, int[] operationCount, int pos, int sum) {
        if(pos == numArr.length) {
            if(sum > max) max = sum;
            if(sum < min) min = sum;
            return;
        }

        // + - * /
        if(operationCount[0] > 0) {
            // + 가능
            operationCount[0]--;
            solve(numArr, operationCount, pos + 1, sum + numArr[pos]);
            operationCount[0]++;
        }
        if(operationCount[1] > 0) {
            // - 가능
            operationCount[1]--;
            solve(numArr, operationCount, pos + 1, sum - numArr[pos]);
            operationCount[1]++;
        }
        if(operationCount[2] > 0) {
            // * 가능
            operationCount[2]--;
            solve(numArr, operationCount, pos + 1, sum * numArr[pos]);
            operationCount[2]++;
        }
        if(operationCount[3] > 0) {
            // / 가능
            operationCount[3]--;
            solve(numArr, operationCount, pos + 1, sum / numArr[pos]);
            operationCount[3]++;
        }
    }
}

