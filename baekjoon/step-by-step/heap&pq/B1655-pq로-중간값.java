import java.io.*;
import java.util.*;

//최대힙, 최소힙을 사용해 입력할 때마다 항상 중간값 구하기
//최대힙 peek값이 항상 중간값이다.
//입력받아 숫자를 큐에 넣는데 maxQ와 minQ의 사이즈를 항상 동일하게 한다.
//maxQ peek이 더 클 경우 swap
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

        int start = Integer.parseInt(br.readLine());

        maxQueue.add(start); // N은 1보다 크거나 같으므로 시작은 무조건 삽입
        bw.write(start + "\n"); //처음엔 무조건 start 가 중간값임

        for(int i = 1 ; i < N ; i++) { // N은 1보다 크거나 같고 이미 하나를 입력받아 큐에 넣었으므로 1부터 시작
            int n = Integer.parseInt(br.readLine());
            if(i % 2 == 0) maxQueue.add(n); // i가 짝수란 것은 minQ, maxQ 사이즈가 일치하므로 max queue
            else minQueue.add(n); // i가 홀수란 것은 시작 때 maxQ에 넣어서 max 사이즈가 1 더 클 것이므로 min 큐 삽입
            if(minQueue.peek() < maxQueue.peek()) {
                //maxQ peek이 더 클 경우 swap
                int min = minQueue.poll();
                int max = maxQueue.poll();
                maxQueue.add(min);
                minQueue.add(max);
            }
            //중간값 출력, 항상 maxQ peek이 중간값임
            bw.write(maxQueue.peek() + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
