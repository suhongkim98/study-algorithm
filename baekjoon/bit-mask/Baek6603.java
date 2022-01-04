import java.io.*;
import java.util.Arrays;

//로또 추출
//재귀함수, 비트연산 사용
//방문여부를 비트마스크로 사용
//재귀써서 방문여부 6개 시 로또출력
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            String[] input = br.readLine().split(" ");
            int size = Integer.parseInt(input[0]);
            if(size == 0) break;
            int[] arr = new int[size];
            for (int i = 1; i <= size; i++) {
                arr[i - 1] = Integer.parseInt(input[i]);
            }
            //재귀, 비트연산
            solve(arr, 0, 0);
            System.out.println();
            bw.flush();
        }

        bw.close();
        br.close();
    }
    static int countBits(int used) {
        int val = used;
        int count = 0;
        while(val > 0) {
            if((val & 1) != 0) count++;
            val = val >> 1;
        }
        return count;
    }
    static void solve(int[] arr, int pos, int used) {
        if(countBits(used) == 6) {
            //비트 출력
            for(int i = 0 ; i < arr.length ; i++) {
                if((used & (1 << i)) != 0) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }
        for(int i = pos ; i < arr.length ; i++) {
            //여기서 재귀함수 pos는 i+1이지..
            solve(arr, i + 1, used | (1 << i));
        }
    }
}
