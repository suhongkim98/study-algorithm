public class UserSolution {
    Stack<Integer> stack;
    int length;
    int[][] map;
	public void dfs_init(int N, int[][] path) {
	    stack = new Stack<>();
	    length = N;
	    map = path;
	}
	
	public int dfs(int N) {
	    stack.pushStack(N);
	    int result = -1;
	    while(!stack.isEmptyStack()) {
	        int n = stack.popStack();
	        for(int i = 0 ; i < length ; i++){
	            if(map[i][0] == n){
	                if(N < map[i][1]) {
	                    result = map[i][1];
	                    break;
	                }
	                stack.pushStack(map[i][1]);
	            }
	        }
	    }
		return result;
	}
}

class Node<T> {
    T value;
    Node<T> next;
    public Node(T value) {
        this.value = value;
    }
}
class Stack<T> {
    Node<T> top;
    public boolean isEmptyStack() {
        return top == null;
    }
    public T popStack() {
        if(top == null) return null;
        Node<T> node = top;
        top = top.next;
        return node.value;
    }
    public void pushStack(T value) {
        Node<T> node = new Node(value);
        if(top == null) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }
    }
}
