package leetcode.problem225;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue2.add(x);
        int size = queue1.size();
        for (int i = 0; i < size; ++i) {
            queue2.add(queue1.poll());
        }
        Queue<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (queue1.size() == 0) return 0;
        return queue1.poll();
    }

    /** Get the top element. */
    public int top() {
        if (queue1.size() == 0) return 0;
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }

}
