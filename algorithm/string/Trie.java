//https://velog.io/@suhongkim98/Trie
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
}
