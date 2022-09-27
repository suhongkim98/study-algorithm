/*
2개의 큐를 활용해 스택 구현하기
https://leetcode.com/problems/implement-stack-using-queues/submissions/
 */
class MyStack {
    private Queue<Integer> tmpQueue;
    private Queue<Integer> popQueue;
    public MyStack() {
        tmpQueue = new ArrayDeque<>();
        popQueue = new ArrayDeque<>();
    }

    public void push(int x) {
        while (!popQueue.isEmpty()) tmpQueue.add(popQueue.poll());
        popQueue.add(x);
        while (!tmpQueue.isEmpty()) popQueue.add(tmpQueue.poll());
    }

    public int pop() {
        return popQueue.poll();
    }

    public int top() {
        return popQueue.peek();
    }

    public boolean empty() {
        return popQueue.isEmpty() && tmpQueue.isEmpty();
    }
}

