package leetcode.problem232;

import java.util.Stack;

public class MyQueue {

    private Stack<Integer> input = new Stack<>();
    private Stack<Integer> output = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        input.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (output.empty()) {
            if (input.empty()) return 0;
            int size = input.size();
            for (int i = 0; i < size; ++i) {
                output.add(input.pop());
            }
        }
        return output.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (output.empty()) {
            if (input.empty()) return 0;
            int size = input.size();
            for (int i = 0; i < size; ++i) {
                output.add(input.pop());
            }
        }
        return output.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.empty() && output.empty();
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        int peek = obj.peek();
        System.out.println(peek);
        int pop = obj.pop();
        System.out.println(pop);
    }
}
