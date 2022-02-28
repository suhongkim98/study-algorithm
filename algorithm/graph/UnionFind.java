import java.io.IOException;

//서로소집합 유니온 파인드
//그래프에서 두 노드(원소)가 같은 집합에 속하는지 검사한다.
class UnionFind {
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
        // return findSet(parent, parent[v]); //경로압축X
        return parent[v] = findSet(parent, parent[v]); // 경로압축O 시간초과시 사용
    }
    //u와 v 원소를 포함하는 두 집합을 통합하는 연산
    static void unionSet(int[] parent, int u, int v) {
        parent[findSet(parent, u)] = findSet(parent, v);
    }

    // parent 배열 통해 해당 그래프에서 집합의 개수 구하기 // bfs 응용
    static int getSetCount(int[] parent) { // 집합의 개수 반환
        boolean[] visit = new boolean[parent.length];
        int count = 0;
        for(int i = 0 ; i < parent.length ; i++) {
            int myParent = UnionFind.findSet(parent, i); // 해당 원소가 속한 집합의 대표 원소 반환
            if(!visit[myParent]) { // 해당 대표원소를 방문한 적 없다면 카운트하지 않은 집합임
                count++;
                visit[myParent] = true;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        int[] parent = new int[10];

        //집합 10개 생성 (init)
        for(int i = 0 ; i < 10 ; i++) {
            UnionFind.makeSet(parent, i);
        }
        System.out.println(UnionFind.findSet(parent, 1)); // 1번 원소가 속한 집합의 대표원소는?
        System.out.println(UnionFind.findSet(parent, 2)); // 2번 원소가 속한 집합의 대표원소는?
        System.out.println(UnionFind.findSet(parent, 3)); // 3번 원소가 속한 집합의 대표원소는?
        System.out.println(UnionFind.findSet(parent, 0)); // 0번 원소가 속한 집합의 대표원소는?
        System.out.println();

        UnionFind.unionSet(parent, 1, 2); // 1번이 속한 집합과 2번이 속한 집합 합연산
        UnionFind.unionSet(parent,3, 0);// 3번이 속한 집합과 0번이 속한 집합 합연산
        System.out.println(UnionFind.findSet(parent, 1)); // 1번 원소가 속한 집합의 대표원소는?
        System.out.println(UnionFind.findSet(parent, 2)); // 2번 원소가 속한 집합의 대표원소는?
        System.out.println(UnionFind.findSet(parent, 3)); // 3번 원소가 속한 집합의 대표원소는?
        System.out.println(UnionFind.findSet(parent, 0)); // 0번 원소가 속한 집합의 대표원소는?
        System.out.println();

        UnionFind.unionSet(parent, 1, 3); // 1번이 속한 집합과 3번이 속한 집합 합연산
        System.out.println(UnionFind.findSet(parent, 1)); // 1번 원소가 속한 집합의 대표원소는?
        System.out.println(UnionFind.findSet(parent, 2)); // 2번 원소가 속한 집합의 대표원소는?
        System.out.println(UnionFind.findSet(parent, 3)); // 3번 원소가 속한 집합의 대표원소는?
        System.out.println(UnionFind.findSet(parent, 0)); // 0번 원소가 속한 집합의 대표원소는?
        System.out.println();

        System.out.println("집합의 개수 " + UnionFind.getSetCount(parent));
    }
}

//집합의 크기를 알 수 있도록한 유니온파인드
//유니온파인드 자료구조에서 root에 해당하는 각 대표 원소가 parent link로 자신을 가리키지 않고 집합의 크기를 갖도록 한다.
class UnionFindV2 {

    //일반적으로 makeSet을 구현하지 않고 반복문으로 초기화
    static void init(int[] parent) {
        for(int i = 0 ; i < parent.length ; i++) {
            parent[i] = -1;
        }
    }
    static int findSet(int[] parent, int v) {
        // 음수인경우 해당 음수값은 사이즈 * -1을 의미하고 v는 대표원소임을 의미
        if(parent[v] < 0) return v;
        // return findSet(parent, parent[v]); //경로압축X
        return parent[v] = findSet(parent, parent[v]); // 경로압축O 시간초과시 사용
    }
    //v가 속한 집합의 대표원소를 찾아 -1을 곱해 사이즈 반환
    static int getSetSize(int[] parent, int v) {
        return -parent[findSet(parent, v)];
    }
    static void unionSet(int[] parent, int u, int v) {
        int root1 = findSet(parent, u);
        int root2 = findSet(parent, v);
        if(root1 == root2) return; // 대표원소가 같다는 의미는 같은 집합에 있다는 의미로 합집합할 필요 없음
        parent[root1] += parent[root2]; //원소의 개수를 더해줌
        parent[root2] = root1;
    }
    // parent 배열 통해 해당 그래프에서 집합의 개수 구하기 // bfs 응용
    static int getSetCount(int[] parent) { // 집합의 개수 반환
        boolean[] visit = new boolean[parent.length];
        int count = 0;
        for(int i = 0 ; i < parent.length ; i++) {
            int myParent = UnionFindV2.findSet(parent, i); // 해당 원소가 속한 집합의 대표 원소 반환
            if(!visit[myParent]) { // 해당 대표원소를 방문한 적 없다면 카운트하지 않은 집합임
                count++;
                visit[myParent] = true;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        int[] parent = new int[10];

        // (init)
        UnionFindV2.init(parent);

        System.out.println(UnionFindV2.findSet(parent, 1)); // 1번 원소가 속한 집합의 대표원소는?
        System.out.println(UnionFindV2.findSet(parent, 2)); // 2번 원소가 속한 집합의 대표원소는?
        System.out.println(UnionFindV2.findSet(parent, 3)); // 3번 원소가 속한 집합의 대표원소는?
        System.out.println(UnionFindV2.findSet(parent, 0)); // 0번 원소가 속한 집합의 대표원소는?
        System.out.println();

        UnionFindV2.unionSet(parent, 1, 2); // 1번이 속한 집합과 2번이 속한 집합 합연산
        UnionFindV2.unionSet(parent,3, 0);// 3번이 속한 집합과 0번이 속한 집합 합연산
        System.out.println(UnionFindV2.findSet(parent, 1)); // 1번 원소가 속한 집합의 대표원소는?
        System.out.println(UnionFindV2.findSet(parent, 2)); // 2번 원소가 속한 집합의 대표원소는?
        System.out.println(UnionFindV2.findSet(parent, 3)); // 3번 원소가 속한 집합의 대표원소는?
        System.out.println(UnionFindV2.findSet(parent, 0)); // 0번 원소가 속한 집합의 대표원소는?
        System.out.println();

        UnionFindV2.unionSet(parent, 1, 3); // 1번이 속한 집합과 3번이 속한 집합 합연산
        System.out.println(UnionFindV2.findSet(parent, 1)); // 1번 원소가 속한 집합의 대표원소는?
        System.out.println(UnionFindV2.findSet(parent, 2)); // 2번 원소가 속한 집합의 대표원소는?
        System.out.println(UnionFindV2.findSet(parent, 3)); // 3번 원소가 속한 집합의 대표원소는?
        System.out.println(UnionFindV2.findSet(parent, 0)); // 0번 원소가 속한 집합의 대표원소는?
        System.out.println();

        //1번 원소가 속한 집합의 원소개수 구하기
        System.out.println(UnionFindV2.getSetSize(parent, 1));

        System.out.println("집합의 개수 " + UnionFindV2.getSetCount(parent));
    }
}
