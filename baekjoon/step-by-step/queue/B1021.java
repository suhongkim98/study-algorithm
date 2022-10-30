import java.awt.*;
import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 1 ; i < N + 1 ; i++) {
            q.add(i);
        }

        int count = 0;
        input = br.readLine().split(" ");
        for(int i = 0 ; i < M ; i++) {
            int target = Integer.parseInt(input[i]);
            if(q.peek() == target) {
                q.poll();
            } else {
                // 앞으로 뽑아본다.
                int firstCount = 0;
                while (q.peek() != target) {
                    firstCount++;
                    q.addLast(q.removeFirst());
                }
                for(int j = 0 ; j < firstCount ; j++) {
                    // 복구
                    q.addFirst(q.removeLast());
                }
                // 뒤로 뽑아본다.
                int secondCount = 0;
                while (q.peek() != target) {
                    secondCount++;
                    q.addFirst(q.removeLast());
                }
                for(int j = 0 ; j < secondCount ; j++) {
                    // 복구
                    q.addLast(q.removeFirst());
                }

                if(firstCount <= secondCount) {
                    while (q.peek() != target) {
                        count++;
                        q.addLast(q.removeFirst());
                    }
                    q.poll();
                } else {
                    while (q.peek() != target) {
                        count++;
                        q.addFirst(q.removeLast());
                    }
                    q.poll();
                }
            }
        }
        bw.write(count + "");

        br.close();
        bw.close();
    }
}

