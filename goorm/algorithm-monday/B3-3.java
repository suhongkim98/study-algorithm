import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.List;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);
        //int[][] map = new int[N + 1][N + 1]; // 시작은 1
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i < N + 1 ; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i = 0; i < M ; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            adjList.get(start).add(end);
            adjList.get(end).add(start);
        }

        boolean[] visit = new boolean[N + 1];
        boolean done = false;
        Queue<Node> q = new ArrayDeque<>();
        visit[1] = true;
        q.add(new Node(1, 0));
        while (!q.isEmpty()) {
            Node node = q.poll();
            if(node.index == N) {
                done = true;
                break;
            }
            if(node.count == K) continue;

            for(int i = 0 ; i < adjList.get(node.index).size() ; i++) {
                int target = adjList.get(node.index).get(i);
                if(!visit[target]) {
                    visit[target] = true;
                    q.add(new Node(target, node.count + 1));
                }
            }
        }

        if(done) bw.write("YES");
        else bw.write("NO");

        br.close();
        bw.close();
    }
}
class Node {
    int count;
    int index;
    public Node(int index, int count) {
        this.index = index;
        this.count = count;
    }
}
/*
BFS
시작노드에서부터 최대 K회까지 BFS 돌려본다.
목적지 도달 시 true
*/