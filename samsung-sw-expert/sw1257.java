import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;

//Trie, 사전 순에서 특정 순서 문자열 출력
public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		    int order = sc.nextInt();
		    String input = sc.next();
		    UserSolution t = new UserSolution();
		    //love => l,o,v,e,lo,ov,ve,lov,ove,love로 쪼개 삽입
		    for(int i = 0 ; i < input.length() ; i++) {
		        for(int j = 0; j < input.length() - i ; j++) {
		            String sub = input.substring(j, j + i + 1);
		            t.add(sub);
		        }
		    }
		    System.out.println("#" + test_case + " " + t.getOrder(order));
		}
	}
}

class TrieNode {
    char word;
    TrieNode[] childs;
    boolean isLast;
    
    public TrieNode() {
        childs = new TrieNode[26];
    }
    public TrieNode(char word) {
        this();
        this.word = word;
    }
}
class StackNode {
    TrieNode trieNode;
    String result;
    public StackNode(TrieNode trieNode, String result) {
        this.trieNode = trieNode;
        this.result = result;
    }
}
class UserSolution {
    TrieNode root;
    int order;
    String result;
    public UserSolution() {
        root = new TrieNode();
    }
    
    public void add(String words) { //hello
        TrieNode target = root;
        for(int i = 0 ; i < words.length() ; i++) {
            if(target.childs[words.charAt(i) - 'a'] == null) {
                target.childs[words.charAt(i) - 'a'] = new TrieNode(words.charAt(i));
            }
            target = target.childs[words.charAt(i) - 'a'];
        }
        target.isLast = true;
    }
    public String getOrder(int order) {
        this.order = order;
        dfs(root, "");
        if(result == null) return "none";
        return result;
    }
    public void dfs(TrieNode root, String result) {
        Stack<StackNode> s = new Stack<>();
        for(int i = 25 ; i >= 0 ; i--) {
            if(root.childs[i] != null) {
                TrieNode child = root.childs[i];
                s.push(new StackNode(child, "" + child.word));
            }
        }
        while(!s.isEmpty()) {
            StackNode node = s.pop();
            if(node.trieNode.isLast) {
                //끝이면
                order--;
            }
            if(this.order == 0) {
                //결과
                this.result = node.result;
                break;
            }
            
            for(int i = 25 ; i >= 0 ; i--) {
                if(node.trieNode.childs[i] != null) {
                    s.push(new StackNode(node.trieNode.childs[i], node.result + node.trieNode.childs[i].word));
                }
            }
        }
    }
}
