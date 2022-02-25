// 그래프 클래스
class Graph {
    private ArrayList<ArrayList<Integer>> adjList; // 인접리스트 방식

    // 그래프 초기화
    public Graph(int initSize) {
        this.adjList = new ArrayList<>(); // 그래프 생성
        for(int i=0; i<initSize+1; i++) { // index 1부터 시작하니 + 1
            adjList.add(new ArrayList<Integer>());
        }
    }

    // 그래프 return
    public ArrayList<ArrayList<Integer>> getGraph() {
        return this.adjList;
    }

    // 그래프의 특정 노드 return
    public ArrayList<Integer> getNode(int i) {
        return this.adjList.get(i);
    }

    // 그래프 추가 (양방향)
    public void put(int x, int y) {
        adjList.get(x).add(y);
        adjList.get(y).add(x);
    }

    // 그래프 추가 (단방향)
    public void putSingle(int x, int y) {
        adjList.get(x).add(y);
    }

    // 그래프 출력 (인접리스트)
    public void printGraphToAdjList() {
        for(int i=1; i<adjList.size(); i++) {
            System.out.print("정점 " + i + "의 인접리스트");

            for(int j=0; j<adjList.get(i).size(); j++) {
                System.out.print(" -> " + adjList.get(i).get(j));
            }
            System.out.println();
        }
    }
}


public class Main {
    public static void main(String[] args) throws IOException {

        int initSize = 6;
        Graph adjList = new Graph(initSize);

        // index 1 부터 시작
        adjList.put(1, 2);
        adjList.put(1, 3);
        adjList.put(2, 3);
        adjList.put(2, 4);
        adjList.put(3, 4);
        adjList.put(3, 5);
        adjList.put(4, 5);
        adjList.put(4, 6);

        adjList.printGraphToAdjList();
    }
}

