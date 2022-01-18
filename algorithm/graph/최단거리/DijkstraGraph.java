
// 하나의 시작 정점에서 끝 정점까지의 최단 경로를 구하는 알고리즘
// S노드에서 T노드까지 가는 최단 경로가 있는데 그 최단경로 중간에 X노드가 있다고 가정해본다.
// 다익스트라는 S->X까지도 최단거리, X->T까지 가는 경로도 최단거리라는 메커니즘이다.
// 이 성질을 바탕으로 시작점부터 경로를 구해 나감으로써 멀리있는 노드까지도 최단거리를 구할 수 있다.
// 최단거리, 최단경로 다 구할 수 있다.

//DijkstraGraph 는 최단거리만
//DijkstraGraphV2는 최단거리에 최단경로까지 구하는 코드
class DijkstraGraph {
    int[] dist; // 시작점에서 해당 노드까지 가는데 걸리는 최단거리이다. dist[3]은 시작점->3노드까지 가는 최단거리 dist[5]은 시작점->5노드까지
    final int INF = 200000000; // 임의의 큰 값 // Integer max 는 주면 안될듯
    private int size;
    private int[][] graph;

    public DijkstraGraph(int size) {
        this.graph = new int[size][size];
        this.size = size;
        for(int i = 0 ; i < size ; i++) {
            for(int j = 0 ; j < size ; j++) {
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
            for(int j = 0 ; j < size ; j++) {
                if(dist[j] > dist[minVertex] + graph[minVertex][j]) {
                    dist[j] = dist[minVertex] + graph[minVertex][j];
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        int size = 5;
        int start = 0;
        DijkstraGraph g = new DijkstraGraph(size);

        g.insertEdge(0,1,10);
        g.insertEdge(1, 2, 4);
        g.insertEdge(1, 4, 4);
        g.insertEdge(2,3, 3);
        g.insertEdge(3,4,7);
        g.dijkstra(start);

        System.out.println("최단거리");
        for(int i = 0 ; i < 5 ; i++) {
            if(g.dist[i] == g.INF) continue; // 시작노드에서 해당 i번째 노드까지 연결되어있지 않음
            else System.out.println(start + " -> " + i + " = " + g.dist[i]); // 실수방지용으로 else
        }

    }
}
// 최단거리에 최단경로까지 구해보자
// 최단경로는 각각의 노드에 오기 전에 바로 앞 노드가 무엇인지만 알면 된다.
// 왜냐하면 다익스트라의 부분 경로는 그 각각이 시작점부터의 최단경로이기 때문이다.
class DijkstraGraphV2 {
    int[] dist; // 시작점에서 해당 노드까지 가는데 걸리는 최단거리이다. dist[3]은 시작점->3노드까지 가는 최단거리 dist[5]은 시작점->5노드까지
    int[] prev; // 최단경로에서 해당 노드의 이전 노드가 무엇인지 저장
    final int INF = 200000000; // 임의의 큰 값 // Integer max 는 주면 안될듯
    private int size;
    private int[][] graph;

    public DijkstraGraphV2(int size) {
        this.graph = new int[size][size];
        this.size = size;
        for(int i = 0 ; i < size ; i++) {
            for(int j = 0 ; j < size ; j++) {
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
        prev = new int[size];
        for(int i = 0 ; i < size ; i++) {
            dist[i] = INF;
            prev[i] = -1;
        }
        dist[start] = 0; // 시작점은 값이 0, 나머지는 INF

        //방문하지 않은 노드 중 dist가 가장 짧은 노드 선택
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
            for(int j = 0 ; j < size ; j++) {
                if(dist[j] > dist[minVertex] + graph[minVertex][j]) {
                    dist[j] = dist[minVertex] + graph[minVertex][j]; // 최단거리
                    prev[j] = minVertex; // 최단경로에서 해당 노드 이전노드가 무엇인지 저장
                }
            }
        }
    }
  
    public static void main(String[] args) throws IOException {
        int size = 5;
        int start = 0;
        DijkstraGraphV2 g = new DijkstraGraphV2(size);

        g.insertEdge(0,1,10);
        g.insertEdge(1, 2, 4);
        g.insertEdge(1, 4, 4);
        g.insertEdge(2,3, 3);
        g.insertEdge(3,4,7);
        g.dijkstra(start);

        System.out.println("최단거리");
        for(int i = 0 ; i < 5 ; i++) {
            if(g.dist[i] == g.INF) continue; // 시작노드에서 해당 i번째 노드까지 연결되어있지 않음
            else System.out.println(start + " -> " + i + " = " + g.dist[i]); // 실수방지용으로 else
        }

        System.out.println("최단경로");
        for(int i = 0 ; i < 5 ; i++) {
            System.out.println(start + " -> " + i + "까지의 최단경로");
            //목적지부터 넣어서 -1 나올 때까지 이전노드 추적, 스택으로 역순 출력
            Stack<Integer> stack = new Stack<>();
            stack.push(i); // 일단 목적지 집어넣고, 시작노드에서 목적지까지 연결 안되어있어도 일단 목적지는 출력

            //이전 노드가 -1이 아닌경우까지 계속 스택에 삽입
            int prev = g.prev[i];
            while(prev != -1) {
                stack.push(prev);
                prev = g.prev[prev];
            }

            //출력
            while(!stack.isEmpty()) {
                int n = stack.pop();
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
