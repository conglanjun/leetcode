package advance.Greedy;

public class Activities {

    public Activity[] acts = {new Activity(1, 4), new Activity(3, 5), new Activity(0, 6), new Activity(5, 7),
            new Activity(3, 9), new Activity(5, 9), new Activity(6, 10), new Activity(8, 11), new Activity(8, 12),
            new Activity(2, 14), new Activity(12, 16)};

    public Activity[] activitySelection(Activity[] acts) {
        Activity[] res = new Activity[acts.length];
        int index = 0; // the last index of activity
        res[index] = acts[0];
        for (int i = 1; i < acts.length; ++i) {
            if (res[index].end <= acts[i].start) {
                res[++index] = acts[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Activities a = new Activities();
        Activity[] res = a.activitySelection(a.acts);
        for (int i = 0; i < res.length; ++i) {
            if (res[i] == null) break;
            System.out.print(res[i] + ",");
        }
        System.out.println();
    }
}

class Activity {
    public int start;
    public int end;
    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "(" + start + " " + end + ")";
    }
}
