package leetcode.p22GenerateParentheses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        dfs("", 0, 0, n, res);
        return res;
    }

    private void dfs(String curStr, int left, int right, int n, List<String> res) {
        if (left == n && right == n) {
            res.add(curStr);
            return;
        }
        if (left < right) {
            return;
        }
        if (left < n) {
            dfs(curStr + "(", left + 1, right, n, res);
        }
        if (right < n) {
            dfs(curStr + ")", left, right + 1, n, res);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
        System.out.println(g.generateParenthesis(3));
        System.out.println(g.generateParenthesis1(3));
    }

    class Node {
        String res;
        int left;
        int right;

        public Node(String res, int left, int right) {
            this.res = res;
            this.left = left;
            this.right = right;
        }
    }
    // bfs
    public List<String> generateParenthesis1(int n) {
        List<String> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node("", n, n);
        queue.add(node);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.left == 0 && poll.right == 0) {
                ans.add(poll.res);
            }
            if (poll.left > poll.right) {
                continue;
            }
            if (poll.left > 0) {
                queue.add(new Node(poll.res + "(", poll.left - 1, poll.right));
            }
            if (poll.right > 0) {
                queue.add(new Node(poll.res + ")", poll.left, poll.right - 1));
            }
        }
        return ans;
    }

}
