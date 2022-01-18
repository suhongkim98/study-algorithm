import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		for(int i = 0 ; i < M ; i++) {
			int m = Integer.parseInt(input[i]);
			bw.write(upperBound(arr,m) - lowerBound(arr, m) + " ");
		}
		
		
		
		bw.flush();
		bw.close();
        br.close();
	}
	//이분탐색 upper bound lower bound활용해 찾은 값의 upper, lower bound를 구하여 갯수 계산
	static int lowerBound(int[] array,  int value) {
        int low = 0;
        int high = array.length;
        while (low < high) {
            int mid = low + (high - low)/2;
            if (value <= array[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
	static int upperBound(int[] array, int value) {
        int low = 0;
        int high = array.length;
        while (low < high) {
            int mid = low + (high - low)/2;
            if (value >= array[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
