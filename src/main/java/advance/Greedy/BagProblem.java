package advance.Greedy;

public class BagProblem {

    public float[] greedy(Good[] goods, int w) {
        float[] ret = new float[goods.length + 1];
        int total = 0;
        for (int i = 0; i < goods.length; ++i) {
            if (w >= goods[i].weight) {
                w -= goods[i].weight;
                ret[i] = 1;
                total += goods[i].value;
            } else {
                ret[i] = (float) w / goods[i].weight;
                w = 0;
                total += goods[i].value * ret[i];
            }
        }
        ret[goods.length] = total;
        return ret;
    }

    public static void main(String[] args) {
        BagProblem bp = new BagProblem();
        Good[] goods = new Good[3];
        goods[0] = new Good(60, 10);
        goods[1] = new Good(100, 20);
        goods[2] = new Good(120, 30);
        float[] greedy = bp.greedy(goods, 50);
        for (int i = 0; i < greedy.length; ++i) {
            System.out.print(greedy[i] + ",");
        }
    }
}

class Good {
    public int value;
    public int weight;

    public Good(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}
