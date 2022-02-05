class Trie {
    Trie[] child;
    boolean isLast; //해당 노드가 문자열의 마지막인가

    public Trie() {
        child = new Trie[26];
    }
    public void add(String str) {
        if(str.length() == 0) {
            this.isLast = true;
        } else {
            char alpha = str.charAt(0);
            if(child[alpha - 'a'] == null) child[alpha - 'a'] = new Trie();
            child[alpha - 'a'].add(str.substring(1));
        }
    }
    public boolean isContain(String str) {
        if(str.length() == 0) {
            if(isLast) return true;
            else return false;
        }

        char alpha = str.charAt(0);
        if(child[alpha - 'a'] == null) return false;
        return child[alpha - 'a'].isContain(str.substring(1));
    }
    static void dfs(Trie node, String data) {
        if(node.isLast) { // 문자열의 마지막이라면
            System.out.println(data);
        }
        for(int i = 0 ; i < 26 ; i++) {
            if(node.child[i] != null) {
                dfs(node.child[i], data + (char)(i + 'a'));
            }
        }
    }

    public static void main(String[] args) {
        Trie root = new Trie();
        System.out.println("삽입 hello");
        root.add("hello");
        System.out.println("삽입 high");
        root.add("high");
        System.out.println("삽입 hell");
        root.add("hell");
        System.out.println("삽입 gooood");
        root.add("gooood");
        System.out.println("삽입 good");
        root.add("good");

        System.out.println("\ndfs 탐색");
        Trie.dfs(root, "");

        System.out.println("\n문자열 존재 여부 체크");
        System.out.println("helloo: " + root.isContain("helloo"));
        System.out.println("hello: " + root.isContain("hello"));
        System.out.println("world: " + root.isContain("world"));
        System.out.println("high: " + root.isContain("high"));
        System.out.println("hi: " + root.isContain("hi"));
        /*
삽입 hello
삽입 high
삽입 hell
삽입 gooood
삽입 good

dfs 탐색
good
gooood
hell
hello
high

문자열 존재 여부 체크
helloo: false
hello: true
world: false
high: true
hi: false
         */
    }
}
