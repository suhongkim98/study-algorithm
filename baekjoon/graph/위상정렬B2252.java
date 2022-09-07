import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 노드의 개수, 시작은 1
        int M = Integer.parseInt(input[1]); // 입력받는 간선의 개수

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i < N + 1 ; i++) { // 시작 1
            adjList.add(new ArrayList<>());
        }
        int[] inDegree = new int[N + 1]; // index로 들어오는 간선 개수 표시

        for(int i = 0 ; i < M ; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            inDegree[b]++; // b로 들어오는 간선 개수 ++
            adjList.get(a).add(b);
        }
        Queue<Integer> result = TopologicalSort.topologicalSort(inDegree, adjList);
        while (!result.isEmpty()) {
            bw.write(result.poll() + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

// 위상 정렬(Topological sort)은 비순환 방향 그래프(DAG)에서 정점을 선형으로 정렬하는 것
// 순서가 정해져있는 작업을 차례로 수행해야할 때 그 순서를 결정해주기 위해 사용
//
// https://m.blog.naver.com/ndb796/221236874984
class TopologicalSort {
    static Queue<Integer> topologicalSort(int[] inDegree, List<List<Integer>> adjList) {
        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> result = new LinkedList<Integer>();

        // 큐에 inDegree 가 0 인 노드 담기
        for (int i = 1; i < inDegree.length ; i++) { // 시작은 1
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        for(int i = 1 ; i < inDegree.length ; i++) {
            // n개를 방문하기 전에 큐가 비어버리면 사이클이 발생한 것
            if(q.isEmpty()) {
                System.out.println("사이클");
                return null;
            }
            int node = q.poll();
            result.offer(node);

            for(int j = 0 ; j < adjList.get(node).size() ; j++) {
                int y = adjList.get(node).get(j); // index
                // node index 를 제거했다. node -> j 로 간선이 존재하면 j로 들어오는 간선 개수 -- 해주어야 함
                inDegree[y]--;
                if(inDegree[y] == 0) {
                    // -- 해줌으로써 들어오는 간선개수가 0이라면 큐에 삽입해주어야 함
                    q.add(y);
                }
            }
        }
        return result;
    }
}
