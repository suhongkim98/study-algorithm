import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);
        Kruskal k = new Kruskal(V);
        for(int i = 0 ; i < E ; i++) {
            input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            int C = Integer.parseInt(input[2]);
            k.insertEdge(A - 1, B - 1, C);
        }
        bw.write(k.calculate() + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
// 간선을 가중치 기준으로 오름차순 정렬하고 하나씩 선택해서 MST 를 찾는 알고리즘
// 사이클을 union find로 체크한다.
class Edge {
    int u;
    int v;
    int weight;
}
class Kruskal {
    int edgeCount;
    int[] parent;
    Edge[] edgeArr;
    int size;

    public Kruskal(int size) {
        this.size = size;
        int edgeCount = 0;
        parent = new int[size];
        edgeArr = new Edge[size * (size - 1) / 2];
    }
    public void insertEdge(int u, int v, int weight) {
        Edge edge = new Edge();
        edge.u = u;
        edge.v = v;
        edge.weight = weight;

        edgeArr[edgeCount++] = edge;
    }

    //유일한 멤버 v를 포함하는 새로운 집합을 생성한다.
    //자기 자신을 가리킨다는 의미는 해당 집합의 대표원소라는 의미다.
    static void makeSet(int[] parent, int v) {
        parent[v] = v;
    }
    //v를 포함하는 집합을 찾는 연산
    static int findSet(int[] parent, int v) {
        //parent[v] == v라면(자기 자신을 가리킨다면) 해당 원소는 해당 집합의 대표원소이므로 리턴
        //아니라면 해당 원소는 대표원소가 아니므로 재귀로 타고타고 들어간다.
        if(v == parent[v]) return v;
        return parent[v] = findSet(parent, parent[v]);
    }
    //u와 v 원소를 포함하는 두 집합을 통합하는 연산
    static void unionSet(int[] parent, int u, int v) {
        parent[findSet(parent, u)] = findSet(parent, v);
    }

    public int calculate() {
        //가중치로 오름차순 정렬
        Arrays.sort(edgeArr, 0, edgeCount, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        //make set
        for(int i = 0 ; i < size ; i++) {
            makeSet(parent, i);
        }

        int sumWeight = 0, selectCount = 0;
        for(int i = 0 ; i < edgeCount ; i++) {
            int u = edgeArr[i].u, v = edgeArr[i].v;
            if(findSet(parent, u) == findSet(parent, v)) continue; // cycle이므로 통과
            unionSet(parent, u, v); // 두 원소가 속한 각각의 집합을 합친다.

            sumWeight += edgeArr[i].weight;
            if(++selectCount >= size - 1) break;
        }
        return sumWeight;
    }
}
