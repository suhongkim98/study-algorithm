import java.io.*;
import java.util.*;

//다익스트라
//a->t로 갈 때 a --> v --> t라 했을 때 a--> v, v--> t도 모두 최단거리임을 이용한 문제
//중간에 필수로 들르는 노드의 순서에 따라 결과가 달라질 수 있음 경우의 수 따져야함
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);
        DijkstraGraph g = new DijkstraGraph(N);
        for(int i = 0 ; i < E ; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            g.insertEdge(a - 1, b - 1, c);
            g.insertEdge(b - 1, a - 1, c);
        }
        input = br.readLine().split(" ");
        int v1 = Integer.parseInt(input[0]);
        int v2 = Integer.parseInt(input[1]);

        //1->v1->v2->n
        int sum1 = 0;
        g.dijkstra(0); // 1->v1
        sum1 += g.dist[v1 - 1];
        g.dijkstra(v1 - 1); //v1->v2
        sum1 += g.dist[v2 - 1];
        g.dijkstra(v2 - 1); //v2->n
        sum1 += g.dist[N - 1];

        //1->v2->v1->n
        int sum2 = 0;
        g.dijkstra(0); // 1->v2
        sum2 += g.dist[v2 - 1];
        g.dijkstra(v2 - 1); //v2->v1
        sum2 += g.dist[v1 - 1];
        g.dijkstra(v1 - 1); //v1->n
        sum2 += g.dist[N - 1];
        if(sum1 >= g.INF && sum2 >= g.INF) bw.write("-1");
        else bw.write((sum1 > sum2 ? sum2 : sum1) + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
class DijkstraGraph {
    int[] dist; // 시작점에서 해당 노드까지 가는데 걸리는 최단거리이다. dist[3]은 시작점->3노드까지 가는 최단거리 dist[5]은 시작점->5노드까지
    final int INF = 200000000; // 임의의 큰 값 // Integer max 는 주면 안될듯
    private int size;
    private int[][] graph;

    public DijkstraGraph(int size) {
        this.graph = new int[size][size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                graph[i][j] = INF;
            }
        }
    }

    public void insertEdge(int start, int destination, int weight) {
        graph[start][destination] = weight;
    }

    public void dijkstra(int start) { // 시작점을 입력받는다.
        boolean[] visited = new boolean[size];
        dist = new int[size];
        for (int i = 0; i < size; i++)
            dist[i] = INF;
        dist[start] = 0; // 시작점은 값이 0, 나머지는 INF

        //방문하지 않은 노드 중 dist 가 가장 짧은 노드 선택
        for (int i = 0; i < size; i++) {
            int minCost = INF, minVertex = -1;
            for (int j = 0; j < size; j++) {
                if (!visited[j] && dist[j] < minCost) {
                    minCost = dist[j];
                    minVertex = j;
                }
            }
            if (minVertex == -1) break; // 시작노드부터 연결 가능한 모든 노드 연결했으나 연결못한 남은 노드가 있는 상태
            visited[minVertex] = true; // 해당 노드를 방문표시
            // 해당 노드를 통해 갈 수 있는 정점들을 찾아 내가 가지고 있는 최단거리 + 해당 노드까지 가는 거리가 Dist보다 짧은 값인경우 해당 Dist를 업데이트
            for (int j = 0; j < size; j++) {
                if (dist[j] > dist[minVertex] + graph[minVertex][j]) {
                    dist[j] = dist[minVertex] + graph[minVertex][j];
                }
            }
        }
    }
}
