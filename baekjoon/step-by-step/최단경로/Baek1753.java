import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
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

		String[] input = br.readLine().split(" ");
		int V = Integer.parseInt(input[0]);
		int E = Integer.parseInt(input[1]);
		int start = Integer.parseInt(br.readLine());
		
		DijkstraGraph g = new DijkstraGraph(V);
		
		for(int i = 0 ; i < E ; i++) {
			input = br.readLine().split(" ");
			int u = Integer.parseInt(input[0]);
			int v = Integer.parseInt(input[1]);
			int w = Integer.parseInt(input[2]);
			
			g.insertEdge(u - 1, v - 1, w);
		}
		
		g.dijkstra(start - 1);
		for(int i = 0 ; i < V ; i++) {
            if(g.dist[i] == g.INF) bw.write("INF\n"); // 시작노드에서 해당 i번째 노드까지 연결되어있지 않음
            else bw.write(g.dist[i] + "\n");
        }
		
		bw.flush();
		bw.close();
        br.close();
	}
	
}

// 다익스트라 사용
//메모리 초과가 떠서 인접행렬을 인접 리스트로 바꾸자
class Node {
	int index;
	int weight;
	public Node(int index, int weight) {
		this.index = index;
		this.weight = weight;
	}
}
class DijkstraGraph {
    int[] dist; // 시작점에서 해당 노드까지 가는데 걸리는 최단거리이다. dist[3]은 시작점->3노드까지 가는 최단거리 dist[5]은 시작점->5노드까지
    final int INF = 200000000; // 임의의 큰 값 // Integer max 는 주면 안될듯
    private int size;
    private List<ArrayList<Node>> graph;

    public DijkstraGraph(int size) {
        this.graph = new ArrayList<>();
        this.size = size;
        for(int i = 0 ; i < size ; i++) {
        	graph.add(new ArrayList<>());
        }
    }

    public void insertEdge(int start, int destination, int weight) {
    	graph.get(start).add(new Node(destination, weight));
    }

    public void dijkstra(int start) { // 시작점을 입력받는다.
        boolean[] visited = new boolean[size];
        dist = new int[size];
        for(int i = 0 ; i < size ; i++)
            dist[i] = INF;
        dist[start] = 0; // 시작점은 값이 0, 나머지는 INF

        //방문하지 않은 노드 중 dist 가 가장 짧은 노드 선택
        for(int i = 0 ; i < size ; i++) {
            int minCost = INF, minVertex = -1;
            for(int j = 0 ; j < size ; j++) {
                if(!visited[j] && dist[j] < minCost) {
                    minCost = dist[j];
                    minVertex = j;
                }
            }
            if(minVertex == -1) break; // 시작노드부터 연결 가능한 모든 노드 연결했으나 연결못한 남은 노드가 있는 상태
            visited[minVertex] = true; // 해당 노드를 방문표시
            // 해당 노드를 통해 갈 수 있는 정점들을 찾아 내가 가지고 있는 최단거리 + 해당 노드까지 가는 거리가 Dist보다 짧은 값인경우 해당 Dist를 업데이트
            for(int j = 0 ; j < graph.get(minVertex).size() ; j++) {
            	int index = graph.get(minVertex).get(j).index;
            	int weight = graph.get(minVertex).get(j).weight;
                if(dist[index] > dist[minVertex] + weight) {
                    dist[index] = dist[minVertex] + weight;
                }
            }
        }
    }
}
