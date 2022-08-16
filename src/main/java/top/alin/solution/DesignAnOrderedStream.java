package top.alin.solution;

import java.util.ArrayList;
import java.util.List;

public class DesignAnOrderedStream {
    class OrderedStream {
        String[] arr;
        int ptr;
        public OrderedStream(int n) {
            arr = new String[n];
            ptr = 0;
        }

        public List<String> insert(int idKey, String value) {
            List<String> list = new ArrayList<>();
            arr[idKey - 1] = value;
            if (idKey - 1 == ptr) {
                while(ptr < arr.length && arr[ptr] != null) {
                    list.add(arr[ptr]);
                    ptr++;
                }
            }
            return list;
        }
    }
}
