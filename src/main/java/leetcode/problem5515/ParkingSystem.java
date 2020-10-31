package leetcode.problem5515;

import java.util.HashMap;
import java.util.Map;

public class ParkingSystem {
    Map<Integer, Integer> map = null;

    public ParkingSystem(int big, int medium, int small) {
        map = new HashMap<>();
        map.put(1, big);
        map.put(2, medium);
        map.put(3, small);
    }

    public boolean addCar(int carType) {
        int key = 0;
        switch (carType) {
            case 1:
                key = 1;
                break;
            case 2:
                key = 2;
                break;
            case 3:
                key = 3;
                 break;
        }
        int parks = map.get(key);
        if (parks > 0) {
            parks--;
            map.put(key, parks);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ParkingSystem obj = new ParkingSystem(1, 1, 0);
        System.out.println(obj.addCar(1));
        System.out.println(obj.addCar(2));
        System.out.println(obj.addCar(3));
        System.out.println(obj.addCar(1));
    }

}
