package offer;

import java.util.Stack;

public class Offer09TwoStack {
}

class CQueue {

    private Stack<Integer> in;
    private Stack<Integer> out;

    public CQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }

    public void appendTail(int value) {
        in.add(value);
    }

    public int deleteHead() {
        if (out.empty()) {
            if (in.empty()) {
                return -1;
            }
            int inSize = in.size();
            for (int i = 0; i < inSize; ++i) {
                out.add(in.pop());
            }
        }
        return out.pop();
    }

    public static void main(String[] args) {
        CQueue c = new CQueue();
        c.appendTail(5);
        c.appendTail(2);
        System.out.println(c.deleteHead());
        System.out.println(c.deleteHead());

    }
}
