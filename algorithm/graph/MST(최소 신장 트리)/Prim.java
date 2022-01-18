import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int size = 7;
        PrimGraph g = new PrimGraph(size);
        g.insertEdge(0,6, 51);
        g.insertEdge(0,2,31);
        g.insertEdge(0,1,32);
        g.insertEdge(0,5,60);
        g.insertEdge(2,1,21);
        g.insertEdge(2,6,25);
        g.insertEdge(2,4,46);
        g.insertEdge(6,4,51);
        g.insertEdge(3,4,34);
        g.insertEdge(5,4,40);
        g.insertEdge(3,5,18);
        int sum = g.prim();
        System.out.println(sum);
    }
}

// union find로 사이클 체크한다.
// MST는 신장 트리 중 가중치 합이 최소를 의미하는 최소 신장 트리이고 이는 하나의 집합이므로 union find 의 parent 배열로 MST 연결을 표현할 것이다.
// parent 배열 중 parent link가 자기 자신일 경우 해당 노드는 MST 집합 중 대표원소임을 의미 (union find 참고)
// 자세한건 정리본

// weight 배열은 자신과 parent 와 연결된 간선의 가중치를 의미
// parent[3] = 4라 하면 MST 에서 3번노드는 4번노드와 연결되어있고 그 가중치는 weight[3]
class PrimGraph {
    int[][] graph;
    int size;
    int[] parent;
    int[] weight;
    private static final int INF = 999999999;

    public PrimGraph(int size) {
        this.size = size;
        graph = new int[size][size];
        parent = new int[size];
        weight = new int[size];

        for(int i = 0 ; i < size ; i++) {
            for(int j = 0 ; j < size ; j++) {
                graph[i][j] = INF; // INF 로 초기화
            }
        }
    }

    public void insertEdge(int start, int des, int weight) {
        graph[start][des] = weight;
        graph[des][start] = weight;
    }

    // MST 집합을 parent 배열로 구성하고 가중치 합 반환
    public int prim() {
        for(int i = 0 ; i < size ; i++) {
            weight[i] = -1;
        }
        weight[0] = 0; // 0번이 MST 집합의 대표원소

        for(int k = 1 ; k < size ; k++) {
            int minWeight = INF, minVertex = -1, minParent = -1;
            for(int i = 0 ; i < size ; i++) {
                if(weight[i] < 0) continue;
                for(int j = 0 ; j < size ; j++) {
                    if(weight[j] >= 0) continue;
                    if(graph[i][j] < minWeight) {
                        minVertex = j; minParent = i;
                        minWeight = graph[i][j];
                    }
                }
            }
            parent[minVertex] = minParent; weight[minVertex] = minWeight;
        }
        int sum = 0;
        for(int i = 0 ; i < size ; i++) {
            sum += weight[i];
        }
        return sum;
    }
}
