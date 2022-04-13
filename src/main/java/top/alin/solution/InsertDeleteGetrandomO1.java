package top.alin.solution;

import java.util.*;

public class InsertDeleteGetrandomO1 {
    class RandomizedSet {
        Map<Integer, Integer> map;
        List<Integer> list;
        Random random;

        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int index = map.get(val);
            int lastVal = list.get(list.size() - 1);
            list.set(index, lastVal);
            map.put(lastVal, index);
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }

        public int getRandom() {
            int index = random.nextInt(list.size());
            return list.get(index);
        }
    }
}
