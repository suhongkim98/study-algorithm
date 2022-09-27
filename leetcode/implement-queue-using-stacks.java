/*
2개의 스택을 사용해 큐 구현하기
https://leetcode.com/problems/implement-queue-using-stacks/submissions/
 */
class MyQueue {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;
    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void push(int x) {
        while (!popStack.isEmpty()) pushStack.push(popStack.pop());
        pushStack.push(x);
    }

    public int pop() {
        while (!pushStack.isEmpty()) popStack.push(pushStack.pop());
        return popStack.pop();
    }

    public int peek() {
        while (!pushStack.isEmpty()) popStack.push(pushStack.pop());
        return popStack.peek();
    }

    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}

