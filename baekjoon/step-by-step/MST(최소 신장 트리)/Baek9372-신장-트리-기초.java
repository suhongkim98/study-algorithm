import java.io.*;
import java.util.*;

//신장 트리는 그래프 내에 있는 모든 정점을 연결하고 사이클이 없는 그래프를 의미. N개의 정점이 있다면 신장 트리의 간선 수는 N-1개
//최소 신장 트리는 이중 가중치의 합이 최소가 되는 신장 트리의 가중치 합을 구하는 것으로
//가중치가 없는 신장 트리는 가중치가 다 똑같으므로 최소신장트리는 간선 수 만큼이 답이다. 즉 N-1이 답이다.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < T ; i++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            for(int j = 0 ; j < M ; j++) {
                input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
            }
            bw.write((N - 1) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
